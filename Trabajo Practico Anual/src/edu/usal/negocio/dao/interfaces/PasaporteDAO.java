package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Pasaportes;

public interface PasaporteDAO {
	public boolean addPasaporte(Pasaportes pasaporte);
	public boolean updatePasaporte(long Id, Pasaportes pasaporte);
	public boolean deletePasaporte(long Id);
	public Pasaportes queryPasaporte(long Id);
	public List<Pasaportes> getAllPasaportes();
}
