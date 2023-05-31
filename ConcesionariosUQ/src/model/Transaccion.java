package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class Transaccion {

	 private LocalDate fecha;
	 private String total;
	 private String codigoTransaccion;
	 private String codigoEmpleado;
	 private String marcaCoche;
	 private String modeloCoche;
	 private TipoTransacciones tipoTransaccion;
	 private List<DetalleTransaccion> listaDetalles = new ArrayList<>();
	 private Vehiculo car;

	public Transaccion() {
		super();
	}

	public Transaccion(LocalDate fecha, String total, String codigoTransaccion, String codigoEmpleado,
			String marcaCoche, String modeloCoche, TipoTransacciones tipoTransaccion, Vehiculo car) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.codigoTransaccion = codigoTransaccion;
		this.codigoEmpleado = codigoEmpleado;
		this.marcaCoche = marcaCoche;
		this.modeloCoche = modeloCoche;
		this.tipoTransaccion = tipoTransaccion;
		this.car = car;
	}

	public Vehiculo getCar() {
		return car;
	}

	public void setCar(Vehiculo car) {
		this.car = car;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getMarcaCoche() {
		return marcaCoche;
	}

	public void setMarcaCoche(String marcaCoche) {
		this.marcaCoche = marcaCoche;
	}

	public String getModeloCoche() {
		return modeloCoche;
	}

	public void setModeloCoche(String modeloCoche) {
		this.modeloCoche = modeloCoche;
	}

	public TipoTransacciones getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransacciones tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public List<DetalleTransaccion> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<DetalleTransaccion> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTransaccion == null) ? 0 : codigoTransaccion.hashCode());
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
		Transaccion other = (Transaccion) obj;
		if (codigoTransaccion == null) {
			if (other.codigoTransaccion != null)
				return false;
		} else if (!codigoTransaccion.equals(other.codigoTransaccion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaccion [fecha=" + fecha + ", total=" + total + ", codigoTransaccion=" + codigoTransaccion
				+ ", codigoEmpleado=" + codigoEmpleado + ", marcaCoche=" + marcaCoche + ", modeloCoche=" + modeloCoche
				+ ", tipoTransaccion=" + tipoTransaccion + ", listaDetalles=" + listaDetalles + "]";
	}









}
