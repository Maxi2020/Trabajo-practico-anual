package edu.usal.negocio.dominio;

import java.io.Serializable;

public class AeropuertoLlegada implements Serializable{

	private String id_aeropuerto_llegada, Ciudad;
	private Paises pais;
	private Provincias provincia;
	
	public AeropuertoLlegada() {}

	public AeropuertoLlegada(String id_aeropuerto_llegada, String ciudad, Paises pais, Provincias provincia) {
		super();
		this.id_aeropuerto_llegada = id_aeropuerto_llegada;
		this.Ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getId_aeropuerto_llegada() {
		return id_aeropuerto_llegada;
	}

	public void setIdentificacionAeropuerto(String id_aeropuerto_llegada) {
		this.id_aeropuerto_llegada = id_aeropuerto_llegada;
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

	return "[Aeropuerto de Llegada=" + id_aeropuerto_llegada+ ", Ciudad="+ Ciudad + ", Pais=" + pais.toString() + ", Provincia=" + provincia.toString() + "]";

	}
	
}
