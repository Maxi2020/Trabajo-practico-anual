package edu.usal.view.console;

import edu.usal.util.IOGeneral;

public class MenuVistaPrincipal {
public MenuVistaPrincipal() {
	
}
public int ImprimirMenu() {
	return IOGeneral.leerInt("<<<MENU PRINCIPAL>>>\nIngrese Opcion \n1-Menu De Clientes\n0-salir", "Lo ingresado no fue un numero entero");
}
public void OpcionFail() {
	IOGeneral.pritln("Lo Ingresado No Fue Una Opcion Valida");
}
}
