package springDataApp.service.IService;

import springDataApp.dao.entities.Conge;
import java.util.List;

public interface IServiceConge {
    void demanderConge(Conge conge);
    void validerConge(Integer id);
    void modifierConge(Conge conge);
    void supprimerConge(Integer id);
    void annulerConge(Integer id); // Méthode ajoutée
    List<Conge> listerConges();
    Conge rechercherConge(Integer id);
}