<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="cssPrincipal.css">
<link rel="icon" href="img/icon.jpg" type="image/x-icon">
<title>P?gina Principal</title>
</head>
<body>

	<div class="container-fluid">
		<nav class="navbar navbar-fixed-top navbar-expand-lg navbar-dark bg-dark mt-2">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a
							style="margin-left: 10px; border: none"
							class="btn btn-outline-light" href="Controlador?menu=Principal" target="myFrame">Home</a>
						</li>
						<li class="nav-item"><a
							style="margin-left: 10px; border: none"
							class="btn btn-outline-light"
							href="Controlador?menu=Usuarios&accion=Listar" target="myFrame">Usuarios</a>
						</li>
						<li class="nav-item">
							<a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
							href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
						</li>
						<li class="nav-item">
							<a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
							href="Controlador?menu=Proveedores&accion=Listar" target="myFrame">Proveedores</a>
						</li>
						<li class="nav-item">
							<a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
							href="Controlador?menu=Productos&accion=Listar" target="myFrame">Productos</a>
						</li>
						<li class="nav-item">
							<a style="margin-left:10px; border:none" class="btn btn-outline-light" 
							href="Controlador?menu=Ventas&accion=default&UsuarioActivo=${usuario.getCedula_usuario()}"
							target="myFrame">Ventas</a>
						</li>
						<li class="nav-item">
							<a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
							href="Controlador?menu=Reportes&accion=default"
							target="myFrame">Reportes</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="dropdown">
				<button class="btn btn-outline-light dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Usuario: ${usuario.getNombre_usuario()}
				</button>
					
				<div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
					<a class="dropdown-item" href="#"><img src="img/User.png"
						width="40" alt="40"></a> 						
					<a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
					<a class="dropdown-item" href="#">${usuario.getEmail_usuario()}</a>
					<div class="dropdown-divider"></div>
					<form class="dropdown-item" method="POST" action="#">
						<a class="btn btn-danger center-block" type="submit" 
							href="inicio.jsp">Cerrar Sesion</a>
					</form>
				</div>
			</div>
		</nav>			
	</div>
	
	
		
	<div class="m-4" style="height: 900px;">
	
			<iframe style="height: 100%; width: 100%; border: none"
				name="myFrame" src="Home.jsp">					
   	        			
			</iframe>
	
	</div>
	


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
		integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
		crossorigin="anonymous">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
		integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
		crossorigin="anonymous">
	</script>
</body>
</html>