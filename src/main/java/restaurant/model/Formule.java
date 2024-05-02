package restaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
@Table(name="formule")
public class Formule {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(nullable = false,length = 35 )
	@JsonView(Views.Common.class)
	private String libelle;
	@Column(nullable =false,columnDefinition="DECIMAL(5,2)")
	@JsonView(Views.Common.class)
	private double prix;
	@ElementCollection(targetClass=TypeProduit.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="composition_formule")
	@Column(name="type_produit",nullable = false)
	@JsonView(Views.Formule.class)
	private List<TypeProduit> typeProduits=new ArrayList<TypeProduit>();
	
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_pte;
	
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_gde;
	
	

	
	
	public Formule() {}

	public Formule(Integer id, String libelle, double prix, List<TypeProduit> typeProduits) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.typeProduits = typeProduits;
	}
	
	public Formule(String libelle, double prix, List<TypeProduit> typeProduits) {
		this.libelle = libelle;
		this.prix = prix;
		this.typeProduits = typeProduits;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<TypeProduit> getTypeProduits() {
		return typeProduits;
	}

	public void setTypeProduits(List<TypeProduit> typeProduits) {
		this.typeProduits = typeProduits;
	}

	public void afficherDetail() {
		//#Todo
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
