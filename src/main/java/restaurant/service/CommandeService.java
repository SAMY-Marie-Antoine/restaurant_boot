package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOCommande;
import restaurant.model.Commande;

@Service
public class CommandeService {

    @Autowired
	IDAOCommande daoCommande;
	
	public Commande getById(Integer id) 
	{
		Optional<Commande> opt = daoCommande.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Commande) opt.get();
		}
	}

	public List<Commande> getAll()
	{
		return daoCommande.findAll();
	}
	
	public Commande insert(Commande commande) 
	{
		
		return daoCommande.save(commande);
	}
	
	public Commande update(Commande commande) 
	{
		if(commande.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoCommande.save(commande);
	}
	
	public void delete(Commande commande) 
	{
		daoCommande.delete(commande);
	}
	public void deleteById(Integer id) 
	{
		daoCommande.deleteById(id);
	}

}
