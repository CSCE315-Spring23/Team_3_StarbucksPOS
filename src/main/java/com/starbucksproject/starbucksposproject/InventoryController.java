package com.starbucksproject.starbucksposproject;

import javafx.application.Platform;
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

public class InventoryController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView inventoryTable;
    @FXML
    protected void clickServer() {

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
    protected void clickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickChangeInventory() {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Inventory Dialog");
            dialog.setHeaderText("Select an inventory item and quantity");
            ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
            ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
            TextField quantityTextField = new TextField();
            quantityTextField.setText("1");
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT inventory_name FROM inventory ORDER BY inventory_name");
                while (rs.next()) {
                    String inventoryName = rs.getString("inventory_name");
                    inventoryChoiceBox.getItems().add(inventoryName);
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));
            grid.add(new Label("Inventory Item:"), 0, 0);
            grid.add(inventoryChoiceBox, 1, 0);
            grid.add(new Label("Quantity:"), 0, 1);
            grid.add(quantityTextField, 1, 1);
            Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
            selectButton.setDisable(true);
            inventoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                selectButton.setDisable(newValue == null);
            });
            dialog.getDialogPane().setContent(grid);
            Platform.runLater(() -> inventoryChoiceBox.requestFocus());
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == selectButtonType) {
                    String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                    String quantity = quantityTextField.getText();
                    return new Pair<>(selectedInventory, quantity);
                }
                return null;
            });
            Optional<Pair<String, String>> result = dialog.showAndWait();
            result.ifPresent(pair -> {
                String selectedInventory = pair.getKey();
                String quantity = pair.getValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
                java.util.Date date = new Date();
                String currDate = formatter.format(date);
//                System.out.println("Selected Inventory: " + selectedInventory);
//                System.out.println("Quantity: " + quantity);
                String updateInventory = "UPDATE inventory SET quantity = quantity + " + quantity + ", last_stocked = " + currDate + " WHERE inventory_name = '" + selectedInventory + "'";
                try {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(updateInventory);
                    stmt.close();

                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT inventory_id FROM inventory WHERE inventory_name = '" + selectedInventory + "'");
                    rs.next();
                    int inventoryId = rs.getInt("inventory_id");
                    stmt.close();
                    rs.close();

                    Statement maxDeliveryStmt = conn.createStatement();
                    rs = maxDeliveryStmt.executeQuery("SELECT MAX(delivery_id) FROM delivery");
                    rs.next();
                    int deliveryNum = rs.getInt("max") + 1;
                    maxDeliveryStmt.close();
                    Statement insertStmt = conn.createStatement();
                    insertStmt.executeUpdate("INSERT INTO delivery (delivery_id, inventory_id, amount, date_arrived) VALUES ("+ deliveryNum +", " + inventoryId + ", " + quantity + ", " + currDate + ")");
                    insertStmt.close();

                    ObservableList<InventoryItem> items = FXCollections.observableArrayList();
                    final String query = "SELECT * FROM inventory ORDER BY inventory_name";
                    PreparedStatement tableQuery = conn.prepareStatement(query);
                    ResultSet response = tableQuery.executeQuery();
                    while (response.next()) {
                        int id = response.getInt("inventory_id");
                        String name = response.getString("inventory_name");
                        int responsequantity = response.getInt("quantity");
                        int lastStocked = response.getInt("last_stocked");
                        InventoryItem item = new InventoryItem(id, name, responsequantity, lastStocked);
                        items.add(item);
                    }
                    inventoryTable.setItems(items);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            });

    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
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

            while (response.next()) {
                int id = response.getInt("inventory_id");
                String name = response.getString("inventory_name");
                int quantity = response.getInt("quantity");
                int lastStocked = response.getInt("last_stocked");
                InventoryItem item = new InventoryItem(id, name, quantity, lastStocked);
                items.add(item);
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
