package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Paises implements Serializable {
private String pais;

public Paises() {}

public Paises(String pais) {
	super();
	this.pais = pais;
}

public String getPais() {
	return pais;
}

public void setPais(String pais) {
	this.pais = pais;
}

}
