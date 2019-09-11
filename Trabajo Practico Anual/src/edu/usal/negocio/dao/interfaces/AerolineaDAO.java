package edu.usal.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;

public interface AerolineaDAO {
	public boolean addAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException, IOException;
	public void updateAerolinea(Aerolineas aerolinea) throws DAOException, IOException;
	public boolean deleteAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException, IOException;
	public Aerolineas queryAerolinea(int Id) throws DAOException, IOException;
	public List<Aerolineas> getAllAerolineas() throws DAOException, IOException;
}
