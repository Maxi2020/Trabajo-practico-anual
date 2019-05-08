package edu.usal.negocio;

import java.time.LocalDate;

public class Direcciones extends Clientes{
private String calle, altura, ciudad, provincia, pais, codigoPostal;
public Direcciones () {}

public Direcciones(String calle, String altura, String ciudad, String provincia, String pais, String codigoPostal) {
	super();
	this.calle = calle;
	this.altura = altura;
	this.ciudad = ciudad;
	this.provincia = provincia;
	this.pais = pais;
	this.codigoPostal = codigoPostal;
}

public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}
public String getAltura() {
	return altura;
}
public void setAltura(String altura) {
	this.altura = altura;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public String getCodigoPostal() {
	return codigoPostal;
}
public void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}

}
