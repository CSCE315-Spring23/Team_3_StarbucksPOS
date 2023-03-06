package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class PointOfSaleController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToCoffee(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEspresso(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFood(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAlternatives(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField employeeID;
    @FXML
    private TextField employeePIN;
    @FXML
    private Button leftLogin;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    protected void attemptLogin(){

    }
    @FXML
    protected void setIdHighlight(){

    }
    @FXML
    protected void setPinHighlight(){

    }
    @FXML
    protected void clickButton0(){

    }
    @FXML
    protected void clickButton1(){

    }
    @FXML
    protected void clickButton2(){

    }
    @FXML
    protected void clickButton3(){

    }
    @FXML
    protected void clickButton4(){

    }
    @FXML
    protected void clickButton5(){

    }
    @FXML
    protected void clickButton6(){

    }
    @FXML
    protected void clickButton7(){

    }
    @FXML
    protected void clickButton8(){

    }
    @FXML
    protected void clickButton9(){

    }
    @FXML
    protected void clickButtonClear(){

    }

    @FXML
    protected void clickButtonEnter(){

    }
}