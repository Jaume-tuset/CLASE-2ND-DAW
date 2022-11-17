package org.alumno.jaume.jaume_primer_app_spring_mvc;

public class LoginService {

	public boolean usuarioValido(String usuario, String password) {
		if(usuario.contentEquals("jaume") && password.contentEquals("1234")) {
			return true;
		}
		return false;
	}
	
}
