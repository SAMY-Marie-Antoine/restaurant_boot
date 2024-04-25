package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOFormule;
import restaurant.model.Formule;

@Service
public class FormuleService {

    @Autowired
	IDAOFormule daoFormule;
	
	public Formule getById(Integer id) 
	{
		Optional<Formule> opt = daoFormule.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Formule) opt.get();
		}
	}

	public List<Formule> getAll()
	{
		return daoFormule.findAll();
	}
	
	public Formule insert(Formule formule) 
	{
		return daoFormule.save(formule);
	}
	
	public Formule update(Formule formule) 
	{
		if(formule.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoFormule.save(formule);
	}
	
	public void delete(Formule formule) 
	{
		daoFormule.delete(formule);
	}
	public void deleteById(Integer id) 
	{
		daoFormule.deleteById(id);
	}
}
