package vlqhoang.project.smartchoice.ProductInfoService.controller;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vlqhoang.project.smartchoice.ProductInfoService.entity.ProductEntity;
import vlqhoang.project.smartchoice.ProductInfoService.service.ProductInfoService;
import vlqhoang.project.smartchoice.ProductInfoService.service.UserEvtProducerService;
import vlqhoang.project.smartchoice.ProductInfoService.utils.DTOConverter;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductBasicInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private UserEvtProducerService evtProducerService;


    @GetMapping("/product/listAll")
    public List<ProductInfoDTO> fetchAllProduct(Pageable pageable) {
        return productInfoService.getAllProducts(pageable);
    }

    @GetMapping("/product/detail/{productCode}")
    public ProductInfoDTO fetchProductInfo(@PathVariable String productCode) {
        return productInfoService.getProductDetailByProductCode(productCode);
    }

    @PostMapping("/product/search")
    public List<ProductInfoDTO> searchProduct(@RequestParam String searchText,
                                              @RequestParam String userId) {
        String sanitizedSearchTxt = Jsoup.clean(searchText, Whitelist.none()); // sanitizing user input - preventing XSS

        List<ProductEntity> searchResults = productInfoService.searchProduct(sanitizedSearchTxt);

        // auditing search
        // TODO split to other method
        if (searchResults.isEmpty()) evtProducerService.sendUserSearchEvt(DTOConverter.convertToSearchEvtDTO(sanitizedSearchTxt, userId));
        searchResults.forEach(searchResult -> evtProducerService
                .sendUserSearchEvt(DTOConverter.convertToSearchEvtDTO(searchResult, sanitizedSearchTxt, userId)));

        return searchResults.stream()
                .map(DTOConverter::convertToProductInfoDTO)
                .collect(Collectors.toList());
    }
}
