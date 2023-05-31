package model;

public class DetalleTransaccion {
	 private String codigo;
	 private double subtotal;
	 private int cantidad;

	public DetalleTransaccion() {
		super();
	}
	public DetalleTransaccion(String codigo, double subtotal, int cantidad) {
		super();
		this.codigo = codigo;
		this.subtotal = subtotal;
		this.cantidad = cantidad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		DetalleTransaccion other = (DetalleTransaccion) obj;
		if (cantidad != other.cantidad)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleTransaccion [codigo=" + codigo + ", subtotal=" + subtotal + ", cantidad=" + cantidad + "]";
	}





}
