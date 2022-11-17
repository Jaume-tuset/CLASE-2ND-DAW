package org.alumno.jaumetuset.primer_jee.alumno;

public class ValidacionUsuarioService{
		
	public boolean usuarioValido(String usuario, String password) {
		//En cocndicones normales se accedería a una base de datos para 
		//confirmar la contraseña , per opor simplicidad lo validamos 
		//comprobando si son unos valores fijos 
		//El alumno debe cambiar los valores del usuario y contraseñas validos
		if(usuario.contentEquals("jaume")&& password.contentEquals("123456789")) 
			return true;
		return false;
	}
}