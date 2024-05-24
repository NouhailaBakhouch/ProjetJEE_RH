package springDataApp.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springDataApp.dao.entities.Employee;

public interface IEmpRepo extends JpaRepository<Employee, Integer>{
	
}
