package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public interface PaisDAO {
	public Hashtable<Integer,String> leerPaises()throws FileNotFoundException, IOException;;
}
