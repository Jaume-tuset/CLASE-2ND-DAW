package org.alumno.jaume.jaume_primer_app_spring_mvc.srv.excepciones;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Alumno;

public class AlumnoDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L;
	private Alumno alumnoExistente;
	private Alumno alumnoNuevo;
	
	public AlumnoDuplicadoException(Alumno alumnoExistente, Alumno alumnoNuevo) {
		this.alumnoExistente = alumnoExistente;
		this.alumnoNuevo = alumnoNuevo;
	}
	
	@Override
	public String toString() {
		return "ERROR insertando Alumno: <br> "
				+ "Alumno existente <br>"
				+ "dni " + alumnoExistente.getDni() + "<br>"
				+ "nombre " + alumnoExistente.getNombre() + "<br>"
				+ "Alumno nuevo <br>" 
				+ "dni " + alumnoNuevo.getDni() + "<br>"
 				+ "nombre " + alumnoNuevo.getNombre() + "<br>"; 
	}
}
