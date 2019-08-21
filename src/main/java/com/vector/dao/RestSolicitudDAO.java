package com.vector.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vector.beans.ClienteDTO;
import com.vector.beans.SolicitudDTO;
import com.vector.interfaces.SolicitudDAO;


public class RestSolicitudDAO implements SolicitudDAO{
	
	private static final String URL_BASE = "http://172.22.1.126:2020/PrestamoHipotecaRest";
	//private static final String URL_BASE = "http://172.22.1.84:8080/PrestamoHipotecaRest";
	private static Client client;
	private static WebTarget webTarget;
	private static Invocation.Builder invocationBuilder;
	private static Response response;
	
	
	//set time zone to default

	@Override
	public ArrayList<SolicitudDTO> listaSolicitud(SolicitudDTO solicitud, ClienteDTO cliente, Date fechaini, Date fechafin) {
		// TODO Auto-generated method stub
		
		List<SolicitudDTO> listSolicitud = null;
		ArrayList<SolicitudDTO> listaSolicitud = new ArrayList<SolicitudDTO>();
		
		try {
			client = ClientBuilder.newClient();
			webTarget = client.target(URL_BASE).path("/solicitud");
			listSolicitud = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<SolicitudDTO>>(){});
			listaSolicitud = (ArrayList<SolicitudDTO>) listSolicitud;
		
		} catch(Exception e) {
			System.out.println("Error al obtener array usuarios - " +e.getMessage());
		}
		
		Iterator<SolicitudDTO> filtrariterator = listaSolicitud.iterator();
		while(filtrariterator.hasNext()) {
			SolicitudDTO elemento = filtrariterator.next();
			if(elemento.getEstadoSolicitud().getId() != 2) {
				filtrariterator.remove();
			}
		}
		
		listaSolicitud = filtrarListaSolicitud(listaSolicitud, solicitud, cliente, fechaini, fechafin);
		
		return listaSolicitud;
	}

	public ArrayList<SolicitudDTO> filtrarListaSolicitud(ArrayList<SolicitudDTO> listasolicitud, SolicitudDTO solicitud, ClienteDTO cliente, Date fechaini, Date fechafin) {
		// TODO Auto-generated method stub
		
		ArrayList<SolicitudDTO> listafiltrada = null;
		Date fechainicial = new Date(0);
		Date fechafinal = new Date();
		
		if(fechaini != null) fechainicial = fechaini;
		if(fechafin != null) fechafinal = fechafin;
				
		try {
			
			listafiltrada = new ArrayList<SolicitudDTO>();
			Iterator<SolicitudDTO> filtrariterator = listasolicitud.iterator();
			while(filtrariterator.hasNext()) {
				SolicitudDTO elemento = filtrariterator.next();
				
				if((
						elemento.getFechaAceptacion().equals(fechainicial) || elemento.getFechaAceptacion().after(fechainicial)) && 
						(elemento.getFechaAceptacion().equals(fechafinal) || elemento.getFechaAceptacion().before(fechafinal))
						
						) {
					
					if(
							solicitud.getId().isEmpty() &&
							cliente.getDni().isEmpty() &&
							cliente.getNombre().isEmpty() &&
							cliente.getApPaterno().isEmpty() &&
							cliente.getApMaterno().isEmpty()
							) {
						listafiltrada.add(elemento); continue;
					}
					
					if(elemento.getId().equals(solicitud.getId()) && !solicitud.getId().isEmpty()) {
						listafiltrada.add(elemento); continue;
					}
					if(elemento.getCliente().getDni().equals(cliente.getDni()) && !cliente.getDni().isEmpty()) {
						listafiltrada.add(elemento); continue;
					}
					if(elemento.getCliente().getNombre().contains(cliente.getNombre()) && !cliente.getNombre().isEmpty()) {
						listafiltrada.add(elemento); continue;
					}
					if(elemento.getCliente().getApPaterno().contains(cliente.getApPaterno()) && !cliente.getApPaterno().isEmpty()) {
						listafiltrada.add(elemento); continue;
					}
					if(elemento.getCliente().getApMaterno().contains(cliente.getApMaterno()) && !cliente.getApMaterno().isEmpty()) {
						listafiltrada.add(elemento); continue;
					}
										
				}
			}
			
		} catch(Exception e) {
			System.out.println("Error al filtrar la tabla - "+e.getMessage());
		}
		return listafiltrada;
	}

	@Override
	public Boolean aprobarSolicitud(SolicitudDTO solicitud, int estado, String descripcion) {
		// TODO Auto-generated method stub 
		boolean ok = false;
		
		try {
			if(estado==3) solicitud.setFechaAprobacion(new Date());
			solicitud.getEstadoSolicitud().setId(estado);
			if(!descripcion.isEmpty()) solicitud.setDescripcion(descripcion);
			invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			response = invocationBuilder.put(Entity.entity(solicitud, MediaType.APPLICATION_JSON));
			ok = response.readEntity(Boolean.class);
		}catch(Exception e) {
			System.out.println("error al aprobarSolicitud - " + e.getMessage());
		}
		return ok;
	}

	@Override
	public SolicitudDTO getSolicitud(String idsolicitud) {
		// TODO Auto-generated method stub
		
		SolicitudDTO solicitud = new SolicitudDTO();
		
		try {
			
			client = ClientBuilder.newClient();
			webTarget = client.target(URL_BASE).path("/solicitud");
			solicitud = webTarget.path("/numero").path("/"+idsolicitud).request(MediaType.APPLICATION_JSON).get(SolicitudDTO.class);
			
		} catch(Exception e) {
			System.out.println("error en getSolicitud - " + e.getMessage());
		}
		return solicitud;
	}
	
	
}
