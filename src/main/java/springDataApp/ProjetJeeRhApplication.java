package springDataApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springDataApp.dao.entities.Conge;
import springDataApp.dao.entities.Employee;
import springDataApp.service.IService.IServiceConge;
import springDataApp.service.IService.IServiceEmployee;

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

        @Autowired
        private IServiceEmployee serviceEmployee;

        @GetMapping("/")
        public String home() {
            return "home";
        }

        @GetMapping("/employees")
        public String showDashboard(Model model) {
            model.addAttribute("employees", serviceEmployee.listerEmployee());
            return "employees";
        }

        @GetMapping("/create_employee")
        public String showEmployeeForm(Model model) {
            model.addAttribute("employee", new Employee());
            return "employee_form";
        }

        @PostMapping("/create_employees")
        public String addEmployee(@ModelAttribute("employee") Employee employee) {
            serviceEmployee.ajouterEmployee(employee);
            return "redirect:/employees"; // Corrected redirection URL
        }
        @PostMapping("/delete_employee/{id}")
        public String supprimerEmployee(@PathVariable Integer id) {
            serviceEmployee.supprimerEmployee(id);
            return "redirect:/employees";
        }
        @GetMapping("/modifierEmployee/{id}")
        public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
            Employee employee = null;
            try {
                employee = serviceEmployee.rechercherEmployee(id); // Utilisation du service
            } catch (Exception e) {
                throw new RuntimeException("Employee not found with id: " + id);
            }
            model.addAttribute("employee", employee);
            return "edit_employee";
        }

        @PostMapping("/modifierEmployee/{id}")
        public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
            employee.setId(id); // S'assurer que l'ID est défini correctement
            serviceEmployee.modifierEmployee(employee); // Utilisation du service
            return "redirect:/employees"; // Redirige vers le tableau de bord après la modification
        }
        @RequestMapping("/conges")
        public class CongeController {

            @Autowired
            private IServiceConge serviceConge;

            @GetMapping
            public String listerConges(Model model) {
                List<Conge> conges = serviceConge.listerConges();
                model.addAttribute("conges", conges);
                return "conges";
            }
    }
    }
}
