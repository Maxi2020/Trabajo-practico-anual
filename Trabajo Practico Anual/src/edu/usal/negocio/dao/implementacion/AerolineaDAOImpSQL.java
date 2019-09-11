package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Vuelos;
import edu.usal.util.DAOException;

public class AerolineaDAOImpSQL implements AerolineaDAO{
	private Connection cn;
	final String INSERT = "INSERT INTO aerolineas (nombre_aerolinea, alianza) VALUES(?,?)";
	final String UPDATE = "UPDATE aerolineas SET nombre_aerolinea=?, alianza=? WHERE id_aerolinea=?";
	final String DELETE = "DELETE FROM aerolineas WHERE id_aerolinea=?";
	final String GETALL = "SELECT nombre_aerolinea, alianza, numero_vuelo, cantidad_asientos, fecha_hora_salida, fecha_hora_llegada, tiempo_vuelo FROM aerolineas INNER JOIN vuelos on aerolineas.id_aerolinea=vuelos.id_vuelo";
	final String GETONE = "SELECT nombre_aerolinea, alianza, numero_vuelo, cantidad_asientos, fecha_hora_salida, fecha_hora_llegada, tiempo_vuelo FROM aerolineas INNER JOIN vuelos on aerolineas.id_aerolinea=vuelos.id_vuelo WHERE id_aerolinea=?";
	
	
	@Override
	public boolean addAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, aerolinea.getNombreAerolinea() );
			ps.setString(2, aerolinea.getAlianza());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    
		    while(rs.next())
		    	aerolinea.setIdAerolinea((long) rs.getInt(1));
         
            
		} catch (SQLException e) {
			cn.rollback();
			throw new DAOException("EROOR EN SQL addCliente", e);
		}
		finally{
			if(rs !=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					new DAOException("ERROR CLOSE RS querycliente", e);
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
		return true;
	}

	@Override
	public void updateAerolinea(Aerolineas aerolinea) throws DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, aerolinea.getNombreAerolinea() );
			ps.setString(2, aerolinea.getAlianza());
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			throw new DAOException("EROOR EN SQL UPCliente", e);
		}
		finally{
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
	}

	@Override
	public boolean deleteAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, aerolinea.getIdAerolinea());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			cn.rollback();
			throw new DAOException("EROOR EN SQL addCliente", e);
		}
		finally{
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
		return true;
	}

	private Aerolineas Convertir(ResultSet rs) throws SQLException {
    	String nombre_aerolinea  = rs.getString("nombre_aerolinea");
    	String alianza = rs.getString("alianza");
    	String numero_vuelo = rs.getString("numero_vuelo");
    	String tiempo_vuelo = rs.getString("tiempo_vuelo");
    	String cantidad_asientos = rs.getString("cantidad_asientos");
    	LocalDate fecha_salida = rs.getDate("fecha_salida").toLocalDate();
    	LocalDate fecha_llegada = rs.getDate("fecha_llegada").toLocalDate();
    	LocalTime hora_salida = rs.getTime("hora_salida").toLocalTime();
    	LocalTime hora_llegada = rs.getTime("hora_llegada").toLocalTime();
    	
    	Vuelos vuelo = new Vuelos(numero_vuelo, tiempo_vuelo, cantidad_asientos, null, null, null, null, fecha_salida, fecha_llegada, hora_salida, hora_llegada);
    	vuelo.setIdVuelo(rs.getLong("id_vuelo"));
    	ArrayList<Vuelos> vuelos = new ArrayList<Vuelos>();
    	vuelos.add(vuelo);
    	Aerolineas aerolinea = new Aerolineas(null, nombre_aerolinea, alianza, vuelos);
    	aerolinea.setIdAerolinea(rs.getLong("id_aerolinea"));
    	return aerolinea;
    	
    }
	
	@Override
	public List<Aerolineas> getAllAerolineas() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Aerolineas> aerolinea = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			aerolinea.add(Convertir(rs));
		}
	} catch (SQLException e) {
		
		throw new DAOException("Error SQL QueryAllCliente", e);
	}finally {
		if(rs !=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				new DAOException("ERROR CLOSE RS queryAllcliente", e);
			}
		}if(ps !=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				new DAOException("ERROR CLOSE PS querycliente", e);
			}
		}
	}
		
		return aerolinea;
}


	@Override
	public Aerolineas queryAerolinea(int Id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Aerolineas aerolinea = new Aerolineas();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			aerolinea = Convertir(rs);
		}else {
			throw new DAOException("NO SE ENCONTRO NINGUN REGISTRO");
		}
	} catch (SQLException e) {
		
		throw new DAOException("Error SQL queryCliente", e);
	}finally {
		if(rs !=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				new DAOException("ERROR CLOSE RS querycliente", e);
			}
		}if(ps !=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				new DAOException("ERROR CLOSE PS querycliente", e);
			}
		}
	}
		return aerolinea;
	}

}
