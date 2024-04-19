package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Gestionnaire;

public interface IDAOGestionnaire extends JpaRepository<Gestionnaire,Integer> {

}
