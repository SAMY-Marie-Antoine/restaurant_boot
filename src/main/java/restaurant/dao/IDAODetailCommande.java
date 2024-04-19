package restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.DetailCommande;


public interface IDAODetailCommande extends JpaRepository<DetailCommande, Integer> {
	

}

