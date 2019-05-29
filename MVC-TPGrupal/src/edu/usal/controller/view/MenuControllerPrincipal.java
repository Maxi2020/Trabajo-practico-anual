package edu.usal.controller.view;

import edu.usal.view.console.MenuVistaPrincipal;


public class MenuControllerPrincipal {
MenuVistaPrincipal vistaPrincipal;
public MenuControllerPrincipal() {
	this.vistaPrincipal= new MenuVistaPrincipal();
	menu();
}
private void menu() {
	int res = -1;
	while(res!=0){
		res= vistaPrincipal.ImprimirMenu();
		switch(res){
			case 1:	MenuControllerCliente cliente = new MenuControllerCliente();
					break;
			case 2:
					break;
			case 3:
					break;
			case 4: 
					break;
			case 0:	System.exit(0);
			default: System.out.println("Opcion Ingresada Incorrecta");
		}
	}		
}

}
