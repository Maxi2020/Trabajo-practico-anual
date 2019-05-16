package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class PasajerosFrecuentes implements Serializable {
private String alianza, numero, categoria;
private Aerolineas aerolinea;
public PasajerosFrecuentes() {}
public PasajerosFrecuentes(String alianza, String numero, String categoria, Aerolineas aerolinea) {
	super();
	this.alianza = alianza;
	this.numero = numero;
	this.categoria = categoria;
	this.aerolinea = aerolinea;
}
public String getAlianza() {
	return alianza;
}
public void setAlianza(String alianza) {
	this.alianza = alianza;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public Aerolineas getAerolinea() {
	return aerolinea;
}
public void setAerolinea(Aerolineas aerolinea) {
	this.aerolinea = aerolinea;
}


}