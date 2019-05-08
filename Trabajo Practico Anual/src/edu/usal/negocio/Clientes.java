package edu.usal.negocio;

import java.time.LocalDate;

public abstract class Clientes {
private String nombre, apellido, dni, cuit, correo;
private LocalDate fechaNacimiento;
public Clientes () {}
public Clientes(String nombre, String apellido, String dni, String cuit, String correo, LocalDate fechaNacimiento) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.cuit = cuit;
	this.correo = correo;
	this.fechaNacimiento = fechaNacimiento;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getCuit() {
	return cuit;
}
public void setCuit(String cuit) {
	this.cuit = cuit;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}


}
