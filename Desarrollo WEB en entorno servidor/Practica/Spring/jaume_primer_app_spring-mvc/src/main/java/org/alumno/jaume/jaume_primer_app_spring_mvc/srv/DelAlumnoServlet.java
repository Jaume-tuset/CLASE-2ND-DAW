package org.alumno.jaume.jaume_primer_app_spring_mvc.srv;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DelAlumnoServlet{
	
	@Autowired
	AlumnoService alumnoServicio = new AlumnoService();
		
	@RequestMapping(value="/del-alumno", method = RequestMethod.GET)
	public String delAlumno(@RequestParam String dni, ModelMap delAlumno) {
		
		delAlumno.put("dni",dni);
		alumnoServicio.delAlumno(new Alumno(dni,null,0,null,0));
		return "redirect:list-alumno";
	}	
}
