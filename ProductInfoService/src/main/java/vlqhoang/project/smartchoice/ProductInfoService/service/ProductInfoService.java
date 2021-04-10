package vlqhoang.project.smartchoice.ProductInfoService.service;

import org.springframework.data.domain.Pageable;
import vlqhoang.project.smartchoice.ProductInfoService.entity.ProductEntity;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;

public interface ProductInfoService {

    public List<ProductInfoDTO> getAllProducts(Pageable pageable);
    public ProductInfoDTO getProductDetailByProductCode(String productCode);
    public List<ProductEntity> searchProduct(String searchText);
}
