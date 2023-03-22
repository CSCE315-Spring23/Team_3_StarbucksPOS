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

public class TeaController implements Initializable {
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
    @FXML
    protected void clickHotTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104002");
        } else {
            CurrentOrderList.getInstance().addItem("104003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrewedTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104005");
        } else {
            CurrentOrderList.getInstance().addItem("104006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104008");
        } else {
            CurrentOrderList.getInstance().addItem("104009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHoChiMinhTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104011");
        } else {
            CurrentOrderList.getInstance().addItem("104012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTazoChaiTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104017");
        } else {
            CurrentOrderList.getInstance().addItem("104018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedTeaLemonade() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104014");
        } else {
            CurrentOrderList.getInstance().addItem("104015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonBlackTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104040");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104041");
        } else {
            CurrentOrderList.getInstance().addItem("104042");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104043");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104044");
        } else {
            CurrentOrderList.getInstance().addItem("104045");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104026");
        } else {
            CurrentOrderList.getInstance().addItem("104027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104023");
        } else {
            CurrentOrderList.getInstance().addItem("104024");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickPinkDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104020");
        } else {
            CurrentOrderList.getInstance().addItem("104021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104034");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104035");
        } else {
            CurrentOrderList.getInstance().addItem("104036");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104032");
        } else {
            CurrentOrderList.getInstance().addItem("104033");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickDragonDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104028");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104029");
        } else {
            CurrentOrderList.getInstance().addItem("104030");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHibiscusRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104037");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104038");
        } else {
            CurrentOrderList.getInstance().addItem("104039");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and category='tea-hot-iced'");
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
