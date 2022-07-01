package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommandeDaoImpl;
import dao.ItemCommandeDaoImpl;
import model.Article;
import model.Client;
import model.Commande;
import model.ItemCommande;
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
		
		request.setAttribute("total", panier.getTotal());
		request.setAttribute("items", panier.getItems());
		request.getRequestDispatcher("WEB-INF/pageFacture.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		panier.setItems((Map<Article, Integer>) request.getSession(true).getAttribute("items"));
		String idClient = "1";
		try {
			idClient = ((Client) request.getSession(true).getAttribute("USER_CONNECTED_SESSION")).getId();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		int idCommande = 0;
		double total = (Double) request.getSession(true).getAttribute("total");

		Commande commande = new Commande();
		commande.setDate(new Date());
		commande.setIdClient(idClient);
		commande.setTotal(total);

		try {
			new CommandeDaoImpl().create(commande);
			List<Commande> comms = new CommandeDaoImpl().findByIdClient(idClient);
			for (Commande c : comms) {
				idCommande = Math.max(c.getId(), idCommande);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

		for (Entry<Article, Integer> entry : panier.getItems().entrySet()) {
			ItemCommande item = new ItemCommande();
			item.setIdArticle(entry.getKey().getId());
			item.setIdCommande(idCommande);
			item.setPrixUnitaire(entry.getKey().getPrix());
			item.setQuantite(entry.getValue());

			try {
				new ItemCommandeDaoImpl().create(item);
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
		}

		request.getRequestDispatcher("WEB-INF/pageCommandeValidee.jsp").forward(request, response);

	}

}
