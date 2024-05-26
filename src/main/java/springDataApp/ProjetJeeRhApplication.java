package springDataApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springDataApp.dao.entities.Employee;
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
	        @GetMapping("/employees")
		    public String employeeManagement() {
		        return "employees"; // Assurez-vous d'avoir une vue correspondante nommée "employees.html"
		        
		    }
	        @GetMapping("/create_employee")
	        public String showEmployeeForm(Model model) {
	            model.addAttribute("employee", new Employee());
	            return "employee_form"; // Le nom de votre fichier HTML pour le formulaire d'ajout
	            
	        }
	        
	        
	    }
	

}