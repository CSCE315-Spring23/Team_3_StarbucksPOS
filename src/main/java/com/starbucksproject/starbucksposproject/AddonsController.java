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

public class AddonsController {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void clickAddons(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
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
    protected void clickEspressoShot() {

    }
    @FXML
    protected void clickFrappuccinoRoast() {

    }
    @FXML
    protected void clickClassicSyrup() {

    }
    @FXML
    protected void clickVanillaSyrup() {

    }
    @FXML
    protected void clickCaramelSyrup() {

    }
    @FXML
    protected void clickCinnamonDolceSyrup() {

    }
    @FXML
    protected void clickToffeeNutSyrup() {

    }
    @FXML
    protected void clickMochaSauce() {

    }
    @FXML
    protected void clickWhiteChocolateSauce() {

    }
    @FXML
    protected void clickCinnamonDolceTopping() {

    }
    @FXML
    protected void click2pMilk() {

    }
    @FXML
    protected void clickWholeMilk() {

    }
    @FXML
    protected void clickBreve() {

    }
    @FXML
    protected void clickHeavyCream() {

    }
    @FXML
    protected void clickSweetCream() {

    }
    @FXML
    protected void clickWhippedCream() {

    }
    @FXML
    protected void clickAlmondMilk() {

    }
    @FXML
    protected void clickOatMilk() {

    }
    @FXML
    protected void clickSoyMilk() {

    }
    @FXML
    protected void clickCoconutMilk() {

    }
    @FXML
    protected void clickLemonade() {

    }
    @FXML
    protected void clickMatcha() {

    }
    @FXML
    protected void clickStrawberryInclusions() {

    }
    @FXML
    protected void clickDragonfruitInclusions() {

    }
    @FXML
    protected void clickStrawberryAcaiBase() {

    }
    @FXML
    protected void clickMangoDragonfruitBase() {

    }
    @FXML
    protected void clickHoney() {

    }
    @FXML
    protected void clickIce() {

    }
}
