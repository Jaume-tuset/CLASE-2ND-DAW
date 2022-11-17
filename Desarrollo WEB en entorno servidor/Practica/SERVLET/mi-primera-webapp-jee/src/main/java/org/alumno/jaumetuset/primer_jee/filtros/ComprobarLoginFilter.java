package org.alumno.jaumetuset.primer_jee.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="*.do")
public class ComprobarLoginFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		System.out.println(request.getRequestURI());
		
		if(request.getSession().getAttribute("nombre")!=null)
			// Estamos logueados
			chain.doFilter(request, servletResponse);
		else // No estamos logueados
			if(request.getRequestURI().contains("login.do")){
				//No estamos logueados pero estamos en la pagina de login
				chain.doFilter(request,servletResponse);
			} else {
				//No estamos logueados y debemos reenviar al login
				HttpServletResponse response = (HttpServletResponse) servletResponse;
				response.sendRedirect("login.do");
			}
	}
	
	@Override
	public void destroy() {}
	
}