package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Menu;

public interface IDAOMenu extends JpaRepository<Menu,Integer>{

}
