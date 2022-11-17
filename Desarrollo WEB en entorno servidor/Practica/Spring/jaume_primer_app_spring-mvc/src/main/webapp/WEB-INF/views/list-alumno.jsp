<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

<div class="container">
	<h1>Listado de alumnos:</h1>
	<p>Bienvenido ${nombre }</p>
	<table class="table table-striped">
		<thead>
			<th><a class="nav-link">DNI </a></th>
			<th><a class="nav-link"> Nombre </a></th>
			<th><a class="nav-link"> Edad </a></th>
			<th><a class="nav-link"> Ciclo </a></th>
			<th><a class="nav-link"> Curso </a></th>
			<th><a class="nav-link"> ACCIÓN </th>
		</thead>
		<tbody>
			<c:forEach items="${alumnos}" var="alumno">
				<tr>
					<td>${alumno.getDni()}</td>
					<td>${alumno.getNombre()}</td>
					<td>${alumno.getEdad()}</td>
					<td>${alumno.getCiclo()}</td>
					<td>${alumno.getCurso()}</td>
					<td><a class="btn btn-danger" href="mod-alumno.do?dni=${alumno.getDni()}">Modificar</a></td>
					<td><a class="btn btn-danger" href="del-alumno.do?dni=${alumno.getDni()}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	<a class="btn btn-success" href="add-alumno.do">Anyadir Alumno</a>
<%@ include file="../jspf/footer.jspf" %>