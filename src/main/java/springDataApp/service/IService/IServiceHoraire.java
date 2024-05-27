package springDataApp.service.IService;

import springDataApp.dao.entities.Horaire;

import java.util.List;

public interface IServiceHoraire {
    // Create
    Horaire saveHoraire(Horaire horaire);

    // Read
    Horaire getHoraireById(int id);
    List<Horaire> getAllHoraires();
    List<Horaire> getHorairesByEmployeeId(int employeeId);

    // Update
    Horaire updateHoraire(int id, Horaire updatedHoraire);

    // Delete
    void deleteHoraire(int id);
}

