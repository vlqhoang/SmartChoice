package vlqhoang.project.smartchoice.rdPartyMockService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;
import vlqhoang.project.smartchoice.rdPartyMockService.utils.NumberUtils;

@RestController
public class ShoppePriceMockController {

    @GetMapping("/shoppe/product/{productCode}")
    public ResponseEntity<?> getProductPrice(@PathVariable String productCode) {
        if (!productCode.equalsIgnoreCase("SP001") && !productCode.equalsIgnoreCase("SP002"))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        ProductPriceDTO dto = new ProductPriceDTO();
        dto.setProductCode(productCode);
        dto.setPrice(NumberUtils.getRandom(250, 290));
        dto.setVendorName("shoppe");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
