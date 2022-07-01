package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Panier;

@WebServlet("/facture")
public class ServletFacture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Panier panier = new Panier();

	public ServletFacture() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pageCommande.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("total", panier.getTotal());
		request.setAttribute("items", panier.getItems());
		request.getRequestDispatcher("WEB-INF/pageFacture.jsp").forward(request, response);

	}

}
