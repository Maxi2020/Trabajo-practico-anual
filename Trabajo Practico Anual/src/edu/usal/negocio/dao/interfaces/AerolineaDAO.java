package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;


public interface AerolineaDAO {
	public Hashtable<Integer,String> leerAerolineas()throws FileNotFoundException, IOException;;
}
