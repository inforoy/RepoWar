package com.vector.service;

import java.util.ArrayList;
import java.util.Date;

import com.vector.beans.ClienteDTO;
import com.vector.beans.SolicitudDTO;
import com.vector.dao.DAOFactory;
import com.vector.interfaces.SolicitudDAO;

public class SolicitudService {
	
	DAOFactory fabrica= DAOFactory.getDAOFactory(DAOFactory.Rest);
	
	SolicitudDAO dao = fabrica.getSolicitudDAO();
	
	public ArrayList<SolicitudDTO> listaSolicitud(SolicitudDTO solicitud, ClienteDTO cliente, Date fechaini, Date fechafin){
		return dao.listaSolicitud(solicitud, cliente, fechaini, fechafin);
	}
	
	public Boolean aprobarSolicitud(SolicitudDTO solicitud, int estado, String descripcion) {
		return dao.aprobarSolicitud(solicitud, estado, descripcion);
	}
	
	public SolicitudDTO getSolicitud(String idsolicitud) {
		return dao.getSolicitud(idsolicitud);
	}

}
