package vlqhoang.project.smartchoice.ProductPriceComparatorService.service;

import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.List;

public interface ProductPriceService {

    public List<ProductPriceDTO> getAllProductPrices(String productCode);
}
