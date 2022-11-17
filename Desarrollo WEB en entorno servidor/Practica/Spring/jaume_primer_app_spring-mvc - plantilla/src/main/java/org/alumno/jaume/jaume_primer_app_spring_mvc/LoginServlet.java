package org.alumno.jaume.jaume_primer_app_spring_mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet {

	LoginService loginService = new LoginService();
	LogErrorService logErrorService = new LogErrorService();
	PaginaService paginaService = new PaginaService();
	
	static Pagina paginaLogin=new Pagina("Login","login.do");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		paginaService.setPagina(paginaLogin);
		request.getSession().setAttribute("pagina", paginaService.getPagina());
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException{
			
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		paginaService.setPagina(paginaLogin);
		request.getSession().setAttribute("pagina",paginaService.getPagina());
		request.getSession().setAttribute("numModulosInsertados",0);
		//validación correcta
		if(loginService.usuarioValido(nombre, password)) {
			request.getSession().setAttribute("nombre", nombre);
			request.setAttribute("nombre", nombre);
			request.getRequestDispatcher("/WEB-INF/views/bienvenida.jsp").forward(request, response);
		}
		//validación incorrecta
		else {
			logErrorService.addLogError("Login incorrecto","Login incorrecto de : "+nombre+" .");
			request.setAttribute("errores","Usuario '"+nombre+"' o contraseña incorrecta '"+password);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);		
		}
		
		
		
		
	}
	
	
}
