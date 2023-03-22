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

public class InventoryController implements Initializable {
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

    @FXML
    protected void clickChangeInventory() {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Inventory Dialog");
            dialog.setHeaderText("Select an inventory item and quantity");
        ButtonType quickRoundDown = new ButtonType("Round Down", ButtonBar.ButtonData.APPLY);
        ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(quickRoundDown, selectButtonType, ButtonType.CANCEL);
            ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
            ChoiceBox<String> addSubChoiceBox = new ChoiceBox<>();
            addSubChoiceBox.getItems().add("Add");
            addSubChoiceBox.getItems().add("Sub");
            addSubChoiceBox.getSelectionModel().selectFirst();
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
            grid.add(new Label("Add or Subtract:"), 0, 1);
            grid.add(addSubChoiceBox, 1, 1);
            grid.add(new Label("Quantity:"), 0, 2);
            grid.add(quantityTextField, 1, 2);
            Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
            Node roundDownButton = dialog.getDialogPane().lookupButton(quickRoundDown);
            selectButton.setDisable(true);
            roundDownButton.setDisable(true);
            inventoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    roundDownButton.setDisable(inventoryChoiceBox.getSelectionModel().getSelectedItem().equals(""));
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                    rs.next();
                    int amount = rs.getInt("quantity");
                    stmt.close();
                    rs.close();
                    selectButton.setDisable(newValue == null || Integer.parseInt(quantityTextField.getText()) <= 0 || (addSubChoiceBox.getSelectionModel().isSelected(1) && amount - Integer.parseInt(quantityTextField.getText()) < 0));
                }
                catch(Exception e){
                    selectButton.setDisable(true);
                }
            });
            quantityTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    roundDownButton.setDisable(inventoryChoiceBox.getSelectionModel().getSelectedItem().equals(""));
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                    rs.next();
                    int amount = rs.getInt("quantity");
                    stmt.close();
                    rs.close();
                    selectButton.setDisable(Integer.parseInt(newValue) <= 0 || inventoryChoiceBox.getSelectionModel().getSelectedItem() == null || (addSubChoiceBox.getSelectionModel().isSelected(1) && amount - Integer.parseInt(quantityTextField.getText()) < 0));
                }
                catch(Exception e){
                    selectButton.setDisable(true);
                }
            });
            addSubChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    roundDownButton.setDisable(inventoryChoiceBox.getSelectionModel().getSelectedItem().equals(""));
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                    rs.next();
                    int amount = rs.getInt("quantity");
                    stmt.close();
                    rs.close();
                    selectButton.setDisable(Integer.parseInt(quantityTextField.getText()) <= 0 || inventoryChoiceBox.getSelectionModel().getSelectedItem() == null || (addSubChoiceBox.getSelectionModel().isSelected(1) && amount - Integer.parseInt(quantityTextField.getText()) < 0));
                }
                catch(Exception e){
                    selectButton.setDisable(true);
                }
            });
            AtomicBoolean subtracting = new AtomicBoolean(false);
            dialog.getDialogPane().setContent(grid);
            Platform.runLater(() -> inventoryChoiceBox.requestFocus());
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == selectButtonType) {
                    String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                    int quantity = Integer.parseInt(quantityTextField.getText());
                    if (addSubChoiceBox.getSelectionModel().isSelected(1)) {
                        quantity *= -1;
                        subtracting.set(true);
                    }
                    else{
                        subtracting.set(false);
                    }
                    return new Pair<>(selectedInventory, Integer.toString(quantity));
                }
                else if (dialogButton == quickRoundDown){
                    subtracting.set(true);
                    String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                    double amount = 0;
                    try {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                        rs.next();
                        amount = -rs.getDouble("quantity");
                        stmt.close();
                        rs.close();
                        int roundedDown = (int)amount;
                        amount -= roundedDown;
                    }
                    catch (SQLException e){}
                    return new Pair<>(selectedInventory, Double.toString(amount));
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

                    if (!subtracting.get()) {
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
                        insertStmt.executeUpdate("INSERT INTO delivery (delivery_id, inventory_id, amount, date_arrived) VALUES (" + deliveryNum + ", " + inventoryId + ", " + quantity + ", " + currDate + ")");
                        insertStmt.close();
                    }

                    ObservableList<InventoryItem> items = FXCollections.observableArrayList();
                    final String query = "SELECT * FROM inventory ORDER BY inventory_name";
                    PreparedStatement tableQuery = conn.prepareStatement(query);
                    ResultSet response = tableQuery.executeQuery();
                    while (response.next()) {
                        int id = response.getInt("inventory_id");
                        String name = response.getString("inventory_name");
                        double responsequantity = response.getDouble("quantity");
                        int lastStocked = response.getInt("last_stocked");
                        double costs = response.getDouble("costs");

                        InventoryItem item = new InventoryItem(id, name, responsequantity, lastStocked, costs);
                        items.add(item);
                    }
                    inventoryTable.setItems(items);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            });

    }
    @FXML
    protected void clickAddInventoryItem() {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

        Dialog<Pair<String, Pair<String,String>>> dialog = new Dialog<>();
        dialog.setTitle("Add an item");
        dialog.setHeaderText("Select an inventory name and initial quantity ");
        ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
        TextField newNameField = new TextField();
        TextField quantityTextField = new TextField();
        quantityTextField.setText("0");
        TextField costTextField = new TextField();
        costTextField.setText("0.00");
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT inventory_name FROM inventory ORDER BY inventory_name");
//            while (rs.next()) {
//                String inventoryName = rs.getString("inventory_name");
//                inventoryChoiceBox.getItems().add(inventoryName);
//            }
//            rs.close();
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Inventory Item Name:"), 0, 0);
        grid.add(newNameField, 1, 0);
        grid.add(new Label("Cost: $"), 0, 1);
        grid.add(costTextField, 1, 1);
        grid.add(new Label("Initial Amount:"), 0, 2);
        grid.add(quantityTextField, 1, 2);
        Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
        selectButton.setDisable(true);
        ChangeListener<String> action = (observable, oldValue, newValue) -> {
            try {
                selectButton.setDisable(Integer.parseInt(quantityTextField.getText()) < 0 || newNameField.getText().equals("") || (costTextField.getText().indexOf('.') != -1 && costTextField.getText().substring(costTextField.getText().indexOf('.')+1).length() > 2));
            }
            catch (Exception e){
                selectButton.setDisable(true);
            }
        };
//        newNameField.textProperty().addListener((observable, oldValue, newValue) -> {
//            selectButton.setDisable(newValue.equals("") || Integer.parseInt(quantityTextField.getText()) < 0 || Double.parseDouble(costTextField.getText()) < 0 || costTextField.getText().substring(costTextField.getText().indexOf('.')+1).length() > 2);
//        });
        newNameField.textProperty().addListener(action);
//        quantityTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//            try {
//                selectButton.setDisable(Integer.parseInt(newValue) < 0 || newNameField.getText().equals("") || costTextField.getText().substring(costTextField.getText().indexOf('.')+1).length() > 2);
//            }
//            catch (Exception e){
//                selectButton.setDisable(true);
//            }
//        });
        quantityTextField.textProperty().addListener(action);
//        costTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//            try {
//                selectButton.setDisable(Integer.parseInt(quantityTextField.getText()) < 0 || newNameField.getText().equals("") || newValue.substring(newValue.indexOf('.')+1).length() > 2);
//            }
//            catch (Exception e){
//                selectButton.setDisable(true);
//            }
//        });
        costTextField.textProperty().addListener(action);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> inventoryChoiceBox.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == selectButtonType) {
                String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                String quantity = quantityTextField.getText();
                return new Pair<>(selectedInventory, new Pair<>(quantity, costTextField.getText()));
            }
            return null;
        });
        Optional<Pair<String, Pair<String, String>>> result = dialog.showAndWait();
        result.ifPresent(pair -> {
            String inventoryName = pair.getKey();
            String quantity = pair.getValue().getKey();
            String cost = pair.getValue().getValue();
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
            java.util.Date date = new Date();
            String currDate = formatter.format(date);
            int maxId = 1;
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT max(inventory_id) FROM inventory");
                rs.next();
                maxId += rs.getInt("max");
            } catch (SQLException e) {
                e.printStackTrace();
            }
//                System.out.println("Selected Inventory: " + selectedInventory);
//                System.out.println("Quantity: " + quantity);
            String updateInventory = "INSERT INTO inventory VALUES (" + maxId + ",'" + inventoryName + "'," + quantity + "," + currDate + "," + cost + ")";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(updateInventory);
                stmt.close();

                Statement maxDeliveryStmt = conn.createStatement();
                ResultSet rs = maxDeliveryStmt.executeQuery("SELECT MAX(delivery_id) FROM delivery");
                rs.next();
                int deliveryNum = rs.getInt("max") + 1;
                maxDeliveryStmt.close();
                Statement insertStmt = conn.createStatement();
                insertStmt.executeUpdate("INSERT INTO delivery (delivery_id, inventory_id, amount, date_arrived) VALUES ("+ deliveryNum +", " + maxId + ", " + quantity + ", " + currDate + ")");
                insertStmt.close();

                ObservableList<InventoryItem> items = FXCollections.observableArrayList();
                final String query = "SELECT * FROM inventory ORDER BY inventory_name";
                PreparedStatement tableQuery = conn.prepareStatement(query);
                ResultSet response = tableQuery.executeQuery();
                while (response.next()) {
                    int id = response.getInt("inventory_id");
                    String name = response.getString("inventory_name");
                    double responsequantity = response.getDouble("quantity");
                    int lastStocked = response.getInt("last_stocked");
                    double costs = response.getDouble("costs");
                    InventoryItem item = new InventoryItem(id, name, responsequantity, lastStocked, costs);
                    items.add(item);
                }
                inventoryTable.setItems(items);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

    }

    @FXML
    protected void clickRemoveInventoryItem() {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Remove Item");
        dialog.setHeaderText("Select an inventory item");
        ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
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
        Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
        selectButton.setDisable(true);
        inventoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                selectButton.setDisable(newValue == null);
            }
            catch(Exception e){
                selectButton.setDisable(true);
            }
        });
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> inventoryChoiceBox.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == selectButtonType) {
                return inventoryChoiceBox.getSelectionModel().getSelectedItem();
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(item -> {
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
            java.util.Date date = new Date();
            String currDate = formatter.format(date);
//                System.out.println("Selected Inventory: " + selectedInventory);
//                System.out.println("Quantity: " + quantity);
            String updateInventory = "DELETE FROM inventory WHERE inventory_name = '" + item + "'";
//            String updateInventory = "UPDATE inventory SET inventory_name='NA',quantity=0,costs=0 WHERE inventory_name='" + item + "'";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(updateInventory);
                stmt.close();

                ObservableList<InventoryItem> items = FXCollections.observableArrayList();
                final String query = "SELECT * FROM inventory ORDER BY inventory_name";
                PreparedStatement tableQuery = conn.prepareStatement(query);
                ResultSet response = tableQuery.executeQuery();
                while (response.next()) {
                    int id = response.getInt("inventory_id");
                    String name = response.getString("inventory_name");
                    double responsequantity = response.getDouble("quantity");
                    int lastStocked = response.getInt("last_stocked");
                    double costs = response.getDouble("costs");
                    InventoryItem itemUpdate = new InventoryItem(id, name, responsequantity, lastStocked, costs);
                    items.add(itemUpdate);
                }
                inventoryTable.setItems(items);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

    }

    @FXML
    protected void clickChangeInventoryCost() {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Update Cost");
        dialog.setHeaderText("Select an inventory item and new cost");
        ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
        TextField quantityTextField = new TextField();
        quantityTextField.setText("0.00");
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
        grid.add(new Label("Cost: $"), 0, 1);
        grid.add(quantityTextField, 1, 1);
        Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
        selectButton.setDisable(true);
        inventoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectButton.setDisable(newValue == null || Double.parseDouble(quantityTextField.getText()) < 0 || quantityTextField.getText().substring(quantityTextField.getText().indexOf('.')+1).length() > 2);
        });
        quantityTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                selectButton.setDisable(Double.parseDouble(newValue) < 0 || newValue.substring(newValue.indexOf('.')+1).length() > 2 || inventoryChoiceBox.getSelectionModel().getSelectedItem() == null);
            }
            catch (Exception e){
                selectButton.setDisable(true);
            }
        });
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> inventoryChoiceBox.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == selectButtonType) {
                String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                double quantity = Double.parseDouble(quantityTextField.getText());

                return new Pair<>(selectedInventory, String.format("%.2f", quantity));
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
            String updateInventory = "UPDATE inventory SET costs = " + quantity + " WHERE inventory_name = '" + selectedInventory + "'";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(updateInventory);
                stmt.close();

                ObservableList<InventoryItem> items = FXCollections.observableArrayList();
                final String query = "SELECT * FROM inventory ORDER BY inventory_name";
                PreparedStatement tableQuery = conn.prepareStatement(query);
                ResultSet response = tableQuery.executeQuery();
                while (response.next()) {
                    int id = response.getInt("inventory_id");
                    String name = response.getString("inventory_name");
                    double responsequantity = response.getDouble("quantity");
                    int lastStocked = response.getInt("last_stocked");
                    double costs = response.getDouble("costs");

                    InventoryItem item = new InventoryItem(id, name, responsequantity, lastStocked, costs);
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
                InventoryItem item = new InventoryItem(id, name, quantity, lastStocked, costs);
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
