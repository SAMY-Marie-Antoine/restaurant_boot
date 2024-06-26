package restaurant.restcontroller;

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

import restaurant.model.Commande;
import restaurant.service.CommandeService;

import restaurant.view.Views;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin("*")
public class CommandeRestController {

	@Autowired 
	CommandeService commandeSrv;

	@GetMapping
	@JsonView(Views.Commande.class)
	public List<Commande> allCommande() 
	{
		return commandeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Commande.class)
	public Commande ficheCommande(@PathVariable Integer id) 
	{
		return commandeSrv.getById(id);
	}

	/*test*/
	@GetMapping("/ventes/{id}")
	@JsonView(Views.CommandeWithVentes.class)
	public Commande ficheCommandeAvecVentes(@PathVariable Integer id) 
	{
		return commandeSrv.getById(id);
	}
	/*test*/
	@GetMapping("/details/{id}")
	@JsonView(Views.DetailCommande.class)
	public Commande ficheCommandeDetails(@PathVariable Integer id) 
	{
		return commandeSrv.getById(id);
	}
	/*test*/
	@GetMapping("/detailsetventes/{id}")
	@JsonView(Views.CommandeWithDetailsWithVentes.class)
	public Commande ficheCommandeDetailsClient(@PathVariable Integer id) 
	{
		return commandeSrv.getById(id);
	}
	@PostMapping
	public Commande ajoutCommande(@Valid @RequestBody Commande commande, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le commande n'est pas valide");
		}
		return commandeSrv.insert(commande);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Commande.class)
	public Commande modifierCommande(@PathVariable Integer id,@RequestBody Commande commande) 
	{
		commande.setId(id);
		return commandeSrv.update(commande);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerCommande(@PathVariable Integer id) 
	{
		commandeSrv.deleteById(id);
	}
	
}
