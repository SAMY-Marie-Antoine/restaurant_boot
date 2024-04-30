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

import restaurant.model.DetailCommande;
import restaurant.model.Produit;
import restaurant.service.DetailCommandeService;
import restaurant.view.Views;
//import restaurant.view.Views.DetailCommande;

@RestController
@RequestMapping("/api/detailCommande")
@CrossOrigin("*")
public class DCommande {
	
	@Autowired 
	DetailCommandeService dCommandeSrv;
	
	@GetMapping
	@JsonView(Views.DetailCommande.class)
	public  List<DetailCommande> allDCommandes() 
	{
		return dCommandeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.DetailCommande.class)
	public DetailCommande ficheDetailProduit(@PathVariable Integer id) 
	{
		return dCommandeSrv.getById(id);
	}

	@PostMapping
	public DetailCommande ajoutDetailCommande(@Valid @RequestBody DetailCommande detailCommande, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le détail de commande n'est pas valide");
		}
		return dCommandeSrv.insert(detailCommande);
	}
	
	@PutMapping("/{id}")
	public DetailCommande modifierDetailCommande(@PathVariable Integer id,
			@RequestBody DetailCommande detailCommande) 
	{
		detailCommande.setId(id);
		return dCommandeSrv.update(detailCommande);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerDetailCommande(@PathVariable Integer id) 
	{
		dCommandeSrv.deleteById(id);
	}
}
