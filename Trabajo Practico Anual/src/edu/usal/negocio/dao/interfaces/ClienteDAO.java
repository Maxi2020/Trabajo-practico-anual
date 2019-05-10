package edu.usal.negocio.dao.interfaces;
import java.io.*;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;

public interface ClienteDAO {
public void addCliente(Clientes cliente) throws IOException;
public void updateCliente(Clientes cliente);
public void deleteCliente(Clientes cliente);
public void queryCliente(Clientes cliente);
public List<Clientes> getAllClientes() throws FileNotFoundException, IOException;
}
