<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Clientes"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="cssUsuarios.css">
<link rel="icon" href="img/icon.jpg" type="image/x-icon">
<title>Creacion de Cliente</title>
</head>
	<script type="text/javascript">
		function Confirmar_borrar() {
		var respuesta = confirm("¿Estas seguro que deseas eliminar al cliente?");
			if (respuesta == true){
				return true;
			}else{
				return false;
				}
			}
	</script>
<body>
	<div class="row">
		<div class="ingresar card col-md-3">
			<div class="card-body">
				<h4 class="card-title" style="color: white;">Clientes</h4>
				<h6>En este panel podras
					gestionar los datos de los clientes del sistema</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Clientes"> 
							<label>Cedula:</label>
							<input type="number" name="txtcedula" class="form-control" 
							value="${clienteSeleccionado.getCedula_cliente()}" required="required">
						</div>
						<div class="form-group">
							<label>Nombre:</label> 
							<input type="text" name="txtnombre" class="form-control" 
							value="${clienteSeleccionado.getNombre_cliente()}" required="required">
						</div>
						<div class="form-group">
							<label>Email:</label> 
							<input type="email" name="txtemail" class="form-control" 
							value="${clienteSeleccionado.getEmail_cliente()}" required="required">
						</div>
						<div class="form-group">
							<label>Dirección:</label> 
							<input type="text" name="txtdireccion" class="form-control" 
							value="${clienteSeleccionado.getDireccion_cliente()}" required="required">
						</div>
						<div class="form-group">
							<label>Teléfono:</label> 
							<input type="number" name="txttelefono" class="form-control" 
							value="${clienteSeleccionado.getTelefono_cliente()}" required="required">
						</div>

						<input type="submit" class="btn btn-primary mt-2" name="accion" value="Agregar"> 
						<input type="submit" class="btn btn-success mt-2" name="accion" value="Actualizar">
					</form>
				</div>
			</div>
		</div>
		<div class="lista col-md-9">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Cedula</th>
						<th scope="col">Nombre</th>
						<th scope="col">Email</th>
						<th scope="col">Dirección</th>
						<th scope="col">Teléfono</th>
					</tr>
				</thead>
				<tbody>
					<% ArrayList<Clientes> lista= (ArrayList<Clientes>) request.getAttribute("lista");
			for (Clientes cliente:lista){
			%>
					<tr>
						<td><%=cliente.getCedula_cliente()%></td>
						<td><%=cliente.getNombre_cliente()%></td>
						<td><%=cliente.getEmail_cliente()%></td>
						<td><%=cliente.getDireccion_cliente()%></td>
						<td><%=cliente.getTelefono_cliente()%></td>
						<td><a class="btn btn-warning m-2"
							href="Controlador?menu=Clientes&accion=Cargar&id=<%=cliente.getCedula_cliente()%>">Editar</a>
							<a class="btn btn-danger m-2"
							href="Controlador?menu=Clientes&accion=Eliminar&id=<%=cliente.getCedula_cliente()%>" onclick="return Confirmar_borrar()">Eliminar </a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>