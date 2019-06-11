package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Provincias implements Serializable {
	private String provincias;

public Provincias() {}

public Provincias(String provincias) {
	super();
	this.provincias = provincias;
}

public String getProvincias() {
	return provincias;
}

public void setProvincias(String provincias) {
	this.provincias = provincias;
}

@Override
public String toString() {
	return  provincias;
}

}
