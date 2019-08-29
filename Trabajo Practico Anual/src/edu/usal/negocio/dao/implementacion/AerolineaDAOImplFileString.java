package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;

public class AerolineaDAOImplFileString implements AerolineaDAO {

	@Override
	public void addAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAerolinea(Aerolineas aerolinea) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aerolineas> getAllAerolineas() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
