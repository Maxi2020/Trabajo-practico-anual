package edu.usal.negocio.dao.implementacion;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.PropertiesClientes;

public class ClienteDAOSerializacion implements ClienteDAO {
    private File file;
    private ObjectInputStream objectInput;
    private ObjectOutputStream objectOut;
    private FileInputStream FileInput;
    private FileOutputStream fileOut;
	@Override
	public void addCliente(Clientes cliente) throws FileNotFoundException, IOException {
	
	List<Clientes> lista = this.getAllClientes();
	lista.add(cliente);
	this.file = new File(PropertiesClientes.getPathClientes());
	this.fileOut = new FileOutputStream(file);
	this.objectOut = new ObjectOutputStream(fileOut);
	this.objectOut.writeObject(lista);
	this.objectOut.close();
		
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

	@Override
	public List<Clientes> getAllClientes() throws FileNotFoundException, IOException {
	     this.file = new File(PropertiesClientes.getPathClientes());
	     this.FileInput = new FileInputStream (this.file);
	     this.objectInput = new ObjectInputStream (this.FileInput);
	     try {
	    	 List <Clientes> lista= (ArrayList<Clientes>)objectInput.readObject();
			return lista;
	     }
	     catch (ClassNotFoundException e) {
	    	 throw new RuntimeException(e.getMessage()); 
	     }
	}

}
