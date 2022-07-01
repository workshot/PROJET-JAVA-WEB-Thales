package listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.ArticleDaoImpl;
import dao.CategorieDaoImpl;
import model.Article;
import model.Categorie;

@WebListener
public class ListenerAppli implements ServletContextListener {
	private static List<Article> articles = new ArrayList<>();
	private static List<Categorie> lCtegories = new ArrayList<>();
	private static Map<Integer, String> categories = new HashMap<>();

	public ListenerAppli() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("coucou nouvelle appli");
		try {
			articles = new ArticleDaoImpl().findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			lCtegories = new CategorieDaoImpl().findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for (Categorie c : lCtegories) {
			categories.put(c.getId(), c.getNom().toUpperCase());
		}
		arg0.getServletContext().setAttribute("articles", articles);
		arg0.getServletContext().setAttribute("categories", categories);
	}

}
