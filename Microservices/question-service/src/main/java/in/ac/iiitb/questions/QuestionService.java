package in.ac.iiitb.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuestionService {
	public static void main(String[] args) {
		SpringApplication.run(QuestionService.class, args);
	}

}
