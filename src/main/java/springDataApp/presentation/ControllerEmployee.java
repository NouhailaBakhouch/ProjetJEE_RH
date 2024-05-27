package springDataApp.presentation;

import java.util.ArrayList;
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

    //New search method
    @GetMapping("/employees/rechercherEmployee")
    public String searchClientByName(@RequestParam("Nom") String Nom, Model model) {
        List<Employee> Employees;
        try {
            Employees = serviceEmployee.rechercherParNom(Nom); // Utilisation du service pour rechercher par nom
            if (Employees.isEmpty()) {
                model.addAttribute("error", "No Employees found with name: " + Nom);
            } else {
                model.addAttribute("Employees", Employees); // Ajouter les clients trouvés au modèle
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while searching for Employees: " + e.getMessage());
            model.addAttribute("Employees", new ArrayList<>()); // Ajouter une liste vide de clients en cas d'erreur
        }
        return "dashboard";
    }

    // Méthode pour afficher le formulaire d'ajout d'employé
    @GetMapping("/create_employee")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_form"; // Le nom de votre fichier HTML pour le formulaire d'ajout
    }
}
