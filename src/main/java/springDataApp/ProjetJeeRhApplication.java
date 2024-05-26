package springDataApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@SpringBootApplication
@EntityScan(basePackages = "springDataApp.dao.entities")
@EnableJpaRepositories(basePackages = "springDataApp.dao.repositories")
@ComponentScan(basePackages = "springDataApp.service")
public class ProjetJeeRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetJeeRhApplication.class, args);
	}
	 @Controller
	    public class HomeController {

	        @GetMapping("/")
	        public String home() {
	            return "home";
	        }
	    }
	 

}