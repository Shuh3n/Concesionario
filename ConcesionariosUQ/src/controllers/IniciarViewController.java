package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ConcesiorarioUQ;

public class  IniciarViewController {

	Singleton singleton = Singleton.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnVolve;

    @FXML
    private Button btnOlvidoContra;

    @FXML
    private ImageView imagenAdmin;

    @FXML
    private PasswordField txtPassword;

	private Aplicacion aplicacion;

	private PrincipalViewController ventanaPrincipalController;

	private ConcesiorarioUQ concesionario;

	private Stage stage;

    @FXML
    void abrirVentanaEmpleado(ActionEvent event) throws IOException {
    	String password = txtPassword.getText();
    	if(password!=null && !password.equals("")){
    		if(singleton.verificarAdmin(password)){

    			FXMLLoader loader= new FXMLLoader();
    	    	loader.setLocation(Aplicacion.class.getResource("../Views/AdminView.fxml"));
    	    	AnchorPane anchorPane= (AnchorPane)loader.load();
    	    	AdminViewController Controller = loader.getController();
    	    	Controller.setAplicacion(aplicacion);
    	    	Scene scene= new Scene(anchorPane);
    	    	Stage stage = new Stage();
    	    	stage.setScene(scene);
    	    	Controller.init(stage, ventanaPrincipalController);
    	    	stage.show();
    	    	this.stage.close();
    		}
    		else{
    			mostrarMensaje("Notificación", "Administrador no registrado", "Las credenciales ingresadas son falsas", AlertType.INFORMATION);
    		}
    	}
    	else{
    		mostrarMensaje("Notificación", "Campos vacíos", "Por favor ingresar datos", AlertType.INFORMATION);
    	}
    }
    @FXML
    void abrirVentanaPrincipal(ActionEvent event) throws IOException{
    	ventanaPrincipalController.show();
    	this.stage.close();

    }

    @FXML
    void restaurarContra(ActionEvent event) throws IOException{
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(Aplicacion.class.getResource("../Views/RestaurarAdminView.fxml"));
    	AnchorPane anchorPane= (AnchorPane)loader.load();
    	RestaurarAdminViewController Controller = loader.getController();
    	Controller.setAplicacion(aplicacion);
    	Scene scene= new Scene(anchorPane);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	Controller.init(stage);
    	stage.show();

    }

    @FXML
    void initialize() {
    	Image image = new Image("imagenes/Persona.png");
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
