package dao;

import java.sql.SQLException;
import java.util.List;

import model.ItemCommande;

public interface ItemCommandeDao extends Dao<ItemCommande, Integer> {
	public ItemCommande findById(Integer idCommande, Integer idArticle) throws ClassNotFoundException, SQLException;
	public List<ItemCommande> findByIdCommande(Integer idCommande) throws ClassNotFoundException, SQLException;

}
