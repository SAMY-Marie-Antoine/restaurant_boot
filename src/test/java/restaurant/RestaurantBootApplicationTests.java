package restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import restaurant.dao.IDAOProduit;
import restaurant.model.Client;
import restaurant.model.Produit;
import restaurant.model.TypeProduit;
import restaurant.dao.IDAOClient;
//import restaurant.dao.IDAOFormule;

@SpringBootTest
class RestaurantBootApplicationTests {

	
	
	@Autowired
    IDAOProduit produitSrv;
    @Autowired
    IDAOClient clientSrv;
    @Autowired
    //IDAOFormule formuleSrv;

	@Test
	void contextLoads() {
		Produit entree1 = new Produit("Salade Verte",8.50,10,true,TypeProduit.entree,false,false,true,false,true,true,true);
        Produit entree2 = new Produit("Soupe Miso",7.20,10,true,TypeProduit.entree,false,true,false,false,true,true,true);
        Produit entree3 = new Produit("Tabouleh",10.90,10,false,TypeProduit.entree,false,false,false,false,false,true,true);

        produitSrv.save(entree1);
        produitSrv.save(entree2);
        produitSrv.save(entree3);

        Produit plat1 = new Produit("Pâtes au saumon",18.90,10,true,TypeProduit.plat, false,true,false,true,false,true,false);
        Produit plat2 = new Produit("Assiette Vegan",16.90,10,true,TypeProduit.plat,false,true,true,false,true,true,true);
        Produit plat3 = new Produit("Ragoût de Tofu",21.90,10,true,TypeProduit.plat,false,true,true,false,true,true,true);
        Produit plat4 = new Produit("Tajine Agneau",24.90,10,false,TypeProduit.plat,false,false,true,false,false,true,false);

        produitSrv.save(plat1);
        produitSrv.save(plat2);
        produitSrv.save(plat3);
        produitSrv.save(plat4);

        Produit dessert1 = new Produit("Tarte à la crème",9.50,10,true,TypeProduit.dessert,true,true,false,true,false,true,false);
        Produit dessert2 = new Produit("Gâteau aux noisettes",8.90,10,true,TypeProduit.dessert,false,true,true,false,false,true,true);
        Produit dessert3 = new Produit("Brownie",6.50,10,false,TypeProduit.dessert,true,false,true,true,false,true,false);

        produitSrv.save(dessert1);
        produitSrv.save(dessert2);
        produitSrv.save(dessert3);

        Produit boisson1 = new Produit("Thé glacé",5.10,10,false,TypeProduit.boisson,false,false,false,false,false,true,true);
        Produit boisson2 = new Produit("Cola",3.8,10,true,TypeProduit.boisson,false,false,false,false,false,true,true);

        produitSrv.save(boisson1);
        produitSrv.save(boisson2);

        /*Client client1 = new Client("jordanabid");
        Client client2 = new Client("alicebob");

        clientSrv.save(client1);
        clientSrv.save(client2);

        Gestionnaire gest1 = new Gestionnaire("gordonramsay");

        clientSrv.save(gest1);

        List<TypeProduit> list1 = new ArrayList<TypeProduit>();
        Collections.addAll(list1,TypeProduit.entree,TypeProduit.plat,TypeProduit.dessert);
        List<TypeProduit> list2 = new ArrayList<TypeProduit>();
        Collections.addAll(list2,TypeProduit.plat,TypeProduit.boisson);
        List<TypeProduit> list3 = new ArrayList<TypeProduit>();
        Collections.addAll(list3,TypeProduit.plat,TypeProduit.dessert);

        Formule formule1 = new Formule("EntreePlatDessert",36,list1);
        Formule formule2 = new Formule("PlatBoisson",18,list2);
        Formule formule3 = new Formule("PlatDessert",20,list3);

        formuleSrv.save(formule1);
        formuleSrv.save(formule2);
        formuleSrv.save(formule3);*/
	}
	
	
}
