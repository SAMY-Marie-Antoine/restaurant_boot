package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOAvis;
import restaurant.model.Avis;

@Service
public class AvisService {

    @Autowired
	IDAOAvis daoAvis;
	
	public Avis getById(Integer id) 
	{
		Optional<Avis> opt = daoAvis.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Avis) opt.get();
		}
	}

	public List<Avis> getAll()
	{
		return daoAvis.findAll();
	}
	
	public Avis insert(Avis avis) 
	{
		
		return daoAvis.save(avis);
	}
	
	public Avis update(Avis avis) 
	{
		if(avis.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoAvis.save(avis);
	}
	
	public void delete(Avis avis) 
	{
		daoAvis.delete(avis);
	}
	public void deleteById(Integer id) 
	{
		daoAvis.deleteById(id);
	}
}
