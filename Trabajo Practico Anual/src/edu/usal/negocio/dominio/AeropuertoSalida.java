package edu.usal.negocio.dominio;

import java.io.Serializable;

public class AeropuertoSalida implements Serializable{

	private String id_aeropuerto_salida, Ciudad;
	private Paises pais;
	private Provincias provincia;
	
	public AeropuertoSalida() {}

	public AeropuertoSalida(String id_aeropuerto_salida, String ciudad, Paises pais, Provincias provincia) {
		super();
		this.id_aeropuerto_salida = id_aeropuerto_salida;
		this.Ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getId_aeropuerto_salida() {
		return id_aeropuerto_salida;
	}

	public void setIdentificacionAeropuerto(String id_aeropuerto_salida) {
		this.id_aeropuerto_salida = id_aeropuerto_salida;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString(){

	return "[Aeropuerto de Salida=" + id_aeropuerto_salida + ", Ciudad="+ Ciudad + ", Pais=" + pais.toString() + ", Provincia=" + provincia.toString() + "]";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
