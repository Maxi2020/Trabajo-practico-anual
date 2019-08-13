package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Ventas;

public interface VentasDAO {
	public boolean addVentas(Ventas venta) throws IOException;
	public boolean updateVentas(Ventas venta) throws FileNotFoundException, IOException;
	public boolean deleteVentas(Ventas venta) throws FileNotFoundException, IOException;
	public Ventas queryVentas(Ventas venta) throws FileNotFoundException, IOException;
	public List<Ventas> getAllVentas() throws FileNotFoundException, IOException;
	public void saveAllVentas(List<Ventas> listado) throws FileNotFoundException, IOException;
	}

