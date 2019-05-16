package edu.usal.negocio.dao.implementacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.PropertiesClientes;

public class ClienteDAOImpSerializable implements ClienteDAO {
 
	@Override
	public void addCliente(Clientes cliente) throws FileNotFoundException, IOException {
	
	List<Clientes> lista = new ArrayList<Clientes>();
	try {
		lista=getAllClientes();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	lista.add(cliente);
	FileOutputStream fileOut = new FileOutputStream(new File(PropertiesClientes.getPathClientes()));
	ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	objectOut.writeObject(lista);
	objectOut.close();	
	}

	@Override
	public void updateCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clientes> getAllClientes() throws FileNotFoundException, IOException {
		FileInputStream fileInput = new FileInputStream(new File(PropertiesClientes.getPathClientes()));
	    @SuppressWarnings("resource")
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);
	     List<Clientes> cliente = new ArrayList<Clientes>();
	     
	     try {
	    	 cliente=(List<Clientes>) objectInput.readObject();
			return cliente;
	     }
	     catch (ClassNotFoundException e) {
	    	 throw new RuntimeException(e.getMessage()); 
	     }
	}

}
