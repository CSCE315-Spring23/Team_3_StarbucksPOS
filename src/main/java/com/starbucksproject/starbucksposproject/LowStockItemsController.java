package com.starbucksproject.starbucksposproject;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class LowStockItemsController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView inventoryTable;
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
    protected void clickMenuItems(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu-items-gui.fxml"));
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
    protected void clickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * Loads the table to include all inventory items
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        conn = DBConnection.getInstance().getConnection();
        try {
            final String query = "SELECT * FROM inventory ORDER BY inventory_name";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<InventoryItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = inventoryTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("inventory_name"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("last_stocked"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("costs"));

            while (response.next()) {
                int id = response.getInt("inventory_id");
                String name = response.getString("inventory_name");
                double quantity = response.getDouble("quantity");
                int lastStocked = response.getInt("last_stocked");
                double costs = response.getDouble("costs");

                if (quantity <= 25.0) {
                    InventoryItem item = new InventoryItem(id, name, quantity, lastStocked, costs);
                    items.add(item);
                }
            }

            inventoryTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }

    }
}
