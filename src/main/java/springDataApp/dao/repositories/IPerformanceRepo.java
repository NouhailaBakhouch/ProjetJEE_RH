package springDataApp.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springDataApp.dao.entities.Performance;

public interface IPerformanceRepo extends JpaRepository<Performance, Integer>{

}
