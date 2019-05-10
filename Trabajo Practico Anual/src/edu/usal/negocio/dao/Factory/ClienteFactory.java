package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.ClienteDAOImpleArchivo;
import edu.usal.negocio.dao.implementacion.ClienteDAOSerializacion;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ClienteFactory {
public static ClienteDAO getImplementacion (String source) {
	if(source.equals("Archivo")) {
		return new ClienteDAOImpleArchivo();
	}
	else if(source.equals("Serializacion")) {
		return new ClienteDAOSerializacion();
	}
	return null;
}
}
