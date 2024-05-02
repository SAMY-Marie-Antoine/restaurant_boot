package restaurant.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.model.Menu;
import restaurant.service.MenuService;
import restaurant.view.Views;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin("*")
public class MenuRestController {
	
	@Autowired 
	MenuService menuSrv;

	@GetMapping
	@JsonView(Views.Menu.class)
	public List<Menu> allMenu() 
	{
		return menuSrv.getAll();
	}

	@PostMapping
	@JsonView(Views.Menu.class)
	public Menu newMenu(@Valid @RequestBody Menu menu) 
	{
		return menuSrv.insert(menu);
	}

}
