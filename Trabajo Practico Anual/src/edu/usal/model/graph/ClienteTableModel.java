package edu.usal.model.graph;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public class ClienteTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteDAO cliente;
	private List<Clientes> lista = new ArrayList<>();
	
	public ClienteTableModel(ClienteDAO cliente)	{
	this.cliente=cliente;
}

	public void UpdateModel () throws FileNotFoundException, IOException, DAOException {
		cliente = ClienteFactory.getClienteDAO("Sql");
		lista = cliente.getAllClientes();
	}
	
	public String getColumnName(int column) {
		switch(column) {
		case 0: return "id_cliente";
		case 1: return "nombre";
		case 2: return "apellido";
		case 3: return "dni";
		case 4: return "cuit";
		case 5: return "email";
		case 6: return "fecha_nacimiento";
		case 7: return "numero_pasaporte";
		case 8: return "autoridad_emision";
		case 9: return "fecha_emision";
		case 10: return "fecha_vencimiento";
		case 11: return "pais_emision";
		case 12: return "numero_celular";
		case 13: return "numero_laboral";
		case 14: return "numero_personal";
		case 15: return "categoria_pasajero";
		case 16: return "alianza";
		case 17: return "nombre_aerolinea";
		case 18: return "calle_residencia";
		case 19: return "Altura_residencia";
		case 20: return "ciudad_residencia";
		case 21: return "codigo_postal";
		case 22: return "pais_residencia";
		case 23: return "provincia_residencia";
		default: return "[no]";
		}
	}
	@Override
	public int getColumnCount() {
		return 23;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Clientes get = lista.get(rowIndex);
		switch (columnIndex) {
		case 0: return get.getIdCliente();
		case 1: return get.getNombre();
		case 2: return get.getApellido();
		case 3: return get.getDni();
		case 4: return get.getCuit();
		case 5: return get.getEmail();
		case 6: 
			DateFormat df = DateFormat.getDateInstance();
			return df.format(get.getFechaNacimiento());
		case 7: return get.getPasaporte().getNumeroPasaporte();
		case 8: return get.getPasaporte().getAutoridadEmision();
		case 9: 
			DateFormat df2 = DateFormat.getDateInstance();
			return df2.format(get.getPasaporte().getFechaEmision());
		case 10: 
			DateFormat df3 = DateFormat.getDateInstance();
			return df3.format(get.getPasaporte().getFechaVencimiento());
		case 11: return get.getPasaporte().getPais();
		case 12: return get.getTelefono().getNumeroCelular();
		case 13: return get.getTelefono().getNumeroLaboral();
		case 14: return get.getTelefono().getNumeroPersonal();
		case 15: return get.getPasajerofrecuente().getCategoria();
		case 16: return get.getPasajerofrecuente().getAlianza();
		case 17: return get.getPasajerofrecuente().getAerolinea().getNombreAerolinea();
		case 18: return get.getDireccion().getCalle();
		case 19: return get.getDireccion().getAltura();
		case 20: return get.getDireccion().getCiudad();
		case 21: return get.getDireccion().getCodigoPostal();
		case 22: return get.getDireccion().getPais();
		case 23: return get.getDireccion().getProvincia();
		
		default : return "";
		}
	}
}
