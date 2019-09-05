package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;

public interface ProvinciaDAO {
	public Hashtable<Integer,String> leerProvincias()throws FileNotFoundException, IOException;
	public void addProvincia(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public void updateProvincia(Clientes cliente) throws DAOException;
	public void deleteProvincia(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public Provincias queryProvincia(int Id) throws  DAOException;
	public List<Provincias> getAllProvincias() throws DAOException;
}
