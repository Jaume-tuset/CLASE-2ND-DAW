<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/menuSuperior.jspf"%>

<head>
	<title>Login</title>
</head>
	<body>
		<form action=" login.do" method="post">
		Introduzca nombre : <input type="text" name="nombre"/>
		Introduzca contraseña : <input type="password" name="password"/>
		<input type="submit" value="login"/> 
		</form>
<%@ include file="../jspf/footer.jspf"%>
	</body>
</html>