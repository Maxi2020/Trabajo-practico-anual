package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.DireccionDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.util.DAOException;

public class DireccionDAOImpSQL implements DireccionDAO{
	
	private Connection cn;
	final String INSERT = "INSERT INTO direcciones (calle, altura, ciudad, codigo_postal, id_pais, id_cliente, id_provincia) VALUES(?,?,?,?,?,?,?)";
	final String UPDATE = "UPDATE direcciones SET calle=?, altura=?, ciudad=?, codigo_postal=? WHERE id_direccion=?";
	final String DELETE = "DELETE FROM direcciones WHERE id_direccion=?";
	final String GETALL = "SELECT id_direccion, calle, altura, ciudad, codigo_postal, id_pais, id_cliente, id_provincia FROM direcciones";
	final String GETONE = "SELECT id_direccion, calle, altura, ciudad, codigo_postal, id_pais, id_cliente, id_provincia FROM direcciones WHERE id_direccion=?";

	@Override
	public boolean addDireccion(Clientes cliente, Connection cn) throws SQLException, DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Direcciones direccion = new Direcciones();
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getDireccion().getCalle());
			ps.setString(2, cliente.getDireccion().getAltura());
			ps.setString(3, cliente.getDireccion().getCiudad());
			ps.setString(4, cliente.getDireccion().getCodigoPostal());
			ps.setLong(5, cliente.getDireccion().getPais().getIdPais());
			ps.setLong(6, cliente.getIdCliente());
			ps.setLong(7, cliente.getDireccion().getProvincia().getIdProvincia());
			ps.executeUpdate();
		    rs= ps.getGeneratedKeys();
		    
		    while(rs.next())
		    	direccion.setIdDireccion((long) rs.getInt(1));

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
	public void updateDireccion(Clientes cliente) throws DAOException {
		PreparedStatement ps = null;
		
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getDireccion().getCalle());
			ps.setString(2, cliente.getDireccion().getAltura());
			ps.setString(3, cliente.getDireccion().getCiudad());
			ps.setString(4, cliente.getDireccion().getCodigoPostal());

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
	public boolean deleteDireccion(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getDireccion().getIdDireccion());
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
	
	private Direcciones Convertir(ResultSet rs) throws SQLException {
		String calle = rs.getString("calle");
		String altura = rs.getString("altura");
		String ciudad = rs.getString("ciudad");
		String codigoPostal = rs.getString("codigo_postal");
    	
		Direcciones direccion =  new Direcciones(calle, altura, ciudad, codigoPostal, null ,null, null);
    	direccion.setIdDireccion(rs.getLong("id_direccion"));
    	return direccion;
    }

	@Override
	public Direcciones queryDireccion(int Id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Direcciones direccion = new Direcciones();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			direccion = Convertir(rs);
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
		
		return direccion;
	}

	@Override
	public List<Direcciones> getAllDirecciones() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Direcciones> direccion = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			direccion.add(Convertir(rs));
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
		
		return direccion;
	}

}
