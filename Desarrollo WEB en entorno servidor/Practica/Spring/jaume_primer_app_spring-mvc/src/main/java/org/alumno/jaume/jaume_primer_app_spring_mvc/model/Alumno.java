package org.alumno.jaume.jaume_primer_app_spring_mvc.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.alumno.jaume.jaume_primer_app_spring_mvc.model.interfaces.Modificable;
import org.alumno.jaume.jaume_primer_app_spring_mvc.util.Ts;
import org.hibernate.validator.constraints.Range;

public class Alumno implements Modificable<Alumno>,Serializable,Comparable<Alumno>{
	
	private static final long serialVersionUID=1L;
	
	/***** DECLARACIÓN DE VARIABLES *********/
	
	@Pattern(regexp="[0-9]{8}{A-Za-z}{1}",message ="El dni debe tener 8 numeros y 1 letra.")
	private String dni;
	
	@Size(min=5,message="El nombre debe de tener un tamaño minimo de 5")
	private String nombre;
	
	@NotNull(message="La edad no puede estar vacia")	
	@Range(min=18, max=99, message = " La edad debe ser igual o mayor a 18 y menor o igual a 99")
	@Digits(integer=2,fraction=0,message="La edad no puede tener decimales ni más de 2 digitos")
	private int edad;
	
	@Size(min=3,message="El ciclo debe de tener un tamaño minimo de 3")
	private String ciclo;
	
	@NotNull(message="El curso no puede estar vacio")
	@Range(min=1, max=2, message="El curso solo admite los valores de 1 o 2")
	private Integer curso;
	

	private boolean erasmus;
	private String[] ineresadosEn;
	private String lenguajeFavorito;
	
	
	/************* GETTERS Y SETTERS  *******************/
	
	public boolean isErasmus() {
		return erasmus;
	}

	public void setErasmus(boolean erasmus) {
		this.erasmus = erasmus;
	}

	public String[] getIneresadosEn() {
		return ineresadosEn;
	}

	public void setIneresadosEn(String[] ineresadosEn) {
		this.ineresadosEn = ineresadosEn;
	}

	public String getLenguajeFavorito() {
		return lenguajeFavorito;
	}

	public void setLenguajeFavorito(String lenguajeFavorito) {
		this.lenguajeFavorito = lenguajeFavorito;
	}

	public Date getTs() {
		return ts;
	}

	private String user;
	private Date ts;

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}


	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	/********* CONSTRUCTOR ***************/
	
	public Alumno(String dni, String nombre, int edad, String ciclo, int curso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.ciclo = ciclo;
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	/*********** METODOS *************/
	
	public boolean sePuedeModificarUtilizando(Alumno itemModificado) {
		if(this.getUser()!= null && this.getTs() != null) {
			String usuarioActual=this.getUser();
			String usuarioModificado=itemModificado.getUser();
			Date fechaActual=Ts.parseIso(Ts.formatIso(this.getTs()));
			Date fechaModificada=Ts.parseIso(Ts.formatIso(itemModificado.getTs()));
			if(!usuarioActual.equals(usuarioModificado)) {
				return false;
			}
		}
		return true;
	}
	
	public String mensajeNoSePuedeModificar() {
		String msg="\r\n\t[ERROR]\r\n<br/>"+
				"\t '$item' ha sido modificado por otro usuario. \r\n<br/> "+
				"\t Para evitar la perdida de información se impide guardar '$item'. \r\n<br/>"+
				"\tÚltima modificación realizada por ["+this.getUser()+"] el ["+Ts.ts(this.getTs())+"]\r\n<br/>";
			return msg.replace("$item","Alumno");			
		}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", ciclo=" + ciclo + ", curso=" + curso
				+ "]";
	}

	@Override
	public void setTs(Date ts) {
		ts=this.ts;
	}

	@Override
	public int compareTo(Alumno o) {
		return 1;
	}
}
