package edu.usal.negocio.dao.interfaces;
import java.io.*;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public interface ClienteDAO {
public boolean addCliente(Clientes cliente) throws IOException, DAOException;
public boolean updateCliente(Clientes cliente) throws FileNotFoundException, IOException, DAOException;
public boolean deleteCliente(Clientes cliente) throws FileNotFoundException, IOException, DAOException;
public Clientes queryCliente(int Id) throws FileNotFoundException, IOException, DAOException;
public List<Clientes> getAllClientes() throws FileNotFoundException, IOException, DAOException;

}
