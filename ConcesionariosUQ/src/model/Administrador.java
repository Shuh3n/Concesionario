package model;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable{

	private String credencial;


	public Administrador() {
		super();
	}

	public Administrador(String credencial) {
		super();
		this.credencial = credencial;
	}

	public Administrador(String nombre, String apellido, String identificacion, String credencial){
		super(nombre, apellido, identificacion);
		this.credencial = credencial;
	}

	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public int hashCode(){
		return super.hashCode();
	}
	public boolean equals(Object obj){
		return super.equals(obj);
	}




}
