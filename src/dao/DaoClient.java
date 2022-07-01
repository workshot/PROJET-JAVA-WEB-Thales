package dao;

import java.sql.SQLException;


import model.Client;

public interface DaoClient extends Dao<Client, Integer>
{

	public Client checkauthent(int id, String password) throws ClassNotFoundException, SQLException;
	public Client connexion(int id, String motdepasse)  throws ClassNotFoundException, SQLException;
	public boolean authentification(int id, String motdepasse) throws ClassNotFoundException, SQLException;
	public boolean isUserExists(int id) throws ClassNotFoundException, SQLException;
}
