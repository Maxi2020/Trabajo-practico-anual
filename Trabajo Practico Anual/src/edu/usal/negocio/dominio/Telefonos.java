package edu.usal.negocio.dominio;

import java.io.Serializable;


public class Telefonos implements Serializable  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String numeroPersonal, numeroCelular, numeroLaboral;
private int idCliente;
private Long idTelefono;

public Telefonos() {}

public Telefonos(String numeroPersonal, String numeroCelular, String numeroLaboral, int idCliente, Long idTelefono) {
	super();
	this.numeroPersonal = numeroPersonal;
	this.numeroCelular = numeroCelular;
	this.numeroLaboral = numeroLaboral;
	this.idCliente = idCliente;
	this.idTelefono = idTelefono;
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

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public Long getIdTelefono() {
	return idTelefono;
}

public void setIdTelefono(Long idTelefono) {
	this.idTelefono = idTelefono;
}

@Override
public String toString() {
	return "Telefonos [numeroPersonal=" + numeroPersonal + ", numeroCelular=" + numeroCelular + ", numeroLaboral="
			+ numeroLaboral + ", idCliente=" + idCliente + ", idTelefono=" + idTelefono + "]";
}

}
