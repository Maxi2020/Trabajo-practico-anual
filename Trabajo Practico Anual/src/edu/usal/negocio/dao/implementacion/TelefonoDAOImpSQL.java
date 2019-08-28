package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.Connections;
import edu.usal.util.DAOException;

public class TelefonoDAOImpSQL implements TelefonoDAO {
	
	private Connection cn;
	final String INSERT = "INSERT INTO telefonos (personal, celular, laboral, id_cliente) VALUES(?,?,?,?)";
	final String UPDATE = "UPDATE telefonos SET personal=?, celular=?, laboral=?, id_cliente=? WHERE id_telefono=?";
	final String DELETE = "DELETE FROM telefonos WHERE id_telefono=?";
	final String GETALL = "SELECT id_telefono, personal, celular, laboral, id_cliente FROM telefonos";
	final String GETONE = "SELECT id_telefono, personal, celular, laboral, id_cliente FROM telefonos WHERE id_telefono=?";

	@Override
	public boolean addTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		cn.setAutoCommit(false);
		try { 
			ps = cn.prepareStatement(INSERT);
			ps.setString(1, cliente.getTelefono().getNumeroPersonal());
			ps.setString(2, cliente.getTelefono().getNumeroCelular());
			ps.setString(3, cliente.getTelefono().getNumeroLaboral());
			ps.setInt(4, cliente.getTelefono().getIdCliente());
		
			if(ps.executeUpdate() == 0) {
				
				throw new DAOException("FALLO EN AGREGAR SQL cliente");
			}

		} catch (SQLException e) {
			throw new DAOException("EROOR EN SQL addCliente", e);
		}
		finally{
			if(ps !=null) {
		
				try {
					ps.close();
					cn.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateTelefono(Clientes cliente, Connection cn) throws DAOException {
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		try { 

			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getTelefono().getNumeroPersonal());
			ps.setString(2, cliente.getTelefono().getNumeroCelular());
			ps.setString(3, cliente.getTelefono().getNumeroLaboral());
			ps.setInt(4, cliente.getTelefono().getIdCliente());
			
			if(ps.executeUpdate() == 0) {
			
				throw new DAOException("FALLO EN MODIFICAR SQL cliente");
			}
		
		} catch (SQLException e) {
			throw new DAOException("EROOR EN SQL UPCliente", e);
		}
		finally{
			if(ps !=null) {
				try {
					ps.close();
					cn.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteTelefono(Clientes cliente, Connection cn) throws DAOException {
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getTelefono().getIdTelefono());
			if(ps.executeUpdate() == 0) {
				throw new DAOException("FALLO EN BORRRAR SQL cliente");
			}	
		} catch (SQLException e) {
			throw new DAOException("EROOR EN SQL addCliente", e);
		}
		finally{
			if(ps !=null) {
				try {
					ps.close();
					cn.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}return false;
	}
    
	private Telefonos Convertir(ResultSet rs) throws SQLException {
    	  
    	String personal = rs.getString("personal");
    	String celular = rs.getString("celular");
    	String laboral = rs.getString("laboral");
    	int id_cliente = rs.getInt("id_cliente");
    	
    	Telefonos telefono = new Telefonos(personal, celular, laboral, id_cliente, null);
    	telefono.setIdTelefono(rs.getLong("id_telefono"));
    	return telefono;
    	
    }

	@Override
	public Telefonos queryTelefono(int Id) throws DAOException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn = Connections.getConnection();
		Telefonos telefono = new Telefonos();
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			telefono = Convertir(rs);
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
				cn.close();
			} catch (SQLException e) {
				new DAOException("ERROR CLOSE PS querycliente", e);
			}
		}
	}
		
		return telefono;
	}

	@Override
	public List<Telefonos> getAllTelefonos() throws DAOException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn = Connections.getConnection();
		List<Telefonos> telefono = new ArrayList<>();
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			telefono.add(Convertir(rs));
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
				cn.close();
			} catch (SQLException e) {
				new DAOException("ERROR CLOSE PS querycliente", e);
			}
		}
	}
		
		return telefono;
	}

}
