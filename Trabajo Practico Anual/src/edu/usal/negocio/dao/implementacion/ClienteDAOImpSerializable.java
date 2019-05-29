package edu.usal.negocio.dao.implementacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.IOGeneral;
import edu.usal.util.PropertiesUtil;


public class ClienteDAOImpSerializable implements ClienteDAO {
	
	private FileOutputStream fileOut;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectInput;
	private File file;
	
 
	@Override
	public boolean addCliente(Clientes cliente) throws FileNotFoundException, IOException {
		
		List<Clientes> listado = this.getAllClientes();
		listado.add(cliente);
		this.saveAllClientes(listado);
		return true;
	
	}

	@Override
	public boolean updateCliente(Clientes cliente) throws FileNotFoundException, IOException {
		List<Clientes> listado = this.getAllClientes();
		for(Clientes clientes : listado) {
			if(clientes.getIdCliente() == cliente.getIdCliente()) {
				listado.remove(clientes);
				listado.add(cliente);
				this.saveAllClientes(listado);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCliente(Clientes cliente) throws FileNotFoundException, IOException {
		List<Clientes> listado = this.getAllClientes();
		for(Clientes clientes : listado) {
			if(clientes.getIdCliente() == cliente.getIdCliente()) {
				listado.remove(clientes);
				this.saveAllClientes(listado);
				return true;
			}
		}
	   return false;
		
	}

	@Override
	public Clientes queryCliente(Clientes cliente) throws FileNotFoundException, IOException {
		List<Clientes> listado = getAllClientes();
		for(Clientes clientes : listado) {
			if(clientes.getIdCliente() == cliente.getIdCliente()) {
					 return clientes;
				 }
			 }
		    return null;  		 
	}
	

    @SuppressWarnings("unchecked")
    public List<Clientes> getAllClientes() throws FileNotFoundException, IOException {
    	this.file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileClientes());
    	
    	if(!file.exists()) {
    	file = new File(PropertiesUtil.getPathClientes());
    	file.mkdir();
    	file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileClientes());
    	file.createNewFile();
    	List<Clientes> cliente = new ArrayList<Clientes>();
    	this.saveAllClientes(cliente);
    	return cliente;
    	
    }
    	this.fileInput = new FileInputStream(file);
    	this.objectInput = new ObjectInputStream(fileInput);
	    
	     try {
	    	 List<Clientes> cliente = (List<Clientes>) objectInput.readObject();
	    	 this.fileInput.close();
	    	 this.objectInput.close();
			 return cliente;
			 
	     }
	     catch (ClassNotFoundException e) {
	    	 IOGeneral.pritln("Error en la lectura del archivo\nMensaje: "+e.getMessage());
	     }
	     return null;
    }
    
    public void saveAllClientes(List<Clientes> listado) throws FileNotFoundException, IOException {
    	this.file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileClientes());
    	this.fileOut = new FileOutputStream(file);
    	this.objectOut = new ObjectOutputStream(fileOut);
    	this.objectOut.writeObject(listado);
    	this.objectOut.close();
    }

}
