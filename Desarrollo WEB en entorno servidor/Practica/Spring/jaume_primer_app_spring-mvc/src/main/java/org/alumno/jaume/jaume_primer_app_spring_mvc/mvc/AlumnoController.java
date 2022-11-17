package org.alumno.jaume.jaume_primer_app_spring_mvc.mvc;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Alumno;
import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Pagina;
import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/model/Alumno")
public class AlumnoController {

	Pagina pagina = new Pagina("Alumnos","list-alumno");
	
	@Autowired
	AlumnoService alumnoServicio = new AlumnoService();
	PaginaService paginaServico;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//metodo listarAlumnos que atiende a list-alumno en modo GET y que incorpora al modelo el listado de alumnosy la pagina recuperada del servicio
	@RequestMapping(value="/list-alumno",method = RequestMethod.GET)
	public String listarAlumnos(ModelMap listadoAlumnos){
	
		listadoAlumnos.addAttribute("lista", alumnoServicio.listaAlumnos());	
		listadoAlumnos.addAttribute("pagina",pagina.getPaginaActiva());
		return "lista-alumno";
	}
	
	
	//añadir parametros de los campos del formulario en el metodo 
	//redirigir la peticion debemos utilizar redirect:urlARedireccionar
	@RequestMapping(value="/add-alumno",method = RequestMethod.POST)
	public String nuevoAlumno(ModelMap nuevoAlumno,/*VALIDAR ALUMNO*/@Valid Alumno alumno ,BindingResult validacion /*@RequestParam String nombre,@RequestParam String dni,@RequestParam String edad,@RequestParam String ciclo,@RequestParam String curso*/) {
		String errores="";
		//incluir bean en el modelo para solucionar el error de ejecución
		nuevoAlumno.addAttribute("pagina",pagina.getPaginaActiva());
		
		try {
			alumnoServicio.addAlumno(alumno);

			//para evitar pasar parametros innecesarios
			nuevoAlumno.clear();
			
			//para evitar inserciones duplicadas comentamos código y redirigimos a listar
			return "redirect:list-alumno";

		}catch(NumberFormatException e) {
			errores=e.getMessage();
		}catch(AlumnoDuplicadoException e) {
			errores=e.toString();
		}
		
		//si llegamos aqui hay un error porque no se ejecuta la linea
		nuevoAlumno.addAttribute("errores",errores);
		return "add-alumno";
		
	}
	
	@RequestMapping(value="/del-alumno", method=RequestMethod.POST)
	 public String delAlumno(ModelMap delAlumno,@RequestParam String dni) {

		alumnoServicio.delAlumno(new Alumno(dni));
		delAlumno.clear();
		
		return "del-alumno";
	
	}
	
	
	//añadir un metodo que sea capaz de leer un parámetro dni,
	//recuperar dicho Alumno y envairlo a un nuevo fichero update-alumno.jsp
	@RequestMapping(value="/mod-alumno",method = RequestMethod.POST)
	public String modificarDNI(ModelMap modifDni, @RequestParam String dni) {
		
		alumnoServicio.modificarAlumnoPorDni(dni);
		modifDni.clear();
				
		return "mod-alumno";	
	}
	
	
	//modificar alumno
	@RequestMapping(value="/mod-alumno",method = RequestMethod.POST)
	public String modificarAlumno(ModelMap modifAlum, @RequestParam Alumno alumno) throws Exception {
		
		alumnoServicio.modificarAlumno(alumno,alumno.getUser());
		modifAlum.clear();
				
		return "mod-alumno";	
	}
	
	/*procesar Modificar Alumnos
	@RequestMapping(value="/mod-alumno",method = RequestMethod.POST)
	public String procesaUpdateAlumno(ModelMap updateAlumnos,@Valid Alumno alumno , BindingResult validar) {
		
		String errores=" ";
		
		updateAlumnos.addAttribute("pagina",pagina.getPaginaActiva());
		
		try {
			alumnoServicio.addAlumno(alumno);
			updateAlumnos.clear();
			
			
			
			return "redirect:list-alumno";

		}catch(NumberFormatException e) {
			errores=e.getMessage();
		}catch(AlumnoDuplicadoException e) {
			errores=e.toString();
		}
		
		if(errores.toString() != null) {
			return "list-alumno";
		}else{
			return "mod-alumno";			
		}
		
	}
	*/
	
	@RequestMapping(value="/update-alumno",method=RequestMethod.POST)
	public String procesaUpdateAlumno(ModelMap modelUpdate, @Valid Alumno alumno, BindingResult validar) {

		modelUpdate.addAttribute("pagina",pagina.getPaginaActiva());
		if(validar.hasErrors()) {
			return "update-alumno";
		}
		try {
			alumnoServicio.modificarAlumno(alumno, modelUpdate.getAttribute("nombre").toString());
			modelUpdate.clear();
			return "redirect:list-alumno";
		}catch (Exception e) {
			modelUpdate.addAttribute(alumnoServicio.encontrarAlumnoPorDni(alumno.getDni()));
			modelUpdate.addAttribute("errores",e.getMessage());
			return "update-alumno";
		}		
	}
	
	@RequestMapping(value="/add-alumno",method=RequestMethod.GET)
	public String mostrarAlumno(ModelMap modelMostrar) {
		modelMostrar.addAttribute("pagian",pagina.getPaginaActiva());
		modelMostrar.addAttribute("alumno",new Alumno("","Nuevo Alumno",18,"DAW",2));
		modelMostrar.addAttribute("interesadoEnLista",alumnoServicio.listaInteresadoEn().toArray());
		modelMostrar.addAttribute("generoSeleccionadoLista",alumnoServicio.generoInteresado().toArray());
		return "add-alumno";
	}	
	
	/*@ModelAttribute("interesadoEnLista")
	public Object[] getinteresadoEnLista() {
		return alumnoServicio.listaInteresadoEn().toArray();
	}*/
	
	
}