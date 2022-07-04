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

@WebServlet("/nouvelArticle")
public class ServletCreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCreateArticle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pageCreateArticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String description = request.getParameter("description");
		String img = request.getParameter("img");
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		Article article = new Article(0, nom, prix, description, img, idCategorie);

		try {
			new ArticleDaoImpl().create(article);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Article> articles = new ArrayList();
		try {
			articles = new ArticleDaoImpl().findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.getServletContext().setAttribute("articles", articles);

		request.getRequestDispatcher("WEB-INF/pageListeArticles.jsp").forward(request, response);
	}

}
