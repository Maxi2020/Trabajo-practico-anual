package edu.usal.negocio.dominio;

public class Paises {
	
	private int idPais;
	private String nombrePais;

public Paises() {}

public Paises(int idPais, String nombrePais) {
	super();
	this.idPais = idPais;
	this.nombrePais = nombrePais;
}

public int getIdPais() {
	return idPais;
}

public void setIdPais(int idPais) {
	this.idPais = idPais;
}

public String getNombrePais() {
	return nombrePais;
}

public void setNombrePais(String nombrePais) {
	this.nombrePais = nombrePais;
}

@Override
public String toString() {
	return "Paises [idPais=" + idPais + ", nombrePais=" + nombrePais + "]";
}

}
