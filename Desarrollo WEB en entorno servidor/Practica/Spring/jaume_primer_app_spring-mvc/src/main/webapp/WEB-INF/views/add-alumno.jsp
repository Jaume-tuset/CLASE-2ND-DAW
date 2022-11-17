<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

<div class="container">
	<h1>Nuevo alumno:</h1>
	<p>
		<font color="red">${errores}</font>
	</p>
	<mvc:form method="post" action="add-alumno.do" modelAttribute="alumno">
		<div class="form-row">
			<div class="col">
				<mvc:label path="dni">Dni:</mvc:label>
				<mvc:input path="dni" type="text" id="dni" name="dni" required
				class="form-control"/>
				<mvc:errors path="dni" cssClass="text-warning"></mvc:errors>
			</div>
			<div class="col">
				<mvc:label path="nombre">Nombre:</mvc:label>
				<mvc:input path="nombre" type="text" id="nombre" name="nombre" required
				class="form-control"/>
				<mvc:errors path="nombre" cssClass="text-warning"></mvc:errors>
			</div>
		</div>
		<div class="form-row">
			<div class="col">
				<mvc:label path="edad">Edad:</mvc:label>
				<mvc:input path="edad" type="number" id="edad" name="edad" required
				class="form-control" min="18" max="100"/>
			</div>
			<div class="col">
				<mvc:label path="ciclo" >Ciclo:</mvc:label>
				<mvc:input path="ciclo" type="text" id="ciclo" name="ciclo" required
				class="form-control" minlength="3"/>
			</div>
			<div class="col">
				<mvc:label path="curso" >Curso:</mvc:label>
				<mvc:input path="curso" type="number" id="curso" name="curso" required
				class="form-control" min="1" max="2"/>
			</div>
		</div>
		<br>
		<div class="form-row">
			<div class="col">
				<mvc:checkbox path="erasmus"/>
				<mvc:label path="erasmus">Alumno en Erasmus</mvc:label>
			</div>
			<div class="col">
				<mvc:label path="interesadosEn">Interesados en : </mvc:label>
				<mvc:checkboxes path="interesadoEn" items="${interesadoEnLista}"/>
				<!-- <mvc:checkbox path="interesadoEn" value='Backend'/>Backend
				<mvc:checkbox path="interesadoEn" value='Frontend'/>Frontend-->
			</div>
			<div class="col">
				<mvc:label path="lenguajeFavorito">Lenguaje Favorito: </mvc:label>
				<mvc:checkbox path="lenguajeFavorito" values='Java'/>&nbsp;Java
			</div>
		</div>
		<div class="form-row">
			<div class="col">
				<mvc:label path="genero">Género: </mvc:label><br/>
				<!--<mvc:radiobutton path="genero" value="Hombre"/>Hombre<br/>
				<mvc:radiobutton path="genero" value="Mujer"/>Mujer-->
				<mvc:radiobuttons path="genero" items="${generoSeleccionado}"/>
			</div>
		</div>
		<mvc:input path="submit" type="submit" value="Añadir" class="btn btn-success"></mvc:input>
	</mvc:form>
	
<%@ include file="../jspf/footer.jspf" %>