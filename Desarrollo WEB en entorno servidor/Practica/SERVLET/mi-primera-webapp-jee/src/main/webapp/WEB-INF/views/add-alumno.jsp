
<div class="container">
	<p><font color="red">${errores}</font></p>
	<h1>Nuevo alumno:</h1>
	<form action="add-alumno.do" method="post">
		<div class="form-row">
			<div class="col">
				<label>Dni:</label>
				<input type="text" id="dni" name="dni" required
				class="form-control" minlength="9"/>
			</div>
			<div class="col">
				<label>Nombre:</label>
				<input type="text" id="nombre" name="nombre" required
				class="form-control" minlength="5"/>
			</div>
		</div>
		<div class="form-row">
			<div class="col">
				<label>Edad:</label>
				<input type="number" id="edad" name="edad" required
				class="form-control" min="18" max="100"/>
			</div>
			<div class="col">
				<label>Ciclo:</label>
				<input type="text" id="ciclo" name="ciclo" required
				class="form-control" minlength="3"/>
			</div>
			<div class="col">
				<label>Curso:</label>
				<input type="number" id="curso" name="curso" required
				class="form-control" min="1" max="2"/>
			</div>
		</div>
		<br>
		<input type="submit" value="A�adir" class="btn btn-success">
	</form>
	<%@ include file="../jspf/footer.jspf" %>
	