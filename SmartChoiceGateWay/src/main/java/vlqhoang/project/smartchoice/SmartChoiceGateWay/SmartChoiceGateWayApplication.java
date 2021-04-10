package vlqhoang.project.smartchoice.SmartChoiceGateWay;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SmartChoiceGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartChoiceGateWayApplication.class, args);
	}

	/**
	 * Tracing id provided by sleuth
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
