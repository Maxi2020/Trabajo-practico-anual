package Pirncipal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import edu.usal.negocio.dao.Factory.AerolineaFactory;
import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.Factory.DireccionFactory;
import edu.usal.negocio.dao.Factory.PaisFactory;
import edu.usal.negocio.dao.Factory.PasajeroFrecuenteFactory;
import edu.usal.negocio.dao.Factory.PasaporteFactory;
import edu.usal.negocio.dao.Factory.ProvinciaFactory;
import edu.usal.negocio.dao.Factory.TelefonoFactory;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.DireccionDAO;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.Connections;
import edu.usal.util.DAOException;

public class principal {
private static Connection cn;
public static void main(String []args) throws IOException, DAOException {

	LocalDate fechaemision = LocalDate.of(2019, 9, 21);
	LocalDate fechavencimiento = LocalDate.of(2019, 10, 21);
	LocalDate fechanacimiento = LocalDate.of(1997, 8, 6);
	Paises pais = new Paises(null, "argentina");
	Provincias provincia = new Provincias(null, "santa fe");
	Aerolineas ln = new Aerolineas(null, "dadsda", "sdadgh", null);
	Pasaportes pasaporte = new Pasaportes("AOF123","Argen",fechaemision, fechavencimiento, pais, null );
	PasajerosFrecuentes pasajeroFrecuente = new PasajerosFrecuentes("dadda","dadasd",ln, null);
	Direcciones direccion = new Direcciones("Av España","1154","Lujan","6700", pais, provincia, null);
	Telefonos telefono = new Telefonos("2323524566","2323123432","232305054", null);
	Clientes cliente = new Clientes("Jose","Martinez Gomez","5546","580890","Jose.martinezgomez@usal.edu.ar", fechanacimiento , null, pasaporte, telefono, pasajeroFrecuente, direccion);
	
	ClienteDAO clienteImple = ClienteFactory.getClienteDAO("Sql");
	PasaporteDAO pasaImple = PasaporteFactory.getPasaporteDAO("Sql");
	TelefonoDAO teleImple = TelefonoFactory.getTelefonoDAO("Sql");
	PasajeroFrecuenteDAO pasaFreImple = PasajeroFrecuenteFactory.getPasajeroFrecuenteDAO("Sql");
	DireccionDAO direImple = DireccionFactory.getDireccionDAO("Sql");
	PaisDAO paisImp = PaisFactory.getPaiDAO("Sql");
	ProvinciaDAO provinciaImp = ProvinciaFactory.getProvinciaDAO("Sql");
	AerolineaDAO aerolineaImp = AerolineaFactory.getAerolineaDAO("Sql");
	
	try {	
		cn = Connections.getConnection();
		if(clienteImple.addCliente(cliente, cn) && pasaImple.addPasaporte(cliente, cn) && pasaFreImple.addPasajeroFrecuente(cliente, cn) && teleImple.addTelefono(cliente, cn) &&
				direImple.addDireccion(cliente, cn) && paisImp.addPais(cliente, cn) && provinciaImp.addProvincia(cliente, cn) && aerolineaImp.addAerolinea(ln, cn)){ 
			//clienteImple.commitCliente(con);
			System.out.println("Se pudo guardar el cliente");
		}
	else {
			//clienteImple.rollbackClinete(conn);
			
			System.out.println("No se pudo guardar el cliente.");
		}
	}  catch (SQLException r) {
		//clienteImple.rollbackClinete(conn);
		System.out.println("SE HZO EL ROLLBACK");
				r.printStackTrace();
	}	
	try {
		cn.close();
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}