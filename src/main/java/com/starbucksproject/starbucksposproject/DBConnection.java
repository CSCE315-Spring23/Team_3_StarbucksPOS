package com.starbucksproject.starbucksposproject;

import java.io.IOException;
import java.sql.*;

public class DBConnection {
    private static DBConnection instance;
    private Connection conn = null;

    private DBConnection() {
        db_login();
    }

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
    //Creates a connection instance
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return conn;
    }

}
