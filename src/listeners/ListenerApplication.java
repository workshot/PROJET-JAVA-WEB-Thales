package listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import dao.ArticleDaoImpl;
import model.Article;


/**
 * Application Lifecycle Listener implementation class ListenerApplication
 *
 */
@WebListener
public class ListenerApplication implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public ListenerApplication() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
    	
    	  List<Article> articles = new ArrayList(); 
    	  try {
			articles = new ArticleDaoImpl().findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
          arg0.getServletContext().setAttribute("articles", articles);
    }
	
}
