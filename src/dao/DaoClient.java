package dao;

import java.sql.SQLException;


import model.Client;

public interface DaoClient extends Dao<Client, String>
{

	public Client checkauthent(String id, String password) throws ClassNotFoundException, SQLException;
	public Client connexion(String id, String motdepasse)  throws ClassNotFoundException, SQLException;
	public boolean authentification(String id, String motdepasse) throws ClassNotFoundException, SQLException;
	public boolean isUserExists(String id) throws ClassNotFoundException, SQLException;
}
