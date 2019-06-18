package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vuelos implements Serializable {
	
	private String numeroVuelo, tiempoVuelo;
	private int id_vuelo;
	private int cantidadAsientos;
	private AeropuertoSalida aeropuerto_de_salida;
	private AeropuertoLlegada aeropuerto_de_llegada;
	private LocalDateTime fechaHoraSalida, fechaHoraLlegada;
	
	public Vuelos() {}

	public Vuelos(String numeroVuelo, String tiempoVuelo, int id_vuelo, int cantidadAsientos,
			AeropuertoSalida aeropuerto_de_salida, AeropuertoLlegada aeropuerto_de_llegada,
			LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada) {
		super();
		this.numeroVuelo = numeroVuelo;
		this.tiempoVuelo = tiempoVuelo;
		this.id_vuelo = id_vuelo;
		this.cantidadAsientos = cantidadAsientos;
		this.aeropuerto_de_salida = aeropuerto_de_salida;
		this.aeropuerto_de_llegada = aeropuerto_de_llegada;
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

	public int getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	public int getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

	public AeropuertoSalida getAeropuerto_de_salida() {
		return aeropuerto_de_salida;
	}

	public void setAeropuerto_de_salida(AeropuertoSalida aeropuerto_de_salida) {
		this.aeropuerto_de_salida = aeropuerto_de_salida;
	}

	public AeropuertoLlegada getAeropuerto_de_llegada() {
		return aeropuerto_de_llegada;
	}

	public void setAeropuerto_de_llegada(AeropuertoLlegada aeropuerto_de_llegada) {
		this.aeropuerto_de_llegada = aeropuerto_de_llegada;
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
		
		return "\n Vuelo "+id_vuelo+" \n [Numero de vuelo= "+numeroVuelo+", Cantidad de asientos= "+cantidadAsientos+ ", Tiempo de vuelo= "+tiempoVuelo+", Fecha y hora de salida= "+fechaHoraSalida+", Fecha y hora de llegada= "+fechaHoraLlegada+"] \n-> Datos de Aeropuerto de Salida= \n "+aeropuerto_de_salida.toString()+" \n-> Datos de Aeropuerto de Llegada= \n " + aeropuerto_de_llegada.toString()+ "]";
				
				
	}
	
	
}
