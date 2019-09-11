package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public class ClienteDAOImpSQL implements ClienteDAO {
	
	private ResultSet rs = null;
	private Connection cn;
	final String INSERT = "INSERT INTO clientes (nombre, apellido, dni,cuit, fecha_nacimiento, email) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE clientes SET nombre=?, apellido=?, dni=?, cuit=?, fecha_nacimiento=?, email=? WHERE id_cliente=?";
	final String DELETE = "DELETE FROM clientes WHERE id_cliente=?";
	final String GETALL = "SELECT id_cliente, nombre, apellido, dni,cuit, fecha_nacimiento, email FROM clientes";
	final String GETONE = "SELECT id_cliente, nombre, apellido, dni,cuit, fecha_nacimiento, email FROM clientes WHERE id_cliente=?";
	

	//@Override
	public boolean addCliente(Clientes cliente, Connection cn) throws DAOException, SQLException{
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try { 
			ps= cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			ps.setString(6, cliente.getEmail());
			ps.executeUpdate();
			ps.getGeneratedKeys();
			while(rs.next()) 
				cliente.setIdCliente((long) rs.getInt(1));
			cn.commit();
			
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
	public void updateCliente(Clientes cliente) throws DAOException  {
		PreparedStatement ps = null;
		
		try { 
			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			ps.setString(6, cliente.getEmail());
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
	public boolean deleteCliente(Clientes cliente, Connection cn) throws DAOException, SQLException  {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);
		
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getIdCliente());
			ps.executeUpdate();
			cn.commit();
			
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
	
    private Clientes Convertir(ResultSet rs) throws SQLException {
  
    	String nombre = rs.getString("nombre");
    	String apellido = rs.getString("apellido");
    	String dni = rs.getString("dni");
    	String cuit = rs.getString("cuit");
    	LocalDate fecha_nacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
    	String email = rs.getString("email");
    	Clientes cliente = new Clientes(nombre, apellido, dni, cuit, email,
    			fecha_nacimiento, null ,null ,null ,null, null );
    	cliente.setIdCliente(rs.getLong("id_cliente"));
    	return cliente;
    	
    }
    
	@Override
	
    public Clientes queryCliente(int Id) throws DAOException  {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Clientes cliente = new Clientes();
		
	try {
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			cliente = Convertir(rs);
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
		return cliente;
	}
	
	@Override
    public List<Clientes> getAllClientes() throws DAOException  {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Clientes> cliente = new ArrayList<>();
		
	try {
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			cliente.add(Convertir(rs));
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
		return cliente;
	}

}
