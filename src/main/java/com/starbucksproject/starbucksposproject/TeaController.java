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

public class TeaController {
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
    protected void clickHotTea() {

    }
    @FXML
    protected void clickBrewedTea() {

    }
    @FXML
    protected void clickGreenTea() {

    }
    @FXML
    protected void clickHoChiMinhTea() {

    }
    @FXML
    protected void clickTazoChaiTea() {

    }
    @FXML
    protected void clickIcedTeaLemonade() {

    }
    @FXML
    protected void clickTavalonBlackTea() {

    }
    @FXML
    protected void clickTavalonGreenTea() {

    }
    @FXML
    protected void clickStrawberryRefresher() {

    }
    @FXML
    protected void clickStrawberryLemonadeRefresher() {

    }
    @FXML
    protected void clickPinkDrink() {

    }
    @FXML
    protected void clickMangoRefresher() {

    }
    @FXML
    protected void clickMangoLemonadeRefresher() {

    }
    @FXML
    protected void clickDragonDrink() {

    }
    @FXML
    protected void clickHibiscusRefresher() {

    }
}
