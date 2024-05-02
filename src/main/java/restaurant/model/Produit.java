package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
@Table(name="produit")
@Component  
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(nullable = false,length = 35)
	@JsonView(Views.Common.class)
	private String libelle;
	@Column(nullable = false,columnDefinition="DECIMAL(5,2)")
	@JsonView(Views.Common.class)
	private double prix;
	@Column(nullable=false,columnDefinition="INT")
	@JsonView(Views.Common.class)
	private int stock;
	@Column(nullable=false)
	@JsonView(Views.Common.class)
	private boolean dansFormule;
	@Enumerated(EnumType.STRING)
	@Column(name="type_produit",nullable = false, columnDefinition = "ENUM('entree','plat','dessert','boisson')")
	@JsonView(Views.Common.class)
	private TypeProduit type;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean allergie_oeufs;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean allergie_gluten;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean allergie_arachides;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean allergie_lait;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean allergie_soja;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean hallal;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private boolean vegan;
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_pte;
	@Column()
	@JsonView(Views.Common.class)
	private String nom_photo_gde;
	
	
	public Produit() {}
	

	public Produit(Integer id, String libelle, double prix, int stock, boolean dansFormule, TypeProduit type, boolean allergie_oeufs, boolean allergie_gluten, boolean allergie_arachides, boolean allergie_lait, boolean allergie_soja, boolean hallal, boolean vegan) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.stock = stock;
		this.dansFormule = dansFormule;
		this.type = type;
		this.allergie_oeufs = allergie_oeufs;
		this.allergie_gluten = allergie_gluten;
		this.allergie_arachides = allergie_arachides;
		this.allergie_lait = allergie_lait;
		this.allergie_soja = allergie_soja;
		this.hallal = hallal;
		this.vegan = vegan;
	}
	
	public Produit(String libelle, double prix, int stock, boolean dansFormule, TypeProduit type, boolean allergie_oeufs, boolean allergie_gluten, boolean allergie_arachides, boolean allergie_lait, boolean allergie_soja, boolean hallal, boolean vegan) {
		this.libelle = libelle;
		this.prix = prix;
		this.stock = stock;
		this.dansFormule = dansFormule;
		this.type = type;
		this.allergie_oeufs = allergie_oeufs;
		this.allergie_gluten = allergie_gluten;
		this.allergie_arachides = allergie_arachides;
		this.allergie_lait = allergie_lait;
		this.allergie_soja = allergie_soja;
		this.hallal = hallal;
		this.vegan = vegan;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean getDansFormule() {
		return this.dansFormule;
	}


	public boolean getAllergie_oeufs() {
		return this.allergie_oeufs;
	}


	public boolean getAllergie_gluten() {
		return this.allergie_gluten;
	}


	public boolean getAllergie_arachides() {
		return this.allergie_arachides;
	}


	public boolean getAllergie_lait() {
		return this.allergie_lait;
	}


	public boolean getAllergie_soja() {
		return this.allergie_soja;
	}


	public boolean getHallal() {
		return this.hallal;
	}


	public boolean getVegan() {
		return this.vegan;
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

	public boolean isAllergie_oeufs() {
		return allergie_oeufs;
	}


	public void setAllergie_oeufs(boolean allergie_oeufs) {
		this.allergie_oeufs = allergie_oeufs;
	}


	public boolean isAllergie_gluten() {
		return allergie_gluten;
	}


	public void setAllergie_gluten(boolean allergie_gluten) {
		this.allergie_gluten = allergie_gluten;
	}


	public boolean isAllergie_arachides() {
		return allergie_arachides;
	}


	public void setAllergie_arachides(boolean allergie_arachides) {
		this.allergie_arachides = allergie_arachides;
	}


	public boolean isAllergie_lait() {
		return allergie_lait;
	}


	public void setAllergie_lait(boolean allergie_lait) {
		this.allergie_lait = allergie_lait;
	}


	public boolean isAllergie_soja() {
		return allergie_soja;
	}


	public void setAllergie_soja(boolean allergie_soja) {
		this.allergie_soja = allergie_soja;
	}


	public boolean isHallal() {
		return hallal;
	}


	public void setHallal(boolean hallal) {
		this.hallal = hallal;
	}


	public boolean isVegan() {
		return vegan;
	}


	public void setVegan(boolean vegan) {
		this.vegan = vegan;
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
