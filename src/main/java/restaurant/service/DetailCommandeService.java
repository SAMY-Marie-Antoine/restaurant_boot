package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOAvis;
import restaurant.dao.IDAODetailCommande;
import restaurant.model.Avis;
import restaurant.model.DetailCommande;

@Service
public class DetailCommandeService {

    @Autowired
	IDAODetailCommande daoDetailCommande;
	
	public DetailCommande getById(Integer id) 
	{
		Optional<DetailCommande> opt = daoDetailCommande.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (DetailCommande) opt.get();
		}
	}

	public List<DetailCommande> getAll()
	{
		return daoDetailCommande.findAll();
	}
	
	public DetailCommande insert(DetailCommande detailCommande) 
	{
		
		return daoDetailCommande.save(detailCommande);
	}
	
	public DetailCommande update(DetailCommande detailCommande) 
	{
		if(detailCommande.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoDetailCommande.save(detailCommande);
	}
	
	public void delete(DetailCommande detailCommande) 
	{
		daoDetailCommande.delete(detailCommande);
	}
	public void deleteById(Integer id) 
	{
		daoDetailCommande.deleteById(id);
	}
}
