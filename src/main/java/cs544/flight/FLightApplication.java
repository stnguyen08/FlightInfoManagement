package cs544.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.springframework.ui", "aha"})
//@EnableAutoConfiguration
//@ComponentScan("org.springframework.ui", "aha")
public class FLightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FLightApplication.class, args);
	}
}
