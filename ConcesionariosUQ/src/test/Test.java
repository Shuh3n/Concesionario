package test;

import model.Administrador;
import model.ConcesiorarioUQ;

public class Test {


	public Test() {
		super();
	}
	public static void main(String[] args) {

		ConcesiorarioUQ concesrionario = new ConcesiorarioUQ();
		Administrador admin = new Administrador("Santiago", "Orozco", "1021804899", "899");
		concesrionario.getListaAdministradores().add(admin);
	}


}
