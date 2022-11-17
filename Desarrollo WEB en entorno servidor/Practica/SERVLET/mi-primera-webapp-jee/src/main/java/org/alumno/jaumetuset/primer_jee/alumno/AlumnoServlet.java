package org.alumno.jaumetuset.primer_jee.alumno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class AlumnoServlet extends HttpServlet{
	AlumnoService alumnoService = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
		request.setAttribute("alumnos", alumnoService.listaAlumnos());
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
		request.setAttribute("alumnos", alumnoService.listaAlumnos());
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}