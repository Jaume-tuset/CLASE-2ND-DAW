package org.alumno.jaumetuset.primer_jee.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alumno.jaumetuset.primer_jee.alumno.AlumnoService;
import org.alumno.jaumetuset.primer_jee.alumno.ValidacionUsuarioService;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE8

//Un Servlet es una clase de programación Java
//utilizado para extender las capacidades de los servidores
//que almacenan aplicaciones mediante el modelo de programación
// petición (request) respuesta (response)

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. ¿Como se crea la respuesta?

@WebServlet(urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet {
	LoginService loginServicio = new LoginService();
	AlumnoService alumnoServicio = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		request.getSession().invalidate();
		response.sendRedirect("login.do");

	}
	
}
