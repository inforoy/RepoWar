package com.vector.service;

import com.vector.beans.LoginModel;
import com.vector.dao.DAOFactory;
import com.vector.interfaces.UsuarioDAO;

public class UsuarioService {
	
	DAOFactory fabrica= DAOFactory.getDAOFactory(DAOFactory.Rest);
	
	UsuarioDAO dao =  fabrica.getUsuarioDAO();
	
	public int validarUsuario(LoginModel usuario) {
		return dao.validarUsuario(usuario);
	}

}
