package vlqhoang.project.smartchoice.rdPartyMockService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;
import vlqhoang.project.smartchoice.rdPartyMockService.utils.NumberUtils;

@RestController
public class TikiPriceMockController {

    @GetMapping("/tiki/product/{productCode}")
    public ResponseEntity<?> getProductPrice(@PathVariable String productCode) {
        if (!productCode.equalsIgnoreCase("TK001") && !productCode.equalsIgnoreCase("TK002"))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        ProductPriceDTO dto = new ProductPriceDTO();
        dto.setProductCode(productCode);
        dto.setPrice(NumberUtils.getRandom(290, 320));
        dto.setVendorName("tiki");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
