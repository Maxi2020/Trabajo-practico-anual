package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Direcciones implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String calle, altura, ciudad, codigoPostal;
private Paises pais;
private Provincias provincia;
private int idPais, idProvincia, idDireccion, idCliente;

public Direcciones () {}

public Direcciones(String calle, String altura, String ciudad, String codigoPostal, Paises pais, Provincias provincia,
		int idPais, int idProvincia, int idDireccion, int idCliente) {
	super();
	this.calle = calle;
	this.altura = altura;
	this.ciudad = ciudad;
	this.codigoPostal = codigoPostal;
	this.pais = pais;
	this.provincia = provincia;
	this.idPais = idPais;
	this.idProvincia = idProvincia;
	this.idDireccion = idDireccion;
	this.idCliente = idCliente;
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

public Paises getPais() {
	return pais;
}

public void setPais(Paises pais) {
	this.pais = pais;
}

public Provincias getProvincia() {
	return provincia;
}

public void setProvincia(Provincias provincia) {
	this.provincia = provincia;
}

public int getIdPais() {
	return idPais;
}

public void setIdPais(int idPais) {
	this.idPais = idPais;
}

public int getIdProvincia() {
	return idProvincia;
}

public void setIdProvincia(int idProvincia) {
	this.idProvincia = idProvincia;
}

public int getIdDireccion() {
	return idDireccion;
}

public void setIdDireccion(int idDireccion) {
	this.idDireccion = idDireccion;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

@Override
public String toString() {
	return "Direcciones [calle=" + calle + ", altura=" + altura + ", ciudad=" + ciudad + ", codigoPostal="
			+ codigoPostal + ", pais=" + pais.toString() + ", provincia=" + provincia.toString() + ", idPais=" + idPais + ", idProvincia="
			+ idProvincia + ", idDireccion=" + idDireccion + ", idCliente=" + idCliente + "]";
}

}
