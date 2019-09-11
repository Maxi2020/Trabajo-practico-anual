package edu.usal.controler.graph;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTable;

import edu.usal.model.graph.ClienteTableModel;
import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.util.DAOException;

public class ControlerCliente {
	private ClienteTableModel model;
	 private JTable ClienteTable;
	 
	public ControlerCliente(ClienteDAO cliente) throws FileNotFoundException, IOException, DAOException {
    	this.model = new ClienteTableModel(cliente = ClienteFactory.getClienteDAO("Sql"));
    	this.model.UpdateModel();
    	this.ClienteTable.setModel(model);
    }
}
