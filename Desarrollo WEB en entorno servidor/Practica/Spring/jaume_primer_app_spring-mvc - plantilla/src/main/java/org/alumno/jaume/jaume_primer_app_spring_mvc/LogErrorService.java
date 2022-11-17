package org.alumno.jaume.jaume_primer_app_spring_mvc;

public class LogErrorService  extends Exception {

	private static final long serialVersionUID=1L;
	
	public void addLogError(String incorrecto, String nombre) {
		if(nombre!="jaume") {
			System.out.println("Nombre Incorrecto");
		}
	}

}
