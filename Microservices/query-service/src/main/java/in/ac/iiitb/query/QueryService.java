package in.ac.iiitb.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QueryService {

	public static void main(String[] args) {
		SpringApplication.run(QueryService.class, args);
	}

}
