package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Direcciones implements Serializable {
private String calle, altura, ciudad, codigoPostal;
private Paises paises;
private Provincias provincias;
public Direcciones () {}
public Direcciones(String calle, String altura, String ciudad, String codigoPostal, Paises paises,
		Provincias provincias) {
	super();
	this.calle = calle;
	this.altura = altura;
	this.ciudad = ciudad;
	this.codigoPostal = codigoPostal;
	this.paises = paises;
	this.provincias = provincias;
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
public String getCodigoPostal() {
	return codigoPostal;
}
public void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}
public Paises getPaises() {
	return paises;
}
public void setPaises(Paises paises) {
	this.paises = paises;
}
public Provincias getProvincias() {
	return provincias;
}
public void setProvincias(Provincias provincias) {
	this.provincias = provincias;
}
@Override
public String toString() {
	return "[Pais=" + paises.toString() + ", Provincia=" + provincias.toString()+", Codigo Postal= "+codigoPostal+", Ciudad=" + ciudad +", Calle=" + calle + ", Altura=" + altura;
}


}
