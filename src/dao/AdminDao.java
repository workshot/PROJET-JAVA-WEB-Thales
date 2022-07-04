package dao;

import java.sql.SQLException;

import model.Admin;

public interface AdminDao extends Dao<Admin, String> {

	public Admin checkauthent(String login, String password) throws ClassNotFoundException, SQLException;

	public Admin connexion(String login, String password) throws ClassNotFoundException, SQLException;

	public boolean authentification(String login, String password) throws ClassNotFoundException, SQLException;

	public boolean isUserExists(String login) throws ClassNotFoundException, SQLException;
}
