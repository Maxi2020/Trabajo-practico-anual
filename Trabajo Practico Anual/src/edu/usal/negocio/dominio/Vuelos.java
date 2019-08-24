package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Vuelos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroVuelo, tiempoVuelo;
	private int idVuelo, idAeropuertoSalida, idAeropuertoLlegada, idAerolinea, cantidadAsientos;
	private Aeropuertos aeropuertoSalida;
	private Aeropuertos aeropuertoLlegada;
	private Aerolineas aerolinea;
	private LocalDateTime fechaHoraSalida, fechaHoraLlegada;
	
public Vuelos() {}

public Vuelos(String numeroVuelo, String tiempoVuelo, int idVuelo, int idAeropuertoSalida, int idAeropuertoLlegada,
		int idAerolinea, int cantidadAsientos, Aeropuertos aeropuertoSalida, Aeropuertos aeropuertoLlegada,
		Aerolineas aerolinea, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada) {
	super();
	this.numeroVuelo = numeroVuelo;
	this.tiempoVuelo = tiempoVuelo;
	this.idVuelo = idVuelo;
	this.idAeropuertoSalida = idAeropuertoSalida;
	this.idAeropuertoLlegada = idAeropuertoLlegada;
	this.idAerolinea = idAerolinea;
	this.cantidadAsientos = cantidadAsientos;
	this.aeropuertoSalida = aeropuertoSalida;
	this.aeropuertoLlegada = aeropuertoLlegada;
	this.aerolinea = aerolinea;
	this.fechaHoraSalida = fechaHoraSalida;
	this.fechaHoraLlegada = fechaHoraLlegada;
}

public String getNumeroVuelo() {
	return numeroVuelo;
}

public void setNumeroVuelo(String numeroVuelo) {
	this.numeroVuelo = numeroVuelo;
}

public String getTiempoVuelo() {
	return tiempoVuelo;
}

public void setTiempoVuelo(String tiempoVuelo) {
	this.tiempoVuelo = tiempoVuelo;
}

public int getIdVuelo() {
	return idVuelo;
}

public void setIdVuelo(int idVuelo) {
	this.idVuelo = idVuelo;
}

public int getIdAeropuertoSalida() {
	return idAeropuertoSalida;
}

public void setIdAeropuertoSalida(int idAeropuertoSalida) {
	this.idAeropuertoSalida = idAeropuertoSalida;
}

public int getIdAeropuertoLlegada() {
	return idAeropuertoLlegada;
}

public void setIdAeropuertoLlegada(int idAeropuertoLlegada) {
	this.idAeropuertoLlegada = idAeropuertoLlegada;
}

public int getIdAerolinea() {
	return idAerolinea;
}

public void setIdAerolinea(int idAerolinea) {
	this.idAerolinea = idAerolinea;
}

public int getCantidadAsientos() {
	return cantidadAsientos;
}

public void setCantidadAsientos(int cantidadAsientos) {
	this.cantidadAsientos = cantidadAsientos;
}

public Aeropuertos getAeropuertoSalida() {
	return aeropuertoSalida;
}

public void setAeropuertoSalida(Aeropuertos aeropuertoSalida) {
	this.aeropuertoSalida = aeropuertoSalida;
}

public Aeropuertos getAeropuertoLlegada() {
	return aeropuertoLlegada;
}

public void setAeropuertoLlegada(Aeropuertos aeropuertoLlegada) {
	this.aeropuertoLlegada = aeropuertoLlegada;
}

public Aerolineas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(Aerolineas aerolinea) {
	this.aerolinea = aerolinea;
}

public LocalDateTime getFechaHoraSalida() {
	return fechaHoraSalida;
}

public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
	this.fechaHoraSalida = fechaHoraSalida;
}

public LocalDateTime getFechaHoraLlegada() {
	return fechaHoraLlegada;
}

public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
	this.fechaHoraLlegada = fechaHoraLlegada;
}

@Override
public String toString() {
	return "Vuelos [numeroVuelo=" + numeroVuelo + ", tiempoVuelo=" + tiempoVuelo + ", idVuelo=" + idVuelo
			+ ", idAeropuertoSalida=" + idAeropuertoSalida + ", idAeropuertoLlegada=" + idAeropuertoLlegada
			+ ", idAerolinea=" + idAerolinea + ", cantidadAsientos=" + cantidadAsientos + ", aeropuertoSalida="
			+ aeropuertoSalida.toString() + ", aeropuertoLlegada=" + aeropuertoLlegada.toString() + ", aerolinea=" + aerolinea.toString()
			+ ", fechaHoraSalida=" + fechaHoraSalida + ", fechaHoraLlegada=" + fechaHoraLlegada + "]";
}

}
