package vlqhoang.project.smartchoice.SmartChoiceEurekaNamingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SmartChoiceEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartChoiceEurekaNamingServerApplication.class, args);
	}

}
