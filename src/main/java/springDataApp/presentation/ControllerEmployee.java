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

    @PostMapping
    public String ajouterEmployee(@ModelAttribute Employee e) {
        serviceEmployee.ajouterEmployee(e);
        return "redirect:/employees";
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
}
