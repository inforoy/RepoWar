package com.vector.beans;

public class UsuarioDTO {
	
	private String t002_username;
	private String t002_password;
	private int t002_id_rol;
	private RolDTO rol;
	
	public UsuarioDTO() {
		
	}
	
	// get and set
	public String getT002_username() {
		return t002_username;
	}
	public void setT002_username(String t002_username) {
		this.t002_username = t002_username;
	}
	public String getT002_password() {
		return t002_password;
	}
	public void setT002_password(String t002_password) {
		this.t002_password = t002_password;
	}
	public int getT002_id_rol() {
		return t002_id_rol;
	}
	public void setT002_id_rol(int t002_id_rol) {
		this.t002_id_rol = t002_id_rol;
	}
	public RolDTO getRol() {
		return rol;
	}
	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
	
}
