package edu.usal.negocio.dominio;

import java.io.Serializable;

public class PasajerosFrecuentes implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String numero, categoria, alianza;
private Aerolineas aerolinea;
private int idAerolinea, idCliente, idPasajeroFrecuente;

public PasajerosFrecuentes() {}

public PasajerosFrecuentes(String numero, String categoria, String alianza, Aerolineas aerolinea, int idAerolinea,
		int idCliente, int idPasajeroFrecuente) {
	super();
	this.numero = numero;
	this.categoria = categoria;
	this.alianza = alianza;
	this.aerolinea = aerolinea;
	this.idAerolinea = idAerolinea;
	this.idCliente = idCliente;
	this.idPasajeroFrecuente = idPasajeroFrecuente;
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

public String getAlianza() {
	return alianza;
}

public void setAlianza(String alianza) {
	this.alianza = alianza;
}

public Aerolineas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(Aerolineas aerolinea) {
	this.aerolinea = aerolinea;
}

public int getIdAerolinea() {
	return idAerolinea;
}

public void setIdAerolinea(int idAerolinea) {
	this.idAerolinea = idAerolinea;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public int getIdPasajeroFrecuente() {
	return idPasajeroFrecuente;
}

public void setIdPasajeroFrecuente(int idPasajeroFrecuente) {
	this.idPasajeroFrecuente = idPasajeroFrecuente;
}

@Override
public String toString() {
	return "PasajerosFrecuentes [numero=" + numero + ", categoria=" + categoria + ", alianza=" + alianza
			+ ", aerolinea=" + aerolinea.toString() + ", idAerolinea=" + idAerolinea + ", idCliente=" + idCliente
			+ ", idPasajeroFrecuente=" + idPasajeroFrecuente + "]";
}

}