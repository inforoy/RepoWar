package com.vector.dao;

import com.vector.interfaces.SolicitudDAO;
import com.vector.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	
	public static final int Rest = 1;
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract SolicitudDAO getSolicitudDAO();
	
	public static DAOFactory getDAOFactory (int qFactory) {
		switch(qFactory) {
		case Rest:
			return new RestDAOFactory();
		default:
			return null;
		}
	}

}
