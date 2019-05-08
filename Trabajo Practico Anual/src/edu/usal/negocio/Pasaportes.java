package edu.usal.negocio;

import java.time.LocalDate;

public class Pasaportes extends Clientes {
private String numeroPasaporte, autoridadEmision, paisEmision;
private LocalDate fechaEmision, fechaVencimiento;
public Pasaportes() {}
public Pasaportes(String numeroPasaporte, String autoridadEmision, String paisEmision, LocalDate fechaEmision,
		LocalDate fechaVencimiento) {
	super();
	this.numeroPasaporte = numeroPasaporte;
	this.autoridadEmision = autoridadEmision;
	this.paisEmision = paisEmision;
	this.fechaEmision = fechaEmision;
	this.fechaVencimiento = fechaVencimiento;
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
public String getPaisEmision() {
	return paisEmision;
}
public void setPaisEmision(String paisEmision) {
	this.paisEmision = paisEmision;
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


}
