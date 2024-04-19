package restaurant.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JsonView(Views.Common.class)

	private Avis avis;
	@OneToMany(mappedBy = "commande")
	@JsonView(Views.DetailCommandeWithVentes.class)
	//@JoinColumn(name="")
	private List<DetailCommande> detailCommandes;
	@Column(length=140)
	private String commentaire;
	@Column(nullable=false,columnDefinition="DATE")
	@JsonView(Views.Common.class)
	private LocalDate dateCommande;
	@Column(nullable=false,columnDefinition="TIME")
	@JsonView(Views.Common.class)
	private LocalTime heureCommande;
		
	public Commande() {	}




	//#Todo

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
		
		//List<DetailCommande>  lDCcmd = this.detailCommandes;
	    DetailCommande dCmd = new DetailCommande();
		
		double montant=0;
		int idx;
		for (idx = 0; idx < this.detailCommandes.size(); idx++) {
			dCmd  = this.detailCommandes.get(idx);
		
			montant=montant+ dCmd.getPrix() * dCmd.getQty();
		}
		return montant;
	
	}
}
