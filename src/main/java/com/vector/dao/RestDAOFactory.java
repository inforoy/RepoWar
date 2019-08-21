package com.vector.dao;

import com.vector.interfaces.SolicitudDAO;
import com.vector.interfaces.UsuarioDAO;

public class RestDAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new RestUsuarioDAO();
	}

	@Override
	public SolicitudDAO getSolicitudDAO() {
		// TODO Auto-generated method stub
		return new RestSolicitudDAO();
	}

}
