package edu.usal.negocio;

import java.time.LocalDate;

public class PasajerosFrecuentes extends Clientes {
private String alianza, aerolinea, numero, categoria;
public PasajerosFrecuentes() {}

public PasajerosFrecuentes(String alianza, String aerolineas, String numero, String categoria) {
	super();
	this.alianza = alianza;
	this.aerolinea = aerolinea;
	this.numero = numero;
	this.categoria = categoria;
}

public String getAlianza() {
	return alianza;
}
public void setAlianza(String alianza) {
	this.alianza = alianza;
}
public String getAerolineas() {
	return aerolinea;
}
public void setAerolineas(String aerolineas) {
	this.aerolinea = aerolineas;
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

}
