package edu.usal.view.console;

import java.util.List;

import edu.usal.negocio.dominio.Aeropuertos;
import edu.usal.negocio.dominio.AeropuertoSalida;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Vuelos;
import edu.usal.util.IOGeneral;

public class MenuVistaVuelo {
	
public void menuVistaVuelo() { }
	

	public int ImprimirMenu() {
		return IOGeneral.leerInt("\n <<<MENU PRINCIPAL>>>\nIngrese Opcion \n1-Nuevo Vuelo\n2-Mostrar Vuelos\n3-Modificar Vuelos\n4-Eliminar Vuelos\n0-Salir"
				, "\n Lo Ingresado No Corresponde A Ninguna Opcion");
	}
	
	public void OpcionFail(){
		IOGeneral.pritln("\n Lo Ingresado No Es Valido");
	}
	
	public void MostraVuelo(Vuelos vuelo) {
		IOGeneral.pritln(vuelo.toString());
	}
	
	public Vuelos PedirVuelos() {
		
		/*
		 * Vuelos vuelo = new Vuelos(); Provincias provincia = new Provincias(); Paises
		 * paises = new Paises(); Provincias provincia2 = new Provincias(); Paises
		 * paises2 = new Paises(); AeropuertoSalida aeropuertosalida = new
		 * AeropuertoSalida(); AeropuertoLlegada aeropuertollegada = new
		 * AeropuertoLlegada();
		 * 
		 * IOGeneral.pritln("\n-> //Llenar datos de vuelo// \n");
		 * 
		 * vuelo.setId_vuelo(IOGeneral.leerInt("Ingresar IdVuelo",
		 * "\n Ingresar numeros enteros"));
		 * vuelo.setNumeroVuelo(IOGeneral.leerLinea("Ingresar numero de vuelo"));
		 * vuelo.setCantidadAsientos(IOGeneral.leerInt("Ingresar cantidad de asientos",
		 * "\n Ingresar solo numeros enteros"));
		 * vuelo.setTiempoVuelo(IOGeneral.leerLinea("Ingresar el tiempo de vuelo"));
		 * vuelo.setFechaHoraSalida(IOGeneral.
		 * LeerFechahora("Ingresar la facha y hora de salida yyyy/MM/dd"));
		 * vuelo.setFechaHoraLlegada(IOGeneral.
		 * LeerFechahora("Ingresar la fecha y hora de llegada yyyy/MM/dd"));
		 * IOGeneral.pritln("\n-> //Llenar datos del Aeropuerto de Salida// \n");
		 * provincia.setProvincias(IOGeneral.leerLinea("Ingresar provincia local"));
		 * paises.setPais(IOGeneral.leerLinea("Ingresar el pais local"));
		 * aeropuertosalida.setIdentificacionAeropuerto(IOGeneral.
		 * leerLinea("Ingresar id de Aeropuerto de salida"));
		 * aeropuertosalida.setCiudad(IOGeneral.leerLinea("Ingresar ciudad local"));
		 * aeropuertosalida.setProvincia(provincia); aeropuertosalida.setPais(paises);
		 * vuelo.setAeropuerto_de_salida(aeropuertosalida);
		 * IOGeneral.pritln("\n-> //Llenar datos del Aeropuerto de Llegada// \n");
		 * provincia2.setProvincias(IOGeneral.leerLinea("Ingresar provincia destino"));
		 * paises2.setPais(IOGeneral.leerLinea("Ingresar pais destino"));
		 * aeropuertollegada.setIdentificacionAeropuerto(IOGeneral.
		 * leerLinea("Ingresar id de Aeropuerto de llegada"));
		 * aeropuertollegada.setCiudad(IOGeneral.leerLinea("Ingresar ciudad destino"));
		 * aeropuertollegada.setProvincia(provincia2);
		 * aeropuertollegada.setPais(paises2);
		 * vuelo.setAeropuerto_de_llegada(aeropuertollegada);
		 */
		return null;
		
	}
	
	
	public void OperacionExitosa() {
		IOGeneral.pritln("\n Operacion Realizada Con Exito");
	}
	public void OperacionFail() {
		IOGeneral.pritln("\n La Operacion No Se Pudo Realizar");
	}
	public void LugarError(String lugar, String causa) {
		IOGeneral.pritln("\n La operacion ha fracasado, no fue realizada.\n Error("+lugar+")\tCausa: "+causa);
		}

	public void MostrarLista(List<Vuelos> vuelo) {
		if(!vuelo.isEmpty()) {
			IOGeneral.pritln("\n ///Lista De Vuelos/// \n");
			for(Vuelos listado : vuelo) {
				this.MostraVuelo(listado);
			}
			IOGeneral.pritln("\n Muestra Finalizada ");
		}else {
			IOGeneral.pritln("\n No Hay Elementos En La Lista");
		}
	}
	
	public int PedirID(String causa) {
		return IOGeneral.leerInt("\n Ingrese ID Para Realizar La Operacion ("+causa+")", "\n Debe Ingresar Un Numero Entero");
	}
	public boolean Confirmacion(Vuelos elemento) {
		if(IOGeneral.leerInt("\n Confirma Seleccionar:\n"+elemento.toString()+"\n Ingrese 1 Para Confirmar Su Seleccion", "\n Debe Ingresar Un Numero Entero")==1) {
			return true;
		}
		return false;
	}
	public void CancelarOperacion() {
		IOGeneral.pritln("\n Operacion Cancelada No Se Realizaron Cambios");
	}
	
	
	public Vuelos CosultaDatosModificados(Vuelos modificado) {
		
		/*
		 * Provincias provincia = new Provincias(); Paises paises = new Paises();
		 * Provincias provincia2 = new Provincias(); Paises paises2 = new Paises();
		 * AeropuertoSalida aeropuertosalida = new AeropuertoSalida(); AeropuertoLlegada
		 * aeropuertollegada = new AeropuertoLlegada();
		 * 
		 * IOGeneral.pritln("\n-> //Llenar datos de vuelo// \n");
		 * 
		 * modificado.setId_vuelo(IOGeneral.leerInt("Ingresar IdVuelo",
		 * "\n Ingresar numeros enteros"));
		 * modificado.setNumeroVuelo(IOGeneral.leerLinea("Ingresar numero de vuelo"));
		 * modificado.setCantidadAsientos(IOGeneral.
		 * leerInt("Ingresar cantidad de asientos",
		 * "\n Ingresar solo numeros enteros"));
		 * modificado.setTiempoVuelo(IOGeneral.leerLinea("Ingresar el tiempo de vuelo"))
		 * ; modificado.setFechaHoraSalida(IOGeneral.
		 * LeerFechahora("Ingresar la facha y hora de salida yyyy/MM/dd HH:mm"));
		 * modificado.setFechaHoraLlegada(IOGeneral.
		 * LeerFechahora("Ingresar la fecha y hora de llegada yyyy/MM/dd HH:mm"));
		 * 
		 * IOGeneral.pritln("\n-> //Llenar datos del Aeropuerto de Salida// \n");
		 * 
		 * provincia.setProvincias(IOGeneral.leerLinea("Ingresar provincia local"));
		 * paises.setPais(IOGeneral.leerLinea("Ingresar el pais local"));
		 * aeropuertosalida.setIdentificacionAeropuerto(IOGeneral.
		 * leerLinea("Ingresar id de Aeropuerto de salida"));
		 * aeropuertosalida.setCiudad(IOGeneral.leerLinea("Ingresar ciudad local"));
		 * aeropuertosalida.setProvincia(provincia); aeropuertosalida.setPais(paises);
		 * modificado.setAeropuerto_de_salida(aeropuertosalida);
		 * 
		 * IOGeneral.pritln("\n-> //Llenar datos del Aeropuerto de Llegada// \n");
		 * 
		 * provincia2.setProvincias(IOGeneral.leerLinea("Ingresar provincia destino"));
		 * paises2.setPais(IOGeneral.leerLinea("Ingresar pais destino"));
		 * aeropuertollegada.setIdentificacionAeropuerto(IOGeneral.
		 * leerLinea("Ingresar id de Aeropuerto de llegada"));
		 * aeropuertollegada.setCiudad(IOGeneral.leerLinea("Ingresar ciudad destino"));
		 * aeropuertollegada.setProvincia(provincia2);
		 * aeropuertollegada.setPais(paises2);
		 * modificado.setAeropuerto_de_llegada(aeropuertollegada);
		 * 
		 * return modificado;
		 */
		return null;
	}
	
	public boolean ConfirmarModificacion(Vuelos modificar) {
		if(IOGeneral.leerInt("\n ¿Confirma La Modificacion? \n"+modificar.toString()+"\n Ingrese 1 Para Confirmar", "\n Ingresar Numero Entero")==1) {
			return true;
		}
		return false;
	}
	
	

}
