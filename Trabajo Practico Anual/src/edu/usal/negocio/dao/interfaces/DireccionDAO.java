package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.util.DAOException;


public interface DireccionDAO {
	public void addDireccion(Clientes cliente, Connection cn) throws SQLException, DAOException;
	public void updateDireccion(Clientes cliente) throws DAOException;
	public void deleteDireccion(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public Direcciones queryDireccion(int Id) throws DAOException;
	public List<Direcciones> getAllDirecciones() throws DAOException;
}
