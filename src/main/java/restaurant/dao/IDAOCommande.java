package restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Client;
import restaurant.view.Views.Commande;

public interface IDAOCommande extends JpaRepository<Commande, Integer>{
    
	public List<Commande> findByClient(Client client);
		
}
