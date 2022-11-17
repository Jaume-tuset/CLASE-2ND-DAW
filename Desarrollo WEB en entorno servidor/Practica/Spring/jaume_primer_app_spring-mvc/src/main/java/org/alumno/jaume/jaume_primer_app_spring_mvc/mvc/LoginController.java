package org.alumno.jaume.jaume_primer_app_spring_mvc.mvc;

import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nombre")

public class LoginController {

	//configurar servicios para poder enlazar esos servicios al controlador
	@Autowired
	LoginService loginServicio= new LoginService();
	
	@RequestMapping(value = "/login" , method=RequestMethod.GET)
	public String mostrarLogin() {
		return "login";
	}
	
	//nuevo parametro al controlador para añadir datos que necesita la vista jsp 
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String procesaLogin(@RequestParam String nombre,@RequestParam String password, ModelMap model) {
		
		if(!loginServicio.usuarioValido(nombre, password)) {
			return "login";
		}

		//si llega aqui es porque el usuario es valido
		model.put("nombre", nombre);
		model.put("password", password);
		return "bienvenida";
	}
	
	
	/* MENSAJE DE BIENVENIDA
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String procesaLogin() {
		return "Bienvenid@";
	}*/
	
	/*
	@ResponseBody
	public String holaMundo() {
		return "Hola Mundo desde Spring MVC!!"; 
	}*/
	
}
