package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HexFormat;
import javafx.scene.input.KeyEvent;

public class CoffeeController {

    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    int drinkSize = 0;

    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }

    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }

    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    @FXML
    public void clickAddons(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickNextDrink() {

    }

    @FXML
    public void clickManagerMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clickCoffeeMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clickEspressoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickBlendedMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickTeasMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void clickFoodMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickLogout() {

    }

    @FXML
    protected void clickEditCustomerName() {

    }

    @FXML
    protected void clickVoidLastItem() {

    }

    @FXML
    protected void clickPay() {
//        DateTime dateTime = new DateTime(); // current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String dateStr = dateTime.format(DateTimeFormatter.ofPattern("yyMMdd"));

    }

    @FXML
    protected void clickCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101002");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("101003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCoffeeTraveller() {
        CurrentOrderList.getInstance().getCurrentOrder().add("101014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickIcedCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101005");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("101006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCafeLait() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101008");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("101009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickColdBrew() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("101011");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("101012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCoffeeRefill() {
        CurrentOrderList.getInstance().getCurrentOrder().add("101013");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());

    }
}
