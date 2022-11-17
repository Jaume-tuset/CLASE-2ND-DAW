package org.alumno.jaumetuset.primer_jee.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alumno.jaumetuset.primer_jee.alumno.AlumnoService;
import org.alumno.jaumetuset.primer_jee.pagina.Pagina;

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

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	LoginService loginServicio = new LoginService();
	AlumnoService alumnoServicio = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		request.getSession().setAttribute("pagina", new Pagina("Login", "login.do"));
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		// request.setAttribute("password", request.getParameter("password"));
		
		if(loginServicio.usuarioValido(nombre, password)) {
			request.getSession().setAttribute("nombre", nombre);
			response.sendRedirect("list-alumno.do");
		}else {
			request.setAttribute("errores", "Usuario '" + nombre + "' o contraseña incorrecta");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
		

	}
}
