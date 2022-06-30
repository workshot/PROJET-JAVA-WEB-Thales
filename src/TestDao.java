import java.sql.SQLException;
import java.util.List;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import model.Article;

public class TestDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArticleDao dao = new ArticleDaoImpl();

//		System.out.println("create");
//		Categorie persistedobjet = new Categorie(0, "categ1");
//		dao.create(persistedobjet);

		System.out.println("find all");
		List<Article> liste = dao.findAll();
		for (Article obj : liste) {
			System.out.println(obj);
		}
//		System.out.println();
//
//		System.out.println("update");
//		persistedobjet = new Categorie(7, "categ update");
//		dao.update(persistedobjet);
//
//		System.out.println("find all");
//		liste = dao.findAll();
//		for (Categorie obj : liste) {
//			System.out.println(obj);
//		}
//		System.out.println();
//
//		System.out.println("find by id");
//		Categorie obj2 = dao.findById(8);
//		System.out.println(obj2);
//		System.out.println();
//
//		System.out.println("delete");
//		dao.delete(obj2);
//
//		System.out.println("find all");
//		liste = dao.findAll();
//		for (Categorie obj : liste) {
//			System.out.println(obj);
//		}
	}

}
