package edu.usal.negocio.dominio;

import java.time.LocalDate;

public class PasajerosFrecuentes {
private String alianza, numero, categoria;
private Aerolinea aerolinea;
public PasajerosFrecuentes() {}
public PasajerosFrecuentes(String alianza, String numero, String categoria, Aerolinea aerolinea) {
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
public Aerolinea getAerolinea() {
	return aerolinea;
}
public void setAerolinea(Aerolinea aerolinea) {
	this.aerolinea = aerolinea;
}

}
