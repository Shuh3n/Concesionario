package model;

import java.io.Serializable;

public class Buses extends Vehiculo implements Serializable {

	private String numPasajeros;
	private String numPuertas;
	private String capacidadMaletero;
	private boolean aireAcondicionado;
	private boolean camReversa;
	private String numBolsasAire;
	private boolean abs;
	private String numEjes;
	private String numSalidadEmergencia;

	public Buses() {
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

	public String getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(String capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
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

	public String getNumEjes() {
		return numEjes;
	}

	public void setNumEjes(String numEjes) {
		this.numEjes = numEjes;
	}

	public String getNumSalidadEmergencia() {
		return numSalidadEmergencia;
	}

	public void setNumSalidadEmergencia(String numSalidadEmergencia) {
		this.numSalidadEmergencia = numSalidadEmergencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (abs ? 1231 : 1237);
		result = prime * result + (aireAcondicionado ? 1231 : 1237);
		result = prime * result + (camReversa ? 1231 : 1237);
		result = prime * result + ((capacidadMaletero == null) ? 0 : capacidadMaletero.hashCode());
		result = prime * result + ((numBolsasAire == null) ? 0 : numBolsasAire.hashCode());
		result = prime * result + ((numEjes == null) ? 0 : numEjes.hashCode());
		result = prime * result + ((numPasajeros == null) ? 0 : numPasajeros.hashCode());
		result = prime * result + ((numPuertas == null) ? 0 : numPuertas.hashCode());
		result = prime * result + ((numSalidadEmergencia == null) ? 0 : numSalidadEmergencia.hashCode());
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
		Buses other = (Buses) obj;
		if (abs != other.abs)
			return false;
		if (aireAcondicionado != other.aireAcondicionado)
			return false;
		if (camReversa != other.camReversa)
			return false;
		if (capacidadMaletero == null) {
			if (other.capacidadMaletero != null)
				return false;
		} else if (!capacidadMaletero.equals(other.capacidadMaletero))
			return false;
		if (numBolsasAire == null) {
			if (other.numBolsasAire != null)
				return false;
		} else if (!numBolsasAire.equals(other.numBolsasAire))
			return false;
		if (numEjes == null) {
			if (other.numEjes != null)
				return false;
		} else if (!numEjes.equals(other.numEjes))
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
		if (numSalidadEmergencia == null) {
			if (other.numSalidadEmergencia != null)
				return false;
		} else if (!numSalidadEmergencia.equals(other.numSalidadEmergencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ "Buses [numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", capacidadMaletero="
				+ capacidadMaletero + ", aireAcondicionado=" + aireAcondicionado + ", camReversa=" + camReversa
				+ ", numBolsasAire=" + numBolsasAire + ", abs=" + abs + ", numEjes=" + numEjes
				+ ", numSalidadEmergencia=" + numSalidadEmergencia + "]";
	}





}
