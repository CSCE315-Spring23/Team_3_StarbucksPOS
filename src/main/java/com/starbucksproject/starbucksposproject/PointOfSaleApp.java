package com.starbucksproject.starbucksposproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PointOfSaleApp extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(PointOfSaleApp.class.getResource("pos-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Starbucks Point of Sale");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}