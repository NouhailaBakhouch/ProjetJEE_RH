package springDataApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springDataApp.dao.entities.Conge;
import springDataApp.service.IService.IServiceConge;
import java.util.List;

@Controller
@RequestMapping("/conges")
public class CongeController {

    @Autowired
    private IServiceConge serviceConge;

    @PostMapping
    public String demanderConge(@ModelAttribute Conge conge) {
        serviceConge.demanderConge(conge);
        return "redirect:/conges";
    }

    @GetMapping
    public String listerConges(Model model) {
        List<Conge> conges = serviceConge.listerConges();
        model.addAttribute("conges", conges);
        return "conges";
    }

    @GetMapping("/{id}")
    public String afficherConge(@PathVariable Integer id, Model model) {
        Conge conge = serviceConge.rechercherConge(id);
        if (conge != null) {
            model.addAttribute("conge", conge);
            return "detailsConge";
        } else {
            return "redirect:/conges";
        }
    }

    @PostMapping("/{id}/valider")
    public String validerConge(@PathVariable Integer id) {
        serviceConge.validerConge(id);
        return "redirect:/conges";
    }

    @DeleteMapping("/{id}/annuler")
    public String annulerConge(@PathVariable Integer id) {
        serviceConge.annulerConge(id);
        return "redirect:/conges";
    }

    // Implémentez d'autres méthodes du contrôleur selon les besoins
}
