package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {

	public List<T> findAll() throws ClassNotFoundException, SQLException;

	public T findById(K id) throws ClassNotFoundException, SQLException;

	public void create(T obj) throws ClassNotFoundException, SQLException;

	public void update(T obj) throws ClassNotFoundException, SQLException;

	public void delete(T obj) throws ClassNotFoundException, SQLException;

}
