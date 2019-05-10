package edu.usal.negocio.dao.implementacion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
//import edu.usal.negocio.dominio.Direcciones;
//import edu.usal.negocio.dominio.PasajerosFrecuentes;
//import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.util.PropertiesClientes;

public class ClienteDAOImpleArchivo implements ClienteDAO {
	private File file;
	private FileWriter writer;
	private BufferedWriter Bwriter;
	private Scanner scanner;

	@Override
	public void addCliente(Clientes cliente) throws IOException {
		file = new File ("C:\\Users\\agust\\Documents\\Clientes.dat");
		writer = new FileWriter (file, true);
		Bwriter = new BufferedWriter (writer);
		Bwriter.write(this.SaveCliente(cliente));
		Bwriter.newLine();
		Bwriter.close();
		writer.close();
	}
	private String SaveCliente(Clientes cliente) {
		return cliente.getNombre()  + ";" + cliente.getApellido()  + ";" + cliente.getDni()  + ";" + cliente.getCuit()  + ";" +
	    cliente.getCorreo()   + ";" + cliente.getId()  + ";" + cliente.getDireccion()  + ";" + cliente.getFechaNacimiento()  + ";" +
				cliente.getPasajerofrecuente()  + ";" + cliente.getPasaporte()  + ";" + cliente.getTelefono();
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
	    file = new File (PropertiesClientes.getPathClientes());
	    scanner = new Scanner (file);
	    List<Clientes> lista = new ArrayList<Clientes>();
	    while (scanner.hasNextLine()){
			lista.add(StringtoCliente(scanner.nextLine()));
		
		}
		return lista;
	}
	private Clientes StringtoCliente(String StringCliente) {
		String[] strAux = StringCliente.split(";");
		Clientes cliente = new Clientes();
		//PasajerosFrecuentes pasajeroFrecuente = new PasajerosFrecuentes();
		//Direcciones direccion = new Direcciones();
		//Pasaportes Pasaporte = new Pasaportes();
		cliente.setId(Integer.valueOf(strAux[0]));
		cliente.setNombre(strAux[1]);
		cliente.setApellido(strAux[2]);
		cliente.setDni(strAux[3]);
		cliente.setCuit(strAux[4]);
		cliente.setCorreo(strAux[5]);
		cliente.setFechaNacimiento(LocalDate.parse(strAux[6]));
		
		//Preguntar como dar el split de objetos. 
		//cliente.setTelefono();
		//cliente.setPasajerofrecuente();
		//cliente.setPasaporte();
		
		
		return cliente;
	}

}
