package vlqhoang.project.smartchoice.ProductInfoService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vlqhoang.project.smartchoice.ProductInfoService.entity.ProductEntity;
import vlqhoang.project.smartchoice.ProductInfoService.repository.ProductRepository;
import vlqhoang.project.smartchoice.ProductInfoService.service.ProductInfoService;
import vlqhoang.project.smartchoice.ProductInfoService.utils.DTOConverter;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductInfoDTO> getAllProducts(Pageable pageable) {
        List<ProductEntity> products = productRepository.fetchAllProducts(pageable);
        return DTOConverter.convertToProductInfoDTO(products);
    }

    @Override
    public ProductInfoDTO getProductDetailByProductCode(String productCode) {
        Optional<ProductEntity> product = productRepository.findById(productCode);
        return product.map(DTOConverter::convertToProductInfoDTO).orElse(null);
    }

    @Override
    public List<ProductEntity> searchProduct(String searchText) {
        return productRepository.searchByProductName(searchText);
    }

}
