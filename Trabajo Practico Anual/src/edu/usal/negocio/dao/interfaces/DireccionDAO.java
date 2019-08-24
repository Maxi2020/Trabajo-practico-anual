package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Direcciones;


public interface DireccionDAO {
	public boolean addDireccion(Direcciones direccion);
	public boolean updateDireccion(long Id, Direcciones direccion);
	public boolean deleteDireccion(long Id);
	public Direcciones queryDireccion(long Id);
	public List<Direcciones> getAllDirecciones();
}
