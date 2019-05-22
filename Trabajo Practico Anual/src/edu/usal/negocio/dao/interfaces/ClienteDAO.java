package edu.usal.negocio.dao.interfaces;
import java.io.*;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;

public interface ClienteDAO {
public boolean addCliente(Clientes cliente) throws IOException;
public boolean updateCliente(Clientes cliente) throws FileNotFoundException, IOException;
public boolean deleteCliente(Clientes cliente) throws FileNotFoundException, IOException;
public Clientes queryCliente(Clientes cliente) throws FileNotFoundException, IOException;
public List<Clientes> getAllClientes() throws FileNotFoundException, IOException;
public void saveAllClientes(List<Clientes> listado) throws FileNotFoundException, IOException;
}
