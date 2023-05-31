package model;

import java.io.Serializable;

public class Persona implements Serializable{

	private String nombre;
	private String apellidos;
	private String identificacion;


	public Persona() {
		super();
	}


	public Persona(String nombre, String apellidos, String identificacion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", identificacion=" + identificacion
				+ "]";
	}







}
