package controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import model.ConcesiorarioUQ;
import model.Empleado;
import model.TipoTransacciones;
import model.Transaccion;

public class AdminViewController implements Initializable {

	Singleton singleton = Singleton.getInstance();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnActualizar;

	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnLimpiarInfoEmpleado;

	@FXML
	private Button btnVolver;

	@FXML
	private TableColumn<Empleado, String> columnApellidos;

	@FXML
	private TableColumn<Empleado, String> columnNombres;

	@FXML
	private TableView<Empleado> tableViewEmpleado;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtCedula;

	@FXML
	private TextField txtNombre;

	@FXML
	private TableColumn<?, ?> columnMarcaCarro;

	@FXML
	private TableColumn<?, ?> columnTipoFactura;

	@FXML
	private TableColumn<?, ?> columnValorFactura;

	@FXML
	private TableColumn<?, ?> columnCodeFactura;

	@FXML
	private TableColumn<?, ?> columnModeloCarro;

	@FXML
	private TableColumn<?, ?> columnFechaFactura;

	@FXML
	private Button btnVolverReportes;

	@FXML
	private Button btnEliminarReportes;

	@FXML
	private TableColumn<Transaccion, String> columnCodeEmpleado;

	@FXML
	private Button btnActualizarReportes;

	@FXML
	private Button btnQuitarFiltros;

	@FXML
	private Button generarReportes;

	@FXML
	private TableView<Transaccion> tableViewReportes;

	private Aplicacion aplicacion;
	private Empleado empleadoSeleccion;

	ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();
	ObservableList<Transaccion> listaDetalles = FXCollections.observableArrayList();

	private PrincipalViewController ventanaPrincipalController;

	private ConcesiorarioUQ concesionario;

	private Stage stage;

	private Transaccion transaccionSeleccion;

	@FXML
	private DatePicker dateInicial;

	@FXML
	private DatePicker dateFinal;

	@FXML
	void actualizarInfoEmpleado(ActionEvent event) {
		if (empleadoSeleccion == null) {
			mostrarMensaje("Cliente seleccion", "Cliente Seleccion", "No se ha seleccionado ningun Cliente",
					AlertType.WARNING);
		} else {
			String nombre = txtNombre.getText();
			String apellido = txtApellidos.getText();
			String cedula = txtCedula.getText();

			if (validarDatos(nombre, apellido, cedula)) {
				empleadoSeleccion.setNombre(nombre);
				empleadoSeleccion.setApellidos(apellido);
				empleadoSeleccion.setIdentificacion(cedula);

				limpiarCamposEmpleado(event);
				tableViewEmpleado.getItems().clear();
				tableViewEmpleado.setItems(getEmpleados());
				empleadoSeleccion = null;
				txtCedula.setDisable(false);

				mostrarMensaje("Actualizaci�n", "Cliente Actualizado con �xito",
						"La informaci�n del cliente fue actualizada con �xito", AlertType.INFORMATION);
			}

		}

	}

	@FXML
	void agregarEmpleado(ActionEvent event) {
		String name = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String id = txtCedula.getText();

		if (validarDatos(name, apellidos, id)) {
			crearEmpleado(name, apellidos, id);
			limpiarCamposEmpleado(event);

			tableViewEmpleado.getItems().clear();
			tableViewEmpleado.setItems(getEmpleados());
		}
	}

	private void crearEmpleado(String name, String apellidos, String id) {

		boolean flag = singleton.crearEmpleado(name, apellidos, id);
		if (flag == true) {
			mostrarMensaje("Informaci�n", "Empleado a�adido", "El empleado fue a�adido con �xito",
					AlertType.INFORMATION);

		} else {
			mostrarMensaje("Informaci�n", "Empleado no a�adido", "El empleado ya existe", AlertType.INFORMATION);
		}

	}

	private boolean validarDatos(String nombre, String apellidos, String cedula) {
		String notificacion = "";

		/*
		 * Se valida que el saldo ingresado no sea null ni sea cadena vac�a,
		 * adem�s se valida que sea num�rico para su correcta conversi�n
		 */

		if (nombre == null || nombre.equals("")) {
			notificacion += "Ingrese su nombre\n";
		}

		if (apellidos == null || apellidos.equals("")) {
			notificacion += "Ingrese sus apellidos\n";
		}
		if (cedula == null || cedula.equals("")) {
			notificacion += "Ingrese una c�dula\n";
		} else {
			if (!esNumero(cedula)) {
				notificacion += "La c�dula ingresada debe ser num�rica\n";
			}
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

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertype) {
		Alert alert = new Alert(alertype);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}

	@FXML
	void eliminarEmpleado(ActionEvent event) {
		if (empleadoSeleccion != null) {
			int confirmacion = JOptionPane.showConfirmDialog(null,
					"�Seguro que desea eliminar a" + empleadoSeleccion.getNombre() + "?");

			if (confirmacion == 0) {

				if (singleton.eliminarEmpleado(empleadoSeleccion)) {
					listaEmpleados.remove(empleadoSeleccion);
					mostrarMensaje("Empleado eliminado", "Eliminacion del empleado",
							"Se ha eliminado el empleado con exito", AlertType.INFORMATION);
					limpiarCamposEmpleado(event);
				} else {
					mostrarMensaje("Empleado eliminado", "Eliminacion del empleado",
							"No se ha podido eliminar el empleado", AlertType.WARNING);
				}
			}
		} else {
			mostrarMensaje("Empleado seleccion", "Empleado Seleccion", "No se ha seleccionado ning�n Empleado",
					AlertType.WARNING);
		}

	}

	private ObservableList<Empleado> getEmpleados() {
		listaEmpleados.clear();
		listaEmpleados.addAll(singleton.getListaEmpleados());
		return listaEmpleados;
	}



	@FXML
	void limpiarCamposEmpleado(ActionEvent Event) {
		txtNombre.clear();
		txtApellidos.clear();
		txtCedula.clear();

	}
	@FXML
	void limpiarFiltros(ActionEvent Event) {
		dateInicial.setValue(null);
		dateFinal.setValue(null);
		tableViewReportes.getItems().clear();
	}



	@FXML
	void regresarVetanaPrincipal(ActionEvent event) {
		ventanaPrincipalController.show();
		this.stage.close();

	}

	@FXML
	void actualizarReporte(ActionEvent event) throws IOException {
		if (transaccionSeleccion == null) {
			mostrarMensaje("Notificaci�n", "Selecci�n", "No se ha seleccionado ning�na transacci�n",
					AlertType.INFORMATION);
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../Views/ActualizacionDetalleView.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			Actualizaci�nDetalleController Controller = loader.getController();
			Controller.setAplicacion(aplicacion);
			Scene scene = new Scene(anchorPane);
			Stage stage = new Stage();
			stage.setScene(scene);
			Controller.init(stage, this);
			stage.show();
			Controller.actualizarInfo();
		}

	}

	public Transaccion getTransaccionSelection() {
		return transaccionSeleccion;
	}

	public void refreshTableViewDetalls() {
		tableViewReportes.getItems().clear();
	}

	public void setDetallerSelection() {
		transaccionSeleccion = null;
	}

	@FXML
	void eliminarReporte(ActionEvent event) {
		if (transaccionSeleccion != null) {
			int confirmacion = JOptionPane.showConfirmDialog(null,
					"�Seguro que desea eliminar la transacci�n  " + transaccionSeleccion.getCodigoTransaccion() + "?");

			if (confirmacion == 0) {

				if (singleton.eliminarDetalle(transaccionSeleccion)) {
					listaDetalles.remove(transaccionSeleccion);
					mostrarMensaje("Notificaci�n", "Eliminacion de la transacci�n",
							"Se ha eliminado la transacci�n con �xito", AlertType.INFORMATION);
					limpiarCamposEmpleado(event);
					transaccionSeleccion = null;
				} else {
					mostrarMensaje("Notificaci�n", "Eliminacion de la transacci�n",
							"No se ha podido eliminar la transacci�n", AlertType.WARNING);
				}
			}
		} else {
			mostrarMensaje("Notificaci�n", "", "No se ha seleccionado ning�n Empleado", AlertType.WARNING);
		}

	}

	@FXML
	void abrirVentanaPrincipal(ActionEvent event) {
		ventanaPrincipalController.show();
		this.stage.close();
	}

	@FXML
	void initialize() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.columnNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

		tableViewEmpleado.setItems(getEmpleados());

		tableViewEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				empleadoSeleccion = newSelection;
				txtNombre.setText(empleadoSeleccion.getNombre());
				txtApellidos.setText(empleadoSeleccion.getApellidos());
				txtCedula.setText(empleadoSeleccion.getIdentificacion());
				txtCedula.setDisable(true);

			}
		});

		this.columnCodeFactura.setCellValueFactory(new PropertyValueFactory<>("codigoTransaccion"));
		this.columnValorFactura.setCellValueFactory(new PropertyValueFactory<>("total"));
		this.columnCodeEmpleado.setCellValueFactory(new PropertyValueFactory<>("codigoEmpleado"));
		this.columnMarcaCarro.setCellValueFactory(new PropertyValueFactory<>("marcaCoche"));
		this.columnModeloCarro.setCellValueFactory(new PropertyValueFactory<>("modeloCoche"));
		this.columnTipoFactura.setCellValueFactory(new PropertyValueFactory<>("tipoTransaccion"));
		this.columnFechaFactura.setCellValueFactory(new PropertyValueFactory<>("fecha"));

		tableViewReportes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				transaccionSeleccion = newSelection;
			}
		});

		singleton.devolverAlquileres();
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	void generarReportes(ActionEvent Event){
		LocalDate fechaInicial = dateInicial.getValue();
		LocalDate fechaFinal = dateFinal.getValue();

		tableViewReportes.getItems().clear();

		if(fechaInicial!=null && fechaFinal!=null){
			tableViewReportes.setItems(getDetalles(fechaInicial, fechaFinal));
		}
	}

	private ObservableList<Transaccion> getDetalles(LocalDate fechaInicial, LocalDate fechaFinal) {
		listaDetalles.clear();
		listaDetalles.addAll(singleton.getListaDetalles(fechaInicial, fechaFinal));
		return listaDetalles;
	}

	public void init(Stage stage, PrincipalViewController principalViewController) {
		this.ventanaPrincipalController = principalViewController;
		this.concesionario = aplicacion.getConcesionario();
		this.stage = stage;
	}
}
