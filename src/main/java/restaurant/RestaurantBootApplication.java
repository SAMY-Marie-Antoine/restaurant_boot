package restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import restaurant.dao.IDAOGestionnaire;
import restaurant.model.Client;
import restaurant.model.Formule;
import restaurant.model.Gestionnaire;
import restaurant.model.Produit;
import restaurant.model.TypeProduit;
import restaurant.service.ClientService;
import restaurant.service.ProduitService;

@SpringBootApplication
public class RestaurantBootApplication {
	
	
 


	public static void main(String[] args) {
		SpringApplication.run(RestaurantBootApplication.class, args);
		
		
	        	
		
	}

}
