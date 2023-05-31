package model;

import java.io.Serializable;

public class Deportivo extends Vehiculo implements Serializable{
	private String numPasajeros;
	private String numPuertas;
	private String numBolsasAire;
	private String hp;
	private String tiempo100km;

	public Deportivo() {
		super();
	}



	public String getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(String numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public String getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(String numPuertas) {
		this.numPuertas = numPuertas;
	}

	public String getNumBolsasAire() {
		return numBolsasAire;
	}

	public void setNumBolsasAire(String numBolsasAire) {
		this.numBolsasAire = numBolsasAire;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTiempo100km() {
		return tiempo100km;
	}

	public void setTiempo100km(String tiempo100km) {
		this.tiempo100km = tiempo100km;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((numBolsasAire == null) ? 0 : numBolsasAire.hashCode());
		result = prime * result + ((numPasajeros == null) ? 0 : numPasajeros.hashCode());
		result = prime * result + ((numPuertas == null) ? 0 : numPuertas.hashCode());
		result = prime * result + ((tiempo100km == null) ? 0 : tiempo100km.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deportivo other = (Deportivo) obj;
		if (hp == null) {
			if (other.hp != null)
				return false;
		} else if (!hp.equals(other.hp))
			return false;
		if (numBolsasAire == null) {
			if (other.numBolsasAire != null)
				return false;
		} else if (!numBolsasAire.equals(other.numBolsasAire))
			return false;
		if (numPasajeros == null) {
			if (other.numPasajeros != null)
				return false;
		} else if (!numPasajeros.equals(other.numPasajeros))
			return false;
		if (numPuertas == null) {
			if (other.numPuertas != null)
				return false;
		} else if (!numPuertas.equals(other.numPuertas))
			return false;
		if (tiempo100km == null) {
			if (other.tiempo100km != null)
				return false;
		} else if (!tiempo100km.equals(other.tiempo100km))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ "Deportivo [numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", numBolsasAire="
				+ numBolsasAire + ", hp=" + hp + ", tiempo100km=" + tiempo100km + "]";
	}










}
