package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;

/**
 * This class implements buttons for the coffee menu
 */
public class CoffeeController implements Initializable {

    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    int drinkSize = 0;

    @FXML
    private Button menuItemSpecial1;
    @FXML
    private Button menuItemSpecial2;
    @FXML
    private Button menuItemSpecial3;
    @FXML
    private Button menuItemSpecial4;
    @FXML
    private Button menuItemSpecial5;
    @FXML
    private Button menuItemSpecial6;
    @FXML
    private Button menuItemSpecial7;
    @FXML
    private Button menuItemSpecial8;
    @FXML
    private Button menuItemSpecial9;
    @FXML
    private Button menuItemSpecial10;

    /**
     * This button makes the drink size tall
     */
    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button makes the drink size grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button makes the drink size venti
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    /**This button changes the scene to the addons scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickAddons(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickNextDrink() {}
    /**This button changes the scene to the manager menu scene
     * @param event
     * @throws IOException
     */
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
    /**This button changes the scene to the coffee menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickCoffeeMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**This button changes the scene to the espresso menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickEspressoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**This button changes the scene to the blended menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickBlendedMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**This button changes the scene to the tea menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickTeasMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    /**This button changes the scene to the alternative menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    /**This button changes the scene to the food menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickFoodMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**This button changes the scene to the login scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickLogout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickEditCustomerName() {}

    /**
     * This button removes the latest item in the order list
     */
    @FXML
    protected void clickVoidLastItem() {
        if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
            CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
    }

    /**
     * This button processes the transaction, clears order list, updates the database
     */
    @FXML
    protected void clickPay() {
//        DateTime dateTime = new DateTime(); // current date and time
//        LocalDateTime dateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
//        String dateStr = dateTime.format(DateTimeFormatter.ofPattern("yyMMdd"));
        CurrentOrderList.getInstance().completeTransaction();
    }

    /**
     * This button adds special drink 1 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial1() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999011");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999012");
        } else{
            CurrentOrderList.getInstance().addItem("999013");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 2 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial2() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999021");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999022");
        } else{
            CurrentOrderList.getInstance().addItem("999023");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 3 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial3() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999031");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999032");
        } else{
            CurrentOrderList.getInstance().addItem("999033");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 4 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial4() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999041");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999042");
        } else{
            CurrentOrderList.getInstance().addItem("999043");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 5 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial5() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999051");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999052");
        } else{
            CurrentOrderList.getInstance().addItem("999053");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 6 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial6() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999061");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999062");
        } else{
            CurrentOrderList.getInstance().addItem("999063");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 7 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial7() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999071");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999072");
        } else{
            CurrentOrderList.getInstance().addItem("999073");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 8 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial8() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999081");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999082");
        } else{
            CurrentOrderList.getInstance().addItem("999083");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 9 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial9() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999091");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999092");
        } else{
            CurrentOrderList.getInstance().addItem("999093");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds special drink 10 to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickSpecial10() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("999101");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("999102");
        } else{
            CurrentOrderList.getInstance().addItem("999103");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds coffee to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101002");
        } else {
            CurrentOrderList.getInstance().addItem("101003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds coffee traveller to the order list
     */
    @FXML
    protected void clickCoffeeTraveller() {
        CurrentOrderList.getInstance().addItem("101014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced coffee to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101005");
        } else {
            CurrentOrderList.getInstance().addItem("101006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds cafe lait to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickCafeLait() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101008");
        } else {
            CurrentOrderList.getInstance().addItem("101009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cold brew to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickColdBrew() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101011");
        } else {
            CurrentOrderList.getInstance().addItem("101012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds coffee refill to the order list
     */
    @FXML
    protected void clickCoffeeRefill() {
        CurrentOrderList.getInstance().addItem("101013");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());

    }
    /**
     * Called to initialize a controller after its root element has been
     * completely processed. Used in this context to set up the database and load coffee beverages.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuItemSpecial1.setDisable(true);
        menuItemSpecial2.setDisable(true);
        menuItemSpecial3.setDisable(true);
        menuItemSpecial4.setDisable(true);
        menuItemSpecial5.setDisable(true);
        menuItemSpecial6.setDisable(true);
        menuItemSpecial7.setDisable(true);
        menuItemSpecial8.setDisable(true);
        menuItemSpecial9.setDisable(true);
        menuItemSpecial10.setDisable(true);
        conn = DBConnection.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and category='coffee_hot_iced'");
            while(rs.next()){
                switch((rs.getInt("item_id")/10)%100){
                    case 1:
                        menuItemSpecial1.setDisable(false);
                        menuItemSpecial1.setText(rs.getString("display_name"));
                        break;
                    case 2:
                        menuItemSpecial2.setDisable(false);
                        menuItemSpecial2.setText(rs.getString("display_name"));
                        break;
                    case 3:
                        menuItemSpecial3.setDisable(false);
                        menuItemSpecial3.setText(rs.getString("display_name"));
                        break;
                    case 4:
                        menuItemSpecial4.setDisable(false);
                        menuItemSpecial4.setText(rs.getString("display_name"));
                        break;
                    case 5:
                        menuItemSpecial5.setDisable(false);
                        menuItemSpecial5.setText(rs.getString("display_name"));
                        break;
                    case 6:
                        menuItemSpecial6.setDisable(false);
                        menuItemSpecial6.setText(rs.getString("display_name"));
                        break;
                    case 7:
                        menuItemSpecial7.setDisable(false);
                        menuItemSpecial7.setText(rs.getString("display_name"));
                        break;
                    case 8:
                        menuItemSpecial8.setDisable(false);
                        menuItemSpecial8.setText(rs.getString("display_name"));
                        break;
                    case 9:
                        menuItemSpecial9.setDisable(false);
                        menuItemSpecial9.setText(rs.getString("display_name"));
                        break;
                    case 10:
                        menuItemSpecial10.setDisable(false);
                        menuItemSpecial10.setText(rs.getString("display_name"));
                        break;

                }
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {

        }

    }
}
