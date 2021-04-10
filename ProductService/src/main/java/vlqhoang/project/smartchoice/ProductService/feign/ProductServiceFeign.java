package vlqhoang.project.smartchoice.ProductService.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;

@FeignClient(contextId = "productServiceContext", name = "netflix-zuul-api-gateway")
@RibbonClient(name = "product-info-service")
@Service
public interface ProductServiceFeign {

    @GetMapping("/product-info-service/product/listAll")
    List<ProductInfoDTO> getAllProducts();

    @GetMapping("/product-info-service/product/detail/{productCode}")
    ProductInfoDTO getProductDetail(@PathVariable String productCode);

    @PostMapping("/product-info-service/product/search")
    List<ProductInfoDTO> searchProduct(@RequestParam("searchText") String searchText,
                                       @RequestParam("userId") String userId);
}
