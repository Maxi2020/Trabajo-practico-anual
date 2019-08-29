package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.DAOException;

public interface TelefonoDAO {
	public void addTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public void updateTelefono(Clientes cliente) throws DAOException;
	public void deleteTelefono(Clientes cliente, Connection cn) throws DAOException;
	public Telefonos queryTelefono(int Id) throws DAOException;
	public List<Telefonos> getAllTelefonos() throws DAOException;
}
