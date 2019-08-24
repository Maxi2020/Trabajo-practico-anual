package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;


public class Pasaportes implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String numeroPasaporte, autoridadEmision;
private LocalDate fechaEmision, fechaVencimiento;
private Paises pais;
private int idPais, idCliente, idPasaporte;

public Pasaportes() {}

public Pasaportes(String numeroPasaporte, String autoridadEmision, LocalDate fechaEmision, LocalDate fechaVencimiento,
		Paises pais, int idPais, int idCliente, int idPasaporte) {
	super();
	this.numeroPasaporte = numeroPasaporte;
	this.autoridadEmision = autoridadEmision;
	this.fechaEmision = fechaEmision;
	this.fechaVencimiento = fechaVencimiento;
	this.pais = pais;
	this.idPais = idPais;
	this.idCliente = idCliente;
	this.idPasaporte = idPasaporte;
}

public String getNumeroPasaporte() {
	return numeroPasaporte;
}

public void setNumeroPasaporte(String numeroPasaporte) {
	this.numeroPasaporte = numeroPasaporte;
}

public String getAutoridadEmision() {
	return autoridadEmision;
}

public void setAutoridadEmision(String autoridadEmision) {
	this.autoridadEmision = autoridadEmision;
}

public LocalDate getFechaEmision() {
	return fechaEmision;
}

public void setFechaEmision(LocalDate fechaEmision) {
	this.fechaEmision = fechaEmision;
}

public LocalDate getFechaVencimiento() {
	return fechaVencimiento;
}

public void setFechaVencimiento(LocalDate fechaVencimiento) {
	this.fechaVencimiento = fechaVencimiento;
}

public Paises getPais() {
	return pais;
}

public void setPais(Paises pais) {
	this.pais = pais;
}

public int getIdPais() {
	return idPais;
}

public void setIdPais(int idPais) {
	this.idPais = idPais;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public int getIdPasaporte() {
	return idPasaporte;
}

public void setIdPasaporte(int idPasaporte) {
	this.idPasaporte = idPasaporte;
}

@Override
public String toString() {
	return "Pasaportes [numeroPasaporte=" + numeroPasaporte + ", autoridadEmision=" + autoridadEmision
			+ ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento + ", pais=" + pais.toString()
			+ ", idPais=" + idPais + ", idCliente=" + idCliente + ", idPasaporte=" + idPasaporte + "]";
}

}
