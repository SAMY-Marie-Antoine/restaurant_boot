package restaurant.view;

public class Views {


	public class Common {}//Acces JSON le plus bas niveau, les attributs tels que les id, libelle auront cette projection


	public class Produit extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Compte
	public class ProduitWithVentes extends Produit{}
	public class Commande extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Filiere
	public class CommandeWithVentes extends Commande{} //Acces JSON spécifique pour les chargements toMany
	public class CommandeWithDetailsWithVentes extends CommandeWithVentes{} //Acces JSON spécifique pour les chargements toMany

	
	public class DetailCommande extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Filiere
	public class DetailCommandeAll extends DetailCommande {}
	//public class DetailCommandeWithVentes extends CommandeWithVentes{} //Acces JSON spécifique pour les chargements toMany
	//public class DetailCommande extends DetailCommande{} //Acces JSON spécifique pour les chargements toMany
	//public class DetailCommandeWithVentes extends DetailCommande{} //Acces JSON spécifique pour les chargements toMany
	

	public class Client extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Matiere
	public class ClientWithAchats extends Client{}
	
	public class Menu extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Compte
	public class MenuWithFormules extends Menu{}
	
	public class Avis extends Common {} //
	
	public class Formule extends Common {}
	
	public class Gestionnaire extends Common {}
	
}

