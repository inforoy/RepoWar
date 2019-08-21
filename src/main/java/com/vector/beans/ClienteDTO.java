package com.vector.beans;

public class ClienteDTO {
	private String dni;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String direccion;
	private String correo;
	private String telefono;
	private String nacionalidad;
	private EstadoCivilDTO estadoCivil;
	private SexoDTO sexo;
	
	public ClienteDTO() {
		estadoCivil = new EstadoCivilDTO();
		sexo = new SexoDTO();
	}
	public ClienteDTO(String dni, String nombre, String apPaterno, String apMaterno) {
		this.dni = dni;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public EstadoCivilDTO getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public SexoDTO getSexo() {
		return sexo;
	}
	public void setSexo(SexoDTO sexo) {
		this.sexo = sexo;
	}
	
	
}
