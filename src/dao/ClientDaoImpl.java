package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDaoImpl implements ClientDao {

	public void delete(Client c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from client where id='" + c.getId() + "'";

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(Client c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update client set nom='" + c.getNom() + "', prenom='" + c.getPrenom() + "', password='"
				+ c.getPassword() + "',adresse='" + c.getAdresse() + "',email='" + c.getEmail() + "',tel='" + c.getTel()
				+ "',livraison='" + c.getLivraison() + "' where id='" + c.getId() + "'";
		Statement st = conn.createStatement();

		st.executeUpdate(sql);
		conn.close();
	}

	public void create(Client p) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into client values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getId());
		ps.setString(2, p.getNom());
		ps.setString(3, p.getPrenom());
		ps.setString(4, p.getPassword());
		ps.setString(5, p.getAdresse());
		ps.setString(6, p.getEmail());
		ps.setString(7, p.getTel());
		ps.setString(8, p.getLivraison());
		ps.executeUpdate();

		conn.close();
	}

	public List<Client> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Client> liste = new ArrayList<>();

		String sql = "select * from client";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Client p = null;
		while (rs.next()) {
			p = new Client();
			p.setId(rs.getString("id"));
			p.setNom(rs.getString("nom"));
			p.setPrenom(rs.getString("prenom"));
			p.setPassword(rs.getString("password"));
			p.setAdresse(rs.getString("adresse"));
			p.setEmail(rs.getString("email"));
			p.setTel(rs.getString("tel"));
			p.setLivraison(rs.getString("livraison"));
			liste.add(p);
		}

		conn.close();
		return liste;
	}

	public Client findById(String id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		Client p = null;

		String sql = "select * from client where id='" + id + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			p = new Client();
			p.setId(rs.getString("id"));
			p.setNom(rs.getString("nom"));
			p.setPrenom(rs.getString("prenom"));
			p.setPassword(rs.getString("password"));
			p.setAdresse(rs.getString("adresse"));
			p.setEmail(rs.getString("email"));
			p.setTel(rs.getString("tel"));
			p.setLivraison(rs.getString("livraison"));
		}

		conn.close();
		return p;
	}

}
