package com.vector.interfaces;

import java.util.ArrayList;
import java.util.Date;

import com.vector.beans.ClienteDTO;
import com.vector.beans.SolicitudDTO;


public interface SolicitudDAO {
	
	public ArrayList<SolicitudDTO> listaSolicitud(SolicitudDTO solicitud, ClienteDTO cliente, Date fechaini, Date fechafin);
	
	public Boolean aprobarSolicitud(SolicitudDTO solicitud, int estado, String descripcion);
	
	public SolicitudDTO getSolicitud(String idsolicitud);

}
