package com.starbucksproject.starbucksposproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView employeesTable;
    @FXML
    protected void clickServer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickInventory(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("inventory-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickLowStockItems(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("low-stock-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickMenuItems(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu-items-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickSales(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sales-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickTransactions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("transactions-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickEmployees(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employees-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickZReport(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("z-report-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        conn = DBConnection.getInstance().getConnection();
        try {
            final String query = "SELECT employee_id,employee_name,employee_role,access_mgmt FROM employees ORDER BY employee_id";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<EmployeesItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = employeesTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("employee_id"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("employee_name"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("employee_role"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("access_mgmt"));

            while (response.next()) {
                int id = response.getInt("employee_id");
                String name = response.getString("employee_name");
                String role = response.getString("employee_role");
                Boolean mgmt = response.getBoolean("access_mgmt");
                EmployeesItem item = new EmployeesItem(id, name, role, mgmt);
                items.add(item);
            }

            employeesTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }

    }
}
