package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDaoImpl;

import model.Client;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InscriptionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String livraison = request.getParameter("livraison");
			
        Client u = new Client(id, nom, prenom, password, adresse, email, tel, livraison);
	
		ClientDaoImpl user = new ClientDaoImpl();
		
        boolean estInscrit = false;
        PrintWriter pwOut = response.getWriter(); 
        try {
		if(! new ClientDaoImpl().isUserExists(id)) {
			user.create(u);
		
			estInscrit = true;
	     
		}else{
		// afficher user existe
			//pwOut.print("<p style=\"color:red\">l'utilisateur existe déja!</p>");
			response.setContentType("text/html");  
			pwOut.println("<script type=\"text/javascript\">");  
			pwOut.println("alert('l'utilisateur existe déja!');");  
			pwOut.println("</script>");
			
			
		}
		pwOut.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
