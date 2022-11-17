package org.alumno.jaume.jaume_primer_app_spring_mvc.srv;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.Alumno;
import org.alumno.jaume.jaume_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class AlumnoService {
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	

	static {
		alumnos.add(new Alumno("11111111A","David",22,"DAW",1));
		alumnos.add(new Alumno("22222222B","Jose",23,"DAM",1));
		alumnos.add(new Alumno("33333333C","Alejandor",21,"DAWES",1));
		alumnos.add(new Alumno("44444444D","Marta",23,"ASIX",1));
		alumnos.add(new Alumno("55555555E","Jaume",23,"ASIX",1));
		alumnos.add(new Alumno("66666666F","Pablo",20,"DAM",1));
	}
	
	public List listaAlumnos() {
		return alumnos;
	}
	
	public void addAlumno(Alumno alumno) throws AlumnoDuplicadoException{
		if(existeAlumno(alumno)) {
			throw new AlumnoDuplicadoException(alumno, alumno);
		}else {
			alumnos.add(alumno);
		}
		
	}
	
	public void delAlumno(Alumno alumno) {
		alumnos.remove(alumno);
	}
	
	public boolean existeAlumno(Alumno alumno) {
		for(Alumno a:alumnos) {
			if(alumno.getDni().equals(a.getDni())) {
				return true;
			}
		}
		return false;
	}
	
	public Alumno encontrarAlumnoPorDni(String dni) {
		for(Alumno a:alumnos) {
			if(dni.equals(a.getDni())) {
				return a;
			}
		}
		return null;
	}
	
	public Alumno modificarAlumnoPorDni(String dni) {
			for(Alumno a:alumnos) {
				if(dni.equals(a.getDni())) {
					return a;
				}
			}
			return null;
	}
	
	public void modificarAlumno(Alumno alumnoModificado, String usuarioModificado) throws Exception {
		
		Alumno alumnoActual = new Alumno(usuarioModificado);
		
		if(alumnoModificado != null || usuarioModificado != null){
			throw new Exception();
		}else {
			if(alumnoActual.sePuedeModificarUtilizando(alumnoModificado)) {
				alumnos.remove(alumnoActual);
				alumnos.add(Integer.parseInt(usuarioModificado), alumnoModificado);
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				Date date = new Date(ts.getTime());
				
			}else {
				throw new Exception(alumnoActual.mensajeNoSePuedeModificar());
			}
		}
	}
	
	public List<String> listaInteresadoEn(){
		
		List<String>interesadoEnLista = new ArrayList<>();
		
		interesadoEnLista.add("Backend");
		interesadoEnLista.add("Frontend");
		
		return interesadoEnLista;
		
	}

	public List generoInteresado() {

		List<String>generoSeleccionadoLista = new ArrayList<>();
		
		generoSeleccionadoLista.add("Hombre");
		generoSeleccionadoLista.add("Mujer");
		
		return generoSeleccionadoLista;
	}
	
	
}
