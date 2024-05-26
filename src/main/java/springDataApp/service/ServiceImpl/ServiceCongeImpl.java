package springDataApp.service.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDataApp.dao.entities.Conge;
import springDataApp.dao.repositories.ICongeRepo;
import springDataApp.service.IService.IServiceConge;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCongeImpl implements IServiceConge {

    @Autowired
    private ICongeRepo congeRepository;

    @Override
    public void demanderConge(Conge conge) {
        congeRepository.save(conge);
    }

    @Override
    public void validerConge(Integer id) {
        Optional<Conge> optional = congeRepository.findById(id);
        if (optional.isPresent()) {
            Conge conge = optional.get();
            // Mettez ici la logique pour valider le congé, par exemple mettre à jour le statut du congé
            // conge.setValide(true);
            // Ensuite, sauvegardez le congé mis à jour
            congeRepository.save(conge);
        } else {
            throw new IllegalArgumentException("Congé non trouvé avec l'ID: " + id);
        }
    }

    @Override
    public void modifierConge(Conge conge) {
        congeRepository.save(conge);
    }

    @Override
    public void supprimerConge(Integer id) {
        congeRepository.deleteById(id);
    }

    @Override
    public List<Conge> listerConges() {
        return congeRepository.findAll();
    }

    @Override
    public Conge rechercherConge(Integer id) {
        Optional<Conge> optional = congeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void annulerConge(Integer id) {
        Optional<Conge> optional = congeRepository.findById(id);
        if (optional.isPresent()) {
            Conge conge = optional.get();
            // Mettez ici la logique pour annuler le congé, par exemple mettre à jour le statut du congé
            // conge.setAnnule(true);
            // Ensuite, sauvegardez le congé mis à jour
            congeRepository.save(conge);
        } else {
            throw new IllegalArgumentException("Congé non trouvé avec l'ID: " + id);
        }
    }
}
