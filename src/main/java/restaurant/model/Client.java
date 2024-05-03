package restaurant.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {

	
	@OneToMany(mappedBy="client")
	//@JsonView(Views.Client.class)
	private List<Commande> histCommandes;
		
	public Client() {}

	public Client(Integer id, String username, String password) {
		super(id,username, password);
	}

	public Client(String username, String password) {
		super(username, password);
	}

	public List<Commande> getHistCommandes() {
		return histCommandes;
	}

	public void setHistCommandes(List<Commande> histCommandes) {
		this.histCommandes = histCommandes;
	}
	
	public void dateDerniereActivite() {
		//TODO
	}

}
