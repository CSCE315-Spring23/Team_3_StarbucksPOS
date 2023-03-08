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
import java.util.Arrays;
import java.util.HexFormat;
import javafx.scene.input.KeyEvent;

public class PointOfSaleController {
//    Connection conn = null;
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
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToManager(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    private void db_login(){
//        String teamNumber = "team_3";
//        String dbName = "csce315331_" + teamNumber;
//        String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
//        // dbSetup myCredentials = new dbSetup();
//
//        //Connecting to the database
//        try {
//            conn = DriverManager.getConnection(dbConnectionString, DatabaseCredentials.user, DatabaseCredentials.pswd);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//
//        System.out.println("INFO: Opened database successfully");
//    }
    @FXML
    private TextField employeeID;
    @FXML
    private TextField employeePIN;

    private boolean isManager = false;
    private int currentUserID = -1;
    private String currentUserName = null;
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
    protected void attemptLogin(ActionEvent event) throws NoSuchAlgorithmException {
        //Grab employeeID and pin and match with what's in database
        int id = Integer.parseInt(employeeID.getText());
        String pin = employeePIN.getText();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] hashedPIN = md5.digest(pin.getBytes());
//        if (conn == null) {
//            db_login();
//        }
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            //create a statement object
            Statement stmt = conn.createStatement();
            //Running a query looks for a entered id in the employee table
            String sqlMatch = "SELECT * FROM employees WHERE employee_id=" + id;

            //send statement to DBMS
            //This executeQuery command is useful for data retrieval
            ResultSet result = stmt.executeQuery(sqlMatch);
            result.next();
            //If statement checking if the ID and pins are a match. Upon successful log-in attempt-..
            // check ID to see if manager or barista.
//            String strHashed = Arrays.toString(hashedPIN);
            String strHashed = HexFormat.of().formatHex(hashedPIN);
//            byte[] grabbedBytes = result.getBytes("employee_pin");
//            System.out.println(Arrays.compare(grabbedBytes, hashedPIN));
            String grabbedPIN = result.getString("employee_pin");
            if (result.getInt("employee_id") == id && grabbedPIN.equals(strHashed)) {
                if (result.getBoolean("access_mgmt")) {
                    isManager = true;
                    System.out.println("Log-in Success! Access Permission: Manager");
                } else {
                    isManager = false;
                    System.out.println("Log-in Success! Access Permission: Barista");
                }
                currentUserID = id;
                currentUserName = result.getString("employee_name");
                if (isManager == true) {
                    switchToManager(event);
                }
                else {
                    switchToCoffee(event);
                }



            } else {
                System.out.println("Could not find user. Check username or PIN.");
                employeeID.setText(null);
                employeePIN.setText(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }
    }

    //The textFieldInFocus functions indicate which textField is currently being written in.
    boolean currentFocus = false;
    int enterClicked = 0;
    protected void textFieldInFocus() {
        Node focusNode = employeeID.getScene().getFocusOwner();
        if (focusNode == employeeID) {
            currentFocus = false;
        } else if (focusNode == employeePIN) {
            currentFocus = true;
        }
    }
    @FXML
    protected void setIdHighlight() {
        //I think this function is meant to choose the textField so user can enter numbers?
        //If that's the case, here is the code
        employeeID.requestFocus();
        currentFocus = false;
    }
    @FXML
    protected void setPinHighlight() {
        employeePIN.requestFocus();
        currentFocus = true;
    }

    @FXML
    protected void clickButton0() {
        if (currentFocus == false) {
            employeeID.appendText("0");
        }
        else {
            employeePIN.appendText("0");
        }
    }
    @FXML
    protected void clickButton1() {
        if (currentFocus == false) {
            employeeID.appendText("1");
        }
        else {
            employeePIN.appendText("1");
        }
    }
    @FXML
    protected void clickButton2() {
        if (currentFocus == false) {
            employeeID.appendText("2");
        }
        else {
            employeePIN.appendText("2");
        }
    }
    @FXML
    protected void clickButton3() {
        if (currentFocus == false) {
            employeeID.appendText("3");
        }
        else {
            employeePIN.appendText("3");
        }
    }
    @FXML
    protected void clickButton4() {
        if (currentFocus == false) {
            employeeID.appendText("4");
        }
        else {
            employeePIN.appendText("4");
        }
    }
    @FXML
    protected void clickButton5() {
        if (currentFocus == false) {
            employeeID.appendText("5");
        }
        else {
            employeePIN.appendText("5");
        }
    }
    @FXML
    protected void clickButton6() {
        if (currentFocus == false) {
            employeeID.appendText("6");
        }
        else {
            employeePIN.appendText("6");
        }
    }
    @FXML
    protected void clickButton7() {
        if (currentFocus == false) {
            employeeID.appendText("7");
        }
        else {
            employeePIN.appendText("7");
        }
    }
    @FXML
    protected void clickButton8(){
        if (currentFocus == false) {
            employeeID.appendText("8");
        }
        else {
            employeePIN.appendText("8");
        }
    }
    @FXML
    protected void clickButton9() {
        if (currentFocus == false) {
            employeeID.appendText("9");
        }
        else {
            employeePIN.appendText("9");
        }
    }
    @FXML
    protected void clickButtonClear(ActionEvent event) {
        //Will clear whichever text field is in focus. If neither in focus, clear both.
        if (currentFocus == false) {
            employeeID.setText(null);
        }
        else {
            employeePIN.setText(null);
        }

    }
    @FXML
    protected void clickButtonEnter(ActionEvent event) {
        //leftLogin.setOnAction(event -> attemptLogin());
        currentFocus = true;
        if (enterClicked == 2) {
            try {
                attemptLogin(event);
            } catch (Exception e) {
                System.out.println("failed login");
            }
        }

    }
}