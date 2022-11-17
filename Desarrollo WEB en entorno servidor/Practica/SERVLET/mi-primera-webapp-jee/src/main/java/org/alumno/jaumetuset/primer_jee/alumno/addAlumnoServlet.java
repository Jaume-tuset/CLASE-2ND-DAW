package org.alumno.jaumetuset.primer_jee.alumno; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-alumno.do")
public class addAlumnoServlet extends HttpServlet {
	AlumnoService alumnoServicio = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		
		request.getRequestDispatcher("/WEB-INF/views/add-alumno.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String ciclo = request.getParameter("ciclo");
		String curso = request.getParameter("curso");
		
		
		Alumno a = new Alumno(dni, nombre, Integer.parseInt(edad), ciclo, Integer.parseInt(curso));
		try {
			alumnoServicio.addAlumno(a);
			response.sendRedirect("list-alumno.do");
		}catch(AlumnoDuplicadoException e){
			request.setAttribute("errores", e.toString());
			request.getRequestDispatcher("/WEB-INF/views/add-alumno.jsp").forward(request, response);
		}
	}
}