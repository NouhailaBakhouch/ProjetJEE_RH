package springDataApp.dao;

import java.time.LocalDate;



import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profil")

public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	  private int idP;
	    private String nom;
	    private String prénom;
	    private String adresse;
	    private String numéroDeTéléphone;
	    private String email;
	    private LocalDate dateDeNaissance;

}
