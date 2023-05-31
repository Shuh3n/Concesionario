package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcesiorarioUQ implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Cliente> listaClientes = new ArrayList<>();
	private List<Vehiculo> listaVehiculos = new ArrayList<>();
	private List<Empleado> listaEmpleados = new ArrayList<>();
	private List<Administrador> listaAdministradores = new ArrayList<>();
	private List<Transaccion> listaDetalles = new ArrayList<>();

	public ConcesiorarioUQ() {
		super();
	}

	public ConcesiorarioUQ(String nombre, List<Cliente> listaClientes, List<Vehiculo> listaVehiculos,
			List<Empleado> listaEmpleados, List<Administrador> listaAdministradores, List<Transaccion> listaDetalles) {
		super();
		this.nombre = nombre;
		this.listaClientes = listaClientes;
		this.listaVehiculos = listaVehiculos;
		this.listaEmpleados = listaEmpleados;
		this.listaDetalles = listaDetalles;
		this.setListaAdministradores(listaAdministradores);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public List<Transaccion> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<Transaccion> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	/**
	 * Recibe los parametros para crear un cliente
	 * @param nombre
	 * @param apellido
	 * @param identificacion
	 * @return
	 */
	public boolean crearCliente(String nombre, String apellido, String identificacion, LocalDate fechaNacimiento){
		boolean flag = false;
		if(!verificarCliente(identificacion)){
			Cliente cliente = new Cliente(nombre, apellido, identificacion, fechaNacimiento);
			listaClientes.add(cliente);
			flag = true;
		}
		return flag;
	}

	/**
	 * Vefirica si el cliente existe
	 * @param identificacion
	 * @return retorna true si existe, false lo contrario.
	 */
	public boolean verificarCliente(String identificacion){
		boolean flag = false;
		for (Cliente cliente : listaClientes) {
			if(cliente.getIdentificacion().equals(identificacion)){
				flag = true;
			}
		}
		return flag;
	}



	public boolean eliminarCliente(Cliente clienteSeleccion) {

		for (Cliente cliente : listaClientes) {
			if(cliente.getIdentificacion().equals(clienteSeleccion.getIdentificacion())){
				listaClientes.remove(cliente);
				return true;
			}

		}
		return false;
	}

	public boolean crearVehiculo(Vehiculo coche) {

		for (Vehiculo vehiculo : listaVehiculos) {
			if(vehiculo.equals(coche)){
				return false;
			}
		}
		listaVehiculos.add(coche);
		return true;
	}

	public boolean crearEmpleado(Empleado empleado) {

		for (Empleado emple: listaEmpleados) {
			if(emple.equals(empleado)){
				return false;
			}
		}
		listaEmpleados.add(empleado);
		return true;
	}

	public boolean eliminarEmpleado(Empleado empleadoSeleccion) {
		for (Empleado empleado: listaEmpleados){
			if(empleado.equals(empleadoSeleccion)){
				listaEmpleados.remove(empleado);
				return true;
			}

		}
		return false;
	}

	public boolean verificarAdmin(String password) {
		for (Administrador administrador : listaAdministradores) {
			if(administrador.getCredencial().equals(password)){
				return true;
			}
		}
		return false;
	}

	public boolean verificarEmpleado(String name, String password) {
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getNombre().equals(name) && empleado.getIdentificacion().equals(password)){
				return true;
			}
		}
		return false;
	}

	public String crearFactura(Transaccion transaccion) {

		for (Transaccion trans : listaDetalles) {
			if(trans.equals(transaccion)){
				return "2";
			}
		}
		if(verificarIDEmpleado(transaccion.getCodigoEmpleado())){
			listaDetalles.add(transaccion);
			return "0";
		}
		return "1";


	}

	public boolean eliminarDetalle(Transaccion transaccionSeleccion) {
		for (Transaccion detalle : listaDetalles) {
			if(detalle.equals(transaccionSeleccion)){
				listaDetalles.remove(detalle);
				return true;
			}
		}
		return false;
	}
	public boolean verificarIDEmpleado(String id){
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getIdentificacion().equals(id)){
				return true;
			}
		}
		return false;
	}

	public String actualizarDetalle(Transaccion transaccion) {
		String flag= "2";
		for (Transaccion detalle : listaDetalles) {
			if(detalle.equals(transaccion)){
				if(verificarIDEmpleado(transaccion.getCodigoEmpleado())){
					listaDetalles.remove(detalle);
					listaDetalles.add(transaccion);
					return "0";
				}
			}
		}
		return flag;
	}

	public void devolverAlquileres() {
		List<Transaccion> aux = getListaDetalles().stream()
				.filter(a -> a.getTipoTransaccion()== TipoTransacciones.ALQUILER)
				.collect(Collectors.toList());
		for (Transaccion transaccion : aux) {
			if(transaccion.getFecha().equals(LocalDate.now())){
				listaDetalles.remove(transaccion);
				listaVehiculos.add(transaccion.getCar());

			}

		}
	}

	public List<Transaccion> getListaDetallesFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
		List<Transaccion> transaccionesFiltradas = listaDetalles.stream()
                .filter(transaccion -> transaccion.getFecha().isAfter(fechaInicial) && transaccion.getFecha().isBefore(fechaFinal))
                .collect(Collectors.toList());
		return transaccionesFiltradas;
	}

	public boolean cambiarContra(String nuevaContra, String id) {
		Administrador admin = verificarIDAdmin(id);
		if(admin!=null){
			admin.setCredencial(nuevaContra);
			return true;
		}
		else{
			return false;
		}

	}

	private Administrador verificarIDAdmin(String id) {
		for (Administrador administrador : listaAdministradores) {
			if(administrador.getIdentificacion().equals(id)){
				return administrador;
			}
		}
		return null;
	}
}










