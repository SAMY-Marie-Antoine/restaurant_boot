package restaurant.restcontroller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.model.Client;
import restaurant.model.Compte;
import restaurant.restcontroller.dto.ConnexionDTO;
import restaurant.service.ClientService;
import restaurant.view.Views;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientRestController {
	
	@Autowired
	ClientService clientSrv;
	
	@GetMapping
	@JsonView(Views.Client.class)
	public List<Client> allClients() 
	{
		return clientSrv.getAll();
	}
	
	@PostMapping("/login")
	@JsonView(Views.Client.class)
	public HashMap<String,String> connexion(@RequestBody ConnexionDTO connexionDTO) {
		Compte client = this.clientSrv.findByUsernameAndPassword(connexionDTO.getUsername(), connexionDTO.getPassword());
		
		if(client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		HashMap<String,String> jsonmap = new HashMap<String,String> ();
		jsonmap.put("id",Integer.toString(client.getId()));
		jsonmap.put("username",client.getUsername());
		jsonmap.put("password",client.getPassword());
		if(client instanceof Client){
			jsonmap.put("gestionnaire","false");
			return jsonmap;
		}
		else{
			jsonmap.put("gestionnaire","true");
			return jsonmap;
		}
	}

	@GetMapping("/{id}")
	@JsonView(Views.Client.class)
	public Client ficheClient(@PathVariable Integer id) 
	{
		return clientSrv.getById(id);
	}
	
	@PostMapping
	public Client ajoutClient(@Valid @RequestBody Client client, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le client n'est pas valide");
		}
		return clientSrv.insert(client);
	}
	
	@PutMapping("/{id}")
	public Client modifierClient(@PathVariable Integer id,@RequestBody Client client) 
	{
		client.setId(id);
		return clientSrv.update(client);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerClient(@PathVariable Integer id) 
	{
		clientSrv.deleteById(id);
	}
	
	

}
