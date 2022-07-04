package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDaoImpl;
import model.Article;

@WebServlet("/RechercheArticles")
public class ServletRechercheArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Article> articlesRecherches = new ArrayList<>();

	public ServletRechercheArticles() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pageArticlesRecherches.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		try {
			articlesRecherches = new ArticleDaoImpl().selectByName(nom);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getServletContext().setAttribute("articlesR", articlesRecherches);

		doGet(request, response);

	}

}
