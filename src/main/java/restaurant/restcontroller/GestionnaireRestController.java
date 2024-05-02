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

import restaurant.model.Client;
import restaurant.model.Gestionnaire;
import restaurant.restcontroller.dto.ConnexionDTO;
import restaurant.service.GestionnaireService;
import restaurant.view.Views;
//import restaurant.view.Views.Common;

@RestController
@RequestMapping("/api/gestionaires")
@CrossOrigin("*")
public class GestionnaireRestController {

	@Autowired
	GestionnaireService gestionnaireSrv;
	
	@GetMapping
	@JsonView(Views.Gestionnaire.class)
	public List<Gestionnaire> allClients() 
	{
		return gestionnaireSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Gestionnaire.class)
	public Gestionnaire ficheGestionnaire(@PathVariable Integer id) 
	{
		return gestionnaireSrv.getById(id);
	}
	
	@PostMapping
	public Gestionnaire ajoutGestionnaire(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le gestionnaire n'est pas valide");
		}
		return gestionnaireSrv.insert(gestionnaire);
	}
	
	@PutMapping("/{id}")
	public Gestionnaire modifierGestionnaire(@PathVariable Integer id,@RequestBody Gestionnaire gestionnaire) 
	{
		gestionnaire.setId(id);
		return gestionnaireSrv.update(gestionnaire);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerGestionnaire(@PathVariable Integer id) 
	{
		gestionnaireSrv.deleteById(id);
	}

	@PostMapping("/login")
	@JsonView(Views.Gestionnaire.class)
	public Gestionnaire connexion(@RequestBody ConnexionDTO connexionDTO) {
		Gestionnaire gestionnaire = this.gestionnaireSrv.findByUsernameAndPassword(connexionDTO.getUsername(), connexionDTO.getPassword());
		
		if(gestionnaire == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return gestionnaire;
	}
	
}
