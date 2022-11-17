package org.alumno.jaumetuset.primer_jee.alumno;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alumno.jaumetuset.primer_jee.pagina.Pagina;

class ListaAlumnosServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		AlumnoService alumnoServicio = new AlumnoService();
		
		@Override
		protected void doGet(HttpServletRequest request, 
				HttpServletResponse response) throws IOException, ServletException {
			request.getSession().setAttribute("pagina", new Pagina("Alumnos", "list-alumno.do"));		
			
			request.setAttribute("alumnos", alumnoServicio.listaAlumnos());
			request.getRequestDispatcher("/WEB-INF/views/list-alumno.jsp").forward(request, response);

		}
		
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws IOException, ServletException {
			
			response.sendRedirect("add-alumno.do");

		}
}
