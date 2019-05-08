package edu.usal.negocio;

import java.util.ArrayList;
import java.util.List;

public class LineasAereas {
private String nombreAerolinea;
private List <Vuelos> vuelos=new ArrayList ();
public LineasAereas() {}
public LineasAereas(String nombreAerolinea, List<Vuelos> vuelos) {
	super();
	this.nombreAerolinea = nombreAerolinea;
	this.vuelos = vuelos;
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

}
