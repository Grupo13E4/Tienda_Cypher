<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Productos"%>
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
<title>Productos</title>
</head>
<body>
	<div class="row">
		<div class="ingresar card col-md-3">
			<div class="card-body">
				<h4 class="card-title" style="color: white;">Productos</h4>
				<h6>En este panel podras
					gestionar los datos de los Productos del sistema</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Productos"> 
							<label>codigo de producto:</label>
							<input type="text"placeholder="Ej. 4351621" name="txtcodigoproducto" class="form-control" 
							value="${productoSeleccionado.getCodigo_producto()}">
						</div>
						<div class="form-group">
							<label>iva compra:</label> 
							<input type="text" placeholder="Ej. 25%"name="txtivacompra" class="form-control" 
							value="${productoSeleccionado.getIvacompra()}">
						</div>
						<div class="form-grfoup">
							<label>nitproveedor:</label> 
							<input type="text" placeholder="Ej. 1007673123"name="txtnitproveedor" class="form-control" 
							value="${productoSeleccionado.getNitproveedor()}">
						</div>
						<div class="form-group">
							<label>nombre del producto:</label> 
							<input type="text" placeholder="Ej. empanadas"name="txtnombreproducto" class="form-control" 
							value="${productoSeleccionado.getNombre_producto()}">
						</div>
						<div class="form-group">
							<label>precio de compra</label> 
							<input type="text"placeholder="Ej. 1000" name="txtpreciocompra" class="form-control" 
							value="${productoSeleccionado.getPrecio_compra()}">
						</div>
						<div class="form-group">
							<label>precio de venta</label> 
							<input type="text" placeholder="Ej. 1500"name="txtprecioventa" class="form-control" 
							value="${productoSeleccionado.getPrecio_venta()}">
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
						<th scope="col">Codigo de producto</th>
						<th scope="col">Iva compra</th>
						<th scope="col">Nitproveedor</th>
						<th scope="col">Nombre del producto</th>
						<th scope="col">Precio de compra</th>
						<th scope="col">Precio de venta</th>
					</tr>
				</thead>
				<tbody>
					<% 	ArrayList<Productos> lista= (ArrayList<Productos>) request.getAttribute("lista");
					for (Productos producto:lista){%>
					<tr>
						<td><%=producto.getCodigo_producto()%></td>
						<td><%=producto.getIvacompra()%></td>
						<td><%=producto.getNitproveedor()%></td>
						<td><%=producto.getNombre_producto()%></td>
						<td><%=producto.getPrecio_compra()%></td>
						<td><%=producto.getPrecio_venta()%></td>
						<td><a class="btn btn-outline-warning m-2"
							href="Controlador?menu=Productos&accion=Cargar&id=<%=producto.getCodigo_producto()%>">Editar</a>
							<a class="btn btn-outline-danger m-2"
							href="Controlador?menu=Productos&accion=Eliminar&id=<%=producto.getCodigo_producto()%>">Eliminar</a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>
