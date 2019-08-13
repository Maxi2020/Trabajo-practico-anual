package edu.usal.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class LineasAereas {
private String nombreAerolinea;
private List <Vuelos> vuelos = new ArrayList ();
private String alianza;
private int IdLineasAereas;
public LineasAereas() {}
public LineasAereas(String nombreAerolinea, List<Vuelos> vuelos, String alianza, int idLineasAereas) {
	super();
	this.nombreAerolinea = nombreAerolinea;
	this.vuelos = vuelos;
	this.alianza = alianza;
	this.IdLineasAereas = idLineasAereas;
}
public String getNombreAerolinea() {
	return nombreAerolinea;
}
public void setNombreAerolinea(String nombreAerolinea) {
	this.nombreAerolinea = nombreAerolinea;
}
public List<Vuelos> getVuelos() {
	return vuelos;
}
public void setVuelos(List<Vuelos> vuelos) {
	this.vuelos = vuelos;
}
public String getAlianza() {
	return alianza;
}
public void setAlianza(String alianza) {
	this.alianza = alianza;
}
public int getIdLineasAereas() {
	return IdLineasAereas;
}
public void setIdLineasAereas(int idLineasAereas) {
	IdLineasAereas = idLineasAereas;
}
@Override
public String toString() {
	return "LineasAereas [nombreAerolinea=" + nombreAerolinea + ", vuelos=" + vuelos + ", alianza=" + alianza
			+ ", IdLineasAereas=" + IdLineasAereas + "]";
}	

}
