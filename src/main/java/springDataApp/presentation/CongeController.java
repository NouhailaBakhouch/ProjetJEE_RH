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

    @GetMapping
    public String listerConges(Model model) {
        List<Conge> conges = serviceConge.listerConges();
        model.addAttribute("conges", conges);
        return "conges";
    }

    @GetMapping("/create_conge")
    public String afficherFormulaireDemandeConge(Model model) {
        model.addAttribute("conge", new Conge());
        return "demande_conge_form";
    }

    @PostMapping("/create")
    public String soumettreDemandeConge(@ModelAttribute("conge") Conge conge) {
        serviceConge.demanderConge(conge);
        return "redirect:/conges";
    }

    @GetMapping("/{id}")
    public String afficherDetailsConge(@PathVariable Integer id, Model model) {
        Conge conge = serviceConge.rechercherConge(id);
        if (conge != null) {
            model.addAttribute("conge", conge);
            return "details_conge";
        } else {
            return "redirect:/conges";
        }
    }

    @PostMapping("/{id}/valider")
    public String validerConge(@PathVariable Integer id) {
        serviceConge.validerConge(id);
        return "redirect:/conges";
    }

    @GetMapping("/{id}/edit")
    public String afficherFormulaireModificationConge(@PathVariable Integer id, Model model) {
        Conge conge = serviceConge.rechercherConge(id);
        if (conge != null) {
            model.addAttribute("conge", conge);
            return "edit_conge_form";
        } else {
            return "redirect:/conges";
        }
    }

    @PostMapping("/{id}/edit")
    public String modifierConge(@PathVariable Integer id, @ModelAttribute("conge") Conge conge) {
        conge.setId(id);
        serviceConge.modifierConge(conge);
        return "redirect:/conges";
    }

    @PostMapping("/{id}/delete")
    public String supprimerConge(@PathVariable Integer id) {
        serviceConge.supprimerConge(id);
        return "redirect:/conges";
    }

    @PostMapping("/{id}/annuler")
    public String annulerConge(@PathVariable Integer id) {
        serviceConge.annulerConge(id);
        return "redirect:/conges";
    }

    // Implémentez d'autres méthodes du contrôleur selon les besoins
}
