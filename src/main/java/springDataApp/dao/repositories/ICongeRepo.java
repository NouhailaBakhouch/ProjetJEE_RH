package springDataApp.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springDataApp.dao.entities.Conge;

public interface ICongeRepo extends JpaRepository<Conge, Integer> {
    // Ajoutez des méthodes supplémentaires si nécessaire
}
