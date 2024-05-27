package springDataApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springDataApp.dao.entities.Employee;
import springDataApp.dao.entities.Horaire;
import springDataApp.dao.repositories.IEmpRepo;
import springDataApp.dao.repositories.HoraireRepository;
import springDataApp.dao.repositories.IEmpRepo;

import java.util.List;

@Controller
public class HoraireController {

    private final HoraireRepository horaireRepository;
    private final IEmpRepo employeeRepository;

    @Autowired
    public HoraireController(HoraireRepository horaireRepository, IEmpRepo employeeRepository) {
        this.horaireRepository = horaireRepository;
        this.employeeRepository = employeeRepository;
    }

    // Affiche l'emploi du temps de la semaine pour un employé spécifique
    @GetMapping("/employees/{employeeId}/schedule")
    public String viewScheduleForEmployee(@PathVariable("employeeId") int employeeId, Model model) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            List<Horaire> schedule = horaireRepository.findByEmployee(employee);
            model.addAttribute("employee", employee);
            model.addAttribute("schedule", schedule);
            return "employee_schedule"; // Assurez-vous d'avoir un fichier HTML correspondant à cette vue
        } else {
            // Gérer le cas où l'employé n'est pas trouvé
            return "error"; // Assurez-vous d'avoir une page d'erreur correspondante
        }
    }
}
