package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDaoImpl;
import model.Article;
import model.Panier;

@WebServlet("/commande")
public class ServletCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Panier panier = new Panier();

	public ServletCommande() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("art") != null) {
			int idArticle = Integer.parseInt(request.getParameter("art"));
			Article article = null;
			try {
				article = new ArticleDaoImpl().findById(idArticle);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			int qte = Integer.parseInt(request.getParameter("qte"));

			if (article != null && qte != 0) {
				panier.addItem(article, qte);
			}
		}
		request.getSession(true).setAttribute("total", panier.getTotal());
		request.getSession(true).setAttribute("items", panier.getItems());
		request.getRequestDispatcher("WEB-INF/pageCommande.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("empty") != null) {
			panier = new Panier();
			request.getSession(true).setAttribute("total", panier.getTotal());
			request.getSession(true).setAttribute("items", panier.getItems());
			request.getRequestDispatcher("WEB-INF/pageCommande.jsp").forward(request, response);
		} else {
			request.getSession(true).setAttribute("total", panier.getTotal());
			request.getSession(true).setAttribute("items", panier.getItems());
			request.getRequestDispatcher("WEB-INF/pageFacture.jsp").forward(request, response);
		}
	}

}
