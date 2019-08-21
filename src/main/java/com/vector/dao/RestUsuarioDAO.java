package com.vector.dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vector.beans.LoginModel;
import com.vector.interfaces.UsuarioDAO;


public class RestUsuarioDAO implements UsuarioDAO{
	
	private static final String URL_BASE = "http://172.22.1.126:2020/PrestamoHipotecaRest";
	private static Client cliente;
	private static WebTarget webTarget;
	private static Invocation.Builder invocationBuilder;
	private static Response response;

	public int validarUsuario(LoginModel usuario) {
		// TODO Auto-generated method stub
		System.out.println("entrando");
		int result = -1;
		try {
			System.out.println("Entro 1");
			//cliente = ClientBuilder.newClient();
			cliente = ClientBuilder.newClient();
			System.out.println("Paso 1");
			webTarget = cliente.target(URL_BASE).path("/login");
			invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        response = invocationBuilder.post(Entity.entity(usuario, MediaType.APPLICATION_JSON));
	        result = response.readEntity(Integer.class);
		} catch(Exception e) {
			System.out.println("Error RestUsuarioDAO.validarUsuario - "+e.getMessage());
		}
		
		return result;
	}

}
