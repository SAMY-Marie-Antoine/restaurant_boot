package restaurant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@ManyToMany
	@JsonView(Views.Common.class)
	private List<Produit> produits;
	@ManyToOne
	@JsonView(Views.Common.class)
	private Formule formule;
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_pte;
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_gde;
	
	
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
	public String getNom_photo_pte() {
		return nom_photo_pte;
	}


	public void setNom_photo_pte(String nom_photo_pte) {
		this.nom_photo_pte = nom_photo_pte;
	}


	public String getNom_photo_gde() {
		return nom_photo_gde;
	}


	public void setNom_photo_gde(String nom_photo_gde) {
		this.nom_photo_gde = nom_photo_gde;
	}

}
