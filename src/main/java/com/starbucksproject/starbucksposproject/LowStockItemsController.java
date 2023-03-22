package com.starbucksproject.starbucksposproject;

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
import java.util.Optional;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LowStockItemsController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView lowStockTable;

    /**
     * Changes the current page to the default server page (coffee GUI).
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickServer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the inventory page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickInventory(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("inventory-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the low stock items page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickLowStockItems(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("low-stock-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the sales page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickSales(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sales-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the transactions page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickTransactions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("transactions-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the inventory page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickMenuItems(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu-items-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the employees page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickEmployees(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employees-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current page to the main POS page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickZReport(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("z-report-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickExcessReport(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("excess-report-gui.fxml"));
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

    // changes the maximum amount an item is in stock for it to appear on the low stock table
    @FXML protected void clickChangeMinimumAmount(ActionEvent event) throws IOException {
        ArrayList<String> inventoryNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Low Stock Threshold");
        dialog.setHeaderText("Select an inventory item and a new minimum quantity.");
        ButtonType confirmButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
        TextField minimumAmountTextField = new TextField();
        minimumAmountTextField.setText("25");

        try {
            Statement statement = conn.createStatement();
            ResultSet result_set = statement.executeQuery("SELECT inventory_name FROM inventory ORDER BY inventory_name");

            while (result_set.next()) {
                String inventoryName = result_set.getString("inventory_name");
                inventoryChoiceBox.getItems().add(inventoryName);
            }

            result_set.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Inventory Item: "), 0, 0);
        grid.add(inventoryChoiceBox, 1, 0);
        grid.add(new Label("Minimum Quantity: "), 0, 1);
        grid.add(minimumAmountTextField, 1, 1);
        dialog.getDialogPane().setContent(grid);

        Node confirmButton = dialog.getDialogPane().lookupButton(confirmButtonType);
        confirmButton.setDisable(true);
        inventoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet result_set = statement.executeQuery("SELECT minimum_quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                result_set.next();
                double minimumAmount = result_set.getDouble("minimum_quantity");
                statement.close();
                result_set.close();
                confirmButton.setDisable(newValue == null);
            }
            catch (Exception e) {
                confirmButton.setDisable(true);
            }
        });

        minimumAmountTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet result_set = statement.executeQuery("SELECT  minimum_quantity FROM inventory WHERE inventory_name = '" + inventoryChoiceBox.getSelectionModel().getSelectedItem() + "'");
                result_set.next();
                Double minimumAmount = result_set.getDouble("minimum_quantity");
                statement.close();
                result_set.close();
                confirmButton.setDisable(Double.parseDouble(newValue) <= 0 || inventoryChoiceBox.getSelectionModel().getSelectedItem() == null);
            }
            catch (Exception e) {
                confirmButton.setDisable(true);
            }
        });

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirmButtonType) {
                String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
                double minimumAmount = Double.parseDouble(minimumAmountTextField.getText());

                return new Pair<>(selectedInventory, Double.toString(minimumAmount));
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(pair -> {
           String selectedInventory = pair.getKey();
           String minimumAmount = pair.getValue();
           String updateMinimumAmount = "UPDATE inventory SET minimum_quantity = " + minimumAmount + " WHERE inventory_name = '" + selectedInventory + "'";

           try {
               Statement statement = conn.createStatement();
               statement.executeUpdate(updateMinimumAmount);
               statement.close();

               final String query = "SELECT * FROM inventory ORDER BY inventory_name";
               PreparedStatement tableQuery = conn.prepareStatement(query);
               ResultSet response = tableQuery.executeQuery();
               ObservableList<LowStockInventoryItem> items = FXCollections.observableArrayList();

               while (response.next()) {
                   int id = response.getInt("inventory_id");
                   String name = response.getString("inventory_name");
                   double quantity = response.getDouble("quantity");
                   double minimum_quantity = response.getDouble("minimum_quantity");
                   int lastStocked = response.getInt("last_stocked");

                   if (quantity < minimum_quantity) {
                       LowStockInventoryItem item = new LowStockInventoryItem(id, name, quantity, minimum_quantity, lastStocked);
                       items.add(item);
                   }
               }
               lowStockTable.setItems(items);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
        });
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * Loads the table to include inventory items with 25 or less in stock.
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
            ObservableList<LowStockInventoryItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = lowStockTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("inventory_name"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("minimum_quantity"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("last_stocked"));

            while (response.next()) {
                int id = response.getInt("inventory_id");
                String name = response.getString("inventory_name");
                double quantity = response.getDouble("quantity");
                double minimum_quantity = response.getDouble("minimum_quantity");
                int lastStocked = response.getInt("last_stocked");

                if (quantity < minimum_quantity) {
                    LowStockInventoryItem item = new LowStockInventoryItem(id, name, quantity, minimum_quantity, lastStocked);
                    items.add(item);
                }
            }

            lowStockTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}
