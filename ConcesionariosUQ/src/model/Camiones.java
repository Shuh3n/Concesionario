package model;

import java.io.Serializable;

public class Camiones extends Vehiculo implements Serializable{

	private String capacidadCarga;
	private boolean aireAcondicionado;
	private boolean abs;
	private boolean frenoAire;
	private String numEjes;
	private TipoCamion tipoCamion;

	public Camiones() {
		super();
	}



	public String getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isAbs() {
		return abs;
	}

	public void setAbs(boolean abs) {
		this.abs = abs;
	}

	public boolean isFrenoAire() {
		return frenoAire;
	}

	public void setFrenoAire(boolean frenoAire) {
		this.frenoAire = frenoAire;
	}

	public String getNumEjes() {
		return numEjes;
	}

	public void setNumEjes(String numEjes) {
		this.numEjes = numEjes;
	}

	public TipoCamion getTipocamion() {
		return tipoCamion;
	}

	public void setTipocamion(TipoCamion tipocamion) {
		tipoCamion = tipocamion;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (abs ? 1231 : 1237);
		result = prime * result + (aireAcondicionado ? 1231 : 1237);
		result = prime * result + ((capacidadCarga == null) ? 0 : capacidadCarga.hashCode());
		result = prime * result + (frenoAire ? 1231 : 1237);
		result = prime * result + ((numEjes == null) ? 0 : numEjes.hashCode());
		result = prime * result + ((tipoCamion == null) ? 0 : tipoCamion.hashCode());
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
		Camiones other = (Camiones) obj;
		if (abs != other.abs)
			return false;
		if (aireAcondicionado != other.aireAcondicionado)
			return false;
		if (capacidadCarga == null) {
			if (other.capacidadCarga != null)
				return false;
		} else if (!capacidadCarga.equals(other.capacidadCarga))
			return false;
		if (frenoAire != other.frenoAire)
			return false;
		if (numEjes == null) {
			if (other.numEjes != null)
				return false;
		} else if (!numEjes.equals(other.numEjes))
			return false;
		if (tipoCamion != other.tipoCamion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Camiones [capacidadCarga=" + capacidadCarga + ", aireAcondicionado=" + aireAcondicionado + ", abs="
				+ abs + ", frenoAire=" + frenoAire + ", numEjes=" + numEjes + ", tipoCamion=" + tipoCamion + "]";
	}









}
