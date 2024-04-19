package restaurant.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;


@Entity
@Table(name="detailCommande")
public class DetailCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
	@JsonView(Views.Common.class)
	private double prix;
	@Column
	private int qte;
	@JoinColumn(nullable = false )
	@JsonView(Views.Common.class)
	@ManyToOne
	private Commande commande;
	@JoinColumn(nullable = false )
	@JsonView(Views.Common.class)
	@ManyToOne
	private Produit produit;
	
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	



	@Column
	private boolean dansFormule;

	@Enumerated(EnumType.STRING)
	@Column(name="type_produit",nullable = false, columnDefinition = "ENUM('Entrée','Plat','Dessert','Boisson')")
	private TypeProduit type;
	@Column(nullable = false )
	@JsonView(Views.Common.class)
	private String libelleFormule;
		
	
	
	public DetailCommande() {}

	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public int getqte() {
		return qte;
	}



	public void setqte(int qte) {
		this.qte = qte;
	}



	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}







	public boolean isDansFormule() {
		return dansFormule;
	}



	public void setDansFormule(boolean dansFormule) {
		this.dansFormule = dansFormule;
	}



	public TypeProduit getType() {
		return type;
	}



	public void setType(TypeProduit type) {
		this.type = type;
	}



	public String getLibelleFormule() {
		return libelleFormule;
	}



	public void setLibelleFormule(String libelleFormule) {
		this.libelleFormule = libelleFormule;
	}
	

	



}
