<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import= "com.vector.beans.SolicitudDTO" %>
 <%@ page import= "com.vector.beans.ClienteDTO" %>
 <%@ page import= "java.util.ArrayList" %> 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bandeja Solicitud</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .col-12{
            box-sizing: border-box;
            border-radius: 15px;
            margin-top: 5px;
            margin-bottom: 5px;
            box-shadow: 6px 6px 11px -4px rgba(130,113,130,1);
        }
        .titulo{
            text-align: center;
            color: white;
            background: #007bff;
            background: linear-gradient(to right, #0062E6, #33AEFF);
        }
    </style>
</head>
<body style="background-color: rgb(240,240,240)">
	<%
		SolicitudDTO sol = null;
		ClienteDTO c = null;
		String id = "";
		String dni = "";
		String nombre = "";
		String apat = "";
		String amat = "";
		String fi = "";
		String ff = "";
		try{
		sol = (SolicitudDTO) request.getAttribute("solicitud");
		c = (ClienteDTO) request.getAttribute("cliente");
		id = sol.getId();
		dni = c.getDni();
		nombre = c.getNombre();
		apat = c.getApPaterno();
		amat = c.getApMaterno();
		fi = (String) request.getAttribute("fechainicio");
		out.print(fi);
		ff = (String) request.getAttribute("fechafinal");
		} catch(Exception e){
			out.print(e.getMessage());
		}
	%>
	<div class="container">
         <div class="row">
            <div class="col-12 titulo" style="background-color: rgb(255,255,255)">
                <p class="h4">Busqueda de Solicitud</p>
            </div>
            <div class="col-12">
                <form action="Prestamo" method="post" class="row">
                <input type="hidden" name="metodo" value="listaSolicitud">
                    <div class="col-6" style="background-color: rgb(255, 255, 255);">
                        <p class="h5">Solicitud</p>
                            <div class="form-group row">
                                <label for="colFormLabelNumero" class="col-sm-3 col-form-label col-form-label-sm">Numero</label>
                                <div class="col-sm-9">
                                    <input type="text" name="numeroSolicitud" class="form-control form-control-sm" id="colFormLabelNumero" placeholder="Ingresar numero de solicitud" value="<% out.write(id);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelFinicial" class="col-sm-3 col-form-label col-form-label-sm">Fecha Inicial</label>
                                <div class="col-sm-9">
                                    <input type="date" name="fechaInicial"class="form-control form-control-sm" id="colFormLabelFinicial" placeholder="yyyy-mm-dd" value="<% out.write(fi);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelFfinal" class="col-sm-3 col-form-label col-form-label-sm">Fecha Final</label>
                                <div class="col-sm-9">
                                    <input type="date" name="fechaFinal" class="form-control form-control-sm" id="colFormLabelFfinal" placeholder="yyyy-mm-dd" value="<%out.write(ff);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormSelectEstado" class="col-sm-3 col-form-label col-form-label-sm">Estado</label>
                                <div class="col-sm-9">
                                    <select id="colFormSelectEstado" class="form-control form-control-sm" disabled>
                                        <option selected>Aceptadas</option>
                                    </select>
                                </div>
                            </div>
                    </div>
                    <div class="col-6" style="background-color: rgb(255, 255, 255);">
                        <p class="h5">Cliente</p>
                        
                            <div class="form-group row">
                                <label for="colFormLabelDni" class="col-sm-3 col-form-label col-form-label-sm">DNI</label>
                                <div class="col-sm-9">
                                    <input type="text" name="numeroDNI" class="form-control form-control-sm" id="colFormLabelDni" placeholder="Ingresar numero de DNI" value="<%out.write(dni);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelNombres" class="col-sm-3 col-form-label col-form-label-sm">Nombres</label>
                                <div class="col-sm-9">
                                    <input type="text" name="nombres" class="form-control form-control-sm" id="colFormLabelNombres" placeholder="Ingresar nombres" value="<%out.write(nombre);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelApaterno" class="col-sm-3 col-form-label col-form-label-sm">A. Paterno</label>
                                <div class="col-sm-9">
                                    <input type="text" name="apePaterno" class="form-control form-control-sm" id="colFormLabelApaterno" placeholder="Ingresar Apellidos Paternos" value="<%out.write(apat);%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelAmaterno" class="col-sm-3 col-form-label col-form-label-sm">A. Materno</label>
                                <div class="col-sm-9">
                                    <input type="text" name="apeMaterno" class="form-control form-control-sm" id="colFormLabelAmaterno" placeholder="Ingresar Apellidos Maternos" value="<%out.write(amat);%>">
                                </div>
                            </div>
                    </div>
                    <div class="col-4" style="background-color: rgb(255, 255, 255);"></div>
                    <div class="col-4" style="padding-bottom: 10px; background-color: rgb(255,255,255);">
                        <button type="submit" class="btn btn-outline-secondary btn-block ">Buscar</button>
                    </div>
                    <div class="col-4" style="background-color: rgb(255, 255, 255);"></div>
                </form>
            </div> 
            <div class="col-12" style="background-color: rgb(255, 255, 255);">
                <table class="table table-hover table-sm" style="font-size: .875rem;">
                    <thead>
                        <tr>
                            <th scope="col">Orden</th>
                            <th scope="col">Nro. Solicitud</th>
                            <th scope="col">DNI</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Ver</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	ArrayList<SolicitudDTO> lista = (ArrayList<SolicitudDTO>) request.getAttribute("listado");
                    	int orden = 0;
                    	if(lista==null){
                    		%>
                    		
                    		<%
                    	}
                    	else if(!lista.isEmpty()){
                    		for(SolicitudDTO s : lista){
                    			orden++;
                    %>
                    
                        <tr>
                            <td><%=orden %></td>
                            <td><%=s.getId() %></td>
                            <td><%=s.getCliente().getDni() %></td>
                            <td><%=s.getCliente().getNombre()+" "+s.getCliente().getApPaterno()+" "+s.getCliente().getApMaterno() %></td>
                            <td><%=s.getEstadoSolicitud().getDescripcion() %></td>
                            <td><a href="Prestamo?metodo=getSolicitud&idsolicitud=<%=s.getId() %>">Detalles</a></td>
                        </tr>
                 	<%
                    		}
                    	} else {
                  	%>
                  	<tr>
                        <td colspan="6">
                  		<div class="alert alert-dark" role="alert">
						  No hay resultados que coincidan
						</div>
						</td>
					</tr>
					<%
                	}
				%>
                    </tbody>
                </table>               
				
            </div>
        </div>        
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>