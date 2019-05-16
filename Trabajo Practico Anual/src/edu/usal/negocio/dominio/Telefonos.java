package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Telefonos implements Serializable  {
private String numeroPersonal, numeroCelular, numeroLaboral;
public Telefonos() {}
public Telefonos(String numeroPersonal, String numeroCelular, String numeroLaboral) {
	super();
	this.numeroPersonal = numeroPersonal;
	this.numeroCelular = numeroCelular;
	this.numeroLaboral = numeroLaboral;
}
public String getNumeroPersonal() {
	return numeroPersonal;
}
public void setNumeroPersonal(String numeroPersonal) {
	this.numeroPersonal = numeroPersonal;
}
public String getNumeroCelular() {
	return numeroCelular;
}
public void setNumeroCelular(String numeroCelular) {
	this.numeroCelular = numeroCelular;
}
public String getNumeroLaboral() {
	return numeroLaboral;
}
public void setNumeroLaboral(String numeroLaboral) {
	this.numeroLaboral = numeroLaboral;
}

}
