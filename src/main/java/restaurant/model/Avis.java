package restaurant.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
@Table(name="avis")
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(length = 250, nullable=false)
	@JsonView(Views.Common.class)
	private String avis;
	@OneToOne
	@JoinColumn(name="id_commande",nullable=false)
	@JsonView(Views.Client.class)
	private Commande commande;
	@Column(nullable=false)
	@JsonView(Views.Common.class)
	private LocalTime heure;
	@Column(nullable=false)
	private LocalDate date;
	
	public Avis() {}

	public Avis(Integer id, String avis, Commande commande) {
		this.id = id;
		this.avis = avis;
		this.commande = commande;
		this.heure = LocalTime.now();
		this.date = LocalDate.now();
	}
	
	public Avis(String avis, Commande commande) {
		this.avis = avis;
		this.commande = commande;
		this.heure = LocalTime.now();
		this.date = LocalDate.now();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalTime getHeure() {
		return this.heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
