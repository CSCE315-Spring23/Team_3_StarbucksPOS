package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class EspressoController {

    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void clickTall() {

    }
    @FXML
    protected void clickGrande() {

    }
    @FXML
    protected void clickVenti() {

    }
    @FXML
    protected void clickAddons() {

    }@FXML
    protected void clickNext() {

    }
    @FXML
    public void clickManagerMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clickCoffeeMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clickEspressoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickBlendedMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickTeasMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    protected void clickFoodMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickBack() {

    }
    @FXML
    protected void clickEditCustomerName() {

    }
    @FXML
    protected void clickVoidLastItem() {

    }
    @FXML
    protected void clickPay() {

    }
    @FXML
    protected void clickAmericano() {

    }
    @FXML
    protected void clickIcedAmericano() {

    }
    @FXML
    protected void clickCappuccino() {

    }
    @FXML
    protected void clickLatte() {

    }
    @FXML
    protected void clickIcedLatte() {

    }
    @FXML
    protected void clickCinnamonDolceLatte() {

    }
    @FXML
    protected void clickIcedCinnamonDolceLatte() {

    }
    @FXML
    protected void clickCaramelMacchiato() {

    }
    @FXML
    protected void clickIcedCaramelMacchiato() {

    }
    @FXML
    protected void clickCoconutMacchiato() {

    }
    @FXML
    protected void clickIcedCoconutMacchiato() {

    }
    @FXML
    protected void clickMocha() {

    }
    @FXML
    protected void clickIcedMocha() {

    }
    @FXML
    protected void clickWhiteMocha() {

    }
    @FXML
    protected void clickIcedWhiteMocha() {

    }
    @FXML
    protected void clickCoconutMocha() {

    }
    @FXML
    protected void clickIcedCoconutMocha() {

    }
    @FXML
    protected void clickBlackWhiteMocha() {

    }
    @FXML
    protected void clickIcedBlackWhiteMocha() {

    }
    @FXML
    protected void clickSolo() {

    }
    @FXML
    protected void clickDouble() {

    }
    @FXML
    protected void clickTriple() {

    }
    @FXML
    protected void clickQuad() {

    }

}
