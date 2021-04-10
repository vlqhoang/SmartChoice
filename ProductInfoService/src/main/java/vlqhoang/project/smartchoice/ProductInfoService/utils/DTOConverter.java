package vlqhoang.project.smartchoice.ProductInfoService.utils;

import vlqhoang.project.smartchoice.ProductInfoService.entity.ProductEntity;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.UserSearchEvtDTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter {

    /**
     * Convert entity to DTO
     * @param productEntity - product entity data
     * @return converted DTO
     */
    public static ProductInfoDTO convertToProductInfoDTO(ProductEntity productEntity) {
        ProductInfoDTO dto = new ProductInfoDTO();
        dto.setProductCode(productEntity.getProductCode());
        dto.setProductName(productEntity.getProductName());
        dto.setType(productEntity.getProductType());
        return dto;
    }

    public static List<ProductInfoDTO> convertToProductInfoDTO(List<ProductEntity> productEntity) {
        if (productEntity.isEmpty()) return new LinkedList<>();
        return productEntity.stream().map(DTOConverter::convertToProductInfoDTO).collect(Collectors.toList());
    }

    public static UserSearchEvtDTO convertToSearchEvtDTO(ProductEntity searchedProduct, String searchString, String userID) {
        UserSearchEvtDTO dto = new UserSearchEvtDTO();
        dto.setProductCode(searchedProduct.getProductCode());
        dto.setSearchStr(searchString);
        dto.setUserId(userID);
        dto.setSearchTime(new Date());
        return dto;
    }

    public static UserSearchEvtDTO convertToSearchEvtDTO(String searchString, String userID) {
        UserSearchEvtDTO dto = new UserSearchEvtDTO();
        dto.setSearchStr(searchString);
        dto.setUserId(userID);
        dto.setSearchTime(new Date());
        return dto;
    }
}
