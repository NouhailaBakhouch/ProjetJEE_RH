package springDataApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springDataApp.dao.entities.Performance;
import springDataApp.service.IService.PerformanceService;

@Controller
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/")
    public String listPerformances(Model model) {
        model.addAttribute("performances", performanceService.getAllPerformances());
        return "performances/list";
    }

    @GetMapping("/add")
    public String showAddPerformanceForm(Model model) {
        model.addAttribute("performance", new Performance());
        return "performances/add";
    }

    @PostMapping("/add")
    public String addPerformance(@ModelAttribute("performance") Performance performance) {
        performanceService.addPerformance(performance);
        return "redirect:/performances/";
    }

    @GetMapping("/edit/{id}")
    public String showEditPerformanceForm(@PathVariable("id") int id, Model model) {
        Performance performance = performanceService.getPerformanceById(id);
        model.addAttribute("performance", performance);
        return "performances/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePerformance(@PathVariable("id") int id, @ModelAttribute("performance") Performance performance) {
        performance.setId(id);
        performanceService.updatePerformance(performance);
        return "redirect:/performances/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerformance(@PathVariable("id") int id) {
        performanceService.deletePerformance(id);
        return "redirect:/performances/";
    }
}
