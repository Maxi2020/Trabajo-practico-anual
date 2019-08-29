package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Aerolineas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAerolinea = null;
	private String nombreAerolinea, alianza;
	private ArrayList<Vuelos> vuelo;

public Aerolineas() {}

public Aerolineas(Long idAerolinea, String nombreAerolinea, String alianza, ArrayList<Vuelos> vuelo) {
	super();
	this.idAerolinea = idAerolinea;
	this.nombreAerolinea = nombreAerolinea;
	this.alianza = alianza;
	this.vuelo = vuelo;
}

public Long getIdAerolinea() {
	return idAerolinea;
}

public void setIdAerolinea(Long idAerolinea) {
	this.idAerolinea = idAerolinea;
}

public String getNombreAerolinea() {
	return nombreAerolinea;
}

public void setNombreAerolinea(String nombreAerolinea) {
	this.nombreAerolinea = nombreAerolinea;
}

public String getAlianza() {
	return alianza;
}

public void setAlianza(String alianza) {
	this.alianza = alianza;
}

public ArrayList<Vuelos> getVuelo() {
	return vuelo;
}

public void setVuelo(ArrayList<Vuelos> vuelo) {
	this.vuelo = vuelo;
}

@Override
public String toString() {
	return "Aerolineas [idAerolinea=" + idAerolinea + ", nombreAerolinea=" + nombreAerolinea + ", alianza=" + alianza
			+ ", vuelo=" + vuelo + "]";
}

}
