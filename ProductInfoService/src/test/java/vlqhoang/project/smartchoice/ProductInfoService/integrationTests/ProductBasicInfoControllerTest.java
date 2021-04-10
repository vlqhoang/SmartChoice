package vlqhoang.project.smartchoice.ProductInfoService.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductInfoDTO;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductBasicInfoControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFetchAllProduct() {
        ResponseEntity<List<ProductInfoDTO>> response = testRestTemplate
                .exchange("http://localhost:8100/product/listAll",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<ProductInfoDTO>>() {});

        List<ProductInfoDTO> actualResult = response.getBody();
        assert actualResult != null && actualResult.size() > 0;
    }

    @Test
    public void testFetchProductDetail_ValidProductCode() {
        ResponseEntity<ProductInfoDTO> response = testRestTemplate
                .exchange("http://localhost:8100/product/detail/P001",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ProductInfoDTO>() {});

        ProductInfoDTO actualResult = response.getBody();
        assert actualResult != null;
    }

    @Test
    public void testFetchProductDetail_InvalidProductCode() {
        ResponseEntity<ProductInfoDTO> response = testRestTemplate
                .exchange("http://localhost:8100/product/detail/unknown",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ProductInfoDTO>() {});

        ProductInfoDTO actualResult = response.getBody();
        assert actualResult == null;
    }

    @Test
    public void testSearchProduct_ValidProductName() {
        ResponseEntity<List<ProductInfoDTO>> response = testRestTemplate
                .exchange("http://localhost:8100/product/search?searchText=sam&userId=025351864",
                        HttpMethod.POST,
                        null,
                        new ParameterizedTypeReference<List<ProductInfoDTO>>() {});

        List<ProductInfoDTO> actualResult = response.getBody();
        assert actualResult != null && actualResult.size() > 0;
    }

    @Test
    public void testSearchProduct_InvalidProductName() {
        ResponseEntity<List<ProductInfoDTO>> response = testRestTemplate
                .exchange("http://localhost:8100/product/search?searchText=111&userId=025351864",
                        HttpMethod.POST,
                        null,
                        new ParameterizedTypeReference<List<ProductInfoDTO>>() {});

        List<ProductInfoDTO> actualResult = response.getBody();
        assert actualResult != null && actualResult.size() == 0;
    }

}
