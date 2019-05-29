package edu.usal.view.console;

import java.time.LocalDate;
import java.util.List;

import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.IOGeneral;


public class MenuVistaCliente {
	public void menuVistaCliente() {
		
	}
	
	public int ImprimirMenu() {
		return IOGeneral.leerInt("<<<MENU PRINCIPAL>>>\nIngrese Opcion \n1-Nuevo Cliente\n2-Mostrar Clientes\n3-Modificar Clientes\n4-Eliminar Clientes\n0-salir"
				, "Lo ingresado no corresponde a ninguna opcion");
	}
	
	public void OpcionFail(){
		IOGeneral.pritln("Lo ingresado no es valido");
	}
	
	public void MostraCliente(Clientes cliente) {
		IOGeneral.pritln(cliente.toString());
	}
	public Clientes PedirClientes() {
		
		Clientes cliente = new Clientes(); Pasaportes pasaporte = new Pasaportes(); Paises paisEmision =new Paises(); Telefonos telefono =new Telefonos(); 
		Direcciones direccion = new Direcciones(); Paises paises = new Paises(); Provincias provincia= new Provincias(); PasajerosFrecuentes pasajero = new PasajerosFrecuentes();
		Aerolineas aerolinea = new Aerolineas();
		  
		  cliente.setNombre(IOGeneral.leerLinea("Ingresar Nombre")); cliente.setApellido(IOGeneral.leerLinea("Ingresar Apellido"));
		  cliente.setCorreo(IOGeneral.leerLinea("Ingresar Correo")); cliente.setCuit(IOGeneral.leerLinea("Ingresar Cuit"));
		  cliente.setDni(IOGeneral.leerLinea("Ingresar DNI")); cliente.setIdCliente(IOGeneral.leerInt("Ingresar IdCliente", "Ingresar Numeros Enteros"));
		  cliente.setFechaNacimiento(IOGeneral.LeerFecha("Ingresar Fecha De Nacimiento yyyy/MM/dd"));
		  pasaporte.setAutoridadEmision(IOGeneral.leerLinea("Ingresar Autoridad De Emision")); 
		  pasaporte.setFechaEmision(IOGeneral.LeerFecha("Ingresar Fecha De Emision Pasaporte yyyy/MM/dd"));
		  pasaporte.setFechaVencimiento(IOGeneral.LeerFecha("Ingresar Fecha De vencimiento Pasaporte yyyy/MM/dd"));
		  pasaporte.setNumeroPasaporte(IOGeneral.leerLinea("Ingresar Numero Pasaporte")); paisEmision.setPais(IOGeneral.leerLinea("Ingresar Pais"));
		  pasaporte.setPaisEmision(paisEmision); cliente.setPasaporte(pasaporte);
		  telefono.setNumeroCelular(IOGeneral.leerLinea("Ingresar Numero Celular")); telefono.setNumeroLaboral(IOGeneral.leerLinea("Ingresar Numero Laboral"));
		  telefono.setNumeroPersonal(IOGeneral.leerLinea("Ingresar Numero Personal")); cliente.setTelefono(telefono);
		  direccion.setAltura(IOGeneral.leerLinea("Ingresar Altura")); direccion.setCalle(IOGeneral.leerLinea("Ingresar Direccion"));
		  direccion.setCiudad(IOGeneral.leerLinea("Ingresar Ciudad")); direccion.setCodigoPostal(IOGeneral.leerLinea("Ingresar Codigo Postal"));
		  paises.setPais(IOGeneral.leerLinea("Ingresar Pais")); direccion.setPaises(paises); provincia.setProvincias(IOGeneral.leerLinea("Ingresar Provincia"));
		  direccion.setProvincias(provincia); cliente.setDireccion(direccion); pasajero.setAlianza(IOGeneral.leerLinea("Ingresar Alianza")); 
		  pasajero.setCategoria(IOGeneral.leerLinea("Ingresar Categoria")); pasajero.setNumero(IOGeneral.leerLinea("Ingresar Numero Pasajero")); 
		  aerolinea.setAerolinea(IOGeneral.leerLinea("Ingresar Aerolinea"));
		  pasajero.setAerolinea(aerolinea); cliente.setPasajerofrecuente(pasajero);
		  
		  return cliente;
	}
	public void OperacionExitosa() {
		IOGeneral.pritln("Operacion Realizada Con Exito");
	}
	public void OperacionFail() {
		IOGeneral.pritln("La Operacion No Se Pudo Realizae");
	}
	public void LugarError(String lugar, String causa) {
		IOGeneral.pritln("La operacion ha fracasado, no fue realizada.\n Error("+lugar+")\tCausa: "+causa);
		}
	public void MostrarLista(List<Clientes> cliente) {
		if(!cliente.isEmpty()) {
			IOGeneral.pritln("Lista De Clientes: ");
			for(Clientes listado : cliente) {
				this.MostraCliente(listado);
			}
			IOGeneral.pritln("Muestra Finalizada ");
		}else {
			IOGeneral.pritln("No Hay Elementos En La Lista");
		}
	}
	public int PedirID(String causa) {
		return IOGeneral.leerInt("Ingrese ID Para Realizar La Operacion ("+causa+")", "Debe Ingresar Un Numero Entero");
	}
	public boolean Confirmacion(Clientes elemento) {
		if(IOGeneral.leerInt("Confirma Seleccionar:\n"+elemento.toString()+"\n Ingrese 1 Para Confirmar Su Seleccion", "Debe Ingresar Un Numero Entero")==1) {
			return true;
		}
		return false;
	}
	public void CancelarOperacion() {
		IOGeneral.pritln("Operacion Cancelada No Se Realizaron Cambios");
	}
	public Clientes CosultaDatosModificados(Clientes modificado) {
		Pasaportes pasaporte = new Pasaportes(); Paises paisEmision =new Paises(); Telefonos telefono =new Telefonos(); 
		Direcciones direccion = new Direcciones(); Aerolineas aerolinea = new Aerolineas();
		Paises paises = new Paises(); Provincias provincia= new Provincias(); PasajerosFrecuentes pasajero = new PasajerosFrecuentes();
		
	
		  modificado.setNombre(IOGeneral.leerLinea("Ingresar Nombre")); modificado.setApellido(IOGeneral.leerLinea("Ingresar Apellido"));
		  modificado.setCorreo(IOGeneral.leerLinea("Ingresar Correo")); modificado.setCuit(IOGeneral.leerLinea("Ingresar Cuit"));
		  modificado.setDni(IOGeneral.leerLinea("Ingresar DNI")); 
		  modificado.setFechaNacimiento(IOGeneral.LeerFecha("Ingresar Fecha De Nacimiento yyyy/MM/dd"));
		  pasaporte.setAutoridadEmision(IOGeneral.leerLinea("Ingresar Autoridad De Emision")); 
		  pasaporte.setFechaEmision(IOGeneral.LeerFecha("Ingresar Fecha De Emision Pasaporte yyyy/MM/dd"));
		  pasaporte.setFechaVencimiento(IOGeneral.LeerFecha("Ingresar Fecha De vencimiento Pasaporte yyyy/MM/dd"));
		  pasaporte.setNumeroPasaporte(IOGeneral.leerLinea("Ingresar Numero Pasaporte")); paisEmision.setPais(IOGeneral.leerLinea("Ingresar Pais"));
		  pasaporte.setPaisEmision(paisEmision); modificado.setPasaporte(pasaporte);
		  telefono.setNumeroCelular(IOGeneral.leerLinea("Ingresar Numero Celular")); telefono.setNumeroLaboral(IOGeneral.leerLinea("Ingresar Numero Laboral"));
		  telefono.setNumeroPersonal(IOGeneral.leerLinea("Ingresar Numero Personal")); modificado.setTelefono(telefono);
		  direccion.setAltura(IOGeneral.leerLinea("Ingresar Altura")); direccion.setCalle(IOGeneral.leerLinea("Ingresar Direccion"));
		  direccion.setCiudad(IOGeneral.leerLinea("Ingresar Ciudad")); direccion.setCodigoPostal(IOGeneral.leerLinea("Ingresar Codigo Postal"));
		  paises.setPais(IOGeneral.leerLinea("Ingresar Pais")); direccion.setPaises(paises); provincia.setProvincias(IOGeneral.leerLinea("Ingresar Provincia"));
		  direccion.setProvincias(provincia); modificado.setDireccion(direccion); pasajero.setAlianza(IOGeneral.leerLinea("Ingresar Alianza")); 
		  pasajero.setCategoria(IOGeneral.leerLinea("Ingresar Categoria")); pasajero.setNumero(IOGeneral.leerLinea("Ingresar Numero Pasajero")); 
		  aerolinea.setAerolinea(IOGeneral.leerLinea("Ingresar Aerolinea"));
		  pasajero.setAerolinea(aerolinea); modificado.setPasajerofrecuente(pasajero);
		  
		  return modificado;
	}
	public boolean ConfirmarModificacion(Clientes modificar) {
		if(IOGeneral.leerInt("¿Confirma La Modificacion? \n"+modificar.toString()+"\n Ingrese 1 Para Confirmar", "Ingresar Numero Entero")==1) {
			return true;
		}
		return false;
	}
	
	}

