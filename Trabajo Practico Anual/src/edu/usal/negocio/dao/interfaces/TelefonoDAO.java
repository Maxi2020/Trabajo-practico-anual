package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Telefonos;

public interface TelefonoDAO {
	public boolean addTelefono(Telefonos telefono);
	public boolean updateTelefono(long Id, Telefonos telefono);
	public boolean deleteTelefono(long Id);
	public Telefonos queryTelefono(long Id);
	public List<Telefonos> getAllTelefonos();
}
