package org.alumno.jaume.jaume_primer_app_spring_mvc.srv;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Alumno;
import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AddAlumnoServlet {

	@Autowired
	AlumnoService alumnoServicio = new AlumnoService();
	
	@RequestMapping(value="/add-alumno",method = RequestMethod.GET)
	public String addAlumno(ModelMap nuevoAlumno,@RequestParam String nombre,@RequestParam String dni,@RequestParam String edad,@RequestParam String ciclo,@RequestParam String curso) throws NumberFormatException, AlumnoDuplicadoException {
		
		nuevoAlumno.put("dni",dni);
		nuevoAlumno.put("nombre",nombre);
		nuevoAlumno.put("edad",edad);
		nuevoAlumno.put("ciclo",ciclo);
		nuevoAlumno.put("curso",curso);
		
		
		alumnoServicio.addAlumno(new Alumno(dni,nombre,Integer.parseInt(edad),ciclo,Integer.parseInt(curso)));
		return "redirect:list-alumno";
	}	
	
	
}
