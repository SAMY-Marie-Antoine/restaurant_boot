package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOCompte;
import restaurant.model.Client;
import restaurant.model.Compte;
import restaurant.model.Gestionnaire;

@Service
public class GestionnaireService {

	
	@Autowired
	IDAOCompte daoGestionnaire;
	
	public Gestionnaire getById(Integer id) 
	{
		Optional<Compte> opt = daoGestionnaire.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Gestionnaire) opt.get();
		}
	}
	
	public List<Gestionnaire> getAll()
	{
		return daoGestionnaire.findAllGestionnaire();
	}
	
	public Gestionnaire insert(Gestionnaire gestionnaire) 
	{
		
		return daoGestionnaire.save(gestionnaire);
	}
	
	public Gestionnaire update(Gestionnaire gestionnaire) 
	{
		if(gestionnaire.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoGestionnaire.save(gestionnaire);
	}
	
	public void delete(Gestionnaire gestionnaire) 
	{
		daoGestionnaire.delete(gestionnaire);
	}
	public void deleteById(Integer id) 
	{
		daoGestionnaire.deleteById(id);
	}
	
	public Gestionnaire findByUsernameAndPassword(String username, String password){
		return (Gestionnaire) daoGestionnaire.findByUsernameAndPassword(username,password);
	}
	
}
