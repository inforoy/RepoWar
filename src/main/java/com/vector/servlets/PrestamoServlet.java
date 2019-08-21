package com.vector.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vector.beans.ClienteDTO;
import com.vector.beans.LoginModel;
import com.vector.beans.SolicitudDTO;
import com.vector.service.SolicitudService;
import com.vector.service.UsuarioService;

/**
 * Servlet implementation class PrestamoServlet
 */
//@WebServlet("/PrestamoServlet")
@WebServlet(name = "Prestamo", urlPatterns = { "/Prestamo" })
public class PrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String metodo = request.getParameter("metodo");
		System.out.println("entrando al servlet");
		switch(metodo) {
		case "validarusuario":
			validarusuario(request, response);
			break;
		case "listaSolicitud":
			listaSolicitud(request, response);
			break;
		case "aprobarSolicitud":
			aprobarSolicitud(request, response);
			break;
		case "getSolicitud":
			getSolicitud(request, response);
			break;
		}
		
	}
	
	public SolicitudDTO solicitudselect = null;
	
	private void getSolicitud(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String paramidsolicitud = request.getParameter("idsolicitud").trim();
		try {
			
			SolicitudService ss = new SolicitudService();
			solicitudselect = ss.getSolicitud(paramidsolicitud);
			
			request.setAttribute("solicitud", solicitudselect);
			request.getRequestDispatcher("CreditoHipotecario.jsp").forward(request, response);
			
		}catch(Exception e) {
			System.out.println("error en servlet getSolicitud - "+e.getMessage());
		}
	}

	private void aprobarSolicitud(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			
			String paramestado = request.getParameter("estado").trim();
			String paramdescripcion = request.getParameter("descripcion").trim();
			
			int codestado = 0;
			if(paramestado.equals("Aprobar")) {
				codestado = 3;
			} else if(paramestado.equals("Rechazar")) {
				codestado = 5;
			} else {
				codestado = 0;
			}
			
			
			SolicitudService ss = new SolicitudService();
			Boolean ok = ss.aprobarSolicitud(solicitudselect, codestado, paramdescripcion);
			
			if(!ok) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Ha ocurrido un error inesperado en el proceso de actualizacion');");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("CreditoHipotecario.jsp");
				rd.include(request, response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('La actualizacion se ha llevado satisfactoriamente');");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("BandejaSolicitud.jsp");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println("error en servlet aprobarSolicitud - "+e.getMessage());
		}
	}

	private void listaSolicitud(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		String paramnumsolicitud = request.getParameter("numeroSolicitud").trim();
		String paramfechainicial = request.getParameter("fechaInicial").trim();
		String paramfechafinal = request.getParameter("fechaFinal").trim();
		String paramnumdni = request.getParameter("numeroDNI").trim();
		String paramnombre = request.getParameter("nombres").trim();
		String paramapepaterno = request.getParameter("apePaterno").trim();
		String paramapematerno = request.getParameter("apeMaterno").trim();
		
		try {
			Date fechaini = null;
			Date fechafin = null;
			if(!paramfechainicial.isEmpty()) fechaini = objSDF.parse(paramfechainicial);
			if(!paramfechafinal.isEmpty()) fechafin = objSDF.parse(paramfechafinal);
			
			SolicitudDTO solicitud = new SolicitudDTO(paramnumsolicitud);
			ClienteDTO cliente = new ClienteDTO(paramnumdni,paramnombre,paramapepaterno,paramapematerno);
			
			SolicitudService ss = new SolicitudService();
			ArrayList<SolicitudDTO> listasolicitud = ss.listaSolicitud(solicitud, cliente, fechaini, fechafin);
			
			request.setAttribute("listado", listasolicitud);
			request.setAttribute("cliente",  cliente);
			request.setAttribute("solicitud", solicitud);
			request.setAttribute("fechainicio",  paramfechainicial);
			request.setAttribute("fechafinal", paramfechafinal);
			request.getRequestDispatcher("BandejaSolicitud.jsp").forward(request, response);
			
			System.out.println("Lista servelt");
			for (SolicitudDTO soli : listasolicitud) {
				System.out.println(soli);
			}
			
		}catch(Exception e) {
			System.out.println("error en servlet listarSolciitud - "+e.getMessage());
		}
		
	}

	protected void validarusuario(HttpServletRequest request, HttpServletResponse response) {
		String paramuser = request.getParameter("user").trim();
		String parampassword = request.getParameter("password").trim();
		
		LoginModel usuario = new LoginModel();
		usuario.setUsuario(paramuser);
		usuario.setClave(parampassword);
		usuario.setRolDescripcion("rweb");
		
		try {
			
			UsuarioService us = new UsuarioService();
			int result = us.validarUsuario(usuario);
			if(result == 0) {
				response.sendRedirect("BandejaSolicitud.jsp");
			}
			if(result == 1) {
				request.setAttribute("mensaje", "Usuario incorrecto para Web");
				request.getRequestDispatcher("index.jsp").forward(request, response);  
			}
			if(result == 2) {
				request.setAttribute("mensaje", "Credenciales Incorrectas");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}catch(Exception e) {
			System.out.println("Error en el servlet - "+e.getMessage());
		}
		
			
	}

}
