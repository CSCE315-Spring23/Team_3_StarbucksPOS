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

public class FoodController {
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
    protected void clickBagel() {
        CurrentOrderList.getInstance().addItem("201003");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMultigrainBagel() {
        CurrentOrderList.getInstance().addItem("201002");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickEverythingBagel() {
        CurrentOrderList.getInstance().addItem("201001");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCreamCheese() {
        CurrentOrderList.getInstance().addItem("201004");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheeseDanish() {
        CurrentOrderList.getInstance().addItem("201006");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickAppleFritter() {
        CurrentOrderList.getInstance().addItem("201007");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSaltedCaramelCookie() {
        CurrentOrderList.getInstance().addItem("201008");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCinnamonRoll() {
        CurrentOrderList.getInstance().addItem("201009");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBlueberryMuffin() {
        CurrentOrderList.getInstance().addItem("201010");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTuxedoMuffin() {
        CurrentOrderList.getInstance().addItem("201011");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBananaMuffin() {
        CurrentOrderList.getInstance().addItem("201012");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetCroissant() {
        CurrentOrderList.getInstance().addItem("201014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickToffeeBar() {
        CurrentOrderList.getInstance().addItem("201017");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrownie() {
        CurrentOrderList.getInstance().addItem("201019");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201018");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201015");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBakedChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201016");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickZoesCookie() {
        CurrentOrderList.getInstance().addItem("201020");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheesecake() {
        CurrentOrderList.getInstance().addItem("201021");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickReesesBar() {
        CurrentOrderList.getInstance().addItem("201022");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
}
