package listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.ArticleDaoImpl;
import model.Article;

@WebListener
public class ListenerSession implements HttpSessionListener {
	private static List<Article> articles = new ArrayList<>();

	public ListenerSession() {
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		try {
			articles = new ArticleDaoImpl().findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("articles", articles);
				
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
	}

}
