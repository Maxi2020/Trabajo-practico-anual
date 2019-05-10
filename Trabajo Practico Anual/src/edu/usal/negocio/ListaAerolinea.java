package edu.usal.negocio;

public class ListaAerolinea {
private String Aerolinea;
//agregar el id en todos los objetos
public ListaAerolinea() {}

public ListaAerolinea(String aerolinea) {
	super();
	Aerolinea = aerolinea;
}

public String getAerolinea() {
	return Aerolinea;
}

public void setAerolinea(String aerolinea) {
	Aerolinea = aerolinea;
}

}
