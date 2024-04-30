package springDataApp.service;


import org.springframework.data.jpa.repository.JpaRepository;

import springDataApp.dao.Personne;



public interface IGestionPersonne extends JpaRepository<Personne, Integer>{

}