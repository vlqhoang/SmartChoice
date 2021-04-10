package vlqhoang.project.smartchoice.ProductPriceComparatorService.unitTests.controller;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.controller.ProductPriceController;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.ProductPriceService;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductPriceController.class)
public class ProductPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductPriceService productPriceService;

    @Test
    public void testGetAllPricesOfProduct() throws Exception {

        ProductPriceDTO productPriceDTO = new ProductPriceDTO("P001", "samsung", 500d, "tiki");
        when(productPriceService.getAllProductPrices(anyString())).thenReturn(Collections.singletonList(productPriceDTO));

        RequestBuilder req = MockMvcRequestBuilders
                .get("/price/list/P001")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult res = mockMvc
                .perform(req)
                .andExpect(status().isOk()) // quickly pre-check response status
                .andReturn();

        String expectedRes = "[{\"productCode\":\"P001\",\"productName\":\"samsung\",\"price\":500.0,\"vendorName\":\"tiki\"}]";
        String actualRes = res.getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedRes, actualRes, false);
    }
}
