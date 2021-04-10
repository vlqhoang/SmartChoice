package vlqhoang.project.smartchoice.ProductPriceComparatorService.service;

import org.springframework.http.HttpMethod;

public interface WebService {

    public <T> T fetchData(String url, HttpMethod method, Class<T> entity);
}
