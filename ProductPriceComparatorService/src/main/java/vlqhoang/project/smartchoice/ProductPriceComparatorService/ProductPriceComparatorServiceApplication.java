package vlqhoang.project.smartchoice.ProductPriceComparatorService;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductPriceComparatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceComparatorServiceApplication.class, args);
	}

	/**
	 * Tracing id provided by sleuth
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
