package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.view.Views.Article;

public interface IDAOArticle extends JpaRepository<Article,Integer>{

}
