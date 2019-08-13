package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.VentasDAOImpSerializable;
import edu.usal.negocio.dao.interfaces.VentasDAO;

public class VentaFactory {
	public static VentasDAO getVentasDAO (String source) {
		if(source.equals("Serializable")) {
			return new VentasDAOImpSerializable();
		}
		return null;
	}
}