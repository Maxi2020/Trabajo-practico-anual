package edu.usal.negocio;

import java.time.LocalDateTime;

public abstract class Vuelos {
	
	
	private String aerolinea ,numeroVuelo, tiempoVuelo;
	private int cantidadAsientos;
	private LocalDateTime fechaHoraSalida, fechaHoraLlegada;
	
	public Vuelos () {}

	public Vuelos(String aerolinea, String numeroVuelo, String tiempoVuelo, int cantidadAsientos,
			LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada) {
		super();
		this.aerolinea = aerolinea;
		this.numeroVuelo = numeroVuelo;
		this.tiempoVuelo = tiempoVuelo;
		this.cantidadAsientos = cantidadAsientos;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
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

	public int getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
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
	
	
}
