package edu.usal.negocio.dominio;

public class Aerolineas {

	private int idAerolinea;
	private String nombreAerolinea, alianza;

public Aerolineas() {}

public Aerolineas(int idAerolinea, String nombreAerolinea, String alianza) {
	super();
	this.idAerolinea = idAerolinea;
	this.nombreAerolinea = nombreAerolinea;
	this.alianza = alianza;
}

public int getIdAerolinea() {
	return idAerolinea;
}

public void setIdAerolinea(int idAerolinea) {
	this.idAerolinea = idAerolinea;
}

public String getNombreAerolinea() {
	return nombreAerolinea;
}

public void setNombreAerolinea(String nombreAerolinea) {
	this.nombreAerolinea = nombreAerolinea;
}

public String getAlianza() {
	return alianza;
}

public void setAlianza(String alianza) {
	this.alianza = alianza;
}

@Override
public String toString() {
	return "Aerolineas [idAerolinea=" + idAerolinea + ", nombreAerolinea=" + nombreAerolinea + ", alianza=" + alianza
			+ "]";
}

}
