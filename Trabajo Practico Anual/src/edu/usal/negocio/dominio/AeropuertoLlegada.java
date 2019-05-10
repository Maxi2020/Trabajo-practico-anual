package edu.usal.negocio.dominio;

public class AeropuertoLlegada extends Vuelos{
//provincia y pais objeto sacar extend objeto de vuelos
	private String identificacionAeropuerto, Ciudad, Provincia, Pais;
	
	public AeropuertoLlegada() {}

	public AeropuertoLlegada(String identificacionAeropuerto, String ciudad, String provincia, String pais) {
		super();
		this.identificacionAeropuerto = identificacionAeropuerto;
		Ciudad = ciudad;
		Provincia = provincia;
		Pais = pais;
	}

	public String getIdentificacionAeropuerto() {
		return identificacionAeropuerto;
	}

	public void setIdentificacionAeropuerto(String identificacionAeropuerto) {
		this.identificacionAeropuerto = identificacionAeropuerto;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}
	
}
