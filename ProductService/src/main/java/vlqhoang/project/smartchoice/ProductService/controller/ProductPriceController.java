package vlqhoang.project.smartchoice.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlqhoang.project.smartchoice.ProductService.feign.PriceServiceFeign;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.List;

@RestController
public class ProductPriceController {

    @Autowired
    private PriceServiceFeign priceServiceFeign;

    @GetMapping("/product/price/{productCode}")
    public List<ProductPriceDTO> fetchAllPricesOfProduct(@PathVariable String productCode) {
        return priceServiceFeign.getAllPrices(productCode);
    }
}
