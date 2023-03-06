package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
public class PointOfSaleController {
    Connection conn = null;

    private void db_login(){
        String teamNumber = "team_3";
        String dbName = "csce315331_" + teamNumber;
        String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
        // dbSetup myCredentials = new dbSetup();

        //Connecting to the database
        try {
            conn = DriverManager.getConnection(dbConnectionString, DatabaseCredentials.user, DatabaseCredentials.pswd);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        System.out.println("INFO: Opened database successfully");
    }
    @FXML
    private TextField employeeID;
    @FXML
    private TextField employeePIN;

    private boolean isManager = false;
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
    protected void attemptLogin() {
        //Grab employeeID and pin and match with what's in database
        String id = employeeID.getText();
        String pin = employeePIN.getText();
        if (conn == null) {
            db_login();
        }
        try {
            //create a statement object
            Statement stmt = conn.createStatement();
            //Running a query
            String sqlMatchID = "SELECT employee_id FROM employees WHERE employee_id=" + id;
            String sqlMatchPIN = "SELECT employee_pin FROM employees WHERE employee_id=" + id;
            //send statement to DBMS
            //This executeQuery command is useful for data retrieval
            ResultSet resultID = stmt.executeQuery(sqlMatchID);
            ResultSet resultPIN = stmt.executeQuery(sqlMatchPIN);
            //If statement checking if the ID and pins are a match. Upon successful log-in attempt-..
            // check ID to see if manager or barista.
            if (resultID.getString("employee_id") == id && resultPIN.getString("employee_pin") == pin) {
                if (resultID.getString("employee_id").charAt(0) == '1') {
                    isManager = true;
                    System.out.println("Log-in Success! Access Permission: Manager");
                } else {
                    isManager = false;
                    System.out.println("Log-in Success! Access Permission: Barista");
                }
            } else {
                System.out.println("Could not find user. Check username or PIN.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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