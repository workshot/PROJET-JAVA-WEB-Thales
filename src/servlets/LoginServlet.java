package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDaoImpl;
import model.Client;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		Client u = null;
		
		PrintWriter pwOut = response.getWriter(); 
		try {
			u = new ClientDaoImpl().checkauthent(id , pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if( (u != null) ){
			request.setAttribute("u", u);
			
			session.setAttribute("USER_CONNECTED_SESSION",new ClientDaoImpl().connexion(id, pass));
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
		}
		else{
		//	pwOut.print("<p style=\"color:red\">Identifiant ou mot de passe Incorrect!</p>");
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.setContentType("text/html");  
			pwOut.println("<script type=\"text/javascript\">");  
			pwOut.println("alert('Identifiant ou mot de passe Incorrect!');");  
			pwOut.println("</script>");
			RequestDispatcher view = request.getRequestDispatcher("accueil.jsp");		
			view.include(request, response);
			
		}
		pwOut.close();
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public boolean deconnecter(HttpSession session) {
		boolean estDeconnecte = false;
		Object user = session.getAttribute("USER_CONNECTED_SESSION");
		if(user != null) {
			session.invalidate();
			estDeconnecte = true;
		}
		return estDeconnecte;
	}
	
	

	public boolean inscrire(String id, String nom, String pass,boolean sesouvenirdemoi) throws ClassNotFoundException, SQLException {
		return new ClientDaoImpl().inscription(id, nom, pass,false );

	}
	
	public boolean connecter(HttpSession session, String id, String password) {
		boolean estConnecte = false;
		if(new ClientDaoImpl().authentification(id , password)) {
			session.setAttribute("USER_CONNECTED_SESSION",new ClientDaoImpl().connexion(id, password));
			estConnecte = true;
		}
		return estConnecte;
	}

}
