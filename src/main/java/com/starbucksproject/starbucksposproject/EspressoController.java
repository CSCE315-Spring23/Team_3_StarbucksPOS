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
 * This class is the controller for the espresso beverages. It has buttons that let the server choose espress based drinks
 */
public class EspressoController implements Initializable {

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
     * This button sets the drink size to tall
     */
    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button sets the drink size to grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button sets the drink size to venti
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    @FXML
    protected void clickAddons() {}
    @FXML
    protected void clickNextDrink() {}

    /**This button takes the user to the manager scene
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

    /**This button takes the user to the coffee menu scene
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

    /**This button takes the user to the espresso menu scene
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
    /**This button takes the user to the blended coffee menu scene
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
    /**This button takes the user to the tea menu scene
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
    /**This button takes the user to the alternative menu scene
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
    /**This button takes the user to the food menu scene
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
    /**This button takes the user to the login scene
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
     * This function removes the latest item in the order list
     */
    @FXML
    protected void clickVoidLastItem() {
        if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
            CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
    }

    /**
     * This function processes the transaction, clears order, updates database
     */
    @FXML
    protected void clickPay() {
        CurrentOrderList.getInstance().completeTransaction();

    }

    /**
     * This button adds the special drink 1 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 2 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 3 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 4 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 5 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 6 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 7 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 8 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 9 to the order list in either size tall, grande, or venti
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
     * This button adds the special drink 10 to the order list in either size tall, grande, or venti
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
     * This button adds americano to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103002");
        } else {
            CurrentOrderList.getInstance().addItem("103003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced americano to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103041");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103042");
        } else {
            CurrentOrderList.getInstance().addItem("103043");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cappuccino to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103005");
        } else {
            CurrentOrderList.getInstance().addItem("103006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103008");
        } else {
            CurrentOrderList.getInstance().addItem("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103008");
        } else {
            CurrentOrderList.getInstance().addItem("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cinnamon dolce latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103020");
        } else {
            CurrentOrderList.getInstance().addItem("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced cinnamon dolce latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103020");
        } else {
            CurrentOrderList.getInstance().addItem("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds caramel macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103011");
        } else {
            CurrentOrderList.getInstance().addItem("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced caramel macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103011");
        } else {
            CurrentOrderList.getInstance().addItem("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds coconut macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103026");
        } else {
            CurrentOrderList.getInstance().addItem("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced cocounut macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103026");
        } else {
            CurrentOrderList.getInstance().addItem("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103014");
        } else {
            CurrentOrderList.getInstance().addItem("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103014");
        } else {
            CurrentOrderList.getInstance().addItem("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds white mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103017");
        } else {
            CurrentOrderList.getInstance().addItem("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced white mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103017");
        } else {
            CurrentOrderList.getInstance().addItem("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds coconut mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103036");
        } else {
            CurrentOrderList.getInstance().addItem("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced coconut mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103036");
        } else {
            CurrentOrderList.getInstance().addItem("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds black white mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103039");
        } else {
            CurrentOrderList.getInstance().addItem("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced black white mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103039");
        } else {
            CurrentOrderList.getInstance().addItem("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds solo espresso to the order list
     */
    @FXML
    protected void clickSolo() {
        CurrentOrderList.getInstance().addItem("103031");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds double espresso to the order list
     */
    @FXML
    protected void clickDouble() {
        CurrentOrderList.getInstance().addItem("103032");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds triple espresso to the order list
     */
    @FXML
    protected void clickTriple() {
        CurrentOrderList.getInstance().addItem("103033");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds quad espresso to the order list
     */
    @FXML
    protected void clickQuad() {
        CurrentOrderList.getInstance().addItem("103034");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * Called to initialize a controller after its root element has been
     * completely processed. Used in this context to set up the database and load espresso beverages.
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and category='espresso-drinks'");
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
