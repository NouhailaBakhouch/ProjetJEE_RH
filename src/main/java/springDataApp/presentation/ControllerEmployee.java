package springDataApp.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springDataApp.dao.entities.Employee;
import springDataApp.service.IService.IServiceEmployee;

@Controller
@RequestMapping("/employees")
public class ControllerEmployee {

    @Autowired
    private IServiceEmployee serviceEmployee;

    @PostMapping("/create_employee")
    public String ajouterEmployee(@ModelAttribute Employee e, Model model) {
        serviceEmployee.ajouterEmployee(e);
        model.addAttribute("message", "L'employé a été ajouté avec succès.");
        return "redirect:/employees"; // Redirige vers la liste des employés après l'ajout
    }

    @DeleteMapping("/{id}")
    public String supprimerEmployee(@PathVariable Integer id) {
        serviceEmployee.supprimerEmployee(id);
        return "redirect:/employees";
    }

    @PutMapping
    public String modifierEmployee(@ModelAttribute Employee e) {
        serviceEmployee.modifierEmployee(e);
        return "redirect:/employees";
    }

    @GetMapping
    public String listerEmployee(Model model) {
        List<Employee> employees = serviceEmployee.listerEmployee();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/{id}")
    public String rechercherEmployee(@PathVariable Integer id, Model model) {
        Employee employee = serviceEmployee.rechercherEmployee(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employeeDetails";
        } else {
            return "redirect:/employees";
        }
    }

    // Méthode pour afficher le formulaire d'ajout d'employé
    @GetMapping("/create_employee")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_form"; // Le nom de votre fichier HTML pour le formulaire d'ajout
    }
}
