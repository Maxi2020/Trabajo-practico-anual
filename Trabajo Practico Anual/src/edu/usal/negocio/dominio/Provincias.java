package edu.usal.negocio.dominio;

public class Provincias {

	private int idProvincia;
	private String nombreProvincia;
	
public Provincias() {}

public Provincias(int idProvincia, String nombreProvincia) {
	super();
	this.idProvincia = idProvincia;
	this.nombreProvincia = nombreProvincia;
}

public int getIdProvincia() {
	return idProvincia;
}

public void setIdProvincia(int idProvincia) {
	this.idProvincia = idProvincia;
}

public String getNombreProvincia() {
	return nombreProvincia;
}

public void setNombreProvincia(String nombreProvincia) {
	this.nombreProvincia = nombreProvincia;
}

@Override
public String toString() {
	return "Provincias [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + "]";
}

}
