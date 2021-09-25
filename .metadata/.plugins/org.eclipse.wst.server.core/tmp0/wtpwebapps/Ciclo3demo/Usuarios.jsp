<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Usuarios"%>
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
<title>Creacion de Usuario</title>
</head>
<body>
	<div class="row">
		<div class="ingresar card col-md-3">
			<div class="card-body">
				<h4 class="card-title" style="color: white;">Usuarios</h4>
				<h6>En este panel podras
					gestionar los datos de los usuarios del sistema</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Usuarios"> 
							<label>Cedula:</label>
							<input type="text" name="txtcedula" class="form-control" 
							value="${usuarioSeleccionado.getCedula_usuario()}">
						</div>
						<div class="form-group">
							<label>Nombre:</label> 
							<input type="text" name="txtnombre" class="form-control" 
							value="${usuarioSeleccionado.getNombre_usuario()}">
						</div>
						<div class="form-group">
							<label>Email:</label> 
							<input type="text" name="txtemail" class="form-control" 
							value="${usuarioSeleccionado.getEmail_usuario()}">
						</div>
						<div class="form-group">
							<label>Usuario:</label> 
							<input type="text" name="txtusuario" class="form-control" 
							value="${usuarioSeleccionado.getUsuario()}">
						</div>
						<div class="form-group">
							<label>Password:</label> 
							<input type="password" name="txtpassword" class="form-control" 
							value="${usuarioSeleccionado.getPassword()}">
						</div>

						<input type="submit" class="btn btn-outline-primary mt-2" name="accion" value="Agregar"> 
						<input type="submit" class="btn btn-outline-success mt-2" name="accion" value="Actualizar">
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
						<th scope="col">Usuario</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<% ArrayList<Usuarios> lista= (ArrayList<Usuarios>) request.getAttribute("lista");
			for (Usuarios usuario:lista){
			%>
					<tr>
						<td><%=usuario.getCedula_usuario()%></td>
						<td><%=usuario.getNombre_usuario()%></td>
						<td><%=usuario.getEmail_usuario()%></td>
						<td><%=usuario.getUsuario()%></td>
						<td><%=usuario.getPassword()%></td>
						<td><a class="btn btn-outline-warning m-2"
							href="Controlador?menu=Usuarios&accion=Cargar&id=<%=usuario.getCedula_usuario()%>">Editar</a>
							<a class="btn btn-outline-danger m-2"
							href="Controlador?menu=Usuarios&accion=Eliminar&id=<%=usuario.getCedula_usuario()%>">Eliminar</a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>
