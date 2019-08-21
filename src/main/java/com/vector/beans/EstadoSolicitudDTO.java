package com.vector.beans;

public class EstadoSolicitudDTO {
	private int id;
	private String descripcion;
	
	public EstadoSolicitudDTO() {
		
	}
	public EstadoSolicitudDTO(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "EstadoSolicitud [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
