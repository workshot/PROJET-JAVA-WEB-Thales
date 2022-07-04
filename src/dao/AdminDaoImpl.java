package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;

public class AdminDaoImpl implements AdminDao {

	public void delete(Admin c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from admin where login='" + c.getLogin() + "'";

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(Admin c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update admin set password='" + c.getPassword() + "',actif='" + c.getActif() + "' where login='"
				+ c.getLogin() + "'";
		Statement st = conn.createStatement();

		st.executeUpdate(sql);
		conn.close();
	}

	public void create(Admin p) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into admin values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getLogin());
		ps.setString(4, p.getPassword());
		ps.setBoolean(8, p.getActif());
		ps.executeUpdate();

		conn.close();
	}

	public List<Admin> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Admin> liste = new ArrayList<>();

		String sql = "select * from admin";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Admin p = null;
		while (rs.next()) {
			p = new Admin();
			p.setLogin(rs.getString("login"));
			p.setPassword(rs.getString("password"));
			p.setActif(rs.getBoolean("actif"));
			liste.add(p);
		}

		conn.close();
		return liste;
	}

	public Admin findById(String id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		Admin p = null;

		String sql = "select * from admin where login='" + id + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			p = new Admin();
			p.setLogin(rs.getString("id"));
			p.setPassword(rs.getString("password"));
			p.setActif(rs.getBoolean("actif"));
		}

		conn.close();
		return p;
	}

	public Admin checkauthent(String id, String password) throws ClassNotFoundException, SQLException {
		Admin u = findById(id);
		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}

	public Admin connexion(String id, String motdepasse) {
		Admin connectedUser = null;
		if (this.authentification(id, motdepasse)) {
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

	public boolean authentification(String id, String pass) {
		boolean estAuthentifie = false;
		Admin userToFind = null;
		try {
			userToFind = this.findById(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userToFind != null) {
			if (userToFind.getPassword().equals(pass)) {
				estAuthentifie = true;
			}
		}
		return estAuthentifie;
	}

	public boolean isUserExists(String id) throws ClassNotFoundException, SQLException {
		return (this.findById(id) != null);
	}

}
