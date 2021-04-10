package vlqhoang.project.smartchoice.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vlqhoang.project.smartchoice.ProductService.feign.ProductServiceFeign;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;

@RestController
public class ProductInfoController {

    @Autowired
    private ProductServiceFeign productInfoServiceFeign;

    @GetMapping("/product/detail/{productCode}")
    public ProductInfoDTO fetchProductData(@PathVariable String productCode) {
        return productInfoServiceFeign.getProductDetail(productCode);
    }

    @GetMapping("/product/listAll")
    public List<ProductInfoDTO> fetchAllProducts() {
        return productInfoServiceFeign.getAllProducts();
    }

    @PostMapping("/product/search")
    public List<ProductInfoDTO> searchProduct(@RequestParam String searchText,
                                              @RequestParam String userId) {
        return productInfoServiceFeign.searchProduct(searchText, userId);
    }
}
