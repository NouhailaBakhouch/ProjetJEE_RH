package springDataApp.service.IService;

import java.util.List;

import springDataApp.dao.entities.Employee;

public interface IServiceEmployee {
    public void ajouterEmployee(Employee e);
    public void supprimerEmployee(Integer id);
    public void modifierEmployee(Employee e);
    public List<Employee> listerEmployee();
    public Employee rechercherEmployee(Integer id);
}