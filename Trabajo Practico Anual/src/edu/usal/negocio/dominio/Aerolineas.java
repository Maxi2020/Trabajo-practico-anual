package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Aerolineas implements Serializable {
private String aerolinea;

public Aerolineas() {}

public Aerolineas(String aerolinea) {
	super();
	this.aerolinea = aerolinea;
}

public String getAerolinea() {
	return aerolinea;
}

public void setAerolinea(String aerolinea) {
	this.aerolinea = aerolinea;
}

@Override
public String toString() {
	return aerolinea;
}

}
