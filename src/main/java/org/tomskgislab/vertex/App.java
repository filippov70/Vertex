package org.tomskgislab.vertex;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	TextArea t;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource("Main.fxml"));
			BorderPane dh = (BorderPane) loader.load();
			Scene s = new Scene(dh);
			primaryStage.setScene(s);
			primaryStage.show();
	
			//t = (TextArea) loader.load();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}