package vlqhoang.project.smartchoice.ProductPriceComparatorService.service;

import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

public interface PriceCollectorService {
    /**
     * Collect new price of a product
     * @param productCode - product code to perform 3rd party service query
     * @return ProductPriceDTO - new product price data
     */
    public ProductPriceDTO collectPriceData(String productCode);

    /**
     * Differentiating service url for each collector service
     * @return base url
     */
    public String getBaseURL();

    /**
     * Differentiating services via service names
     * @return service name
     */
    public String getType();
}
