<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf"%>

<div class="container">
	<h1>Listado de alumnos:</h1>
	<table class="table table-striped">
		<thead>
			<th> DNI </th>
			<th> Nombre </th>
			<th> Edad </th>
			<th> Ciclo </th>
			<th> Curso </th>
			<th> Accion </th>
		</thead>
		<tbody>
			<c:forEach items="${alumnos}" var="alumno">
				<tr>
					<td>${alumno.getDni()}</td>
					<td>${alumno.getNombre()}</td>
					<td>${alumno.getEdad()}</td>
					<td>${alumno.getCiclo()}</td>
					<td>${alumno.getCurso()}</td>
					<td><a class="btn btn-danger" href="del-alumno.do?dni=${alumno.getDni()}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	<a class="btn btn-success" href="add-alumno.do">Añadir alumno</a>
	
<%@ include file="../jspf/footer.jspf" %>