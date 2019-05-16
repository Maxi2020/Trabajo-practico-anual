package edu.usal.negocio.dao.Factory;


import edu.usal.negocio.dao.implementacion.ClienteDAOImpSerializable;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ClienteFactory {
public static ClienteDAO getImplementacion (String source) {
	if(source.equals("Serializable")) {
		return new ClienteDAOImpSerializable();
	}
	return null;
}
}