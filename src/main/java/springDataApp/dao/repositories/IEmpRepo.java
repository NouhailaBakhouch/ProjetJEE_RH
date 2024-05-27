package springDataApp.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springDataApp.dao.entities.Employee;

public interface IEmpRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByNomContaining(String nom);


	
}
