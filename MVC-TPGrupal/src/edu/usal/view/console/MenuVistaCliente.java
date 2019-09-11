package edu.usal.view.console;

import java.util.List;

import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Alianzas;
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
		return IOGeneral.leerInt("\n <<<MENU PRINCIPAL>>>\nIngrese Opcion \n1-Nuevo Cliente\n2-Mostrar Clientes\n3-Modificar Clientes\n4-Eliminar Clientes\n0-Salir"
				, "\n Lo Ingresado No Corresponde A Ninguna Opcion");
	}
	
	public void OpcionInvalida(){
		IOGeneral.pritln("\n Lo Ingresado No Es Valido");
	}
	
	public void MostraCliente(Clientes cliente) {
		IOGeneral.pritln(cliente.toString());
	}
	public void MostrarPasaporte(Pasaportes pasaporte) {
		IOGeneral.pritln(pasaporte.toString());
	}
	public Clientes AgregarClientes() {
	Clientes cliente = new Clientes();  
	  IOGeneral.pritln("\n-> //Llenar Datos Cliente// \n");
	  cliente.setNombre(IOGeneral.leerLinea("Ingresar Nombre")); cliente.setApellido(IOGeneral.leerLinea("Ingresar Apellido"));
      cliente.setCorreo(IOGeneral.leerLinea("Ingresar Correo")); cliente.setCuit(IOGeneral.leerLinea("Ingresar Cuit"));
	  cliente.setDni(IOGeneral.leerLinea("Ingresar DNI")); cliente.setIdCliente(IOGeneral.leerInt("Ingresar IdCliente", "\n Ingresar Numeros Enteros"));
      cliente.setFechaNacimiento(IOGeneral.LeerFecha("Ingresar Fecha De Nacimiento yyyy/MM/dd"));
	  return cliente;
	}
	public PasajerosFrecuentes AgregarPasasajerosFrecuentes() {
    PasajerosFrecuentes pasajero = new PasajerosFrecuentes(); Aerolineas aerolinea = new Aerolineas(); Alianzas alianzas = new Alianzas();
	   IOGeneral.pritln("\n-> //Llenar Datos De Aerolinea// \n");
	   aerolinea.setAerolinea(IOGeneral.leerLinea("Ingresar Aerolinea")); aerolinea.setIdAerolinea(IOGeneral.leerInt("Ingresar IdAerolinea", "\n Ingresar Numeros Enteros"));
	   alianzas.setAlianza(IOGeneral.leerLinea("Ingresar Alianza De Aerolinea")); alianzas.setIdAlianza(IOGeneral.leerInt("Ingresar IdAlianza", "\n Ingresar Numeros Enteros"));
	   pasajero.setCategoria(IOGeneral.leerLinea("Ingresar Categoria De Pasajero")); pasajero.setNumero(IOGeneral.leerLinea("Ingresar Numero Pasajero")); 
	   pasajero.setIdPasajeroFrecuente(IOGeneral.leerInt("Ingresar IdPasajero Frecuente", "\n Ingresar Numeros Enteros"));
	   pasajero.setAerolinea(aerolinea); pasajero.setAlianza(alianzas);
	   return pasajero;
	}
	public Pasaportes AgregarPasaportes() {
	Pasaportes pasaporte = new Pasaportes(); Paises paisEmision = new Paises();
	  IOGeneral.pritln("\n-> //Llenar Datos Del Pasaporte// \n");
	  pasaporte.setIdPasaporte(IOGeneral.leerInt("Ingresar IdPasaporte", "\n Ingresar Numeros Enteros"));
	  pasaporte.setAutoridadEmision(IOGeneral.leerLinea("Ingresar Autoridad De Emision Del Pasaporte")); 
	  pasaporte.setFechaEmision(IOGeneral.LeerFecha("Ingresar Fecha De Emision Del Pasaporte yyyy/MM/dd"));
	  pasaporte.setFechaVencimiento(IOGeneral.LeerFecha("Ingresar Fecha De vencimiento Del Pasaporte yyyy/MM/dd"));
	  pasaporte.setNumeroPasaporte(IOGeneral.leerLinea("Ingresar Numero Del Pasaporte")); paisEmision.setPais(IOGeneral.leerLinea("Ingresar Pais De Emision Del Pasaporte"));
	  pasaporte.setPaisEmision(paisEmision);
	  return pasaporte;
	}
	public Telefonos AgregarTelefonos() {
	Telefonos telefono =new Telefonos();
	  telefono.setNumeroCelular(IOGeneral.leerLinea("Ingresar Numero Celular")); telefono.setNumeroLaboral(IOGeneral.leerLinea("Ingresar Numero Laboral"));
	  telefono.setNumeroPersonal(IOGeneral.leerLinea("Ingresar Numero Personal"));telefono.setIdTelefono(IOGeneral.leerInt("Ingresar IdTelefono", "\n Ingresar Numeros Enteros"));
	  return telefono;
	}
	public Direcciones AgregarDirecciones() {
	Direcciones direccion = new Direcciones(); Paises paises = new Paises(); Provincias provincia= new Provincias();
	   paises.setPais(IOGeneral.leerLinea("Ingresar Pais De Residencia")); paises.setIdPais(IOGeneral.leerInt("Ingresar IdCliente", "\n Ingresar Numeros Enteros"));
	   direccion.setPaises(paises); provincia.setProvincias(IOGeneral.leerLinea("Ingresar Provincia")); provincia.setIdProvincia(IOGeneral.leerInt("Ingresar IdProvincia", "\n Ingresar Numeros Enteros"));
	   direccion.setProvincias(provincia); direccion.setCiudad(IOGeneral.leerLinea("Ingresar Ciudad"));direccion.setCalle(IOGeneral.leerLinea("Ingresar Direccion"));direccion.setAltura(IOGeneral.leerLinea("Ingresar Altura De La Direccion"));
	   direccion.setCodigoPostal(IOGeneral.leerLinea("Ingresar Codigo Postal")); direccion.setIdDireccion(IOGeneral.leerInt("Ingresar IdCliente", "\n Ingresar Numeros Enteros"));
	   return direccion;
		   
	}
	public void OperacionExitosa() {
		IOGeneral.pritln("\n Operacion Realizada Con Exito");
	}
	public void OperacionFallida() {
		IOGeneral.pritln("\n La Operacion No Se Pudo Realizar");
	}
	public void LugarError(String lugar, String causa) {
		IOGeneral.pritln("\n La operacion ha fracasado, no fue realizada.\n Error("+lugar+")\tCausa: "+causa);
		}
	public void MostrarLista(List<Clientes> cliente) {
		if(!cliente.isEmpty()) {
			IOGeneral.pritln("\n ///Lista De Clientes/// \n");
			for(Clientes listado : cliente) {
				this.MostraCliente(listado);
			}
			IOGeneral.pritln("\n Muestra Finalizada ");
		}else {
			IOGeneral.pritln("\n No Hay Elementos En La Lista");
		}
	}
	public void MostrarListaP(List<Pasaportes> pasaporte) {
		if(!pasaporte.isEmpty()) {
			IOGeneral.pritln("\n ///Lista De Pasaportes/// \n");
			for(Pasaportes listado : pasaporte) {
				this.MostrarPasaporte(listado);
			}
			IOGeneral.pritln("\n Muestra Finalizada ");
		}else {
			IOGeneral.pritln("\n No Hay Elementos En La Lista");
		}
	}
	public int PedirID(String causa) {
		return IOGeneral.leerInt("\n Ingrese ID Para Realizar La Operacion ("+causa+")", "\n Debe Ingresar Un Numero Entero");
	}
	public boolean Confirmacion(Clientes elemento) {
		if(IOGeneral.leerInt("\n Confirma Seleccionar:\n"+elemento.toString()+" \n \n Ingrese 1 Para Confirmar Su Seleccion", "\n Debe Ingresar Un Numero Entero")==1) {
			return true;
		}
		return false;
	}
	public void CancelarOperacion() {
		IOGeneral.pritln("\n Operacion Cancelada No Se Realizaron Cambios");
	}
	public Clientes AgregarClienteModificado(Clientes modificado) {
		/*
		 * Pasaportes pasaporte = new Pasaportes(); Paises paisEmision =new Paises();
		 * Telefonos telefono =new Telefonos(); Direcciones direccion = new
		 * Direcciones(); Aerolineas aerolinea = new Aerolineas(); Paises paises = new
		 * Paises(); Provincias provincia= new Provincias(); PasajerosFrecuentes
		 * pasajero = new PasajerosFrecuentes();
		 * 
		 * IOGeneral.pritln("\n-> //Llenar Datos Cliente// \n");
		 * modificado.setNombre(IOGeneral.leerLinea("Ingresar Nombre"));
		 * modificado.setApellido(IOGeneral.leerLinea("Ingresar Apellido"));
		 * modificado.setCorreo(IOGeneral.leerLinea("Ingresar Correo"));
		 * modificado.setCuit(IOGeneral.leerLinea("Ingresar Cuit"));
		 * modificado.setDni(IOGeneral.leerLinea("Ingresar DNI"));
		 * modificado.setFechaNacimiento(IOGeneral.
		 * LeerFecha("Ingresar Fecha De Nacimiento yyyy/MM/dd"));
		 * telefono.setNumeroCelular(IOGeneral.leerLinea("Ingresar Numero Celular"));
		 * telefono.setNumeroLaboral(IOGeneral.leerLinea("Ingresar Numero Laboral"));
		 * telefono.setNumeroPersonal(IOGeneral.leerLinea("Ingresar Numero Personal"));
		 * modificado.setTelefono(telefono);
		 * paises.setPais(IOGeneral.leerLinea("Ingresar Pais De Residencia"));
		 * direccion.setPaises(paises);
		 * provincia.setProvincias(IOGeneral.leerLinea("Ingresar Provincia"));
		 * direccion.setCiudad(IOGeneral.leerLinea("Ingresar Ciudad"));direccion.
		 * setCalle(IOGeneral.leerLinea("Ingresar Direccion"));direccion.setAltura(
		 * IOGeneral.leerLinea("Ingresar Altura De La Direccion"));
		 * direccion.setCodigoPostal(IOGeneral.leerLinea("Ingresar Codigo Postal"));
		 * direccion.setProvincias(provincia); modificado.setDireccion(direccion);
		 * IOGeneral.pritln("\n-> //Llenar Datos Del Pasaporte// \n");
		 * pasaporte.setAutoridadEmision(IOGeneral.
		 * leerLinea("Ingresar Autoridad De Emision Del Pasaporte"));
		 * pasaporte.setFechaEmision(IOGeneral.
		 * LeerFecha("Ingresar Fecha De Emision Del Pasaporte yyyy/MM/dd"));
		 * pasaporte.setFechaVencimiento(IOGeneral.
		 * LeerFecha("Ingresar Fecha De vencimiento Del Pasaporte yyyy/MM/dd"));
		 * pasaporte.setNumeroPasaporte(IOGeneral.
		 * leerLinea("Ingresar Numero Del Pasaporte")); paisEmision.setPais(IOGeneral.
		 * leerLinea("Ingresar Pais De Emision Del Pasaporte"));
		 * pasaporte.setPaisEmision(paisEmision); modificado.setPasaporte(pasaporte);
		 * IOGeneral.pritln("\n-> //Llenar Datos De Aerolinea// \n");
		 * aerolinea.setAerolinea(IOGeneral.leerLinea("Ingresar Aerolinea"));pasajero.
		 * setAlianza(IOGeneral.leerLinea("Ingresar Alianza De Aerolinea"));
		 * pasajero.setCategoria(IOGeneral.leerLinea("Ingresar Categoria De Pasajero"));
		 * pasajero.setNumero(IOGeneral.leerLinea("Ingresar Numero Pasajero"));
		 * pasajero.setAerolinea(aerolinea); modificado.setPasajerofrecuente(pasajero);
		 * 
		 * return modificado;
		 */
		return modificado;
	}
	public boolean ConfirmarModificacion(Clientes modificar) {
		if(IOGeneral.leerInt("\n ¿Confirma La Modificacion? \n"+modificar.toString()+"\n \n Ingrese 1 Para Confirmar", "\n Ingresar Numero Entero")==1) {
			return true;
		}
		return false;
	}
	
	}

