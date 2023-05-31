package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Persona implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fechaNacimiento;

	public Cliente(){

	}
	public Cliente(String nombre, String apellido, String identificacion, LocalDate fechaNacimiento){
		super(nombre, apellido, identificacion);
		this.fechaNacimiento = fechaNacimiento;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int hashCode(){
		return super.hashCode();
	}
	public boolean equals(Object obj){
		return super.equals(obj);
	}


}




