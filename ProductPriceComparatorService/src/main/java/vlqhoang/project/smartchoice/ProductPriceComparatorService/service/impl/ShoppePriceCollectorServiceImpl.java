package vlqhoang.project.smartchoice.ProductPriceComparatorService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.PriceCollectorService;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.WebService;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.ProductPriceDTO;

@Service
public class ShoppePriceCollectorServiceImpl implements PriceCollectorService {

    @Autowired
    private WebService webService;

    @Override
    public ProductPriceDTO collectPriceData(String productCode) {
        String url = this.getBaseURL().concat("product/").concat(productCode);
        return webService.fetchData(url, HttpMethod.GET, ProductPriceDTO.class);
    }

    @Override
    public String getBaseURL() {
        return "http://localhost:8400/shoppe/";
    }

    @Override
    public String getType() {
        return "shoppe";
    }
}

