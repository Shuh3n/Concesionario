package model;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

	public Empleado(){

	}
	public Empleado(String nombre, String apellido, String identificacion){
		super(nombre, apellido, identificacion);
	}
	public int hashCode(){
		return super.hashCode();
	}
	public boolean equals(Object obj){
		return super.equals(obj);
	}

	public boolean verificarIdentificacion(String identificicacion){
		return this.getIdentificacion().equals(identificicacion);
	}
}
