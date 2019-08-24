package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.AerolineaDAOImplFileString;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;

public class AerolineaFactory {
	public static AerolineaDAO getAerolineaDAO(String source){
		if(source.equals("ArchivoTxt")) {
		return new AerolineaDAOImplFileString();
		}
		return null;
}
}
