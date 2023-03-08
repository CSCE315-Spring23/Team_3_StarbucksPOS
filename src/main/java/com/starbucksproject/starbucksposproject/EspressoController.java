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
    protected void clickAddons() {

    }@FXML
    protected void clickNextDrink() {

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

    }
    @FXML
    protected void clickAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103002");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103041");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103042");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103043");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103005");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103008");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103008");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103020");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103020");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103011");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103011");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103026");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103026");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103014");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103014");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103017");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103017");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103036");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103036");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103039");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("103039");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSolo() {
        CurrentOrderList.getInstance().getCurrentOrder().add("103031");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickDouble() {
        CurrentOrderList.getInstance().getCurrentOrder().add("103032");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTriple() {
        CurrentOrderList.getInstance().getCurrentOrder().add("103033");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickQuad() {
        CurrentOrderList.getInstance().getCurrentOrder().add("103034");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
