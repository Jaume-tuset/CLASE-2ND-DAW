<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

<div class="container">
	<h1>Borrar alumno:</h1>
	<p><font color="red">${errores}</font></p>
	<form action="del-alumno.do" method="post">
		<div class="form-row">
			<div class="col">
				<label>Dni:</label>
				<input type="text" id="dni" name="dni" required
				class="form-control" minlength="9"/>
			</div>
		</div>
		<br>
		<input type="submit" value="Borrar" class="btn btn-success">
	</form>
	
<%@ include file="../jspf/footer.jspf" %>