package edu.usal.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ventas {
//todas las listas son objetos
	private List<Clientes> clientes = new ArrayList();
	private List<Vuelos> vuelos = new ArrayList();
	private List<ListaAerolinea> aerolinea  = new ArrayList();
	private LocalDateTime fecha_hora_de_venta;
	private String Forma_de_pago;

	public Ventas() {}
	
	public Ventas(List<Clientes> clientes, List<Vuelos> vuelos, List<ListaAerolinea> aerolinea,
			LocalDateTime fecha_hora_de_venta, String forma_de_pago) {
		super();
		this.clientes = clientes;
		this.vuelos = vuelos;
		this.aerolinea = aerolinea;
		this.fecha_hora_de_venta = fecha_hora_de_venta;
		this.Forma_de_pago = forma_de_pago;
	}

	public List<Vuelos> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelos> vuelos) {
		this.vuelos = vuelos;
	}

	public List<ListaAerolinea> getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(List<ListaAerolinea> aerolinea) {
		this.aerolinea = aerolinea;
	}

	public LocalDateTime getFecha_hora_de_venta() {
		return fecha_hora_de_venta;
	}

	public void setFecha_hora_de_venta(LocalDateTime fecha_hora_de_venta) {
		this.fecha_hora_de_venta = fecha_hora_de_venta;
	}

	public String getForma_de_pago() {
		return Forma_de_pago;
	}

	public void setForma_de_pago(String forma_de_pago) {
		this.Forma_de_pago = forma_de_pago;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	
	
	
	
	
	
	
	
}
