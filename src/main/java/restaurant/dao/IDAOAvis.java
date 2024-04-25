package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Avis;

public interface IDAOAvis extends JpaRepository<Avis, Integer>{
    
		
}