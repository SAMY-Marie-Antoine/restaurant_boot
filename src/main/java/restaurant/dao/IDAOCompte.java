package restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restaurant.model.Client;
import restaurant.model.Compte;
import restaurant.model.Gestionnaire;

public interface IDAOCompte extends JpaRepository<Compte, Integer>{
	
    @Query("from Client")
	public List<Client> findAllClient();
    @Query("from Gestionnaire")
	public List<Gestionnaire> findAllGestionnaire();
}
