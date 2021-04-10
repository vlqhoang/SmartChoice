package vlqhoang.project.smartchoice.ProductService.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.List;

@FeignClient(contextId = "priceServiceContext", name = "netflix-zuul-api-gateway")
@RibbonClient(name = "price-comparator-service")
@Service
public interface PriceServiceFeign {

    @GetMapping("/price-comparator-service/price/list/{productCode}")
    List<ProductPriceDTO> getAllPrices(@PathVariable String productCode);
}
