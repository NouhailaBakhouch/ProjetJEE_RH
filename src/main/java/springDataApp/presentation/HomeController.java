package springDataApp.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @GetMapping("/employees")
    public String employeeManagement() {
        return "employees"; // Assurez-vous d'avoir une vue correspondante nommée "employees.html"
    }
}
