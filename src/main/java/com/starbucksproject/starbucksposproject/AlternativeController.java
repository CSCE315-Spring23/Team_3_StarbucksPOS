package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * THe AlternativeController.java function implements javafx buttons for the alternative menu items in our database
 */
public class AlternativeController implements Initializable {
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
     * Assign drink size variable to 0 to indicate tall
     */
    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }

    /**
     * Assign drink size variable to 1 to indicate grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }

    /**
     * Assign drink size variable to 2 to indicate venti
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    /**This button changes the scene to the addons scene where the user can add addons to the drink
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickAddons(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickNextDrink() {}

    /** This function changes the scene to the manager-view scene
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

    /**This function changes the scene to the coffee menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickCoffeeMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function changes the scene to the espresso menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickEspressoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function changes the scene to the blended beverage scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickBlendedMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function changes the scene to the Tea drink scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickTeasMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**This button changes the scene to the coffee alternative scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This button takes the user to login scene
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
     * This button removes the most recently added item in the order list
     */
    @FXML
    protected void clickVoidLastItem() {
        if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
            CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
    }

    /**
     * This button processes the payment by clearing order list and changing database
     */
    @FXML
    protected void clickPay() {
        CurrentOrderList.getInstance().completeTransaction();

    }

    /**
     * This button adds special item 1 to the orderlist
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
     * This button adds special item 2 to the orderlist
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
     * This button adds special item 3 to the orderlist
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
     * This button adds special item 4 to the orderlist
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
     * This button adds special item 5 to the orderlist
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
     * This button adds special item 6 to the orderlist
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
     * This button adds special item 7 to the orderlist
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
     * This button adds special item 8 to the orderlist
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
     * This button adds special item 9 to the orderlist
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
     * This button adds special item 10 to the orderlist
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
     * This button adds steamed milk to the orderlist
     */
    @FXML
    protected void clickSteamedMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106013");
        }
        else if(drinkSize == 1){

                CurrentOrderList.getInstance().addItem("106014");
        } else{
                CurrentOrderList.getInstance().addItem("106015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cold milk to the orderlist
     */
    @FXML
    protected void clickColdMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106002");
        } else {
            CurrentOrderList.getInstance().addItem("106003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds hot chocolate to the orderlist
     */
    @FXML
    protected void clickHotChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106005");
        } else {
            CurrentOrderList.getInstance().addItem("106006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds hot white chocolate to the orderlist
     */
    @FXML
    protected void clickHotWhiteChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106008");
        } else {
            CurrentOrderList.getInstance().addItem("106009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds soda to the orderlist
     */
    @FXML
    protected void clickSoda() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106011");
        } else {
            CurrentOrderList.getInstance().addItem("106012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed. Used in this context to set up the database and load special items.
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and category='coffee-alternatives'");
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
