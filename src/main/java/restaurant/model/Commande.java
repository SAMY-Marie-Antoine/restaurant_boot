package restaurant.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity
@Table(name="commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@ManyToOne
	@JsonView(Views.CommandeWithVentes.class)
	private Client client;
	@OneToOne
	@JsonView(Views.Commande.class)
	private Avis avis;
	@OneToMany(mappedBy = "commande")
	@JsonView(Views.CommandeWithDetailsWithVentes.class)
	//@JsonView(Views.DetailCommande.class)
	private List<DetailCommande> detailCommandes;
	@Column(length=140)
	@JsonView(Views.Commande.class)
	private String commentaire;
	@Column(nullable=false,columnDefinition="DATE")
	@JsonView(Views.Commande.class)
	private LocalDate dateCommande;
	@Column(nullable=false,columnDefinition="TIME")
	@JsonView(Views.Commande.class)
	private LocalTime heureCommande;
		
	public Commande() {
		this.dateCommande  = LocalDate.now();
		this.heureCommande = LocalTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Avis getAvis() {
		return avis;
	}

	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	public List<DetailCommande> getDetailCommandes() {
		return detailCommandes;
	}

	public void setDetailCommandes(List<DetailCommande> detailCommandes) {
		this.detailCommandes = detailCommandes;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public LocalTime getHeureCommande() {
		return heureCommande;
	}

	public void setHeureCommande(LocalTime heureCommande) {
		this.heureCommande = heureCommande;
	}

	public double calculPrixTotal() {
		
	    DetailCommande dCmd = new DetailCommande();
		
		double montant=0;
		for (int idx = 0; idx < this.detailCommandes.size(); idx++) {
			dCmd  = this.detailCommandes.get(idx);
			montant=montant+ dCmd.getPrix() * dCmd.getQte();
		}
		return montant;
	}
}
