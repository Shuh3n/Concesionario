package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ConcesiorarioUQ;

public class IniciarEmpleadoViewController {

	Singleton singleton = Singleton.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnVolver;

    @FXML
    private ImageView imagenAdmin;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtPassword;

	private PrincipalViewController ventanaPrincipalController;

	private ConcesiorarioUQ concesionario;

	private Stage stage;

	private Aplicacion aplicacion;


    @FXML
    void abrirVentanaEmpleado(ActionEvent event) throws IOException {
    	String name = txtNombre.getText();
    	String password = txtPassword.getText();
    	if(validarDatos(name, password)){
    		if(singleton.verificarEmpleado(name, password)){

    			FXMLLoader loader= new FXMLLoader();
    	    	loader.setLocation(Aplicacion.class.getResource("../Views/EmpleadoView.fxml"));
    	    	AnchorPane anchorPane= (AnchorPane)loader.load();
    	    	EmpleadoViewController Controller = loader.getController();
    	    	Controller.setAplicacion(aplicacion);
    	    	Scene scene= new Scene(anchorPane);
    	    	Stage stage = new Stage();
    	    	stage.setScene(scene);
    	    	Controller.init(stage, ventanaPrincipalController);
    	    	stage.show();
    	    	this.stage.close();
    		}
    		else{
    			mostrarMensaje("Notificaci�n", "Empleado no registrado", "El usuario ingresado no existe", AlertType.INFORMATION);
    		}
    	}
    }

    private boolean validarDatos(String nombre , String cedula) {
		String notificacion = "";

		/*Se valida que el saldo ingresado no sea null ni sea cadena vac�a,
		adem�s se valida que sea num�rico para su correcta conversi�n */


		if (nombre == null || nombre.equals("")) {
			notificacion += "Ingrese su nombre\n";
		}

		if (cedula == null || cedula.equals("")) {
			notificacion += "Ingrese una contrase�a\n";
		}
		else {
			if(!esNumero(cedula)){
				notificacion += "La contrase�a ingresada debe ser num�rica\n";
			}
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificaci�n", "Empleado no existe", notificacion, AlertType.WARNING);
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
    void abrirVentanaPrincipal(ActionEvent event) {
    	ventanaPrincipalController.show();
    	this.stage.close();

    }

    @FXML
    void initialize() {
    	Image image = new Image("imagenes/Empleado.png");
    	imagenAdmin.setImage(image);

    }
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertype) {
		Alert alert = new Alert(alertype);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}
	public  void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void init(Stage stage, PrincipalViewController principalViewController) {
		this.ventanaPrincipalController = principalViewController;
		this.concesionario = aplicacion.getConcesionario();
		this.stage = stage;
	}
}
