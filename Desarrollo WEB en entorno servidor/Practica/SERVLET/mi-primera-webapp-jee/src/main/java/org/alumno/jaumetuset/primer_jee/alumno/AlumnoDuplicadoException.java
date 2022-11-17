package org.alumno.jaumetuset.primer_jee.alumno;

public class AlumnoDuplicadoException extends Exception{
	private static final long serialVersionUID = 1L;
	public Alumno alumnoNew;
	public Alumno alumnoExiste;
	
	
	public AlumnoDuplicadoException(Alumno alumnoNew, Alumno alumnoExiste) {
		this.alumnoExiste=alumnoExiste;
		this.alumnoNew=alumnoNew;
	}
	

	public AlumnoDuplicadoException() {	}


	@Override
	public String toString() {
		return "ERROR insertando Alumno: <br> "
				+ "Alumno existente <br>"
				+ "dni " + alumnoExiste.getDni() + "<br>"
				+ "nombre " + alumnoExiste.getNombre() + "<br>"
				+ "Alumno nuevo <br>" 
				+ "dni " + alumnoNew.getDni() + "<br>"
 				+ "nombre " + alumnoNew.getNombre() + "<br>"; 
	}	
}
