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
Pasaportes pasaporte1 = new Pasaportes();
Paises paisEmision1=new Paises();
Telefonos telefono1=new Telefonos();
Direcciones direccion1= new Direcciones();
Paises paises1= new Paises();
Provincias provincia1= new Provincias();
PasajerosFrecuentes pasajero1= new PasajerosFrecuentes();
Aerolineas aerolinea1 = new Aerolineas();

cliente.setNombre("agus1");
cliente.setApellido("Cammarota");
cliente.setCorreo("sadadsadd");
cliente.setCuit("sallll");
cliente.setDni("234245");
cliente.setIdCliente(2);
cliente.setFechaNacimiento(LocalDate.now());
pasaporte1.setAutoridadEmision("sdsad");
pasaporte1.setFechaEmision(LocalDate.now());
pasaporte1.setFechaVencimiento(LocalDate.now());
pasaporte1.setNumeroPasaporte("23232");
paisEmision1.setPais("argentina");
pasaporte1.setPaisEmision(paisEmision1);
cliente.setPasaporte(pasaporte1);
telefono1.setNumeroCelular("2321111");
telefono1.setNumeroLaboral("232323211");
telefono1.setNumeroPersonal("124244224");
cliente.setTelefono(telefono1);
direccion1.setAltura("2111");
direccion1.setCalle("libertador");
direccion1.setCiudad("pilar");
direccion1.setCodigoPostal("1223");
paises1.setPais("Argentina");


direccion1.setPaises(paises1);
provincia1.setProvincias("Buenos Aires");
direccion1.setProvincias(provincia1);
cliente.setDireccion(direccion1);
pasajero1.setAlianza("american");
pasajero1.setCategoria("economica");
pasajero1.setNumero("2223");
aerolinea1.setAerolinea("american ss");
pasajero1.setAerolinea(aerolinea1);
cliente.setPasajerofrecuente(pasajero1);
try {
	ImpDAO.addCliente(cliente);
	cliente.setApellido("raul");
	cliente.setIdCliente(23);
	ImpDAO.addCliente(cliente);
}
catch(Exception e){
	e.printStackTrace();
}
	
	
	ImpDAO.queryCliente(cliente);

}
}
