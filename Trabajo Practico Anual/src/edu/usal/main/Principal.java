package edu.usal.main;

//PRUEBA ALTA CLIENTE 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
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

public class Principal {
public static void main(String[] args) throws FileNotFoundException, IOException {
ClienteDAO ImpDAO = ClienteFactory.getImplementacion("Serializable");	

Clientes cliente = new Clientes();
Pasaportes pasaporte = new Pasaportes();
Paises paisEmision=new Paises();
Telefonos telefono=new Telefonos();
Direcciones direccion= new Direcciones();
Paises paises= new Paises();
Provincias provincia= new Provincias();
PasajerosFrecuentes pasajero= new PasajerosFrecuentes();
Aerolineas aerolinea = new Aerolineas();

cliente.setNombre("Agustin");
cliente.setApellido("Cammarota");
cliente.setCorreo("sadadsadd");
cliente.setCuit("sallll");
cliente.setDni("234245");
cliente.setIdCliente(1);
cliente.setFechaNacimiento(LocalDate.now());
pasaporte.setAutoridadEmision("sdsad");
pasaporte.setFechaEmision(LocalDate.now());
pasaporte.setFechaVencimiento(LocalDate.now());
pasaporte.setNumeroPasaporte("23232");
paisEmision.setPais("argentina");
pasaporte.setPaisEmision(paisEmision);
cliente.setPasaporte(pasaporte);
telefono.setNumeroCelular("2321111");
telefono.setNumeroLaboral("232323211");
telefono.setNumeroPersonal("124244224");
cliente.setTelefono(telefono);
direccion.setAltura("2111");
direccion.setCalle("libertador");
direccion.setCiudad("pilar");
direccion.setCodigoPostal("1223");
paises.setPais("Argentina");


direccion.setPaises(paises);
provincia.setProvincias("Buenos Aires");
direccion.setProvincias(provincia);
cliente.setDireccion(direccion);
pasajero.setAlianza("american");
pasajero.setCategoria("economica");
pasajero.setNumero("2223");
aerolinea.setAerolinea("american ss");
pasajero.setAerolinea(aerolinea);
cliente.setPasajerofrecuente(pasajero);

	
	try {
		
		ImpDAO.addCliente(cliente);
		List <Clientes> listado= ImpDAO.getAllClientes();
		for(Clientes clientes : listado )
		{
			System.out.println(cliente.getApellido());
		}
	}
	catch (IOException e) {
		e.printStackTrace();
	}

}
}
