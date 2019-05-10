package edu.usal.negocio;

import java.time.LocalDate;

public class Telefonos extends Clientes {
	//objetos en clientes sacar extends 
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
