package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import controllers.PrincipalViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Buses;
import model.Camiones;
import model.Cliente;
import model.ConcesiorarioUQ;
import model.Deportivo;
import model.Empleado;
import model.Estado;
import model.Motos;
import model.Persona;
import model.Pickups;
import model.Sedan;
import model.Suv;
import model.TipoCamion;
import model.TipoCombustible;
import model.TipoTransmision;
import model.Vans;
import model.Vehiculo;

public class Aplicacion extends Application {

	private ConcesiorarioUQ concesionario;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.concesionario = new ConcesiorarioUQ();
		mostrarVentanaPrincipal();

	}

	public ConcesiorarioUQ getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(ConcesiorarioUQ concesionario) {
		this.concesionario = concesionario;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



	private void mostrarVentanaPrincipal() throws IOException {
		//Se establece la ruta de la ventana que desea ejecutar

		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("../Views/PrincipalView.fxml"));
		AnchorPane anchorPane = (AnchorPane)loader.load();
		PrincipalViewController ventanaPrincipalController = loader.getController();
		ventanaPrincipalController.setAplicacion(this);

		Scene scene= new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		PrincipalViewController controller = loader.getController();
		controller.setStage(primaryStage);
	}








}
