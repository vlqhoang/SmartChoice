package vlqhoang.project.smartchoice.ProductInfoService.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vlqhoang.project.smartchoice.ProductInfoService.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("select p from ProductEntity p")
    public List<ProductEntity> fetchAllProducts(Pageable pageable);

    @Query("select p from ProductEntity p where lower(p.productName) like lower(concat('%', :searchText,'%'))")
    public List<ProductEntity> searchByProductName(@Param(value = "searchText") String searchText);
}
