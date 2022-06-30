package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class ArticleDaoImpl implements ArticleDao {

	public void delete(Article a) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from article where id=" + a.getId();

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(Article a) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update article set nom='" + a.getNom() + "', prix=" + a.getPrix() + ",description='"
				+ a.getDescription() + "',img='" + a.getImg() + "',idCategorie=" + a.getIdCategorie() + " where id="
				+ a.getId();
		Statement st = conn.createStatement();

		st.executeUpdate(sql);
		conn.close();
	}

	public void create(Article a) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into article values(null,? ,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, a.getNom());
		ps.setDouble(2, a.getPrix());
		ps.setString(3, a.getDescription());
		ps.setString(4, a.getImg());
		ps.setInt(5, a.getIdCategorie());
		ps.executeUpdate();

		conn.close();
	}

	public List<Article> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<Article> liste = new ArrayList<>();

		String sql = "select * from article";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		Article a = null;
		while (rs.next()) {
			a = new Article();
			a.setId(rs.getInt("id"));
			a.setNom(rs.getString("nom"));
			a.setPrix(rs.getDouble("prix"));
			a.setDescription(rs.getString("description"));
			a.setImg(rs.getString("img"));
			a.setIdCategorie(rs.getInt("idCategorie"));
			liste.add(a);
		}

		conn.close();
		return liste;
	}

	public Article findById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		Article a = null;

		String sql = "select * from article where id=" + id;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			a = new Article();
			a.setId(rs.getInt("id"));
			a.setNom(rs.getString("nom"));
			a.setPrix(rs.getDouble("prix"));
			a.setDescription(rs.getString("description"));
			a.setImg(rs.getString("img"));
			a.setIdCategorie(rs.getInt("idCategorie"));
		}

		conn.close();
		return a;
	}

}
