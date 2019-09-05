package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.util.DAOException;

public class PasajeroFrecuenteDAOImpSQL implements PasajeroFrecuenteDAO {
	
	private Connection cn;
	final String INSERT = "INSERT INTO pasajero_frecuente (alianza, numero, categoria, id_cliente, id_aerolinea) VALUES(?,?,?,?,?)";
	final String UPDATE = "UPDATE pasajero_frecuente SET alianza=?, numero=?, categoria=? WHERE id_pasajero_frecuente=?";
	final String DELETE = "DELETE FROM pasajero_frecuente WHERE id_pasajero_frecuente=?";
	final String GETALL = "SELECT id_pasajero_frecuente, alianza, numero, categoria, id_cliente, id_aerolinea FROM pasajero_frecuente";
	final String GETONE = "SELECT id_pasajero_frecuente, alianza, numero, categoria, id_cliente, id_aerolinea FROM pasajero_frecuente WHERE id_pasajero_frecuente=?";

	@Override
	public void addPasajeroFrecuente(Clientes cliente, Connection cn) throws SQLException, DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		PasajerosFrecuentes pasajero = new PasajerosFrecuentes();
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getPasajerofrecuente().getAlianza());
			ps.setString(2, cliente.getPasajerofrecuente().getNumero());
			ps.setString(3, cliente.getPasajerofrecuente().getCategoria());
			ps.setLong(4, cliente.getIdCliente());
			ps.setLong(5, cliente.getPasajerofrecuente().getAerolinea().getIdAerolinea());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    
		    
		    while(rs.next())
		    	pasajero.setIdPasajeroFrecuente((long) rs.getInt(1));

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
	}

	@Override
	public void updatePasajeroFrecuente(Clientes cliente) throws DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getPasajerofrecuente().getAlianza());
			ps.setString(2, cliente.getPasajerofrecuente().getNumero());
			ps.setString(3, cliente.getPasajerofrecuente().getCategoria());
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
	public void deletePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getPasajerofrecuente().getIdPasajeroFrecuente());
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
	}

	private PasajerosFrecuentes Convertir(ResultSet rs) throws SQLException {
    	String numero  = rs.getString("numero");
    	String categoria = rs.getString("categoria");
    	String alianza = rs.getString("alianza");
    	
    	PasajerosFrecuentes pasajero = new PasajerosFrecuentes(numero, categoria, alianza, null, null);
    	pasajero.setIdPasajeroFrecuente(rs.getLong("id_pasajero_frecuente"));
    	return pasajero;
    	
    }
	
	@Override
	public PasajerosFrecuentes queryPasajeroFrecuente(int Id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		PasajerosFrecuentes pasajero = new PasajerosFrecuentes();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			pasajero = Convertir(rs);
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
		
		return pasajero;
	}

	@Override
	public List<PasajerosFrecuentes> getAllPasajerosFrecuentes() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PasajerosFrecuentes> pasajero = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			pasajero.add(Convertir(rs));
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
		
		return pasajero;
	}

}

