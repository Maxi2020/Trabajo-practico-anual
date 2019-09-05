package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.util.DAOException;

public class PasaporteDAOImpSQL implements PasaporteDAO{
	
	private Connection cn;
	final String INSERT = "INSERT INTO pasaportes (numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais, id_cliente) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE pasaportes SET numero_pasaporte=?, autoridad_emision=?, fecha_emision=?, fecha_vencimiento=? WHERE id_pasaporte=?";
	final String DELETE = "DELETE FROM pasaportes WHERE id_pasaporte=?";
	final String GETALL = "SELECT id_pasaporte, numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais, id_cliente FROM pasaportes";
	final String GETONE = "SELECT id_pasaporte, numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais, id_cliente FROM telefonos WHERE id_telefono=?";
	
	@Override
	public void addPasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Pasaportes pasaporte = new Pasaportes();
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getPasaporte().getNumeroPasaporte());
			ps.setString(2, cliente.getPasaporte().getAutoridadEmision());
			ps.setDate(3, java.sql.Date.valueOf(cliente.getPasaporte().getFechaEmision()));
			ps.setDate(4, java.sql.Date.valueOf(cliente.getPasaporte().getFechaVencimiento()));
			ps.setLong(5, cliente.getDireccion().getPais().getIdPais());
			ps.setLong(6, cliente.getIdCliente());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    
		    while(rs.next())
		    	pasaporte.setIdPasaporte((long) rs.getInt(1));

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
	public void updatePasaporte(Clientes cliente) throws DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getPasaporte().getNumeroPasaporte());
			ps.setString(2, cliente.getPasaporte().getAutoridadEmision());
			ps.setDate(3, java.sql.Date.valueOf(cliente.getPasaporte().getFechaEmision()));
			ps.setDate(4, java.sql.Date.valueOf(cliente.getPasaporte().getFechaVencimiento()));
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
	public void deletePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getPasaporte().getIdPasaporte());
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

	private Pasaportes Convertir(ResultSet rs) throws SQLException {
    	String numeroPasaporte  = rs.getString("numero_pasaporte");
    	String autoridadEmision = rs.getString("autoridad_emision");
    	LocalDate fechaEmision = rs.getDate("fecha_emision").toLocalDate();
    	LocalDate fechaVencimiento = rs.getDate("fecha_vencimiento").toLocalDate();
    	Pasaportes pasaporte = new Pasaportes(numeroPasaporte, autoridadEmision, fechaEmision, fechaVencimiento, null, null);
    	pasaporte.setIdPasaporte(rs.getLong("id_pasaporte"));
    	return pasaporte;
    	
    }

	@Override
	public Pasaportes queryPasaporte(int Id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pasaportes pasaporte = new Pasaportes();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			pasaporte = Convertir(rs);
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
		return pasaporte;
	}

	@Override
	public List<Pasaportes> getAllPasaportes() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Pasaportes> pasaporte = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			pasaporte.add(Convertir(rs));
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
		return pasaporte;
	}

}
