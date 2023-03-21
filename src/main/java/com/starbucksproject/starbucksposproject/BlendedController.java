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

public class BlendedController {
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
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickNextDrink() {

    }
    @FXML
    public void clickManagerMenu(ActionEvent event) throws IOException {
        if(CurrentOrderList.getInstance().isManager()) {
            root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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
    protected void clickLogout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickEditCustomerName() {

    }
    @FXML
    protected void clickVoidLastItem() {
        if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
            CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
    }
    @FXML
    protected void clickPay() {
        CurrentOrderList.getInstance().completeTransaction();

    }
    @FXML
    protected void clickCoffeeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105002");
        } else {
            CurrentOrderList.getInstance().addItem("105003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void  clickEspressoFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105005");
        } else {
            CurrentOrderList.getInstance().addItem("105006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMochaFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105008");
        } else {
            CurrentOrderList.getInstance().addItem("105009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickWhiteMochaFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105026");
        } else {
            CurrentOrderList.getInstance().addItem("105027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCaramelFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105011");
        } else {
            CurrentOrderList.getInstance().addItem("105012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickJavaChipFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105020");
        } else {
            CurrentOrderList.getInstance().addItem("105021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickVanillaBeanCremeCrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105017");
        } else {
            CurrentOrderList.getInstance().addItem("105018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105014");
        } else {
            CurrentOrderList.getInstance().addItem("105015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickDoubleChocolateCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105023");
        } else {
            CurrentOrderList.getInstance().addItem("105024");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMatchaCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105032");
        } else {
            CurrentOrderList.getInstance().addItem("105033");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBlueberrySmoothie() {
        CurrentOrderList.getInstance().addItem("105028");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickPomegranateSmoothie() {
        CurrentOrderList.getInstance().addItem("105029");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoSmoothie() {
        CurrentOrderList.getInstance().addItem("105030");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
}
