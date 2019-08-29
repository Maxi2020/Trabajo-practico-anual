package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;

public interface AerolineaDAO {
	public void addAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException;
	public void updateAerolinea(Aerolineas aerolinea) throws DAOException;
	public void deleteAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException;
	public List<Aerolineas> getAllAerolineas() throws DAOException;
}
