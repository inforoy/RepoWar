package com.vector.beans;

import java.util.Date;

public class SolicitudDTO {

	private String id;
	private double ingresosPersonales;
	private String empresa;
	private double montoSolicitado;
	private double valorInmueble;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaAceptacion;
	private Date fechaAprobacion;
	private ClienteDTO cliente;
	private EstadoSolicitudDTO estadoSolicitud;
	private PlazoDTO plazo;
	private TasaDTO tasa;
	
	public SolicitudDTO() {
		cliente = new ClienteDTO();
		estadoSolicitud = new EstadoSolicitudDTO();
		plazo = new PlazoDTO();
		tasa = new TasaDTO();
	}
	
	public SolicitudDTO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getIngresosPersonales() {
		return ingresosPersonales;
	}

	public void setIngresosPersonales(double ingresosPersonales) {
		this.ingresosPersonales = ingresosPersonales;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public double getValorInmueble() {
		return valorInmueble;
	}

	public void setValorInmueble(double valorInmueble) {
		this.valorInmueble = valorInmueble;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public EstadoSolicitudDTO getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitudDTO estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public PlazoDTO getPlazo() {
		return plazo;
	}

	public void setPlazo(PlazoDTO plazo) {
		this.plazo = plazo;
	}

	public TasaDTO getTasa() {
		return tasa;
	}

	public void setTasa(TasaDTO tasa) {
		this.tasa = tasa;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", ingresosPersonales=" + ingresosPersonales + ", empresa=" + empresa
				+ ", montoSolicitado=" + montoSolicitado + ", valorInmueble=" + valorInmueble + ",  descripcion="
				+ descripcion + ", fechaCreacion=" + fechaCreacion + ", fechaAceptacion=" + fechaAceptacion
				+ ", fechaAprobacion=" + fechaAprobacion + "]";
	}

}
