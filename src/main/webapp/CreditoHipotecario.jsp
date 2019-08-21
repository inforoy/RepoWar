<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "com.vector.beans.SolicitudDTO" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Credito Hipotecario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .titulo{
            text-align: center;
            color: white;
            background: #007bff;
            background: linear-gradient(to right, #0062E6, #33AEFF);
        }
        .row{
            box-sizing: border-box;
            border-radius: 15px;
            margin-top: 8px;
            margin-bottom: 8px;
        }
    </style>
</head>
<body style="background-color: rgb(240,240,240)">
	<div class="container">
        <div class="row titulo" style="background-color: rgb(255,255,255);box-shadow: 6px 6px 11px -4px rgba(130,113,130,1);">
            <div class="col-12">
                <p class="h4">Credito Hipoticario</p>
            </div>
        </div>
        <% SolicitudDTO s = (SolicitudDTO) request.getAttribute("solicitud"); %>
        
        <div class="row" style="background-color: rgb(255,255,255);box-shadow: 6px 6px 11px -4px rgba(130,113,130,1);">
            <div class="col-12">
                <p class="h5">Datos del Cliente</p>
            </div>
            <div class="col-9">
                <div class="form-group row">
                    <label for="colFormLabelDNI" class="col-sm-2 col-form-label col-form-label-sm">DNI</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelDNI" value="<%=s.getCliente().getDni() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-9">
                <div class="form-group row">
                    <label for="colFormLabelNombre" class="col-sm-2 col-form-label col-form-label-sm">Nombres</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelNombre" value="<%=s.getCliente().getNombre() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelSexo" class="col-sm-3 col-form-label col-form-label-sm">Sexo</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelSexo" value="<%=s.getCliente().getSexo().getDescripcion() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelTelefono" class="col-sm-3 col-form-label col-form-label-sm">Telefono</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelTelefono" value="<%=s.getCliente().getTelefono() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelECivil" class="col-sm-3 col-form-label col-form-label-sm">Estado Civil</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelECivil" value="<%=s.getCliente().getEstadoCivil().getDescripcion() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelCorreo" class="col-sm-3 col-form-label col-form-label-sm">Correo</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelCorreo" value="<%=s.getCliente().getCorreo() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-9">
                <div class="form-group row">
                    <label for="colFormLabelDireccion" class="col-sm-2 col-form-label col-form-label-sm">Direccion</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelDireccion" value="<%=s.getCliente().getDireccion() %>" readonly>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="background-color: rgb(255,255,255);box-shadow: 6px 6px 11px -4px rgba(130,113,130,1);">
            <div class="col-12">
                <p class="h5">Datos de la Solicitud</p>
            </div>
			<div class="col-12">
                <div class="form-group row">
                	<label for="colFormLabelIngreso" class="col-sm-2 col-form-label col-form-label-sm">Numero de Solicitud</label>
                	<div class="col-sm-10">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelIngreso" value="<%=s.getId() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelIngreso" class="col-sm-4 col-form-label col-form-label-sm">Ingreso personal</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelIngreso" value="<%=s.getIngresosPersonales() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelEmpresa" class="col-sm-3 col-form-label col-form-label-sm">Empresa</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelEmpresa" value="<%=s.getEmpresa() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelMonto" class="col-sm-4 col-form-label col-form-label-sm">Monto Solicitado</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelMonto" value="<%=s.getMontoSolicitado() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelPlazo" class="col-sm-3 col-form-label col-form-label-sm">Plazo</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelPlazo" value="<%=s.getPlazo().getId() %>" readonly>
                    </div>
                    <label class="col-sm-2 col-form-label col-form-label-sm">Meses</label>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelInmueble" class="col-sm-4 col-form-label col-form-label-sm">Valor del Inmueble</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelInmueble" value="<%=s.getValorInmueble() %>" readonly>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="colFormLabelTasa" class="col-sm-3 col-form-label col-form-label-sm">Tasa (tea)</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control form-control-sm" id="colFormLabelTasa" value="<%=s.getTasa().getDescripcion() %>" readonly>
                    </div>
                </div>
            </div>
        </div>
        <form action="Prestamo" method="post" id="formaprobar" class="row" style="background-color: rgb(255,255,255);box-shadow: 6px 6px 11px -4px rgba(130,113,130,1);">
            <input type="hidden" name="metodo" value="aprobarSolicitud">
            <div class="col-12">
                <p class="h5">Aprobar / Rechazar</p>
            </div>
            <div class="col-12">
                <div class="form-group row">
                    <label for="colFormSelectSm" class="col-sm-2 col-form-label col-form-label-sm">Estado de la Solicitud</label>
                    <div class="col-sm-5    ">
                        <select name="estado" id="colFormSelectSm" class="form-control form-control-sm">
                            <option selected>- Seleccione -</option>
                            <option>Aprobar</option>
                            <option>Rechazar</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-12">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Descripcion de la aprobacion y/o rechazo</label>
                    <textarea name="descripcion" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
            </div>
            <div class="col-7"></div>
            <div class="col-5" style="padding-bottom: 10px;">
                    <button type="button" class="btn btn-outline-primary btn-block " onClick="validar()">Guardar</button>
            </div>
        </form>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
	function validar(){
		var index = document.getElementById("colFormSelectSm").selectedIndex;
		if(index == 0){
			alert("Elegir el estado de la solicitud");
		} else{
			document.forms["formaprobar"].submit()
		}
		
	}
</script>
</html>