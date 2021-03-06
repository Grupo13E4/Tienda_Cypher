<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<!-- Links para el funcionamiento del boton de ocultar contrase?a(los primero 3) -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
	<link rel="stylesheet" href="CssIndex.css">
	<link rel="icon" href="img/icon.jpg" type="image/x-icon">
	<title>Login Cypher</title>
</head>
<body>
		
	<!-- Inicio Login -->
	<div class = "container col-lg-4">
	
			<div class = "card-body">
				<form class="form-sign" method="get" action="./DemoServlet">
					<div class = "form-group text-center">
						<h3 class="animated infinite bounce">Inicie Sesi?n</h3>
						<img src="img/icon.jpg" class="icon" alt="70" width="80"/>
						<label>Bienvenidos al Sistema</label>
					</div>
					<div class = "form-group">
						
						<input type="text" name="txtusuario" class="form form-control mt-4 text-light" placeholder="Usuario">					
					</div>
					
					<!-- <div class = "form-group">
						<input type="password" name="txtpassword" class="form form-control mt-4 text-light" 
						placeholder="Password">	
						</div> -->
						
						<form id="form1">
						<div class="form-group">
						    <div class="row">
						  <div>

						     <div class="input-group">
						      	<input ID="txtpassword" name="txtpassword" type="password" 
						     	 Class="form form-control mt-4 text-light" placeholder="Password" >
						      	<button style="color: #fff" id="show_password" 
						     	class="btn btn-primary btn-lm mt-4 input-group-append" type="button"
						     	onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
						    </div>
						    
						    	<!-- Funionamiento del Boton para mostrar u ocultar contrase?a -->
						    	
							    	<script type="text/javascript">
										function mostrarPassword(){
												var cambio = document.getElementById("txtpassword");
												if(cambio.type == "password"){
													cambio.type = "text";
													$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
												}else{
													cambio.type = "password";
													$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
												}
											} 
											
											$(document).ready(function () {
											//CheckBox mostrar contrase?a
											$('#Showpassword').click(function () {
												$('#password').attr('type', $(this).is(':checked') ? 'text' : 'password');
											});
										});
										</script>	
								  	<!-- <div class="alert alert-danger">
    									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    									<strong>Ingreso errado!</strong> Verifique su Usuario y Contrase?a.
  									</div>	 -->								
						
					<div>
						<input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-lm mt-4">
						<a class="btn btn-primary btn-lm mt-4" href="inicio.jsp" role="button">Cancelar</a>
					</div>
				</form>
			</div>
	</div>
	<!-- Fin Login -->
	
</body>
</html>