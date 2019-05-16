package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Pasaportes implements Serializable {
	
private String numeroPasaporte, autoridadEmision;
private LocalDate fechaEmision, fechaVencimiento;
private Paises paisEmision;
public Pasaportes() {}
public Pasaportes(String numeroPasaporte, String autoridadEmision, LocalDate fechaEmision, LocalDate fechaVencimiento,
		Paises paisEmision) {
	super();
	this.numeroPasaporte = numeroPasaporte;
	this.autoridadEmision = autoridadEmision;
	this.fechaEmision = fechaEmision;
	this.fechaVencimiento = fechaVencimiento;
	this.paisEmision = paisEmision;
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
public Paises getPaisEmision() {
	return paisEmision;
}
public void setPaisEmision(Paises paisEmision) {
	this.paisEmision = paisEmision;
}


}
