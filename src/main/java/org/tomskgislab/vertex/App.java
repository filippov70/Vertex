package org.tomskgislab.vertex;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	private static final Logger logger = LogManager.getLogger( App.class );
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource("Main.fxml"));
			logger.info("loading fxml...");
			BorderPane dh = (BorderPane) loader.load();
			logger.info("loading fxml complit");
			Scene s = new Scene(dh);
			primaryStage.setScene(s);
			primaryStage.show();
			logger.info("Application started");
		} 
		catch (IOException ex) {
			logger.error(ex.getMessage());
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
