package vlqhoang.project.smartchoice.ProductPriceComparatorService.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import vlqhoang.project.smartchoice.ProductPriceComparatorService.service.WebService;

import java.util.Collections;

@Service
@Log4j2
public class RestTemplateWebService implements WebService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T fetchData(String url, HttpMethod method, Class<T> entity) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            return restTemplate.exchange(url, method, httpEntity, entity).getBody();
        } catch (RestClientException ex) {
            log.error("Error while calling 3rd party service!.", ex);
            return null;
        }
    }
}
