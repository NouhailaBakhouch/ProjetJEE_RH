package springDataApp.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springDataApp.dao.entities.Employee;
import springDataApp.dao.entities.Horaire;

import java.util.List;

@Repository
public interface HoraireRepository extends JpaRepository<Horaire, Integer> {
    List<Horaire> findByEmployee(Employee employee);
}
