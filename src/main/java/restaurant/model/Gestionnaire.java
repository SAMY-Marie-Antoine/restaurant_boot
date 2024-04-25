package restaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("gestionnaire")
public class Gestionnaire extends Compte{

	public Gestionnaire() {}
	
	public Gestionnaire(String username) {
		super(username);
	}

	public void supprimerClientsObsoletes() {
		//TODO WHEN DAOClient
	};
	
	public void supprimerCommandesObsoletes() {
		//TODO WHEN DAOCommandes
	};
}
