package edu.usal.controller.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.IOGeneral;
import edu.usal.view.console.MenuVistaCliente;

public class MenuControllerCliente {
MenuVistaCliente vistaCliente;
ClienteDAO clienteDAO;
public MenuControllerCliente() {
	vistaCliente = new MenuVistaCliente();
	this.MostrarMenu();
}
public void MostrarMenu() {
	int res = -1;
	while(res!=0){
		res= vistaCliente.ImprimirMenu();
		switch(res){
			case 1:	addCliente();
					break;
			case 2: queryCliente();
					break;
			case 3:	updateCliente();
					break;
			case 4: deleteCliente();
					break;
			case 0: break;
			default: IOGeneral.pritln("Numero Equivocado");
		}
	}
}
private void addCliente() {
	
		Clientes cliente = vistaCliente.PedirClientes();
		clienteDAO = ClienteFactory.getClienteDAO("Serializable");
		try {
			if(clienteDAO.addCliente(cliente)) {
				vistaCliente.OperacionExitosa();
			}else {
				vistaCliente.OperacionFail();
			}
		}
		catch (FileNotFoundException e) {
			vistaCliente.LugarError("Archivo No Encontrado", e.getLocalizedMessage());
		}
		catch (IOException e) {
			vistaCliente.LugarError("Entrada/Salida De Datos", e.getLocalizedMessage());
		}
	
	
}
private void queryCliente() {

	try {
		clienteDAO = ClienteFactory.getClienteDAO("Serializable");
		List<Clientes> cliente = clienteDAO.getAllClientes();
		vistaCliente.MostrarLista(cliente);
	}
	catch (FileNotFoundException e) {
			vistaCliente.LugarError("Archivo No Encontrado", e.getLocalizedMessage());
		}
	catch (IOException e) {
			vistaCliente.LugarError("Entrada/Salida De Datos", e.getLocalizedMessage());
		}
}
private void updateCliente() {
	
	try {
	clienteDAO = ClienteFactory.getClienteDAO("Serializable");
	Clientes clienteModificar = new Clientes (null, null, null, null, null, null, vistaCliente.PedirID("Modificar Cliente"), null, null, null, null);
	clienteModificar = clienteDAO.queryCliente(clienteModificar);
	if(clienteModificar != null) {
		if(vistaCliente.Confirmacion(clienteModificar)) {
			if(clienteDAO.updateCliente(clienteModificar)) {
				
				vistaCliente.OperacionExitosa();
			}
		else {
			vistaCliente.OpcionFail();
		}
	}   else {
		vistaCliente.CancelarOperacion();
	    }
	}   else {
		vistaCliente.LugarError("Cliente No Modificado", "No Se Encontro el Id");
	}
    }
	catch (FileNotFoundException e) {
		vistaCliente.LugarError("Archivo No Encontrado", e.getLocalizedMessage());
	}
    catch (IOException e) {
		vistaCliente.LugarError("Entrada/Salida De Datos", e.getLocalizedMessage());
	}
}
private void deleteCliente() {
	
	try {
		clienteDAO = ClienteFactory.getClienteDAO("Serializable");
		Clientes clienteEliminar = new Clientes(null, null, null, null, null, null, vistaCliente.PedirID("Eliminar Cliente"), null, null, null, null);
		clienteEliminar = clienteDAO.queryCliente(clienteEliminar);
		if(clienteEliminar != null) {
		if(vistaCliente.Confirmacion(clienteEliminar)) {
			if(clienteDAO.deleteCliente(clienteEliminar)) {
				vistaCliente.OperacionExitosa();
			}else {
				vistaCliente.OpcionFail();
			}
			}else {
				vistaCliente.CancelarOperacion();
			}
			}else {
				vistaCliente.LugarError("Cliente No Eliminado","No Se Encontro El Id" );
			}
	} 
	catch (FileNotFoundException e) {
		vistaCliente.LugarError("Archivo No Encontrado", e.getLocalizedMessage());
	}
    catch (IOException e) {
		vistaCliente.LugarError("Entrada/Salida De Datos", e.getLocalizedMessage());
	}
}
}
