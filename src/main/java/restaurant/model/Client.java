package restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {

	
	@OneToMany(mappedBy="client")
	@JsonView(Views.CommandeWithVentes.class)
	private List<Commande> histCommandes;
		
	public Client() {}

	public Client(Integer id, String username) {
		super(id,username);
	}

	public Client(String username) {
		super(username);
	}

	public List<Commande> getHistCommandes() {
		return histCommandes;
	}

	public void setHistCommandes(List<Commande> histCommandes) {
		this.histCommandes = histCommandes;
	}
	
	public void dateDerniereActivite() {
		//TODO avec DAOCommande
	}

}
