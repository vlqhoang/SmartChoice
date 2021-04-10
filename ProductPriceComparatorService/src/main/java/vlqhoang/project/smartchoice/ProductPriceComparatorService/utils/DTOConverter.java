package vlqhoang.project.smartchoice.ProductPriceComparatorService.utils;

import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductPriceEntity;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

public class DTOConverter {

    /**
     * Convert product price data to ProductPriceDTO
     * @param productPrice - entity data to be converted
     * @return converted DTO
     */
    public static ProductPriceDTO convertToProductPriceDTO(ProductPriceEntity productPrice) {
        ProductPriceDTO productPriceDTO = new ProductPriceDTO();
        productPriceDTO.setPrice(productPrice.getPrice());
        productPriceDTO.setProductCode(productPrice.getProductCode());
        productPriceDTO.setProductName(productPrice.getProduct().getProductName());
        productPriceDTO.setVendorName(productPrice.getVendor().getVendorName());
        return productPriceDTO;
    }
}
