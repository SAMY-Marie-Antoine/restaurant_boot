package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOMenu;
import restaurant.model.Menu;

@Service
public class MenuService {

    @Autowired
	IDAOMenu daoMenu;
	
	public Menu getById(Integer id) 
	{
		Optional<Menu> opt = daoMenu.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Menu) opt.get();
		}
	}

	public List<Menu> getAll()
	{
		return daoMenu.findAll();
	}
	
	public Menu insert(Menu menu) 
	{
		
		return daoMenu.save(menu);
	}
	
	public Menu update(Menu menu) 
	{
		if(menu.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoMenu.save(menu);
	}
	
	public void delete(Menu menu) 
	{
		daoMenu.delete(menu);
	}
	public void deleteById(Integer id) 
	{
		daoMenu.deleteById(id);
	}
}
