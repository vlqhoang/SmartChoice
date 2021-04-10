package vlqhoang.project.smartchoice.ProductPriceComparatorService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.ProductPriceService;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.List;

@RestController
public class ProductPriceController {

    @Autowired
    private ProductPriceService productPriceService;

    @GetMapping("/price/list/{productCode}")
    public List<ProductPriceDTO> getAllPricesOfProduct(@PathVariable String productCode) {
        return productPriceService.getAllProductPrices(productCode);
    }
}
