package org.alumno.jaume.jaume_primer_app_spring_mvc.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	@ResponseBody
	public String holaMundo() {
		return "Hola Mundo desde Spring MVC!!"; 
	}
}
