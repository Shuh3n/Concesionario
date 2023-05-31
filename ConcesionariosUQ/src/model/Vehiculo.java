package model;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private String marca;
	private String modelo;
	private String cambios;
	private String velocidadMax;
	private String cilindraje;
	private String capacidadMaletero;
	private String numBolsasAire;
	private boolean velocidadCrucero;
	private boolean abs;
	private String numPasajeros;
	private String numPuertas;
	private boolean aireAcondicionado;
	private boolean camReversa;
	private String hp;
	private String aceleracion;
	private boolean traccion;
	private String capacidadCarga;
	private String numEjes;
	private String salidasEmergencia;
	private boolean frenoAire;
	private boolean isEnchufable;
	private boolean isHibridoLigero;
	private String tiempoAproCarga;
	private String autonomia;
	private boolean asisCarril;
	private boolean sensColision;
	private boolean asistentePermanencia;
	private boolean sensTraficoCruzado;

	private TipoCamion tipoCamion;
	private TipoTransmision tipoTransmision;
	private TipoCombustible tipoCombustible;
	private Estado estado;
	private TipoVehiculo tipoVehiculo;
	private String precio;



	public Vehiculo() {
		super();
	}


	public Vehiculo(String marca,
	String modelo,
	String cambios,
	String velocidadMax,
	String cilindraje,
	String capacidadMaletero,
	String numBolsasAire,
	boolean velocidadCrucero,
	boolean abs,
	String numPasajeros,
	String numPuertas,
	boolean aireAcondicionado,
	boolean camReversa,
	String hp,
	String aceleracion,
	boolean traccion,
	String capacidadCarga,
	String numEjes,
	String salidasEmergencia,
	boolean frenoAire,
	boolean isEnchufable,
	boolean isHibridoLigero,
	String tiempoAproCarga,
	String autonomia,
	boolean sensColision,
	boolean asistentePermanencia,
	boolean sensTraficoCruzado,

	TipoVehiculo tipoVehiculo,
	TipoCamion tipoCamion,
	TipoTransmision tipoTransmision,
	TipoCombustible tipoCombustible,
	Estado estado,
	String precio
	) {

		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cambios = cambios;
		this.velocidadMax = velocidadMax;
		this.cilindraje = cilindraje;
		this.tipoTransmision = tipoTransmision;
		this.tipoCombustible = tipoCombustible;
		this.estado = estado;
		this.capacidadMaletero = capacidadMaletero;
		this.numBolsasAire = numBolsasAire;
		this.velocidadCrucero = velocidadCrucero;
		this.abs = abs;
		this.numPasajeros = numPasajeros;
		this.numPuertas = numPuertas;
		this.aireAcondicionado = aireAcondicionado;
		this.camReversa = camReversa;
		this.hp = hp;
		this.aceleracion = aceleracion;
		this.traccion = traccion;
		this.capacidadCarga = capacidadCarga;
		this.numEjes = numEjes;
		this.salidasEmergencia = salidasEmergencia;
		this.frenoAire = frenoAire;
		this.isEnchufable = isEnchufable;
		this.isHibridoLigero = isHibridoLigero;
		this.tiempoAproCarga = tiempoAproCarga;
		this.autonomia = autonomia;
		this.asistentePermanencia = asistentePermanencia;
		this.sensColision = sensColision;
		this.asistentePermanencia = asistentePermanencia;
		this.sensTraficoCruzado = sensTraficoCruzado;

		this.tipoVehiculo = tipoVehiculo;
		this.tipoCamion = tipoCamion;
		this.tipoTransmision = tipoTransmision;
		this.tipoCombustible = tipoCombustible;
		this.estado = estado;
		this.precio = precio;




	}




	public boolean isAsistentePermanencia() {
		return asistentePermanencia;
	}


	public void setAsistentePermanencia(boolean asistentePermanencia) {
		this.asistentePermanencia = asistentePermanencia;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCambios() {
		return cambios;
	}


	public void setCambios(String cambios) {
		this.cambios = cambios;
	}


	public String getVelocidadMax() {
		return velocidadMax;
	}


	public void setVelocidadMax(String velocidadMax) {
		this.velocidadMax = velocidadMax;
	}


	public String getCilindraje() {
		return cilindraje;
	}


	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}


	public String getCapacidadMaletero() {
		return capacidadMaletero;
	}


	public void setCapacidadMaletero(String capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}


	public String getNumBolsasAire() {
		return numBolsasAire;
	}


	public void setNumBolsasAire(String numBolsasAire) {
		this.numBolsasAire = numBolsasAire;
	}


	public boolean isVelocidadCrucero() {
		return velocidadCrucero;
	}


	public void setVelocidadCrucero(boolean velocidadCrucero) {
		this.velocidadCrucero = velocidadCrucero;
	}


	public boolean isAbs() {
		return abs;
	}


	public void setAbs(boolean abs) {
		this.abs = abs;
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


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getAceleracion() {
		return aceleracion;
	}


	public void setAceleracion(String aceleracion) {
		this.aceleracion = aceleracion;
	}


	public boolean isTraccion() {
		return traccion;
	}


	public void setTraccion(boolean traccion) {
		this.traccion = traccion;
	}


	public String getCapacidadCarga() {
		return capacidadCarga;
	}


	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}


	public String getNumEjes() {
		return numEjes;
	}


	public void setNumEjes(String numEjes) {
		this.numEjes = numEjes;
	}


	public String getSalidasEmergencia() {
		return salidasEmergencia;
	}


	public void setSalidasEmergencia(String salidasEmergencia) {
		this.salidasEmergencia = salidasEmergencia;
	}


	public boolean isFrenoAire() {
		return frenoAire;
	}


	public void setFrenoAire(boolean frenoAire) {
		this.frenoAire = frenoAire;
	}


	public boolean isEnchufable() {
		return isEnchufable;
	}


	public void setEnchufable(boolean isEnchufable) {
		this.isEnchufable = isEnchufable;
	}


	public boolean isHibridoLigero() {
		return isHibridoLigero;
	}


	public void setHibridoLigero(boolean isHibridoLigero) {
		this.isHibridoLigero = isHibridoLigero;
	}


	public String getTiempoAproCarga() {
		return tiempoAproCarga;
	}


	public void setTiempoAproCarga(String tiempoAproCarga) {
		this.tiempoAproCarga = tiempoAproCarga;
	}


	public String getAutonomia() {
		return autonomia;
	}


	public void setAutonomia(String autonomia) {
		this.autonomia = autonomia;
	}


	public boolean isAsisCarril() {
		return asisCarril;
	}


	public void setAsisCarril(boolean asisCarril) {
		this.asisCarril = asisCarril;
	}


	public boolean isSensColision() {
		return sensColision;
	}


	public void setSensColision(boolean sensColision) {
		this.sensColision = sensColision;
	}


	public boolean isSensTraficoCruzado() {
		return sensTraficoCruzado;
	}


	public void setSensTraficoCruzado(boolean sensTraficoCruzado) {
		this.sensTraficoCruzado = sensTraficoCruzado;
	}


	public TipoCamion getTipoCamion() {
		return tipoCamion;
	}


	public void setTipoCamion(TipoCamion tipoCamion) {
		this.tipoCamion = tipoCamion;
	}


	public TipoTransmision getTipoTransmision() {
		return tipoTransmision;
	}


	public void setTipoTransmision(TipoTransmision tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}


	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}


	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cambios == null) ? 0 : cambios.hashCode());
		result = prime * result + ((cilindraje == null) ? 0 : cilindraje.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((velocidadMax == null) ? 0 : velocidadMax.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (cambios == null) {
			if (other.cambios != null)
				return false;
		} else if (!cambios.equals(other.cambios))
			return false;
		if (cilindraje == null) {
			if (other.cilindraje != null)
				return false;
		} else if (!cilindraje.equals(other.cilindraje))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (velocidadMax == null) {
			if (other.velocidadMax != null)
				return false;
		} else if (!velocidadMax.equals(other.velocidadMax))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", cambios=" + cambios + ", velocidadMax="
				+ velocidadMax + ", cilindraje=" + cilindraje + ", capacidadMaletero=" + capacidadMaletero
				+ ", numBolsasAire=" + numBolsasAire + ", velocidadCrucero=" + velocidadCrucero + ", abs=" + abs
				+ ", numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", aireAcondicionado="
				+ aireAcondicionado + ", camReversa=" + camReversa + ", hp=" + hp + ", aceleracion=" + aceleracion
				+ ", traccion=" + traccion + ", capacidadCarga=" + capacidadCarga + ", numEjes=" + numEjes
				+ ", salidasEmergencia=" + salidasEmergencia + ", frenoAire=" + frenoAire + ", isEnchufable="
				+ isEnchufable + ", isHibridoLigero=" + isHibridoLigero + ", tiempoAproCarga=" + tiempoAproCarga
				+ ", autonomia=" + autonomia + ", asisCarril=" + asisCarril + ", sensColision=" + sensColision
				+ ", sensTraficoCruzado=" + sensTraficoCruzado + ", tipoCamion=" + tipoCamion + ", tipoTransmision="
				+ tipoTransmision + ", tipoCombustible=" + tipoCombustible + ", estado=" + estado + ", tipoVehiculo="
				+ tipoVehiculo + "]";
	}









}
