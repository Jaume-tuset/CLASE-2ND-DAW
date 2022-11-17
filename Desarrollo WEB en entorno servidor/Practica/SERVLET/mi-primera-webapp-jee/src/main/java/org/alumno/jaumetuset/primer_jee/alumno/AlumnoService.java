package org.alumno.jaumetuset.primer_jee.alumno;

import java.util.ArrayList; 
import java.util.List;
import org.alumno.jaumetuset.primer_jee.alumno.Alumno;

public class AlumnoService{
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	//En una situación real aquí se realizaria un acceso a la BD para obtener 
	//los alumnos , pero en esta unidad didáctica aun no lo haremos
	
	//1º Para evitar tener la lista de alumnos en blanco al arrancar la app
	//debemos crear un bloque estático para inicialiazar el ArrayList al principio
	//con 3 valores : " Jose " , " Pedro " , " Juan "
	

	static {
		alumnos.add(new Alumno(" Jose "));
		alumnos.add(new Alumno(" Pedro "));
		alumnos.add(new Alumno(" Juan "));
		alumnos.add(new Alumno(" María "));
	}
	
	
	//2º Crear un método listaAlumnos() que devuelva la lista de Alumnos
	
	public void listaAlumnos() {
		for (int i = 1; i <= alumnos.size(); i++) {
			System.out.println("El "+i+"º Alumno es : "+alumnos.get(i));
		}
	}
	
	public void addAlumno(Alumno alumno) throws AlumnoDuplicadoException {
		if(exiteAlumno(alumno)) {
			throw new AlumnoDuplicadoException(alumno, alumno);
		}else {
			alumnos.add(alumno);
		}
	}
	
	public void delAlumno(Alumno alumno) {
		alumnos.remove(alumno);
	}
	
	public boolean exiteAlumno(Alumno alumno) {
		for(Alumno a : alumnos) {
			if (alumno.getDni().equals(a.getDni())) {
				return true;
			}
		}
		return false;
	}
	
	public Alumno encontrarAlumnoPorDNI(String dni) {
		for(Alumno a:alumnos) {
			if(dni.equals(a.getDni())) {
				return a;
			}
		}
		return null;
	}
}
