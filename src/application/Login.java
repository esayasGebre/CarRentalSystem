package application;

import java.util.Timer;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Login extends Application {
	public static Stage loginStage;

	@Override
	public void start(Stage primaryStage) {

		Flash myFlash = new Flash();
		myFlash.runTask();

		try {

			Parent root = FXMLLoader.load(getClass().getResource("logIn.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			loginStage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("CRS-Login");
			primaryStage.setResizable(false);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

}
