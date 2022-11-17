package org.alumno.jaumetuset.primer_jee.login;

public class LoginService{
	
	public boolean usuarioValido(String usuario, String password) {
		if (usuario.contentEquals("jaume") && password.contentEquals("1234")) 
			return true;
		return false;
	}
}