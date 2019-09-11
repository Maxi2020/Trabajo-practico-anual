package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;

public class ProvinciaDAOImpSQL implements ProvinciaDAO{
	private Connection cn;
	final String INSERT = "INSERT INTO provincias (nombre_provincia) VALUES(?)";
	final String UPDATE = "UPDATE provincias SET nombre_provincia=? WHERE id_provincia=?";
	final String DELETE = "DELETE FROM provincias WHERE id_provincia=?";
	final String GETALL = "SELECT id_provincia, nombre_provincia FROM provincias";
	final String GETONE = "SELECT id_provincia, nombre_provincia FROM provincias WHERE id_provincia=?";

	@Override
	public Hashtable<Integer, String> leerProvincias() throws FileNotFoundException, IOException {
		return null;
	}

	@Override
	public boolean addProvincia(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Provincias provincia = new Provincias();
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getDireccion().getProvincia().getNombreProvincia());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    while(rs.next())
		    	provincia.setIdProvincia((long) rs.getInt(1));

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
	public void updateProvincia(Clientes cliente) throws  DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getDireccion().getProvincia().getNombreProvincia());
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
	public boolean deleteProvincia(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getDireccion().getProvincia().getIdProvincia());
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

	private Provincias Convertir(ResultSet rs) throws SQLException {
    	String nombreProvincia  = rs.getString("nombre_provincia");
    	Provincias provincia = new Provincias(null, nombreProvincia);
    	provincia.setIdProvincia(rs.getLong("id_pais"));
    	return provincia;
    }
	
	@Override
	public Provincias queryProvincia(int Id) throws  DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Provincias provincia = new Provincias();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			provincia = Convertir(rs);
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
		return provincia;
	}

	@Override
	public List<Provincias> getAllProvincias() throws  DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Provincias> provincia = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			provincia.add(Convertir(rs));
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
		return provincia;
	}
}
