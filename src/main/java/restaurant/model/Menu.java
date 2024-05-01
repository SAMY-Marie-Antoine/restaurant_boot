package restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
public class Menu{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@OneToMany
	@JsonView(Views.Common.class)
	//@JsonView(Views.ProduitWithVentes.class)
	private List<Produit> produits;
	@ManyToOne
	//@JsonView(Views.MenuWithFormules.class)
	@JsonView(Views.Common.class)
	private Formule formule;
	
	public Menu() {	}
	

	public Menu(List<Produit> produits, Formule formule) {
		this.produits = produits;
		this.formule = formule;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

}
