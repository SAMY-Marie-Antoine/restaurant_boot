package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Formule;

public interface IDAOFormule extends JpaRepository<Formule,Integer>{

}
