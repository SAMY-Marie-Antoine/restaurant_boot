package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;


@Entity
@Table(name="detail_commande")
public class DetailCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
	@JsonView(Views.Common.class)
	private double prix;
	@Column
	@JsonView(Views.Common.class)
	private int qte;
	@JsonView(Views.DetailCommande.class)
	@ManyToOne
	@JoinColumn
	private Commande commande;
	@OneToOne
	@JoinColumn
	@JsonView(Views.Common.class)
	private Produit produit;
	@OneToOne
	@JoinColumn
	@JsonView(Views.Common.class)
	private Menu menu;
		
	public DetailCommande() {}

	public DetailCommande(int qte, Commande commande, Menu menu) {
		this.qte = qte;
		this.commande = commande;
		this.menu = menu;
		this.prix = qte*menu.getFormule().getPrix();
	}

	public DetailCommande(int qte, Commande commande, Produit produit) {
		this.qte = qte;
		this.commande = commande;
		this.produit = produit;
		this.prix = qte*produit.getPrix();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
