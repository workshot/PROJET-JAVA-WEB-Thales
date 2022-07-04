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

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import model.Article;

@WebServlet("/listeArticles")
public class ServletListeArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListeArticles() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pageListeArticles.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("supprimer") != null) {
			int id = Integer.parseInt(request.getParameter("supprimer"));
			Article article;
			try {
				ArticleDao articleDao = new ArticleDaoImpl();
				article = articleDao.findById(id);
				articleDao.delete(article);
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
		}
		doGet(request, response);

	}

}
