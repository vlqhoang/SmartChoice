package vlqhoang.project.smartchoice.ProductPriceComparatorService.service.impl;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductPriceEntity;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.repository.ProductPriceRepository;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.PriceCollectorService;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.ProductPriceService;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.utils.DTOConverter;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductPriceServiceImpl implements ProductPriceService {

    private final Map<String, PriceCollectorService> priceCollectorServices; // Key: vendorName - Value: according price collector service
    private final ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceServiceImpl(ProductPriceRepository productPriceRepository, List<PriceCollectorService> priceCollectorServices) {
        this.productPriceRepository = productPriceRepository;
        this.priceCollectorServices = priceCollectorServices.stream()
                .collect(Collectors.toMap(
                        PriceCollectorService::getType,
                        Function.identity())
                );
    }

    @Override
    public List<ProductPriceDTO> getAllProductPrices(String productCode) {
        if (StringUtils.isBlank(productCode)) return new LinkedList<>();
        List<ProductPriceEntity> availablePrices = productPriceRepository.findAllPricesOfProduct(productCode);
        this.considerUpdateOldRecords(availablePrices);
        return availablePrices.stream()
                .map(DTOConverter::convertToProductPriceDTO)
                .collect(Collectors.toList());
    }

    /**
     * Only prices that are considered out-of-date will be updated
     * @param availablePrices - price entity list
     */
    @Transactional
    @TimeLimiter(name = "thirdPartyServiceTimeLimiter", fallbackMethod = "handleTimeOutThirdPartyService")
    public void considerUpdateOldRecords(List<ProductPriceEntity> availablePrices) {
        if (availablePrices.isEmpty()) return;

        availablePrices.stream()
                .filter(this::isRecordEntityOutOfDate)
                .parallel()
                .forEach(productPriceEntity -> {
                    PriceCollectorService collectorService = priceCollectorServices.get(productPriceEntity.getVendor().getVendorName());
                    ProductPriceDTO newProductPrice = collectorService.collectPriceData(productPriceEntity.getProductOriginCode());
                    if (newProductPrice == null || newProductPrice.getPrice().equals(productPriceEntity.getPrice())) return;
                    // update DB with new price, new date
                    productPriceEntity.setPrice(newProductPrice.getPrice());
                    productPriceEntity.setUpdateTime(new Date());
                });
        productPriceRepository.saveAll(availablePrices);
    }

    public void handleTimeOutThirdPartyService(List<ProductPriceEntity> availablePrices, Throwable throwable) {
        log.error("Error on calling third parties!.", throwable);
    }

    /**
     * Logic for classifying out-of-date record
     * @param recordEntity - price entity
     * @return true -> out-of-date / false -> price is still valid
     */
    private boolean isRecordEntityOutOfDate(ProductPriceEntity recordEntity) {
        LocalDate now = LocalDate.now();
        LocalDate updateDate = Instant.ofEpochMilli(recordEntity.getUpdateTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        long noOfDaysDiff = ChronoUnit.DAYS.between(updateDate, now);
        return noOfDaysDiff >= 7;
    }
}
