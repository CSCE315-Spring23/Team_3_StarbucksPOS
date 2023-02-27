package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PointOfSaleController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}