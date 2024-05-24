package springDataApp.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springDataApp.dao.entities.Employee;
import springDataApp.dao.repositories.IEmpRepo;
import springDataApp.service.IService.IServiceEmployee;

@Service
public class ServiceEmployeeImpl implements IServiceEmployee {

    @Autowired
    private IEmpRepo employeeRepository;

    @Override
    public void ajouterEmployee(Employee e) {
    	employeeRepository.save(e);
    }

    @Override
    public void supprimerEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void modifierEmployee(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public List<Employee> listerEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee rechercherEmployee(Integer id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        return optional.orElse(null);
    }
}
