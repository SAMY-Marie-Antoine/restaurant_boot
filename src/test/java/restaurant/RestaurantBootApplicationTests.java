package restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import restaurant.dao.IDAOProduit;
import restaurant.model.Client;
import restaurant.model.Formule;
import restaurant.model.Gestionnaire;
import restaurant.model.Produit;
import restaurant.model.TypeProduit;
import restaurant.service.ClientService;
import restaurant.service.FormuleService;
import restaurant.service.ProduitService;
import restaurant.dao.IDAOCompte;

@SpringBootTest
class RestaurantBootApplicationTests {

	
	
	@Autowired
    ProduitService produitSrv;
    @Autowired
    ClientService clientSrv;
    @Autowired
    FormuleService formuleSrv;
    @Autowired
    IDAOCompte gestionnaireSrv;

	@Test
	void contextLoads() {
		Produit entree1 = new Produit("Salade Verte",8.50,10,true,TypeProduit.entree,false,false,true,false,true,true,true);
        Produit entree2 = new Produit("Soupe Miso",7.20,10,true,TypeProduit.entree,false,true,false,false,true,true,true);
        Produit entree3 = new Produit("Tabouleh",10.90,10,false,TypeProduit.entree,false,false,false,false,false,true,true);

        produitSrv.insert(entree1);
        produitSrv.insert(entree2);
        produitSrv.insert(entree3);

        Produit plat1 = new Produit("Pâtes au saumon",18.90,10,true,TypeProduit.plat, false,true,false,true,false,true,false);
        Produit plat2 = new Produit("Assiette Vegan",16.90,10,true,TypeProduit.plat,false,true,true,false,true,true,true);
        Produit plat3 = new Produit("Ragoût de Tofu",21.90,10,true,TypeProduit.plat,false,true,true,false,true,true,true);
        Produit plat4 = new Produit("Tajine Agneau",24.90,10,false,TypeProduit.plat,false,false,true,false,false,true,false);

        produitSrv.insert(plat1);
        produitSrv.insert(plat2);
        produitSrv.insert(plat3);
        produitSrv.insert(plat4);

        Produit dessert1 = new Produit("Tarte à la crème",9.50,10,true,TypeProduit.dessert,true,true,false,true,false,true,false);
        Produit dessert2 = new Produit("Gâteau aux noisettes",8.90,10,true,TypeProduit.dessert,false,true,true,false,false,true,true);
        Produit dessert3 = new Produit("Brownie",6.50,10,false,TypeProduit.dessert,true,false,true,true,false,true,false);

        produitSrv.insert(dessert1);
        produitSrv.insert(dessert2);
        produitSrv.insert(dessert3);

        Produit boisson1 = new Produit("Thé glacé",5.10,10,false,TypeProduit.boisson,false,false,false,false,false,true,true);
        Produit boisson2 = new Produit("Cola",3.8,10,true,TypeProduit.boisson,false,false,false,false,false,true,true);

        produitSrv.insert(boisson1);
        produitSrv.insert(boisson2);

        Client client1 = new Client("jordanabid");
        Client client2 = new Client("alicebob");

        clientSrv.insert(client1);
        clientSrv.insert(client2);

        Gestionnaire gest1 = new Gestionnaire("gordonramsay");

        gestionnaireSrv.save(gest1);

        List<TypeProduit> list1 = new ArrayList<TypeProduit>();
        Collections.addAll(list1,TypeProduit.entree,TypeProduit.plat,TypeProduit.dessert);
        List<TypeProduit> list2 = new ArrayList<TypeProduit>();
        Collections.addAll(list2,TypeProduit.plat,TypeProduit.boisson);
        List<TypeProduit> list3 = new ArrayList<TypeProduit>();
        Collections.addAll(list3,TypeProduit.plat,TypeProduit.dessert);

        Formule formule1 = new Formule("EntreePlatDessert",36,list1);
        Formule formule2 = new Formule("PlatBoisson",18,list2);
        Formule formule3 = new Formule("PlatDessert",20,list3);

        formuleSrv.insert(formule1);
        formuleSrv.insert(formule2);
        formuleSrv.insert(formule3);
	}
	
	
}
