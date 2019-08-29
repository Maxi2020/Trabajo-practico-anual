package edu.usal.negocio.dao.interfaces;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public interface ClienteDAO {
public void addCliente(Clientes cliente, Connection cn) throws IOException, DAOException, SQLException;
public void updateCliente(Clientes cliente) throws FileNotFoundException, IOException, DAOException;
public void deleteCliente(Clientes cliente, Connection cn) throws FileNotFoundException, IOException, DAOException;
public Clientes queryCliente(int Id) throws FileNotFoundException, IOException, DAOException;
public List<Clientes> getAllClientes() throws FileNotFoundException, IOException, DAOException;

}
