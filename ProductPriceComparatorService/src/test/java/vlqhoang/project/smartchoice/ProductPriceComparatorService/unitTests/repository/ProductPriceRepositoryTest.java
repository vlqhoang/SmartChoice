package vlqhoang.project.smartchoice.ProductPriceComparatorService.unitTests.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.entity.ProductPriceEntity;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.repository.ProductPriceRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductPriceRepositoryTest {

    @Autowired
    ProductPriceRepository productPriceRepository;

    @Test
    public void testFindAll() {
        List<ProductPriceEntity> records = productPriceRepository.findAll();
        assertEquals(3, records.size());
    }
}
