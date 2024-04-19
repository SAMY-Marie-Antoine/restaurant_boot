package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import restaurant.view.Views;

@Entity

@Table(name="article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	private DetailCommande detailCommande;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DetailCommande getDetailCommande() {
		return detailCommande;
	}

	public void setDetailCommande(DetailCommande detailCommande) {
		this.detailCommande = detailCommande;
	}

	public Article(Integer id, DetailCommande detailCommande) {
		// TODO Auto-generated constructor stub
	}

	public Article(DetailCommande detailCommande) {
		// TODO Auto-generated constructor stub
	}

}
