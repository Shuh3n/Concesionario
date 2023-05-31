package controllers;

import java.time.LocalDate;
import java.util.List;

import model.Administrador;
import model.Buses;
import model.Camiones;
import model.Cliente;
import model.ConcesiorarioUQ;
import model.Deportivo;
import model.Empleado;
import model.Estado;
import model.Motos;
import model.Pickups;
import model.Sedan;
import model.Suv;
import model.TipoCamion;
import model.TipoCombustible;
import model.TipoTransacciones;
import model.TipoTransmision;
import model.TipoVehiculo;
import model.Transaccion;
import model.Vans;
import model.Vehiculo;



public class Singleton {

	ConcesiorarioUQ concesionario = null;

	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser
		// protected
		private final static Singleton eINSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public Singleton(){
			inicializarDatos();
		}

	private void inicializarDatos() {
		concesionario = new ConcesiorarioUQ();

		Administrador admin = new Administrador("Santiago", "Orozco", "1021804899", "899");
		concesionario.getListaAdministradores().add(admin);

		Cliente cliente = new Cliente("Miguel", "Florez", "1094883917", LocalDate.of(2004, 10, 1));
		concesionario.getListaClientes().add(cliente);

		Empleado empleado = new Empleado("Pepe", "Grillo", "804");
		concesionario.getListaEmpleados().add(empleado);

		Vehiculo car = new Vehiculo("Mt-09", "2024", "6", "210","900", "0", null, false,
				false, null, null, false, false, null, null, false, null, null, null, false,
				false, false, null, null, false, false, false, TipoVehiculo.MOTO, null, TipoTransmision.MANUAL, TipoCombustible.GASOLINA,
				Estado.NUEVO, "50000");
		concesionario.getListaVehiculos().add(car);
	}

	public ConcesiorarioUQ getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(ConcesiorarioUQ concesionario) {
		this.concesionario = concesionario;
	}







	/**
	 * Como su nombre indica verifica la existencia del admin
	 * @param password
	 * @return
	 */
	public boolean verificarAdmin(String password) {
		return concesionario.verificarAdmin(password);
	}

	/**
	 * Verificar la existencia del empleado
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean verificarEmpleado(String name, String password) {
		return concesionario.verificarEmpleado(name,password);
	}

	/**
	 * Lo que hace es crear el cliente
	 * @param nombre
	 * @param apellidos
	 * @param cedula
	 * @param fechaNacimiento
	 * @return
	 */
	public boolean crearCliente(String nombre, String apellidos, String cedula, LocalDate fechaNacimiento) {
		boolean flag = concesionario.crearCliente(nombre, apellidos, cedula, fechaNacimiento);
		return flag;
	}


	public List<Cliente> getListaClientes() {
		List<Cliente> listaClientes = concesionario.getListaClientes();

		return listaClientes;
	}

	/**
	 * Elimina el cliente enviado
	 * @param clienteSeleccion
	 * @return
	 */
	public boolean eliminarCliente(Cliente clienteSeleccion) {
		boolean flag = concesionario.eliminarCliente(clienteSeleccion);
		return flag;
	}


	//Funciones de crear vehiculos//

	public boolean crearBus(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			boolean aireAcon, boolean camReversa, boolean abs, String numPasajeros, String numPuertas, String capacidadMaletero,
			String bolsasAire, String numEjes,String salidasEmergencia, TipoCombustible combustible,
			TipoTransmision transmision, Estado estado, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga,
			String autonomia, String precio){

		Vehiculo bus = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, capacidadMaletero, bolsasAire,
				false, abs, numPasajeros, numPuertas, false, camReversa, null, null, false,
				null, numEjes, salidasEmergencia, false, isEnchufable, isHibridoLigero, tiempoCarga, autonomia,
				false, false, false, TipoVehiculo.BUS, null, transmision, combustible,
				estado, precio);

		boolean flag = concesionario.crearVehiculo(bus);
		return flag;
	}

	public boolean crearCamion(String marca, String modelo, String cambios, String velocidadMax,
			String cilindraje, TipoCombustible combustible, TipoTransmision transmision, Estado estado,
			boolean absCa, boolean aireAcon, String capacidadCarga, TipoCamion tipoCamion, boolean frenoAire,
			String numEjes, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo Camion = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, null, null,
				false, absCa, null, null, aireAcon, false, null, null, false,
				capacidadCarga, numEjes, null, frenoAire, isEnchufable, isHibridoLigero, tiempoCarga, autonomia,
				false, false, false, TipoVehiculo.CAMION, tipoCamion, transmision, combustible,
				estado, precio);

		boolean flag = concesionario.crearVehiculo(Camion);
		return flag;
	}

	public boolean crearDeportivo(String marca, String modelo, String cambios, String velocidadMax,
			String cilindraje, TipoCombustible combustible, TipoTransmision transmision, Estado estado,
			String numPasajerosDe, String numPuertasDe, String numBolsasAire, String hp, String aceleracion, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo deportivo = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, null,
				numBolsasAire, false, false, numPasajerosDe, numPuertasDe, false, false, hp,
				aceleracion, false, null, null, null, false, isEnchufable, isHibridoLigero,
				tiempoCarga, autonomia, false, false, false, TipoVehiculo.DEPORTIVO, null,
				transmision, combustible, estado, precio);
		boolean flag = concesionario.crearVehiculo(deportivo);
		return flag;
	}

	public boolean crearMoto(String marcaCa, String modeloCa, String cambiosCa, String velocidadMaxCa,
			String cilindrajeCa, TipoCombustible combustibleCa, TipoTransmision transmisionCa, Estado estadoCa, boolean isEnchufable,
			boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo moto = new Vehiculo(marcaCa, modeloCa, cambiosCa, velocidadMaxCa, cilindrajeCa, null, null, false, false, null,
				null, false, false, null, null, false, null, null, null, false, isEnchufable, isHibridoLigero, tiempoCarga, autonomia,
				false, false, false, TipoVehiculo.MOTO, null, transmisionCa, combustibleCa, estadoCa, precio);
		boolean flag = concesionario.crearVehiculo(moto);
		return flag;
	}

	public boolean crearPick(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasa, boolean absPic,
			boolean aire, boolean camRe, String bolsas, boolean cuatrox4, String capacidadCar, String numPuert, boolean isEnchufable,
			boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo pick = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, null, bolsas, false,
				absPic, numPasa, numPuert, aire, camRe, null, null, cuatrox4, capacidadCar, null, null,
				false, isEnchufable, isHibridoLigero, tiempoCarga, autonomia,false, false, false, TipoVehiculo.PICKUP, null,
				transmision, combustible, estado, precio);
		boolean flag = concesionario.crearVehiculo(pick);
		return flag;
	}

	public boolean crearSedan(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasaSe,
			String numPuertSe, String capacidadMaleteroSe, String numBolsasAireSe, boolean aireSe, boolean camSe,
			boolean velocidadCrucer, boolean absSe, boolean sensorColi, boolean sensorTrafi, boolean asisCarril,
			boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo sedan = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, capacidadMaleteroSe, numBolsasAireSe,
				velocidadCrucer, absSe, numPasaSe, numPuertSe, aireSe, camSe, null, null, false, null, null,
				null, false, isEnchufable, isHibridoLigero, tiempoCarga, autonomia, asisCarril, sensorColi,
				sensorTrafi, TipoVehiculo.SEDAN, null, transmision, combustible, estado, precio);

		boolean flag = concesionario.crearVehiculo(sedan);
		return flag;
	}

	public boolean crearSuv(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasaSv,
			String numPuertSv, String capacidadMaleteroSv, String numBolsasAireSv, boolean aireSv, boolean camSv,
			boolean velocidadCrucerSv, boolean absSv, boolean sensorColiSv, boolean sensorTrafiSv, boolean asisCarrilSv,
			boolean traccionSv, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo suv = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, capacidadMaleteroSv, numBolsasAireSv, velocidadCrucerSv,
				absSv, numPasaSv, numPuertSv, aireSv, camSv, null, null, false, null, null, null, false, isEnchufable, isHibridoLigero, tiempoCarga,
				autonomia, asisCarrilSv, false, false, TipoVehiculo.SUV, null, transmision, combustible, estado, precio);
		boolean flag = concesionario.crearVehiculo(suv);
		return flag;
	}

	public boolean crearVan(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasajerosVan,
			String numPuertasVan, String capMaleteroVan, boolean aireAcVan, boolean camVan, String numBolsasAireVan,
			boolean absVan, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		Vehiculo van = new Vehiculo(marca, modelo, cambios, velocidadMax, cilindraje, capMaleteroVan, numBolsasAireVan,
				false, absVan, numPasajerosVan,
				numPuertasVan, aireAcVan, camVan, null, null, false, null, null, null, false,
				isEnchufable, isHibridoLigero, tiempoCarga, autonomia, false, false, false, TipoVehiculo.VAN, null ,
				transmision, combustible, estado, precio);

		boolean flag = concesionario.crearVehiculo(van);
		return flag;
	}




	/**
	 * Crea un empleado recibiendo atributos y verifica si existe antes de agregarlo
	 * @param name
	 * @param apellidos
	 * @param id
	 * @return
	 */
	public boolean crearEmpleado(String name, String apellidos, String id) {
		Empleado empleado = new Empleado(name, apellidos, id);
		boolean flag = concesionario.crearEmpleado(empleado);
		return flag;
	}

	public List<Empleado> getListaEmpleados() {
		return concesionario.getListaEmpleados();
	}

	public List<Vehiculo> getlistaVehiculos() {
		System.out.println(concesionario.getListaVehiculos());

		return concesionario.getListaVehiculos();

	}

	public List<Transaccion> getListaDetalles(LocalDate fechaInicial, LocalDate fechaFinal) {
		return concesionario.getListaDetallesFecha(fechaInicial, fechaFinal);
	}

	/**
	 * Eliminar empleado enviado
	 * @param empleadoSeleccion
	 * @return
	 */
	public boolean eliminarEmpleado(Empleado empleadoSeleccion) {
		boolean flag = concesionario.eliminarEmpleado(empleadoSeleccion);
		return flag;
	}

	/**
	 * crea la factura recibiendo los atributos de la misma
	 * @param marca
	 * @param modelo
	 * @param codigo
	 * @param codigoEmpleado
	 * @param tipotransaccion
	 * @param valor
	 * @param fecha
	 * @param car
	 * @return
	 */
	public String crearFactura(String marca, String modelo, String codigo, String codigoEmpleado,
			TipoTransacciones tipotransaccion, String valor, LocalDate fecha, Vehiculo car) {

		Transaccion transaccion = new Transaccion(fecha, valor, codigo, codigoEmpleado, marca, modelo, tipotransaccion, car);
		return concesionario.crearFactura(transaccion);
	}

	/**
	 * Eliminar una transacci�n seleccionado
	 * @param transaccionSeleccion
	 * @return
	 */
	public boolean eliminarDetalle(Transaccion transaccionSeleccion) {
		return concesionario.eliminarDetalle(transaccionSeleccion);
	}

	/**
	 * Actualiza los datos de una factura
	 * @param marca
	 * @param modelo
	 * @param codigo
	 * @param codigoEmpleado
	 * @param tipotransaccion
	 * @param valor
	 * @param fecha
	 * @param car
	 * @return
	 */
	public String actualizarFactura(String marca, String modelo, String codigo, String codigoEmpleado,
			TipoTransacciones tipotransaccion, String valor, LocalDate fecha, Vehiculo car) {
		Transaccion transaccion = new Transaccion(fecha, valor, codigo, codigoEmpleado, marca, modelo, tipotransaccion, car);
		return concesionario.actualizarDetalle(transaccion);
	}



	public void devolverAlquileres() {
		concesionario.devolverAlquileres();
	}


	public boolean cambiarContra(String nuevaContra, String id) {
		return concesionario.cambiarContra(nuevaContra, id);
	}

}