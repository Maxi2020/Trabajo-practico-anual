package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Paises;
import edu.usal.util.DAOException;

public interface PaisDAO {
	public Hashtable<Integer,String> leerPaises()throws FileNotFoundException, IOException;
	public void addPais(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public void updatePais(Clientes cliente) throws DAOException;
	public void deletePais(Clientes cliente, Connection cn) throws DAOException;
	public Paises queryPais(int Id) throws DAOException;
	public List<Paises> getAllPaises() throws DAOException;
}
