<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css"
rel="stylesheet">
<title>Alumnos</title>

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

	<nav class="navbar navbar-default">

		<a href="http://ieslluissimarro.org/" class="navbar-brand">Simarro</a>

		<nav class="nav nav-pills flex-column flex-sm-row">
			<a class="nav-link active" href="#">Home</a>
			<a class="nav-link" href="/alumno.do">Alumnos</a>
			<a class="nav-link" href="https://aules.edu.gva.es/fp/course/view.php?id=83303">DWES</a>
		</nav>
 
 
		<ul class="nav navbar-nav navbar-right">
			<li><a class="nav-link" href="/login.do">Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<H1>Cabecera</H1>
		Cuerpo de la p�gina
	</div>
	
	<div class="container">
		<h1>Listado de Alumnos</h1>
		<table class="table table-striped">
			<thead>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Accion</th>
			</thead>
			<tbody>
				<tr>
					<td>Nombre 1</td>
					<td>Edad 1</td>
					<td>
						<a class="btn btn-danger" href="#">Borrar</a>
					</td>
				</tr>
				<tr>
					<td>Nombre 2</td>
					<td>Edad 2</td>
					<td>
						<a class="btn btn-danger" href="#">Borrar</a>
					</td>
				</tr>
			</tbody>
		</table>
		<p>
			<a class="btn btn-sucess" href="#">A�adir Alumno</a>
		</p>
	</div>

	<footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>