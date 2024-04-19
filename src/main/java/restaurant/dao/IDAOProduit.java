package restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.model.Produit;
import restaurant.model.TypeProduit;

public interface IDAOProduit extends JpaRepository<Produit,Integer>{

    public List<Produit> findByType(TypeProduit type);
    
    
}
