package org.alumno.jaumetuset.primer_jee.alumno;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/del-alumno.do")
class DelAlumnoServlet extends HttpServlet {
	AlumnoService alumnoServicio = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		
		String dni = request.getParameter("dni");
		
		alumnoServicio.delAlumno(new Alumno(dni, null, 0, null, 0));
		response.sendRedirect("list-alumno.do");

	}
}
