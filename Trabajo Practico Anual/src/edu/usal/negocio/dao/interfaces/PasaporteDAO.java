package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.util.DAOException;

public interface PasaporteDAO {
	public boolean addPasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public void updatePasaporte(Clientes cliente) throws DAOException;
	public boolean deletePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public Pasaportes queryPasaporte(int Id) throws DAOException;
	public List<Pasaportes> getAllPasaportes() throws DAOException;
}
