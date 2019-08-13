package edu.usal.negocio.dominio;

import java.time.LocalDateTime;




public class Ventas {

	private Clientes cliente = new Clientes();
	private Vuelos vuelo = new Vuelos();
	private Aerolineas aereoliniea = new Aerolineas();
	private LocalDateTime fecha_hora_de_venta;
	private String Forma_de_pago;
	private int IdVentas;
	
	public Ventas() {}

	public Ventas(Clientes cliente, Vuelos vuelo, Aerolineas aereoliniea, LocalDateTime fecha_hora_de_venta,
			String forma_de_pago, int IdVentas) {
		super();
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aereoliniea = aereoliniea;
		this.fecha_hora_de_venta = fecha_hora_de_venta;
		this.Forma_de_pago = forma_de_pago;
		this.IdVentas = IdVentas;
	}
    
	public int getIdVentas() {
		return IdVentas;
	}

	public void setIdVentas(int idVentas) {
		IdVentas = idVentas;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Vuelos getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelos vuelo) {
		this.vuelo = vuelo;
	}

	public Aerolineas getAereoliniea() {
		return aereoliniea;
	}

	public void setAereoliniea(Aerolineas aereoliniea) {
		this.aereoliniea = aereoliniea;
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
		Forma_de_pago = forma_de_pago;
	}

	@Override
	public String toString() {
		return "Ventas [cliente=" + cliente + ", vuelo=" + vuelo + ", aereoliniea=" + aereoliniea
				+ ", fecha_hora_de_venta=" + fecha_hora_de_venta + ", Forma_de_pago=" + Forma_de_pago + ", IdVentas="
				+ IdVentas + "]";
	}

	
}