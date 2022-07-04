package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Commande;

public class CommandeDaoImpl implements CommandeDao {

	public void delete(Commande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from commande where id=" + c.getId();

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(Commande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update commande set idClient='" + c.getIdClient() + "', date='"
				+ new java.sql.Date(c.getDate().getTime()) + "', total=" + c.getTotal() + " where id=" + c.getId();
		Statement st = conn.createStatement();
		
		st.executeUpdate(sql);

		conn.close();
	}

	public void create(Commande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into commande values(null,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getIdClient());
		ps.setDate(2, new java.sql.Date(c.getDate().getTime()));
		ps.setDouble(3, c.getTotal());
		ps.executeUpdate();

		conn.close();
	}

	public List<Commande> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Commande> liste = new ArrayList<>();

		String sql = "select * from commande";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Commande c = null;
		while (rs.next()) {
			c = new Commande();
			c.setId(rs.getInt("id"));
			c.setIdClient(rs.getString("idClient"));
			c.setDate(rs.getDate("date"));
			c.setTotal(rs.getDouble("total"));
			liste.add(c);
		}

		conn.close();
		return liste;
	}

	public List<Commande> findByIdClient(String idClient) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Commande> liste = new ArrayList<>();

		String sql = "select * from commande where idClient='" + idClient + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Commande c = null;
		while (rs.next()) {
			c = new Commande();
			c.setId(rs.getInt("id"));
			c.setIdClient(rs.getString("idClient"));
			c.setDate(rs.getDate("date"));
			c.setTotal(rs.getDouble("total"));
			liste.add(c);
		}

		conn.close();
		return liste;
	}

	public Commande findById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		Commande c = null;

		String sql = "select * from commande where id=" + id;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			c = new Commande();
			c.setId(rs.getInt("id"));
			c.setIdClient(rs.getString("idClient"));
			c.setDate(rs.getDate("date"));
			c.setTotal(rs.getDouble("total"));
		}

		conn.close();
		return c;
	}

}
