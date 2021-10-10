<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Proveedores"%>
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
<title>Creacion de Proveedor</title>
</head>
<body>
	<div class="row">
		<div class="ingresar card col-md-4">
			<div class="card-body">
				<h4 class="card-title" style="color: white;">Proveedores</h4>
				<h6>En este panel podras
					gestionar los datos de los proveedores del sistema</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Proveedores"> 
							<label>NIT:</label>
							<input type="text" name="txtnit" class="form-control" value="${proveedorSeleccionado.getNitproveedor()}">
						</div>
						<div class="form-group">
							<label>Ciudad:</label> 
							<input type="text" name="txtciudad" class="form-control" value="${proveedorSeleccionado.getCiudad_proveedor()}">
						</div>
						<div class="form-group">
							<label>Dirección:</label> 
							<input type="text" name="txtdireccion" class="form-control" value="${proveedorSeleccionado.getDireccion_proveedor()}">
						</div>
						<div class="form-group">
							<label>Nombre:</label> 
							<input type="text" name="txtnombre" class="form-control" value="${proveedorSeleccionado.getNombre_proveedor()}">
						</div>
						<div class="form-group">
							<label>Telefono:</label> 
							<input type="text" name="txttelefono" class="form-control" value="${proveedorSeleccionado.getTelefono_proveedor()}">
						</div>

						<input type="submit" class="btn btn-primary mt-2" style="backgraund-color: #0d6efd" name="accion" value="Agregar"> 
						<input type="submit" class="btn btn-success mt-2" style="backgraund-color: #198754" name="accion" value="Actualizar">
					</form>
				</div>
			</div>
		</div>
		<div class="lista col-md-8">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">NIT</th>
						<th scope="col">Ciudad</th>
						<th scope="col">Dirección</th>
						<th scope="col">Nombre</th>
						<th scope="col">Telefono</th>
					</tr>
				</thead>
				<tbody>
					<% ArrayList<Proveedores> lista= (ArrayList<Proveedores>) request.getAttribute("lista");
			for (Proveedores proveedor:lista){
			%>
					<tr>
						<td><%=proveedor.getNitproveedor()%></td>
						<td><%=proveedor.getCiudad_proveedor()%></td>
						<td><%=proveedor.getDireccion_proveedor()%></td>
						<td><%=proveedor.getNombre_proveedor()%></td>
						<td><%=proveedor.getTelefono_proveedor()%></td>
						<td><a class="btn btn-warning m-2"
							href="Controlador?menu=Proveedores&accion=Cargar&id=<%=proveedor.getNitproveedor()%>">Editar</a>
							<a class="btn btn-danger m-2"
							href="Controlador?menu=Proveedores&accion=Eliminar&id=<%=proveedor.getNitproveedor()%>">Eliminar</a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>
