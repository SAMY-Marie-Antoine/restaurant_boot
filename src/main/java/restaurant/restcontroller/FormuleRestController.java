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

import restaurant.model.Formule;
//import restaurant.model.Produit;
import restaurant.service.FormuleService;
import restaurant.view.Views;

@RestController
@RequestMapping("/api/formule")
@CrossOrigin("*")
public class FormuleRestController {
	
	@Autowired 
	FormuleService formuleSrv;
	
	@GetMapping
	@JsonView(Views.Formule.class)
	public List<Formule> allFormules() 
	{
		return formuleSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Formule.class)
	public Formule ficheFormule(@PathVariable Integer id) 
	{
		return formuleSrv.getById(id);
	}
	
	@PostMapping
	public Formule ajoutFormule(@Valid @RequestBody Formule formule, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La formule n'est pas valide");
		}
		return formuleSrv.insert(formule);
	}
	
	@PutMapping("/{id}")
	public Formule modifierFormule(@PathVariable Integer id,@RequestBody Formule formule) 
	{
		formule.setId(id);
		return formuleSrv.update(formule);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerFormule(@PathVariable Integer id) 
	{
		formuleSrv.deleteById(id);
	}
}
