package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Vuelos;

public interface VueloDAO {

	public boolean addVuelo(Vuelos vuelo) throws IOException;
	public boolean updateVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;
	public boolean deleteVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;
	public Vuelos queryVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;
	public List<Vuelos> getAllVuelos() throws FileNotFoundException, IOException;
	public void saveAllVuelos(List<Vuelos> listado) throws FileNotFoundException, IOException;
	
}
