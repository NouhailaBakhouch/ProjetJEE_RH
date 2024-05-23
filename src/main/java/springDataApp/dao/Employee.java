package springDataApp.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("employee")
@EqualsAndHashCode(callSuper = true)
public class Employee extends Personne {
    // Pas besoin d'un nouvel ID, il est hérité de Personne
}