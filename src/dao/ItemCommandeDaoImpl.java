package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ItemCommande;

public class ItemCommandeDaoImpl implements ItemCommandeDao {

	public void delete(ItemCommande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "delete from article_commande where idCommande=" + c.getIdCommande() + " and idArticle="
				+ c.getIdArticle();

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		conn.close();
	}

	public void update(ItemCommande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "update article_commande set quantite=" + c.getQuantite() + " , prixUnitaire="
				+ c.getPrixUnitaire() + "  where idCommande=" + c.getIdCommande() + " and idArticle="
				+ c.getIdArticle();
		Statement st = conn.createStatement();

		st.executeUpdate(sql);
		conn.close();
	}

	public void create(ItemCommande c) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		String sql = "insert into article_commande values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, c.getIdCommande());
		ps.setInt(2, c.getIdArticle());
		ps.setInt(3, c.getQuantite());
		ps.setDouble(4, c.getPrixUnitaire());
		ps.executeUpdate();

		conn.close();
	}

	public List<ItemCommande> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<ItemCommande> liste = new ArrayList<>();

		String sql = "select * from article_commande";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		ItemCommande c = null;
		while (rs.next()) {
			c = new ItemCommande();
			c.setIdCommande(rs.getInt("idCommande"));
			c.setIdArticle(rs.getInt("idArticle"));
			c.setQuantite(rs.getInt("quantite"));
			c.setPrixUnitaire(rs.getDouble("prixUnitaire"));
			liste.add(c);
		}

		conn.close();
		return liste;
	}

	public ItemCommande findById(Integer id) throws ClassNotFoundException, SQLException {
		return null;
	}

	public ItemCommande findById(Integer idCommande, Integer idArticle) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		ItemCommande c = null;

		String sql = "select * from article_commande where idCommande=" + idCommande + " and idArticle=" + idArticle;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			c = new ItemCommande();
			c.setIdCommande(rs.getInt("idCommande"));
			c.setIdArticle(rs.getInt("idArticle"));
			c.setQuantite(rs.getInt("quantite"));
			c.setPrixUnitaire(rs.getDouble("prixUnitaire"));
		}

		conn.close();
		return c;
	}

	@Override
	public List<ItemCommande> findByIdCommande(Integer idCommande) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionSingleton.getInstance();

		List<ItemCommande> liste = new ArrayList<>();

		String sql = "select * from article_commande where idCommande=" + idCommande;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		ItemCommande c = null;
		while (rs.next()) {
			c = new ItemCommande();
			c.setIdCommande(rs.getInt("idCommande"));
			c.setIdArticle(rs.getInt("idArticle"));
			c.setQuantite(rs.getInt("quantite"));
			c.setPrixUnitaire(rs.getDouble("prixUnitaire"));
			liste.add(c);
		}

		conn.close();
		return liste;
	}

}
