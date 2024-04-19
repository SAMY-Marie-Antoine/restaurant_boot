package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Client;

public interface IDAOClient extends JpaRepository<Client, Integer>{
	
}
