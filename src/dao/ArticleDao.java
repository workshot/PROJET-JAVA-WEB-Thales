package dao;

import java.sql.SQLException;
import java.util.List;

import model.Article;

public interface ArticleDao extends Dao<Article, Integer> {

	List<Article> selectByName(String nom) throws ClassNotFoundException, SQLException;

}
