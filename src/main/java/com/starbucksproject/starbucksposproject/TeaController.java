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
    protected void clickHotTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104002");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrewedTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104005");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104008");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHoChiMinhTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104011");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTazoChaiTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104017");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedTeaLemonade() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104014");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonBlackTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104040");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104041");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104042");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104043");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104044");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104045");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104026");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104023");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104024");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickPinkDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104020");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104034");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104035");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104036");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104032");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104033");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickDragonDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104028");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104029");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104030");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHibiscusRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104037");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().getCurrentOrder().add("104038");
        } else {
            CurrentOrderList.getInstance().getCurrentOrder().add("104039");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
}
