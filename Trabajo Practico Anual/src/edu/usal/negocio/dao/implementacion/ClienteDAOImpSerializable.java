package edu.usal.negocio.dao.implementacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Telefonos;
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
	FileOutputStream fileOut = new FileOutputStream(new File(PropertiesClientes.getPathClientes()),true);
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
		
		List<Clientes> listado = new ArrayList<Clientes>();
		
		try {
			
		
			listado=getAllClientes();
		
			 for(Clientes clientes : listado)
			 {
		      
			 System.out.println("///Datos Del Cliente///" + "\n" + "ID Cliente: " +clientes.getIdCliente() + "\n" + "Nombre: " + clientes.getNombre()
		      + "\n" +  "Apellido: " + clientes.getApellido() + "\n" + "Correo: " + clientes.getCorreo() + "\n" +
		      "Cuit: " + clientes.getCuit() + "\n"  + "DNI: " + clientes.getDni()  + "\n" + "Fecha De Nacimiento: " +
		      clientes.getFechaNacimiento() + "\n"  + "\n"  + "///Direccion Del Cliente/// " + ParserDireccion((clientes.getDireccion())) + "\n" + "\n"  
		      +  "///Pasaporte Del Cliente/// " + ParserPasaporte(clientes.getPasaporte()) + "\n"  + "\n" + "///Telefono Del Cliente/// " 
		      + ParserTelefono(clientes.getTelefono()) + "\n" + "\n" + "///Datos De Pasajero Frecuente/// " + ParserPasajero(clientes.getPasajerofrecuente())+ "\n");
			 }
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 
	 
	}
	private String ParserPasaporte(Pasaportes pasaporte) {
	    return  "\n" + "Numero De Pasaporte: " +pasaporte.getNumeroPasaporte() + "\n" + "Autoridad De Emision: " + 
	    pasaporte.getAutoridadEmision() + "\n"  + "Fecha De Emision: " + pasaporte.getFechaEmision() + "\n" 
	    + "Fecha De Vencimiento: " +pasaporte.getFechaVencimiento() + "\n" + "Pais De Emision: " + 
	    ParserPais(pasaporte.getPaisEmision());
			
		}
	private String ParserDireccion(Direcciones direccion) {
		return  "\n" + "Pais: " + ParserPais(direccion.getPaises()) + "\n"  + "Provincia: " + 
	     ParserProvincia(direccion.getProvincias()) + "\n"  + "Ciudad: " + direccion.getCiudad() 
	     + "\n" + "Calle: " + direccion.getCalle() + "\n" + "Codigo Postal: " + direccion.getCodigoPostal()
	     + "\n" + "Altura: " + direccion.getAltura();
	}
	private String ParserProvincia(Provincias provincia) {
		return provincia.getProvincias();
	}
	
	private String ParserTelefono(Telefonos telefono) {
		return  "\n" + "Numero Celular: " +telefono.getNumeroCelular() + "\n" + "Numero Laboral: " 
	    + telefono.getNumeroLaboral() + "\n" + "Numero Personal: " + telefono.getNumeroPersonal();
	}
	
	private String ParserPasajero(PasajerosFrecuentes pasajeroFrecuente) {
		return "\n" +  "Alianza: " + pasajeroFrecuente.getAlianza() + "\n"  + "Numero De Pasajero Frecuente: " 
	    + pasajeroFrecuente.getNumero() + "\n" + "Categoria: " + pasajeroFrecuente.getCategoria() + "\n"  
		+ "Aerolinea: " + ParserAerolinea(pasajeroFrecuente.getAerolinea());
	}
	private String ParserAerolinea(Aerolineas aerolinea) {
		return aerolinea.getAerolinea();
	}
	
	private String ParserPais(Paises pais) {
	return pais.getPais();
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
