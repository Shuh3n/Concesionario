package model;

import java.io.Serializable;

public class Pickups extends Vehiculo implements Serializable{

	private String numPasajeros;
	private String numPuertas;
	private boolean aireAcondicionado;
	private boolean camReversa;
	private String numBolsasAire;
	private boolean abs;
	private boolean is4x4;
	private String capacidadCarga;

	public Pickups() {
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

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isCamReversa() {
		return camReversa;
	}

	public void setCamReversa(boolean camReversa) {
		this.camReversa = camReversa;
	}

	public String getNumBolsasAire() {
		return numBolsasAire;
	}

	public void setNumBolsasAire(String numBolsasAire) {
		this.numBolsasAire = numBolsasAire;
	}

	public boolean isAbs() {
		return abs;
	}

	public void setAbs(boolean abs) {
		this.abs = abs;
	}

	public boolean isIs4x4() {
		return is4x4;
	}

	public void setIs4x4(boolean is4x4) {
		this.is4x4 = is4x4;
	}

	public String getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (abs ? 1231 : 1237);
		result = prime * result + (aireAcondicionado ? 1231 : 1237);
		result = prime * result + (camReversa ? 1231 : 1237);
		result = prime * result + ((capacidadCarga == null) ? 0 : capacidadCarga.hashCode());
		result = prime * result + (is4x4 ? 1231 : 1237);
		result = prime * result + ((numBolsasAire == null) ? 0 : numBolsasAire.hashCode());
		result = prime * result + ((numPasajeros == null) ? 0 : numPasajeros.hashCode());
		result = prime * result + ((numPuertas == null) ? 0 : numPuertas.hashCode());
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
		Pickups other = (Pickups) obj;
		if (abs != other.abs)
			return false;
		if (aireAcondicionado != other.aireAcondicionado)
			return false;
		if (camReversa != other.camReversa)
			return false;
		if (capacidadCarga == null) {
			if (other.capacidadCarga != null)
				return false;
		} else if (!capacidadCarga.equals(other.capacidadCarga))
			return false;
		if (is4x4 != other.is4x4)
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
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+"Pickups [numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", aireAcondicionado="
				+ aireAcondicionado + ", camReversa=" + camReversa + ", numBolsasAire=" + numBolsasAire + ", abs=" + abs
				+ ", is4x4=" + is4x4 + ", capacidadCarga=" + capacidadCarga + "]";
	}








}
