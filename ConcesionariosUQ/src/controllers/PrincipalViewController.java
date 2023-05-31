package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEmpleado;

    @FXML
    private Button btnCerrar;

    @FXML
    private Button btnAdministrador;

	private Aplicacion aplicacion;

	private Stage stage;


    @FXML
    void aceptarEmpleado(ActionEvent event) throws IOException {
     	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(Aplicacion.class.getResource("../Views/IniciarEmpleadoView2.fxml"));
    	AnchorPane anchorPane= (AnchorPane)loader.load();
    	IniciarEmpleadoViewController Controller = loader.getController();
    	Controller.setAplicacion(aplicacion);
    	Scene scene= new Scene(anchorPane);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	Controller.init(stage, this);
    	stage.show();
    	this.stage.close();

    }

    @FXML
    void aceptarAdministrador(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(Aplicacion.class.getResource("../Views/IniciarAdminView.fxml"));
    	AnchorPane anchorPane= (AnchorPane)loader.load();
    	IniciarViewController Controller = loader.getController();
    	Controller.setAplicacion(aplicacion);
    	Scene scene= new Scene(anchorPane);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	Controller.init(stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void cerrarApp(ActionEvent event) {
    	stage.close();

    }

    @FXML
    void initialize() {

    }

    public void show() {
  		stage.show();

  	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setStage(Stage primaryStage) {
			stage = primaryStage;


	}

}
