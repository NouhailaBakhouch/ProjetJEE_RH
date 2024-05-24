package springDataApp.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springDataApp.dao.entities.Employee;
import springDataApp.service.IService.IServiceEmployee;

@RestController
@RequestMapping("/employees")
public class ControllerEmployee {

    @Autowired
    private IServiceEmployee serviceEmployee;

    @PostMapping
    public ResponseEntity<Employee> ajouterEmployee(@RequestBody Employee e) {
        serviceEmployee.ajouterEmployee(e);
        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmployee(@PathVariable Integer id) {
        serviceEmployee.supprimerEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Employee> modifierEmployee(@RequestBody Employee e) {
        serviceEmployee.modifierEmployee(e);
        return ResponseEntity.ok(e);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> listerEmployee() {
        List<Employee> employees = serviceEmployee.listerEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> rechercherEmployee(@PathVariable Integer id) {
        Employee employee = serviceEmployee.rechercherEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}