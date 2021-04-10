package vlqhoang.project.smartchoice.ProductPriceComparatorService.unitTests.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductEntity;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductPriceEntity;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductVendorEntity;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.repository.ProductPriceRepository;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.PriceCollectorService;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.ProductPriceService;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.impl.ProductPriceServiceImpl;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductPriceServiceTest {

    ProductPriceService productPriceService;

    @Mock
    ProductPriceRepository productPriceRepository;

    @Autowired
    List<PriceCollectorService> priceCollectorServices;

    @BeforeEach
    public void init() {
        productPriceService = new ProductPriceServiceImpl(productPriceRepository, priceCollectorServices);
    }

    @Test
    public void testGetAllProductPrices_SingleResult() {

        // setup condition
        ProductEntity productEntity = new ProductEntity("P001", "samsung", "phone");
        ProductVendorEntity vendorEntity = new ProductVendorEntity("vv", "tiki", "tiki.com");
        ProductPriceEntity priceEntity = new ProductPriceEntity("id1", "P001", "vv",
                "TK001", 500d, new Date(), productEntity, vendorEntity);
        when(productPriceRepository.findAllPricesOfProduct(anyString())).thenReturn(Collections.singletonList(priceEntity));
        when(productPriceRepository.saveAll(anyIterable())).thenReturn(Collections.singletonList(priceEntity));

        // perform asserts
        ProductPriceDTO productPriceDTO = new ProductPriceDTO("P001", "samsung", 500d, "tiki");
        List<ProductPriceDTO> expectedResult = Collections.singletonList(productPriceDTO);
        List<ProductPriceDTO> actualResult = productPriceService.getAllProductPrices("something");
        assertEquals(expectedResult.size(), actualResult.size());
        assertEquals(expectedResult.get(0).getPrice(), actualResult.get(0).getPrice());
        assertEquals(expectedResult.get(0).getProductCode(), actualResult.get(0).getProductCode());
    }

    @Test
    public void testGetAllProductPrices_EmptyResult() {
        // setup condition
        when(productPriceRepository.findAllPricesOfProduct(anyString())).thenReturn(Collections.emptyList());

        // perform asserts
        List<ProductPriceDTO> actualResult = productPriceService.getAllProductPrices("something");
        assertEquals(0, actualResult.size());
    }

}
