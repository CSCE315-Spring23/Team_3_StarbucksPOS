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

public class MenuItemsController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TableView menuItemsTable;
    @FXML
    protected void clickServer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("inventory-gui.fxml"));
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
    protected void clickEmployees(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employees-gui.fxml"));
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
    protected void clickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void clickChangeMenuItem() {

        ArrayList<String> menuNames = new ArrayList<>();
        conn = DBConnection.getInstance().getConnection();

            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Update Menu Price");
            dialog.setHeaderText("Select an menu item and price");
            ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
            ChoiceBox<String> menuChoiceBox = new ChoiceBox<>();
            TextField quantityTextField = new TextField();
            quantityTextField.setText("1");
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT item_name FROM menu_items ORDER BY item_name");
                while (rs.next()) {
                    String inventoryName = rs.getString("item_name");
                    menuChoiceBox.getItems().add(inventoryName);
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
            grid.add(new Label("Menu Item:"), 0, 0);
            grid.add(menuChoiceBox, 1, 0);
            grid.add(new Label("Price:"), 0, 1);
            grid.add(quantityTextField, 1, 1);
            Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
            selectButton.setDisable(true);
            menuChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                selectButton.setDisable(newValue == null);
            });
            dialog.getDialogPane().setContent(grid);
            Platform.runLater(() -> menuChoiceBox.requestFocus());
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == selectButtonType) {
                    String selectedInventory = menuChoiceBox.getSelectionModel().getSelectedItem();
                    String quantity = quantityTextField.getText();
                    return new Pair<>(selectedInventory, quantity);
                }
                return null;
            });
            Optional<Pair<String, String>> result = dialog.showAndWait();
            result.ifPresent(pair -> {
                String selectedInventory = pair.getKey();
                String priceDialog = pair.getValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
                Date date = new Date();
                String currDate = formatter.format(date);
//                System.out.println("Selected Inventory: " + selectedInventory);
//                System.out.println("Quantity: " + quantity);
                String updateInventory = "UPDATE menu_items SET price = " + priceDialog + " WHERE item_name = '" + selectedInventory + "'";
                try {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(updateInventory);
                    stmt.close();

//                    stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT item_id FROM menu_items WHERE item_name = '" + selectedInventory + "'");
//                    rs.next();
//                    int inventoryId = rs.getInt("inventory_id");
//                    stmt.close();
//                    rs.close();

                    ObservableList<MenuItemsItem> items = FXCollections.observableArrayList();
                    final String query = "SELECT * FROM menu_items ORDER BY item_name";
                    PreparedStatement tableQuery = conn.prepareStatement(query);
                    ResultSet response = tableQuery.executeQuery();
                    while (response.next()) {
                        int item_id = response.getInt("item_id");
                        String item_name = response.getString("item_name");
                        String display_name = response.getString("display_name");
                        String category = response.getString("category");
                        String size = response.getString("size");
                        String ingredients = response.getString("ingredients");
                        double price = response.getDouble("price");
                        MenuItemsItem item = new MenuItemsItem(item_id, item_name, display_name, category, size, ingredients, price);
                        items.add(item);
                    }

                    menuItemsTable.setItems(items);
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
            final String query = "SELECT * FROM menu_items ORDER BY item_name";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<MenuItemsItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = menuItemsTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("item_id"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("item_name"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("display_name"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("category"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("size"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("ingredients"));
            columns.get(6).setCellValueFactory(new PropertyValueFactory<>("price"));

            while (response.next()) {
                int item_id = response.getInt("item_id");
                String item_name = response.getString("item_name");
                String display_name = response.getString("display_name");
                String category = response.getString("category");
                String size = response.getString("size");
                String ingredients = response.getString("ingredients");
                double price = response.getDouble("price");
                MenuItemsItem item = new MenuItemsItem(item_id, item_name, display_name, category, size, ingredients, price);
                items.add(item);
            }

            menuItemsTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }

    }
}
