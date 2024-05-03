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

import restaurant.model.Avis;
import restaurant.service.AvisService;
import restaurant.view.Views;

@RestController
@RequestMapping("/api/avis")
@CrossOrigin("*")
public class AvisRestController {
	
	@Autowired 
	AvisService avisSrv;

	@GetMapping
	@JsonView(Views.Avis.class)
	public List<Avis> allAvis() 
	{
		return avisSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Avis.class)
	public Avis ficheAvis(@PathVariable Integer id) 
	{
		return avisSrv.getById(id);
	}

	@PostMapping
	public Avis ajoutAvis(@Valid @RequestBody Avis avis, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'avis n'est pas valide");
		}
		return avisSrv.insert(avis);
	}
	
	@PutMapping("/{id}")
	public Avis modifierProduit(@PathVariable Integer id,@RequestBody Avis avis) 
	{
		avis.setId(id);
		return avisSrv.update(avis);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerAvis(@PathVariable Integer id) 
	{
		avisSrv.deleteById(id);
	}
}
