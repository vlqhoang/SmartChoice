package vlqhoang.project.smartchoice.ProductPriceComparatorService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductPriceEntity;

import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, String> {

    @Query("select p from ProductPriceEntity p where p.productCode = :productCode")
    List<ProductPriceEntity> findAllPricesOfProduct(@Param(value = "productCode") String productCode);
}
