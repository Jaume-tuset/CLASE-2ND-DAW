package org.alumno.jaume.jaume_primer_app_spring_mvc.srv;

import org.springframework.stereotype.Service;


//Servicios al controlador LoginController
@Service
public class LoginService {
	public boolean usuarioValido(String nombre, String password) {
		if(nombre.contentEquals("jaume") && password.contentEquals("1234")) {
			return true;
		}
		return false;
	}

}
