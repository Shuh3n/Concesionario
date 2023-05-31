package controllers;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Cliente;
import model.Estado;
import model.TipoCamion;
import model.TipoCombustible;
import model.TipoTransmision;
import model.TipoVehiculo;
import model.Vehiculo;

public class EmpleadoViewController implements Initializable {

	Singleton singleton = Singleton.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSalidasEmergencia;

    @FXML
    private TextField txtHp;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private Button btnSubirFoto;

    @FXML
    private TextField txtCedulaClientes;

    @FXML
    private TextField txtPrecio;

    @FXML
    private CheckBox checkVelocidadCrucero;



    @FXML
    private TextField txtAutonomia;

    @FXML
    private CheckBox checkCamReversa;

    @FXML
    private CheckBox checkFrenoAire;

    @FXML
    private CheckBox checkTraccionTotal;

    @FXML
    private CheckBox checkSensorTraficoCruzado;

    @FXML
    private CheckBox checkAbs;

    @FXML
    private CheckBox checkEnchufable;

    @FXML
    private TableColumn<Cliente, String> columnNombresClientes;

    @FXML
    private ComboBox<TipoTransmision> comboBoxTransmision;

    @FXML
    private CheckBox checkHibridoLigero;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVans;

    @FXML
    private TableColumn<Vehiculo,String> columnModelo;

    @FXML
    private TableColumn<Vehiculo, TipoCombustible> columnCombustible;

    @FXML
    private TableColumn<Vehiculo, Estado> columnEstado;

    @FXML
    private TableColumn<Vehiculo, TipoVehiculo> columnTipo;

    @FXML
    private TableColumn<Vehiculo, String> columnAireAcondicionado;

    @FXML
    private TableColumn<Vehiculo, String> columnAbs;

    @FXML
    private TableColumn<Vehiculo, String> columnAutonomia;

    @FXML
    private TableColumn<Vehiculo, String> columnCapacidadMaletero;

    @FXML
    private TableColumn<Vehiculo, String> columnVelocidadMax;

    @FXML
    private TableColumn<Vehiculo, String> columnPrecio;


    @FXML
    private TableColumn<Vehiculo, String> columnCilindraje;

    @FXML
    private TableColumn<Vehiculo, String> columnTiempoCarga;

    @FXML
    private TableColumn<Vehiculo, String> columnCamaraReversa;

    @FXML
    private TableColumn<Vehiculo, String> columnTransmision;

    @FXML
    private TableView<Vehiculo> tableViewVehiculos;

    @FXML
    private TableColumn<Vehiculo, String> columnCambios;

    @FXML
    private TableColumn<Vehiculo, String> columnMarca;

    @FXML
    private ComboBox<TipoCamion> comboBoxTipoCamion;

    @FXML
    private TextField txtTiempoCarga;

    @FXML
    private Button btnLimpiarCliente;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private CheckBox checkAsisCarril;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private TextField txtNombresClientes;

    @FXML
    private ComboBox<TipoCombustible> comboBoxCombustible;

    @FXML
    private TextField txtAceleracion;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumCambios;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TextField txtApellidosClientes;

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TextField txtCapacidadCarga;

    @FXML
    private DatePicker dateNacimientoClientes;

    @FXML
    private CheckBox checkSensorColision;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnAlquilar;

    @FXML
    private TextField txtNumPuertas;

    @FXML
    private TextField txtMarcaVehiculo;

    @FXML
    private CheckBox checkAireAcondicionado;

    @FXML
    private ComboBox<Estado> comboBoxEstadoVehiculo;

    @FXML
    private ComboBox<TipoVehiculo> comboBoxTipoVehiculo;

    @FXML
    private TextField txtNumEjes;

    @FXML
    private TextField txtCapacidadMaletero;

    @FXML
    private TextField txtNumBolsasAire;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TableColumn<Cliente, String> columnApellidosClientes;

	private Aplicacion aplicacion;

	private PrincipalViewController ventanaPrincipalController;

	private ImageView imageView;

	private Stage stage;

	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();

	private Cliente clienteSeleccion;

	private Vehiculo vehiculoSeleccion;

	private Window primaryStage;


    @FXML
    void mostrarVentanaPrincipal(ActionEvent event) {
    	ventanaPrincipalController.show();
    	this.stage.close();

    }


    @FXML
    void actualizarInfoCliente(ActionEvent event) {
    	if(clienteSeleccion==null){
    		mostrarMensaje("Cliente seleccion", "Cliente Seleccion", "No se ha seleccionado ningun Cliente", AlertType.WARNING);
    	}
    	else{
    		String nombre = txtNombresClientes.getText();
        	String apellido = txtApellidosClientes.getText();
        	String cedula = txtCedulaClientes.getText();
        	LocalDate fechaNacimiento = dateNacimientoClientes.getValue();

        	if(validarDatos(nombre, apellido, cedula, fechaNacimiento)){
        		clienteSeleccion.setNombre(nombre);
        		clienteSeleccion.setApellidos(apellido);
        		clienteSeleccion.setIdentificacion(cedula);
        		clienteSeleccion.setFechaNacimiento(fechaNacimiento);

        		limpiarCamposCliente(event);
        		tableViewClientes.getItems().clear();
        		tableViewClientes.setItems(getClientes());
        		clienteSeleccion = null;
        		txtCedulaClientes.setDisable(false);

        		mostrarMensaje("Actualizaci�n", "Cliente Actualizado con �xito"
        				, "La informaci�n del cliente fue actualizada con �xito"
        				, AlertType.INFORMATION);
        	}




    	}

    }

    @FXML
    void agregarCliente(ActionEvent event) {
    	String nombre = txtNombresClientes.getText();
    	String apellidos = txtApellidosClientes.getText();
    	String cedula = txtCedulaClientes.getText();
    	LocalDate fechaNacimiento = dateNacimientoClientes.getValue();

    	if(validarDatos(nombre, apellidos, cedula, fechaNacimiento)){
    		crearCliente(nombre, apellidos, cedula, fechaNacimiento);
    		limpiarCamposCliente(event);

    		tableViewClientes.getItems().clear();
    		tableViewClientes.setItems(getClientes());
    	}



    }

    private void crearCliente(String nombre, String apellidos, String cedula, LocalDate fechaNacimiento) {
    	boolean resultado = singleton.crearCliente(nombre,apellidos,cedula, fechaNacimiento);
    	if(resultado==true){
    		mostrarMensaje("Informaci�n Cliente", "Cliente creado", "El cliente se ha creado con �xito", AlertType.INFORMATION);
    	}
    	else{
    		mostrarMensaje("Informaci�n Cliente", "Cliente no creado", "El cliente no ha sido creado", AlertType.INFORMATION);

    	}
	}



    private ObservableList<Cliente> getClientes() {
    	listaClientes.clear();
    	listaClientes.addAll(singleton.getListaClientes());
		return listaClientes;
	}

    private ObservableList<Vehiculo> getCoches() {
    	listaVehiculos.clear();
    	listaVehiculos.addAll(singleton.getlistaVehiculos());
    	return listaVehiculos;
    }

	private boolean validarDatos(String nombre, String apellidos, String cedula, LocalDate fechaNacimiento) {
		String notificacion = "";

		/*Se valida que el saldo ingresado no sea null ni sea cadena vac�a,
		adem�s se valida que sea num�rico para su correcta conversi�n */


		if (nombre == null || nombre.equals("")) {
			notificacion += "Ingrese su nombre\n";
		}

		if (apellidos == null || apellidos.equals("")) {
			notificacion += "Ingrese sus apellidos\n";
		}
		if (cedula == null || cedula.equals("")) {
			notificacion += "Ingrese una c�dula\n";
		}
		else {
			if(!esNumero(cedula)){
				notificacion += "La c�dula ingresada debe ser num�rica\n";
			}
		}

		if (fechaNacimiento == null || fechaNacimiento.equals("")) {
			notificacion += "Seleccione una fecha de nacimiento\n";
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Cliente no creado", notificacion, AlertType.WARNING);
			return false;
		}

		return true;
	}

	private boolean esNumero(String string) {

		try {

			Float.parseFloat(string);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

    @FXML
    void limpiarCamposCliente(ActionEvent event) {
    	txtNombresClientes.clear();
    	txtApellidosClientes.clear();
    	txtCedulaClientes.clear();
    	dateNacimientoClientes.setValue(null);

    }

    @FXML
    void eliminarClienteSeleccionado(ActionEvent event) {
    	if(clienteSeleccion!=null){
    		int confirmacion= JOptionPane.showConfirmDialog(null, "�Seguro que desea eliminar este cliente?");

    		if(confirmacion==0){

	    		if(singleton.eliminarCliente(clienteSeleccion)){
	    			listaClientes.remove(clienteSeleccion);
	    			limpiarCamposCliente(event);
	    			mostrarMensaje("Cliente eliminado", "Eliminacion de Cliente", "Se ha eliminado el Cliente con exito", AlertType.INFORMATION);
	    		}
	    		else{
	    			mostrarMensaje("Cliente eliminado", "Eliminacion de Cliente", "No se ha podido eliminar el Cliente", AlertType.WARNING);
	    		}
    		}
    	}
    	else{
    		mostrarMensaje("Cliente seleccion", "Cliente Seleccion", "No se ha seleccionado ningun Cliente", AlertType.WARNING);
    	}
    }















	@FXML
	void vehiculoSeleccionado(ActionEvent event) {
		TipoVehiculo car = comboBoxTipoVehiculo.getValue();
		if(car!=null)
			determinarVehiculos(car);

	}

    public void determinarElectrico(TipoCombustible car){
    	if(car!=null){
	    	switch (car) {
			case ELECTRICO:
				checkEnchufable.setDisable(true);
				checkHibridoLigero.setDisable(true);
				txtAutonomia.setDisable(false);
				txtTiempoCarga.setDisable(false);
				break;

			case HIBRIDO:

				checkEnchufable.setDisable(false);
				checkHibridoLigero.setDisable(false);
				txtAutonomia.setDisable(true);
				txtTiempoCarga.setDisable(true);
				break;

			default:
				checkEnchufable.setDisable(true);
				checkHibridoLigero.setDisable(true);
				txtAutonomia.setDisable(true);
				txtTiempoCarga.setDisable(true);
				break;
			}
    	}

    }

	@FXML
	void tipoCombustibleSeleccionado(ActionEvent event) {
		TipoCombustible combustible = comboBoxCombustible.getValue();
		determinarElectrico(combustible);
	}

	public void determinarVehiculos(TipoVehiculo car){
		switch (car) {
		case BUS:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			txtCapacidadMaletero.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			checkCamReversa.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			checkAbs.setDisable(false);
			txtNumEjes.setDisable(false);
			txtSalidasEmergencia.setDisable(false);
			break;

		case CAMION:
			desabilitarTodo();
			checkAbs.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			txtCapacidadCarga.setDisable(false);
			comboBoxTipoCamion.setDisable(false);
			checkFrenoAire.setDisable(false);
			txtNumEjes.setDisable(false);
			break;

		case DEPORTIVO:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			txtHp.setDisable(false);
			txtAceleracion.setDisable(false);
			break;

		case MOTO:
			desabilitarTodo();
			break;

		case PICKUP:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			checkAbs.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			checkCamReversa.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			checkTraccionTotal.setDisable(false);
			txtCapacidadCarga.setDisable(false);
			break;

		case SEDAN:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			txtCapacidadMaletero.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			checkCamReversa.setDisable(false);
			checkVelocidadCrucero.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			checkAbs.setDisable(false);
			checkSensorColision.setDisable(false);
			checkSensorTraficoCruzado.setDisable(false);
			checkAsisCarril.setDisable(false);
			break;

		case SUV:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			txtCapacidadMaletero.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			checkCamReversa.setDisable(false);
			checkVelocidadCrucero.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			checkAbs.setDisable(false);
			checkSensorColision.setDisable(false);
			checkSensorTraficoCruzado.setDisable(false);
			checkAsisCarril.setDisable(false);
			checkTraccionTotal.setDisable(false);
			break;

		case VAN:
			desabilitarTodo();
			txtNumPasajeros.setDisable(false);
			txtNumPuertas.setDisable(false);
			txtCapacidadMaletero.setDisable(false);
			checkAireAcondicionado.setDisable(false);
			checkCamReversa.setDisable(false);
			txtNumBolsasAire.setDisable(false);
			checkAbs.setDisable(false);
			break;
		}
	}


	public void desabilitarTodo(){
		txtCapacidadMaletero.setDisable(true);
		txtNumBolsasAire.setDisable(true);
		checkVelocidadCrucero.setDisable(true);
		checkAbs.setDisable(true);
		txtNumPasajeros.setDisable(true);
		txtNumPuertas.setDisable(true);
		checkAireAcondicionado.setDisable(true);
		checkCamReversa.setDisable(true);
		txtHp.setDisable(true);
		txtAceleracion.setDisable(true);
		checkTraccionTotal.setDisable(true);
		txtCapacidadCarga.setDisable(true);
		txtNumEjes.setDisable(true);
		txtSalidasEmergencia.setDisable(true);
		comboBoxTipoCamion.setDisable(true);
		checkFrenoAire.setDisable(true);
		checkAsisCarril.setDisable(true);
		checkSensorColision.setDisable(true);
		checkSensorTraficoCruzado.setDisable(true);
		checkHibridoLigero.setDisable(true);
	}

	@FXML
	void registrarVehiculo(ActionEvent event) {
		TipoVehiculo car = comboBoxTipoVehiculo.getValue();
		if (car != null) {
			switch (car) {
			case BUS:
				String numPasajeros = txtNumPasajeros.getText();
				String numPuertas = txtNumPuertas.getText();
				String capacidadMaletero = txtCapacidadMaletero.getText();
				boolean aireAcon = checkAireAcondicionado.isSelected();
				boolean camReversa = checkCamReversa.isSelected();
				String bolsasAire = txtNumBolsasAire.getText();
				boolean abs = checkAbs.isSelected();
				String numEjes = txtNumEjes.getText();
				String salidasEmergencia = txtSalidasEmergencia.getText();


				if (getDatosValidosCoches()) {
					if (validarDatos(numPasajeros, numPuertas, capacidadMaletero, bolsasAire, numEjes,
							salidasEmergencia)) {
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearBus(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasajeros, numPuertas, capacidadMaletero, aireAcon, camReversa,bolsasAire,abs,numEjes,salidasEmergencia,
									isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearBus(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
											numPasajeros, numPuertas, capacidadMaletero, aireAcon, camReversa,bolsasAire,abs,numEjes,salidasEmergencia,
											false, false, tiempoCarga, autonomia, precio);
							}
							}
							else {
								crearBus(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
										numPasajeros, numPuertas, capacidadMaletero, aireAcon, camReversa,bolsasAire,abs,numEjes,salidasEmergencia,
										false, false, null, null, precio);

							}

						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);
					}
				}
				break;
			case CAMION:
				boolean absCa = checkAbs.isSelected();
				boolean aireAconCa = checkAireAcondicionado.isSelected();
				String capacidadCarga = txtCapacidadCarga.getText();
				TipoCamion tipoCamion= comboBoxTipoCamion.getValue();
				boolean frenoAire = checkFrenoAire.isSelected();
				String numEjesCa = txtNumEjes.getText();

				if(getDatosValidosCoches()){
					if(validarDatos(capacidadCarga, tipoCamion, numEjesCa)){
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearCamion(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									absCa, aireAconCa, capacidadCarga, tipoCamion, frenoAire, numEjesCa,
									isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearCamion(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
											absCa, aireAconCa, capacidadCarga, tipoCamion, frenoAire, numEjesCa,
											false, false, tiempoCarga, autonomia, precio);
							}
							}
							else {
								crearCamion(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
										absCa, aireAconCa, capacidadCarga, tipoCamion, frenoAire, numEjesCa,
										false, false, null, null, precio);

							}

						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);
					}
				}
				break;
			case DEPORTIVO:
				String numPasajerosDe = txtNumPasajeros.getText();
				String numPuertasDe = txtNumPuertas.getText();
				String numBolsasAire = txtNumBolsasAire.getText();
				String hp = txtHp.getText();
				String aceleracion = txtAceleracion.getText();

				if(getDatosValidosCoches()){
					if(validarDatos(numPasajerosDe, numPuertasDe, numBolsasAire, hp, aceleracion)){
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearDeportivo(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasajerosDe, numPuertasDe, numBolsasAire, hp, aceleracion, isEnchufable, isHibridoLigero,
									null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearDeportivo(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
											numPasajerosDe, numPuertasDe, numBolsasAire, hp, aceleracion, false, false,
											tiempoCarga, autonomia, precio);
								}
							}
							else {
								crearDeportivo(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
										numPasajerosDe, numPuertasDe, numBolsasAire, hp, aceleracion, false, false,
										null, null, precio);

							}

						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);
					}
				}
				break;

			case MOTO:

				if(getDatosValidosCoches()){
					String marca= txtMarcaVehiculo.getText();
					String modelo = txtModelo.getText();
					String cambios = txtNumCambios.getText();
					String velocidadMax = txtVelocidadMax.getText();
					String cilindraje = txtCilindraje.getText();
					TipoCombustible combustible = comboBoxCombustible.getValue();
					TipoTransmision transmision = comboBoxTransmision.getValue();
					Estado estado = comboBoxEstadoVehiculo.getValue();
					String precio = txtPrecio.getText();

					if (combustible == TipoCombustible.HIBRIDO) {
						boolean isEnchufable = checkEnchufable.isSelected();
						boolean isHibridoLigero = checkEnchufable.isSelected();
						crearMoto(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
								 isEnchufable, isHibridoLigero, null, null, precio);
					} else {
						if (combustible == TipoCombustible.ELECTRICO) {
							String tiempoCarga = txtTiempoCarga.getText();
							String autonomia = txtAutonomia.getText();
							if (validarDatosElectrico(tiempoCarga, autonomia)) {
								crearMoto(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
										estado, false, false, tiempoCarga, autonomia, precio);
							}
						}
						else {
							crearMoto(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
									estado, false, false, null, null, precio);

						}

					}
					tableViewVehiculos.getItems().clear();
					tableViewVehiculos.setItems(getCoches());
					limpiarInfoCoches(event);

				}
				break;

			case PICKUP:
				String numPasa = txtNumPasajeros.getText();
				String numPuert = txtNumPuertas.getText();
				boolean absPic = checkAbs.isSelected();
				boolean aire = checkAireAcondicionado.isSelected();
				boolean camRe = checkCamReversa.isSelected();
				String bolsas = txtNumBolsasAire.getText();
				boolean cuatrox4 = checkTraccionTotal.isSelected();
				String capacidadCar = txtCapacidadCarga.getText();

				if(getDatosValidosCoches()){
					if(validarDatos(numPasa, bolsas, capacidadCar, numPuert)){
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearPick(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasa, numPuert, absPic, aire, camRe, bolsas, cuatrox4 ,
									capacidadCar, isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearPick(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
											numPasa, numPuert, absPic, aire, camRe, bolsas, cuatrox4 ,
											capacidadCar, false, false, tiempoCarga, autonomia, precio);					}
							}
							else {
								crearPick(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
										numPasa, numPuert, absPic, aire, camRe, bolsas, cuatrox4 ,
										capacidadCar, false, false, null, null, precio);
							}
						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);

					}
				}

				break;

			case SEDAN:
				String numPasaSe = txtNumPasajeros.getText();
				String numPuertSe = txtNumPuertas.getText();
				String capacidadMaleteroSe = txtCapacidadMaletero.getText();
				boolean aireSe = checkAireAcondicionado.isSelected();;
				boolean camSe = checkCamReversa.isSelected();
				boolean velocidadCrucer = checkVelocidadCrucero.isSelected();
				String numBolsasAireSe = txtNumBolsasAire.getText();
				boolean absSe= checkAbs.isSelected();
				boolean sensorColi = checkSensorColision.isSelected();
				boolean sensorTrafi = checkSensorTraficoCruzado.isSelected();
				boolean asisCarril = checkAsisCarril.isSelected();

				if(getDatosValidosCoches()){
					if(validarDatosSe(numPasaSe, numPuertSe, capacidadMaleteroSe, numBolsasAireSe )){
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearSedan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasaSe, numPuertSe, capacidadMaleteroSe, aireSe, camSe, velocidadCrucer, numBolsasAireSe ,
									absSe, sensorColi, sensorTrafi, asisCarril, isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearSedan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
											numPasaSe, numPuertSe, capacidadMaleteroSe, aireSe, camSe, velocidadCrucer, numBolsasAireSe ,
											absSe, sensorColi, sensorTrafi, asisCarril, false, false, tiempoCarga, autonomia, precio);					}
							}
							else {
								crearSedan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
										estado, numPasaSe, numPuertSe, capacidadMaleteroSe, aireSe, camSe,
										velocidadCrucer, numBolsasAireSe, absSe, sensorColi, sensorTrafi, asisCarril,
										false, false, null, null, precio);
							}
						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);
					}
				}
				break;

			case SUV:
				String numPasaSv = txtNumPasajeros.getText();
				String numPuertSv = txtNumPuertas.getText();
				String capacidadMaleteroSv = txtCapacidadMaletero.getText();
				boolean aireSv = checkAireAcondicionado.isSelected();
				;
				boolean camSv = checkCamReversa.isSelected();
				boolean velocidadCrucerSv = checkVelocidadCrucero.isSelected();
				String numBolsasAireSv = txtNumBolsasAire.getText();
				boolean absSv = checkAbs.isSelected();
				boolean sensorColiSv = checkSensorColision.isSelected();
				boolean sensorTrafiSv = checkSensorTraficoCruzado.isSelected();
				boolean asisCarrilSv = checkAsisCarril.isSelected();
				boolean traccionSv = checkTraccionTotal.isSelected();

				if (getDatosValidosCoches()) {
					if (validarDatosSe(numPasaSv, numPuertSv, capacidadMaleteroSv, numBolsasAireSv)) {
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearSuv(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasaSv, numPuertSv, capacidadMaleteroSv, numBolsasAireSv, aireSv, camSv,
									velocidadCrucerSv, absSv, sensorColiSv, sensorTrafiSv, asisCarrilSv, traccionSv,
									isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearSuv(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
											estado, numPasaSv, numPuertSv, capacidadMaleteroSv, numBolsasAireSv, aireSv,
											camSv, velocidadCrucerSv, absSv, sensorColiSv, sensorTrafiSv, asisCarrilSv,
											traccionSv, false, false, tiempoCarga, autonomia, precio);
								}
							} else {
								crearSuv(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
										estado, numPasaSv, numPuertSv, capacidadMaleteroSv, numBolsasAireSv, aireSv,
										camSv, velocidadCrucerSv, absSv, sensorColiSv, sensorTrafiSv, asisCarrilSv,
										traccionSv, false, false, null, null, precio);

							}

						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);
						}
					}
					break;

			case VAN:
				String numPasajerosVan = txtNumPasajeros.getText();
				String numPuertasVan = txtNumPuertas.getText();
				;
				String capMaleteroVan = txtCapacidadMaletero.getText();
				boolean aireAcVan = checkAireAcondicionado.isSelected();
				boolean camVan = checkCamReversa.isSelected();
				String numBolsasAireVan = txtNumBolsasAire.getText();
				boolean absVan = checkAbs.isSelected();

				if (getDatosValidosCoches()) {
					if (validarDatosSe(numPasajerosVan, numPuertasVan, capMaleteroVan, numBolsasAireVan)) {
						String marca = txtMarcaVehiculo.getText();
						String modelo = txtModelo.getText();
						String cambios = txtNumCambios.getText();
						String velocidadMax = txtVelocidadMax.getText();
						String cilindraje = txtCilindraje.getText();
						TipoCombustible combustible = comboBoxCombustible.getValue();
						TipoTransmision transmision = comboBoxTransmision.getValue();
						Estado estado = comboBoxEstadoVehiculo.getValue();
						String precio = txtPrecio.getText();

						if (combustible == TipoCombustible.HIBRIDO) {
							boolean isEnchufable = checkEnchufable.isSelected();
							boolean isHibridoLigero = checkEnchufable.isSelected();
							crearVan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
									numPasajerosVan, numPuertasVan, capMaleteroVan, aireAcVan, camVan, numBolsasAireVan,
									absVan, isEnchufable, isHibridoLigero, null, null, precio);
						} else {
							if (combustible == TipoCombustible.ELECTRICO) {
								String tiempoCarga = txtTiempoCarga.getText();
								String autonomia = txtAutonomia.getText();
								if (validarDatosElectrico(tiempoCarga, autonomia)) {
									crearVan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
											estado, numPasajerosVan, numPuertasVan, capMaleteroVan, aireAcVan, camVan,
											numBolsasAireVan, absVan, false, false, tiempoCarga, autonomia, precio);
								}
							}
							else {
								crearVan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
										estado, numPasajerosVan, numPuertasVan, capMaleteroVan, aireAcVan, camVan,
										numBolsasAireVan, absVan, false, false, null, null, precio);

							}

						}
						tableViewVehiculos.getItems().clear();
						tableViewVehiculos.setItems(getCoches());
						limpiarInfoCoches(event);

					}
				}
				break;
			}
		}
		else{
			mostrarMensaje("Notificiaci�n", "Campos vac�os", "Por favor rellenar los campos solicitados", AlertType.INFORMATION);

		}




	}

	private void crearBus(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasajeros,
			String numPuertas, String capacidadMaletero, boolean aireAcon, boolean camReversa, String bolsasAire,
			boolean abs, String numEjes, String salidasEmergencia, boolean isEnchufable, boolean isHibridoLigero,
			String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearBus(marca, modelo, cambios, velocidadMax, cilindraje, aireAcon, camReversa,  abs,
				 numPasajeros, numPuertas, capacidadMaletero, bolsasAire, numEjes, salidasEmergencia,
				 combustible, transmision, estado, isEnchufable, isHibridoLigero, tiempoCarga, autonomia, precio);
   	if(flag==true){
   		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

   	}
   	else{
   		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
   	}

	}


	private void crearSedan(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasaSe,
			String numPuertSe, String capacidadMaleteroSe, boolean aireSe, boolean camSe, boolean velocidadCrucer,
			String numBolsasAireSe, boolean absSe, boolean sensorColi, boolean sensorTrafi, boolean asisCarril,
			boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearSedan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
				numPasaSe, numPuertSe, capacidadMaleteroSe, numBolsasAireSe,aireSe,camSe, velocidadCrucer, absSe, sensorColi,
				sensorTrafi, asisCarril, isEnchufable, isHibridoLigero, tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}
	}


	private boolean validarDatosElectrico(String tiempo, String autonomia){
		String notificacion = "";

		if (tiempo == null || tiempo.equals("")) {
			notificacion += "Ingrese el tiempo que tarda en cargar\n";
		}
		else {
			if(!esNumero(tiempo)){
				notificacion += "El tiempo que tarda en cargar debe ser un dato num�rico\n";
			}
		}
		if (autonomia == null || autonomia.equals("")) {
			notificacion += "Ingrese la autonom�a del veh�culo\n";
		}
		else {
			if(!esNumero(autonomia)){
				notificacion += "La autonom�a debe estar dada en n�meros\n";
			}
		}
		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}
		return true;
	}

	private void crearVan(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasajerosVan,
			String numPuertasVan, String capMaleteroVan, boolean aireAcVan, boolean camVan, String numBolsasAireVan,
			boolean absVan, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearVan(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision,
				estado, numPasajerosVan, numPuertasVan, capMaleteroVan, aireAcVan, camVan, numBolsasAireVan, absVan,
				isEnchufable, isHibridoLigero , tiempoCarga, autonomia, precio);
		if (flag == true)
		{
			mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
		}

	}


	private void crearSuv(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasaSv,
			String numPuertSv, String capacidadMaleteroSv, String numBolsasAireSv, boolean aireSv, boolean camSv,
			boolean velocidadCrucerSv, boolean absSv, boolean sensorColiSv, boolean sensorTrafiSv, boolean asisCarrilSv,
			boolean traccionSv, boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearSuv(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
								numPasaSv, numPuertSv, capacidadMaleteroSv, numBolsasAireSv,aireSv,camSv, velocidadCrucerSv,
								absSv, sensorColiSv, sensorTrafiSv, asisCarrilSv, traccionSv, isEnchufable, isHibridoLigero ,
								tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}
	}





	private boolean validarDatosSe(String numPasaSe, String numPuertSe, String capacidadMaleteroSe,
			String numBolsasAireSe) {
		String notificacion = "";
		if (numPasaSe == null || numPasaSe.equals("")) {
			notificacion += "Ingrese el n�mero de pasajeros que puede llevar\n";
		}
		else {
			if(!esNumero(numPasaSe)){
				notificacion += "El n�mero de pasajeros debe estar dada en n�meros\n";
			}
		}

		if (numBolsasAireSe == null || numBolsasAireSe.equals("")) {
			notificacion += "Ingrese el n�mero de bolsas de aire\n";
		}
		else {
			if(!esNumero(numBolsasAireSe)){
				notificacion += "El n�mero de bolsas de aire debe ser un dato num�rico\n";
			}
		}
		if (capacidadMaleteroSe == null || capacidadMaleteroSe.equals("")) {
			notificacion += "Ingrese la capacidad del maletero\n";
		}
		else {
			if(!esNumero(capacidadMaleteroSe)){
				notificacion += "La capacidad del maletero debe estar dados en n�meros\n";
			}
		}
		if (numPuertSe == null || numPuertSe.equals("")) {
			notificacion += "Ingrese el n�mero de puertas\n";
		}
		else {
			if(!esNumero(numPuertSe)){
				notificacion += "El n�mero de puertas del veh�culo debe ser un dato num�rico\n";
			}
		}
		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}
		return true;


	}


	private void crearPick(String marca, String modelo, String cambios, String velocidadMax, String cilindraje,
			TipoCombustible combustible, TipoTransmision transmision, Estado estado, String numPasa, String numPuert, boolean absPic,
			boolean aire, boolean camRe, String bolsas, boolean cuatrox4, String capacidadCar, boolean isEnchufable, boolean isHibridoLigero,
			String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearPick(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado,
								numPasa, absPic, aire, camRe, bolsas, cuatrox4, capacidadCar, numPuert, isEnchufable, isHibridoLigero
								, tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}
	}



	private boolean validarDatos(String numPasa, String bolsas, String capacidadCar, String numPuert) {
		String notificacion = "";
		if (numPasa == null || numPasa.equals("")) {
			notificacion += "Ingrese el n�mero de pasajeros que puede llevar la Pick-Up\n";
		}
		else {
			if(!esNumero(numPasa)){
				notificacion += "El n�mero de pasajeros debe estar dada en n�meros\n";
			}
		}

		if (bolsas == null || bolsas.equals("")) {
			notificacion += "Ingrese el n�mero de bolsas de aire del Pick-Up\n";
		}
		else {
			if(!esNumero(bolsas)){
				notificacion += "El n�mero de bolsas de aire debe ser un dato num�rico\n";
			}
		}
		if (capacidadCar == null || capacidadCar.equals("")) {
			notificacion += "Ingrese la capacidad de carga de la Pick-Up\n";
		}
		else {
			if(!esNumero(capacidadCar)){
				notificacion += "La capacidad de carga debe estar dados en n�meros\n";
			}
		}
		if (numPuert == null || numPuert.equals("")) {
			notificacion += "Ingrese el n�mero de puertas de la Pick-Up\n";
		}
		else {
			if(!esNumero(numPuert)){
				notificacion += "El n�mero de puertas del veh�culo debe ser un dato num�rico\n";
			}
		}
		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}
		return true;


	}


	private void crearMoto(String marcaCa, String modeloCa, String cambiosCa, String velocidadMaxCa,
			String cilindrajeCa, TipoCombustible combustibleCa, TipoTransmision transmisionCa, Estado estadoCa, boolean isEnchufable,
			boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio){

		boolean flag = singleton.crearMoto(marcaCa, modeloCa, cambiosCa, velocidadMaxCa, cilindrajeCa, combustibleCa, transmisionCa, estadoCa,
				isEnchufable, isHibridoLigero, tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}
	}


	private void crearDeportivo(String marcaCa, String modeloCa, String cambiosCa, String velocidadMaxCa,
			String cilindrajeCa, TipoCombustible combustibleCa, TipoTransmision transmisionCa, Estado estadoCa,
			String numPasajerosDe, String numPuertasDe, String numBolsasAire, String hp, String aceleracion,
			 boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearDeportivo(marcaCa, modeloCa, cambiosCa, velocidadMaxCa, cilindrajeCa, combustibleCa, transmisionCa, estadoCa,
				numPasajerosDe, numPuertasDe, numBolsasAire, hp, aceleracion, isEnchufable, isHibridoLigero, tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}

	}


	private boolean validarDatos(String numPasajerosDe, String numPuertasDe, String numBolsasAire, String hp,
			String aceleracion) {
		String notificacion = "";
		if (numPasajerosDe == null || numPasajerosDe.equals("")) {
			notificacion += "Ingrese el n�mero de pasajeros que puede llevar el deportivo\n";
		}
		else {
			if(!esNumero(numPasajerosDe)){
				notificacion += "El n�mero de pasajeros debe estar dada en n�meros\n";
			}
		}
		if (numPuertasDe == null || numPuertasDe.equals("")) {
			notificacion += "Ingrese el n�mero de puertas del deportivo\n";
		}
		else {
			if(!esNumero(numPuertasDe)){
				notificacion += "El n�mero de puertas deben ser un dato num�rico\n";
			}
		}
		if (numBolsasAire == null || numBolsasAire.equals("")) {
			notificacion += "Ingrese el n�mero de bolsas de aire del deportivo\n";
		}
		else {
			if(!esNumero(numBolsasAire)){
				notificacion += "El n�mero de bolsas de aire debe ser un dato num�rico\n";
			}
		}
		if (hp == null || hp.equals("")) {
			notificacion += "Ingrese los caballos de fuerza del deportivo\n";
		}
		else {
			if(!esNumero(hp)){
				notificacion += "Los caballos de fuerza del veh�culo deben estar dados en n�meros\n";
			}
		}
		if (aceleracion == null || aceleracion.equals("")) {
			notificacion += "Ingrese la aceleraci�n de 0-100 del deportivo\n";
		}
		else {
			if(!esNumero(aceleracion)){
				notificacion += "El n�mero de ejes del cami�n deben ser un dato num�rico\n";
			}
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}
		txtHp.setText(hp+"HP");
		txtAceleracion.setText(aceleracion+"S");
		return true;


	}


	private void crearCamion(String marcaCa, String modeloCa, String cambiosCa, String velocidadMaxCa,
			String cilindrajeCa, TipoCombustible combustibleCa, TipoTransmision transmisionCa, Estado estadoCa,
			boolean absCa, boolean aireAconCa, String capacidadCarga, TipoCamion tipoCamion, boolean frenoAire,
			String numEjesCa,boolean isEnchufable, boolean isHibridoLigero, String tiempoCarga, String autonomia, String precio) {

		boolean flag = singleton.crearCamion(marcaCa, modeloCa, cambiosCa, velocidadMaxCa, cilindrajeCa, combustibleCa, transmisionCa, estadoCa,
				absCa, aireAconCa, capacidadCarga, tipoCamion, frenoAire, numEjesCa, isEnchufable, isHibridoLigero, tiempoCarga, autonomia, precio);
		if(flag==true){
    		mostrarMensaje("Informaci�n", "Veh�culo a�adido", "El veh�culo se agreg� con �xito", AlertType.INFORMATION);

    	}
    	else{
    		mostrarMensaje("Informaci�n", "Veh�culo no a�adido", "El veh�culo ya existe", AlertType.INFORMATION);
    	}

	}


	private boolean validarDatos(String capacidadCarga, TipoCamion tipoCamion, String numEjesCa) {
		String notificacion = "";
		if (capacidadCarga == null || capacidadCarga.equals("")) {
			notificacion += "Ingrese la capacidad de carga del cami�n";
		}
		else {
			if(!esNumero(capacidadCarga)){
				notificacion += "La capacidad de cargas del cami�n debe estar dada en n�meros\n";
			}
		}
		if (numEjesCa == null || numEjesCa.equals("")) {
			notificacion += "Ingrese el n�mero de ejes del cami�n";
		}
		else {
			if(!esNumero(numEjesCa)){
				notificacion += "El n�mero de ejes del cami�n deben ser un dato num�rico\n";
			}
		}

		if (tipoCamion == null || tipoCamion.equals("")) {
			notificacion += "Seleccione un tipo de cami�n";
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}

		return true;
	}





	private boolean validarDatos(String numPasajeros, String numPuertas, String capacidadMaletero, String bolsasAire, String numEjes,
			String salidasEmergencia) {
		String notificacion = "";

		/*Se valida que el saldo ingresado no sea null ni sea cadena vac�a,
		adem�s se valida que sea num�rico para su correcta conversi�n */


		if (numPasajeros == null || numPasajeros.equals("")) {
			notificacion += "Ingrese un n�mero de pasajeros";
		}
		else {
			if(!esNumero(numPasajeros)){
				notificacion += "El n�mero de pasajeros debe ser num�rico\n";
			}
		}

		if (numPuertas == null || numPuertas.equals("")) {
			notificacion += "Ingrese el n�mero de puertas\n";
		}
		else {
			if(!esNumero(numPuertas)){
				notificacion += "El n�mero de puertas debe ser num�rica\n";
			}
		}
		if (capacidadMaletero == null || capacidadMaletero.equals("")) {
			notificacion += "Ingrese la capacidad del maletero\n";
		}
		else {
			if(!esNumero(capacidadMaletero)){
				notificacion += "La capacidad del maletero debe ser num�rico\n";
			}
		}

		if (bolsasAire == null || bolsasAire.equals("")) {
			notificacion += "Ingrese el n�mero de bolsas de aire\n";
		}
		else {
			if(!esNumero(bolsasAire)){
				notificacion += "El n�mero de bolsas de aire debe ser num�rico\n";
			}
		}

		if (numEjes == null || numEjes.equals("")) {
			notificacion += "Ingrese el n�mero de ejes\n";
		}
		else {
			if(!esNumero(numEjes)){
				notificacion += "El n�mero de ejes debe ser num�rico\n";
			}
		}
		if (salidasEmergencia == null || salidasEmergencia.equals("")) {
			notificacion += "Ingrese el n�mero de salidas de emergencia\n";
		}
		else {
			if(!esNumero(salidasEmergencia)){
				notificacion += "El n�mero de salidas de emergencia debe ser num�rico\n";
			}
		}
		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}

		return true;
	}


	private boolean validarDatosVehiculos(String marca, String modelo, String cambios, String velocidadMax, String cilindraje, TipoCombustible combustible, TipoTransmision transmision, Estado estado, String precio){
		String notificacion = "";
		if (marca == null || marca.equals("")) {
			notificacion += "Ingrese la marca del veh�culo";
		}

		if (modelo == null || modelo.equals("")) {
			notificacion += "Ingrese un modelo de vev�culo";
		}

		if (cambios == null || cambios.equals("")) {
			notificacion += "Ingrese el n�mero de cambios del veh�culo";
		}
		else {
			if(!esNumero(cambios)){
				notificacion += "El n�mero de cambios debe ser num�rico\n";
			}
		}

		if (velocidadMax == null || velocidadMax.equals("")) {
			notificacion += "Ingrese la velocidad m�xima del veh�culo";
		}
		else {
			if(!esNumero(velocidadMax)){
				notificacion += "La velocidad m�xima del veh�culo debe ser num�rico\n";
			}
		}

		if (cilindraje == null || cilindraje.equals("")) {
			notificacion += "Ingrese el cilindraje del veh�culo";
		}
		else {
			if(!esNumero(cilindraje)){
				notificacion += "El cilindraje del veh�culo debe ser num�rico\n";
			}
		}

		if (combustible == null || combustible.equals("")) {
			notificacion += "Elija un tipo de combustible\n";
		}

		if (cambios == null || cambios.equals("")) {
			notificacion += "Elija un tipo de transmisi�n\n";
		}

		if (estado == null || estado.equals("")) {
			notificacion += "Elija un tipo de estado\n";
		}
		if (precio == null || precio.equals("")) {
			notificacion += "Ingrese el precio del veh�culo";
		}
		else {
			if(!esNumero(precio)){
				notificacion += "El precio del veh�culo debe ser num�rico\n";
			}
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Veh�culo no creado", notificacion, AlertType.WARNING);
			return false;
		}
		txtVelocidadMax.setText(velocidadMax+"Km/h");
		txtCilindraje.setText(cilindraje+"L");
		return true;


	}

	private boolean getDatosValidosCoches(){
		String marca = txtMarcaVehiculo.getText();
		String modelo = txtModelo.getText();
		String cambios = txtNumCambios.getText();
		String velocidadMax = txtVelocidadMax.getText();
		String cilindraje = txtCilindraje.getText();
		TipoCombustible combustible = comboBoxCombustible.getValue();
		TipoTransmision transmision = comboBoxTransmision.getValue();
		Estado estado = comboBoxEstadoVehiculo.getValue();
		String precio = txtPrecio.getText();
		return validarDatosVehiculos(marca, modelo, cambios, velocidadMax, cilindraje, combustible, transmision, estado, precio);
	}

	@FXML
    void limpiarInfoCoches(ActionEvent event) {
		comboBoxCombustible.getSelectionModel().clearSelection();
		comboBoxTransmision.getSelectionModel().clearSelection();
		comboBoxEstadoVehiculo.getSelectionModel().clearSelection();
		comboBoxTipoVehiculo.getSelectionModel().clearSelection();
		comboBoxTipoCamion.getSelectionModel().clearSelection();

		txtMarcaVehiculo.clear();
		txtModelo.clear();
		txtNumCambios.clear();;
		txtVelocidadMax.clear();
		txtCilindraje.clear();
		txtPrecio.clear();
		txtAutonomia.clear();
		txtTiempoCarga.clear();


		txtCapacidadMaletero.clear();
		txtNumBolsasAire.clear();
		checkVelocidadCrucero.setSelected(false);
		checkAbs.setSelected(false);
		txtNumPasajeros.clear();;
		txtNumPuertas.clear();
		checkAireAcondicionado.setSelected(false);
		checkCamReversa.setSelected(false);
		txtHp.clear();
		txtAceleracion.clear();
		checkTraccionTotal.setSelected(false);
		txtCapacidadCarga.clear();
		txtNumEjes.clear();
		txtSalidasEmergencia.clear();;
		checkFrenoAire.setSelected(false);
		checkAsisCarril.setSelected(false);
		checkSensorColision.setSelected(false);
		checkSensorTraficoCruzado.setSelected(false);
		checkHibridoLigero.setSelected(false);
		checkEnchufable.setSelected(false);
    }












	//TAB COMPRAS//
	@FXML
	void abrirVentanaAlquiler(ActionEvent event) throws IOException{
		if(vehiculoSeleccion==null){
    		mostrarMensaje("Cliente seleccion", "Cliente Seleccion", "No se ha seleccionado ningun Cliente", AlertType.WARNING);
    		}
		else{
		 	FXMLLoader loader= new FXMLLoader();
	    	loader.setLocation(Aplicacion.class.getResource("../Views/AlquilerView.fxml"));
	    	AnchorPane anchorPane= (AnchorPane)loader.load();
	    	AlquilerViewController Controller = loader.getController();
	    	Controller.setAplicacion(aplicacion);
	    	Scene scene= new Scene(anchorPane);
	    	Stage stage = new Stage();
	    	stage.setScene(scene);
	    	Controller.init(stage, this);
	    	stage.show();
	    	Controller.facturaAlquiler();

		}

	}

	@FXML
	void abrirVentanaTransacciones(ActionEvent event) throws IOException{
		if(vehiculoSeleccion==null){
    		mostrarMensaje("Cliente seleccion", "Cliente Seleccion", "No se ha seleccionado ningun Cliente", AlertType.WARNING);
    		}
		else{
		 	FXMLLoader loader= new FXMLLoader();
	    	loader.setLocation(Aplicacion.class.getResource("../Views/TransaccionesView.fxml"));
	    	AnchorPane anchorPane= (AnchorPane)loader.load();
	    	TransaccionesViewController Controller = loader.getController();
	    	Controller.setAplicacion(aplicacion);
	    	Scene scene= new Scene(anchorPane);
	    	Stage stage = new Stage();
	    	stage.setScene(scene);
	    	Controller.init(stage, this);
	    	stage.show();
	    	Controller.facturaCompra();
		}

    }

	public Vehiculo getCarSelection(){
		return vehiculoSeleccion;
	}

	public void setCarSelection(){
		vehiculoSeleccion = null;
	}

	@FXML
	void fileChooser(ActionEvent event){
		FileChooser file = new FileChooser();
		file.setTitle("Abrir im�genes");
		File selectedFile = file.showOpenDialog(stage);

		ExtensionFilter ex1 = new ExtensionFilter("Im�genes", "*.png" , "*.jpg");
		file.getExtensionFilters().add(ex1);

		if (selectedFile != null) {
			System.out.println(selectedFile.getAbsolutePath());
			String imageUrl = selectedFile.toURI().toString();
			Image image = new Image(imageUrl);
			imageView.setImage(image);
		}
	}

	@FXML
    void initialize() {
    }

	public  void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void init(Stage stage, PrincipalViewController principalViewController) {
		this.ventanaPrincipalController = principalViewController;
		this.stage = stage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.columnNombresClientes.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidosClientes.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

		tableViewClientes.setItems(getClientes());
		tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null){
				clienteSeleccion= newSelection;
				txtNombresClientes.setText(clienteSeleccion.getNombre());
	    		txtApellidosClientes.setText(clienteSeleccion.getApellidos());
	    		txtCedulaClientes.setText(clienteSeleccion.getIdentificacion());
	    		dateNacimientoClientes.setValue(clienteSeleccion.getFechaNacimiento());
	    		txtCedulaClientes.setDisable(true);

			}
		});
		checkEnchufable.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkHibridoLigero.setDisable(true);
            } else {
                checkHibridoLigero.setDisable(false);
            }
        });
		checkHibridoLigero.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkEnchufable.setDisable(true);
            } else {
                checkEnchufable.setDisable(false);
            }
        });



		comboBoxTipoVehiculo.getItems().addAll(TipoVehiculo.values());
		comboBoxTransmision.getItems().addAll(TipoTransmision.values());
		comboBoxCombustible.getItems().addAll(TipoCombustible.values());
		comboBoxEstadoVehiculo.getItems().addAll(Estado.values());
		comboBoxTipoCamion.getItems().addAll(TipoCamion.values());

		tableViewVehiculos.setItems(getCoches());

		this.columnCombustible.setCellValueFactory(new PropertyValueFactory<>("tipoCombustible"));
		this.columnTransmision.setCellValueFactory(new PropertyValueFactory<>("tipoTransmision"));
		this.columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
		this.columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		this.columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.columnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		this.columnCambios.setCellValueFactory(new PropertyValueFactory<>("cambios"));
		this.columnVelocidadMax.setCellValueFactory(new PropertyValueFactory<>("velocidadMax"));
		this.columnCilindraje.setCellValueFactory(new PropertyValueFactory<>("cilindraje"));
		this.columnCapacidadMaletero.setCellValueFactory(new PropertyValueFactory<>("capacidadMaletero"));
		this.columnAireAcondicionado.setCellValueFactory(new PropertyValueFactory<>("aireAcondicionado"));
		this.columnCamaraReversa.setCellValueFactory(new PropertyValueFactory<>("camReversa"));
		this.columnTiempoCarga.setCellValueFactory(new PropertyValueFactory<>("tiempoAproCarga"));
		this.columnAutonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
		this.columnAbs.setCellValueFactory(new PropertyValueFactory<>("abs"));
		this.columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

		tableViewVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null){
				vehiculoSeleccion= newSelection;
			}
		});
	}




	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertype) {
		Alert alert = new Alert(alertype);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}


	public void init(Stage stage2) {
		this.stage = stage2;
	}


	public void show() {
		stage.show();

	}

	public void refreshTableViewVehiculos(){
		tableViewVehiculos.getItems().clear();
		tableViewVehiculos.setItems(getCoches());
	}

}
