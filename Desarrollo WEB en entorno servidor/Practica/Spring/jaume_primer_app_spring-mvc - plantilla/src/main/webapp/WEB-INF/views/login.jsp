<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

<div class="container">
	<p><font color="red">${errores}</font></p>
	<form action="login.do" method="post">
		Introduzca nombre: <input type="text" name="nombre"/>
		<br><br>
		Introduzca password: <input type="password" name="password"/>
		<br><br>
		<input type="submit" value="Login"/>
	</form>
</div>
<%@ include file="../jspf/footer.jspf"%>