package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import model.Client;

public class ClientDaoImpl implements DaoClient{

	public void delete(Client u) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bijou", "root", "root");

		String sql = "delete from  client where id= " + u.getId();

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();

	}

	public void update(Client u) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bijou", "root", "root");

		String sql = "update client set id='" + u.getId() + "',password='" + u.getPassword() + "',nom="+u.getNom()+ "',adresse="+u.getAdresse()+ "',email="+u.getEmail()+ "',tel="+u.getTel()+ "',livraison="+u.getLivraison()+ " where prenom="
				+ u.getPrenom();
		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void create(Client u) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bijoux", "root", "root");

		String sql = "insert into client values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ps.setString(3, u.getNom());
		ps.setString(4, u.getPrenom());
		ps.setString(2, u.getPassword());
		ps.setString(5, u.getAdresse());
		ps.setString(6, u.getEmail());
		ps.setString(7, u.getTel());
		ps.setString(8, u.getLivraison());

		ps.executeUpdate();

		conn.close();
	}

	public List<Client> findAll() throws ClassNotFoundException, SQLException {
		ArrayList<Client> liste = new ArrayList<Client>();

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bijoux", "root", "root");

		String sql = "select * from client";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Client u = null;
		while (rs.next()) {
			u = new Client();
			u.setId(rs.getInt("id"));
			u.setNom(rs.getString("nom"));
			u.setPrenom(rs.getString("prenom"));
			u.setPassword(rs.getString("password"));
			u.setAdresse(rs.getString("adresse"));
			u.setEmail(rs.getString("email"));
			u.setTel(rs.getString("tel"));
			u.setLivraison(rs.getString("livrison"));
			liste.add(u);

		}

		conn.close();
		return liste;
	}

	public Client findById(Integer id) throws ClassNotFoundException, SQLException {
		Client u = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bijoux", "root", "root");

		String sql = "select * from client where id = " + id ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			u = new Client();
			u.setId(rs.getInt("id"));
			u.setNom(rs.getString("nom"));
			u.setPrenom(rs.getString("prenom"));
			u.setPassword(rs.getString("password"));
			u.setAdresse(rs.getString("adresse"));
			u.setEmail(rs.getString("email"));
			u.setTel(rs.getString("tel"));
			u.setLivraison(rs.getString("livraison"));
			
		}
		conn.close();
		return u;
	}


	public Client checkauthent(int id, String password) throws ClassNotFoundException, SQLException {
		Client u = findById(id);
		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}
	
	public Client connexion(int id, String motdepasse) {
		Client connectedUser = null;
		if(this.authentification(id, motdepasse)) {
			try {
				connectedUser = this.findById(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connectedUser;
	}
	
	/**
	 * 
	 * @param login
	 * @param motdepasse
	 * @return
	 */
	public boolean authentification(int id, String pass) {
		boolean estAuthentifie = false;
		Client userToFind = null;
		try {
			userToFind = this.findById(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userToFind != null) {
			if(userToFind.getPassword().equals(pass)) {
				estAuthentifie = true;
			}
		}
		return estAuthentifie;
	}

	/**
	 * 
	 * @param login_ou_nom
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean isUserExists(int id) throws ClassNotFoundException, SQLException {
		return (this.findById(id) != null);
	}
	
	/**
	 * 
	 * @param login
	 * @param nom
	 * @param motdepasse
	 * @param seSouvenirdeMoi
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean inscription(int id, String nom, String pass, boolean seSouvenirdeMoi) throws ClassNotFoundException, SQLException {
		boolean estInscrit = false;
		
		if(!this.isUserExists(id)) {
			Client nouvelInscrit = new Client();
			nouvelInscrit.setNom(nom);
			estInscrit = true;
		}
		return estInscrit;
	}

	

	


	
	

	
}
