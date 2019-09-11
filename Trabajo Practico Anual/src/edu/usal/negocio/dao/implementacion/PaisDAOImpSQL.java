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
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Paises;
import edu.usal.util.DAOException;

public class PaisDAOImpSQL implements PaisDAO {
	private Connection cn;
	final String INSERT = "INSERT INTO paises (nombre_pais) VALUES(?)";
	final String UPDATE = "UPDATE paises SET nombre_pais=? WHERE id_pais=?";
	final String DELETE = "DELETE FROM paises WHERE id_pais=?";
	final String GETALL = "SELECT id_pais, nombre_pais FROM paises";
	final String GETONE = "SELECT id_pais, nombre_pais FROM paises WHERE id_pais=?";

	@Override
	public Hashtable<Integer, String> leerPaises() throws FileNotFoundException, IOException {
		return null;
	}

	@Override
	public boolean addPais(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Paises pais = new Paises();
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getDireccion().getPais().getNombrePais());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    
		    while(rs.next())
		    	pais.setIdPais((long) rs.getInt(1));

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
	public void updatePais(Clientes cliente) throws DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getDireccion().getPais().getNombrePais());
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
	public boolean deletePais(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getDireccion().getPais().getIdPais());
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

	private Paises Convertir(ResultSet rs) throws SQLException {
    	String nombrePais  = rs.getString("nombre_pais");
    	Paises pais = new Paises(null, nombrePais);
    	pais.setIdPais(rs.getLong("id_pais"));
    	return pais;
    }
	
	@Override
	public Paises queryPais(int Id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Paises pais = new Paises();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			pais = Convertir(rs);
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
		return pais;
	}

	@Override
	public List<Paises> getAllPaises() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paises> pais = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			pais.add(Convertir(rs));
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
		return pais;
	}

}
