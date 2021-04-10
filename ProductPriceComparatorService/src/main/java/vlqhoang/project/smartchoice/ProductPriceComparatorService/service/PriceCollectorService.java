package vlqhoang.project.smartchoice.ProductPriceComparatorService.service;

import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

public interface PriceCollectorService {
    public ProductPriceDTO collectPriceData(String productCode);
    public String getBaseURL();
    public String getType();
}
