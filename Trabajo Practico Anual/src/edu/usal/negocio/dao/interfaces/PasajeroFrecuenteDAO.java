package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.util.DAOException;


public interface PasajeroFrecuenteDAO {
	public boolean addPasajeroFrecuente(Clientes cliente, Connection cn) throws SQLException, DAOException;
	public void updatePasajeroFrecuente(Clientes cliente) throws DAOException;
	public boolean deletePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public PasajerosFrecuentes queryPasajeroFrecuente(int Id) throws DAOException;
	public List<PasajerosFrecuentes> getAllPasajerosFrecuentes() throws DAOException;
}
