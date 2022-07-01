package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;

public class CategorieDaoImpl implements CategorieDao {

	public void delete(Categorie c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from categorie where id=" + c.getId();

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(Categorie c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update categorie set nom='" + c.getNom() + "' where id=" + c.getId();
		Statement st = conn.createStatement();

		st.executeUpdate(sql);
		conn.close();
	}

	public void create(Categorie c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into categorie values(null,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getNom());
		ps.executeUpdate();

		conn.close();
	}

	public List<Categorie> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Categorie> liste = new ArrayList<>();

		String sql = "select * from categorie";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Categorie c = null;
		while (rs.next()) {
			c = new Categorie();
			c.setId(rs.getInt("id"));
			c.setNom(rs.getString("nom"));
			liste.add(c);
		}

		conn.close();
		return liste;
	}

	public Categorie findById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		Categorie a = null;

		String sql = "select * from categorie where id=" + id;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			a = new Categorie();
			a.setId(rs.getInt("id"));
			a.setNom(rs.getString("nom"));
		}

		conn.close();
		return a;
	}

}
