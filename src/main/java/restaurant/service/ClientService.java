package restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.IDAOClient;
import restaurant.model.Client;

@Service
public class ClientService {

     @Autowired
	IDAOClient daoClient;
	
	public Client getById(Integer id) 
	{
		Optional<Client> opt = daoClient.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Client) opt.get();
		}
	}

	public List<Client> getAll()
	{
		return daoClient.findAll();
	}
	
	public Client insert(Client client) 
	{
		
		return daoClient.save(client);
	}
	
	public Client update(Client client) 
	{
		if(client.getId()==null) 
		{
			throw new RuntimeException("Besoin d'un id pour faire une mise à jour.");
		}
		
		return daoClient.save(client);
	}
	
	public void delete(Client client) 
	{
		daoClient.delete(client);
	}
	public void deleteById(Integer id) 
	{
		daoClient.deleteById(id);
	}
		
}
