package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.PasajerosFrecuentes;


public interface PasajeroFrecuenteDAO {
	public boolean addPasajeroFrecuente(PasajerosFrecuentes pasajeroFrecuente);
	public boolean updatePasajeroFrecuente(long Id, PasajerosFrecuentes pasajeroFrecuente);
	public boolean deletePasajeroFrecuente(long Id);
	public PasajerosFrecuentes queryPasajeroFrecuente(long Id);
	public List<PasajerosFrecuentes> getAllPasajerosFrecuentes();
}
