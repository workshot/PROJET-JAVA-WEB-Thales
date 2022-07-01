package dao;

import java.sql.SQLException;
import java.util.List;

import model.Commande;

public interface CommandeDao extends Dao<Commande, Integer> {

	List<Commande> findByIdClient(String idClient) throws ClassNotFoundException, SQLException;

}
