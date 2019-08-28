package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.Factory.TelefonoFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.Connections;
import edu.usal.util.DAOException;

public class ClienteDAOImpSQL implements ClienteDAO {
	private TelefonoDAO telefonoDAO;
	private Connection cn;
	final String INSERT = "INSERT INTO clientes (nombre, apellido, dni,cuit, fecha_nacimiento, email) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE clientes SET nombre=?, apellido=?, dni=?, cuit=?, fecha_nacimiento=?, email=? WHERE id_cliente=?";
	final String DELETE = "DELETE FROM clientes WHERE id_cliente=?";
	final String GETALL = "SELECT id_cliente, nombre, apellido, dni,cuit, fecha_nacimiento, email FROM clientes";
	final String GETONE = "SELECT id_cliente, nombre, apellido, dni,cuit, fecha_nacimiento, email FROM clientes WHERE id_cliente=?";

	//@Override
	public boolean addCliente(Clientes cliente) throws DAOException, SQLException{
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		cn.setAutoCommit(false);
		telefonoDAO = TelefonoFactory.getTelefonoDAO("Sql");
		try { 
			ps = cn.prepareStatement(INSERT);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			ps.setString(6, cliente.getEmail());
			if(ps.executeUpdate() == 0) {
				ps.close();
				if(telefonoDAO.addTelefono(cliente, cn)) {
					cn.commit();
					cn.close();
					return true;
				}
			}

		} catch (SQLException e) {
			throw new DAOException("EROOR EN SQL addCliente", e);
		}
		finally{
			if(ps !=null) {
				try {
					cn.rollback();
					cn.close();
					ps.close();
				} catch (SQLException e) {
					throw new DAOException("ERROR EN SQL closePSCliente", e);
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateCliente(Clientes cliente) throws DAOException  {
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		try { 

			ps = cn.prepareStatement(UPDATE);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			ps.setString(6, cliente.getEmail());
			
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
	public boolean deleteCliente(Clientes cliente) throws DAOException  {
		PreparedStatement ps = null;
		cn = Connections.getConnection();
		try {
			ps = cn.prepareStatement(DELETE);
			ps.setLong(1, cliente.getIdCliente());
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
		}
		return false;
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
		cn = Connections.getConnection();
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
				cn.close();
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
		cn = Connections.getConnection();
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
				cn.close();
			} catch (SQLException e) {
				new DAOException("ERROR CLOSE PS querycliente", e);
			}
		}
	}
		
		return cliente;
	}

public static void main ( String [] args) throws DAOException, FileNotFoundException, IOException, SQLException {
	ClienteDAO clienteDAO;
	clienteDAO = ClienteFactory.getClienteDAO("Sql");
		
		  List<Clientes> clientes = clienteDAO.getAllClientes();
		  TelefonoDAO tel;
			tel = TelefonoFactory.getTelefonoDAO("Sql");
				
				  //List<Telefonos> telefono = tel.getAllTelefonos();
		  //for (Clientes a :
		  //clientes) { System.out.print(a.toString()); }
		 
		
		  LocalDate ahora = LocalDate.now(); Clientes client = new Clientes
		  ("martin","cammarota","231","235","ds",ahora, null ,null, null, null, null);
		  
		  Telefonos d = new Telefonos("311313","134342", "342424", 5, null);
		  client.setTelefono(d);
		  clienteDAO.addCliente(client);
		 
}
}
