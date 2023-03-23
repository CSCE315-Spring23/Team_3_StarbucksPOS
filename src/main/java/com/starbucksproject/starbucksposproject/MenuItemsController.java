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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * This class implements functions for the menu items page.
 */
public class MenuItemsController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TableView menuItemsTable;

    /**
     * Changes the current page to the main server page.
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
     * Changes the current page to the Z report page.
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

    /**
     * Changes the current page to the menu items page.
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
     * Changes the current page to the login page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Allows a user to modify special seasonal menu items through a dialog.
     *
     * @throws SQLException
     */
    @FXML
    protected void updateSpecialMenuItems() throws SQLException {
        conn = DBConnection.getInstance().getConnection();
        Dialog<ArrayList<Pair<String, Double>>> dialog = new Dialog<>();
        dialog.setTitle("Update Special Menu");
        dialog.setHeaderText("Update names, prices, and ingredients:");
        ButtonType done = new ButtonType("Done", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(done, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Enabled"), 0, 0);
        grid.add(new Label("Display Name"), 1, 0);
        grid.add(new Label("Item Base Name"), 2, 0);
        grid.add(new Label("Ingredients"), 3, 0);
        grid.add(new Label("Price"), 4, 0);
//        List<ObservableList<Pair<String, Double>>> ingredientArray = new ArrayList<>(10);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");
        ArrayList<String> ingredients_list = new ArrayList<>();
        while (rs.next()){
            ingredients_list.add(rs.getString("inventory_name"));
        }
        rs.close();
        stmt.close();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and (size='NA' or size='grande')");
        MenuItemsItem[] currSpecials = new MenuItemsItem[10];
        while (rs.next()){
            currSpecials[((rs.getInt("item_id")/10)%100)-1] = new MenuItemsItem(rs.getString("inventory_name").contains("-grande") ? rs.getString("inventory_name").substring(0, rs.getString("inventory_name").indexOf("-grande")) : rs.getString("inventory_name"), rs.getString("display_name"), rs.getString("category"), rs.getDouble("price"), true);
        }
        Node[][] gridArr = new Node[10][6];
        ObservableList<Pair<String, Double>>[] selectedIngredientLists = new ObservableList[10];
        for (int i = 1; i <= 10; i++) {
            CheckBox checkBox = new CheckBox("");
//            checkBox.setContentDisplay(ContentDisplay.RIGHT);
            TextField dispName = new TextField();
            TextField baseName = new TextField();
            Button ingredients = new Button("Select Ingredients");
            TextField price = new TextField();
            ChoiceBox<String> category = new ChoiceBox<>(FXCollections.observableArrayList(
                    "coffee-hot-iced", "espresso-drink", "frappuccino-and-blended", "tea-hot-iced", "coffee-alternatives", "add-on", "bakery-coremark"
            ));
            if (currSpecials[i-1] != null){
                checkBox.setSelected(true);
                dispName.setText(currSpecials[i-1].getDisplay_name());
                baseName.setText(currSpecials[i-1].getItem_name());
                price.setText(Double.toString(currSpecials[i-1].getPrice()));
                category.getSelectionModel().select(currSpecials[i-1].getCategory());
            }


            checkBox.setOnAction(event -> {
                dispName.setDisable(!checkBox.isSelected());
                ingredients.setDisable(!checkBox.isSelected());
                price.setDisable(!checkBox.isSelected());
            });
            //Save to separate variable for the lambda function to operate separate from the loop
            //Think of it like taking a snapshot
            int finalI = i;
            ingredients.setOnAction(event -> {
                IngredientDialog ingredientDialog = new IngredientDialog(ingredients_list);
                Optional<ObservableList<Pair<String,Double>>> selectedIngredients = ingredientDialog.showAndWait();
                selectedIngredients.ifPresent(pairs -> {
                    selectedIngredientLists[finalI-1] = pairs;
                });
            });
            grid.add(checkBox, 0, i);
            grid.add(dispName, 1, i);
            grid.add(baseName, 2, i);
            grid.add(ingredients, 3, i);
            grid.add(price, 4, i);
            grid.add(category, 5, i);
            gridArr[i-1][0] = checkBox;
            gridArr[i-1][1] = dispName;
            gridArr[i-1][2] = baseName;
            gridArr[i-1][3] = ingredients;
            gridArr[i-1][4] = price;
            gridArr[i-1][5] = category;
        }
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == done) {
//                String selectedInventory = inventoryChoiceBox.getSelectionModel().getSelectedItem();
//                String quantity = quantityTextField.getText();
//                return new Pair<>(selectedInventory, new Pair<>(quantity, costTextField.getText()));
                try {
                    ArrayList<PreparedStatement> stmts = new ArrayList<>(10);
                    String sql = "UPDATE special_menu_items SET inventory_name=?,display_name=?,category=?,ingredients=?,amounts=?,price=?,size=?,enabled=? WHERE item_id = ?";
                    for (int i = 0; i < 10; i++) {
                        CheckBox currCheckBox = (CheckBox) gridArr[i][0];
                        TextField currDispName = (TextField) gridArr[i][1];
                        TextField currBaseName = (TextField) gridArr[i][2];
//                        Button currIngredients = (Button) gridArr[i][3];
                        TextField currPrice = (TextField) gridArr[i][4];
                        ChoiceBox<String> currCategory = (ChoiceBox<String>) gridArr[i][5];
                        ArrayList<String> ingredients = new ArrayList<>();
                        ArrayList<Double> amounts = new ArrayList<>();
                        try {
                            selectedIngredientLists[i].forEach(pair -> {
                                ingredients.add(pair.getKey());
                                amounts.add(pair.getValue());
                            });
                        }
                        catch(Exception e){
                            //do nothing intentionally
                        }
                        if (currCheckBox.isSelected()) {
                            if(currCategory.getSelectionModel().getSelectedItem().equals("add-on") || currCategory.getSelectionModel().getSelectedItem().equals("bakery-coremark")){
                                PreparedStatement prepped = conn.prepareStatement(sql);
                                prepped.setString(1, currBaseName.getText());
                                prepped.setString(2, currDispName.getText());
                                prepped.setString(3, currCategory.getSelectionModel().getSelectedItem());
                                if(ingredients.size() == 0){
                                    prepped.setArray(4, null);
                                }
                                else{
                                    Array sqlIngredients = conn.createArrayOf("text", ingredients.toArray());
                                    prepped.setArray(4, sqlIngredients);
                                }
                                if(amounts.size() == 0){
                                    prepped.setArray(5, null);
                                }
                                else {
                                    Array sqlAmounts = conn.createArrayOf("double", amounts.toArray());
                                    prepped.setArray(5, sqlAmounts);
                                }
                                prepped.setDouble(6, Double.parseDouble(currPrice.getText()));
                                prepped.setString(7, "NA");
                                prepped.setInt(9, Integer.parseInt("999" + String.format("%02d",i+1) + "0"));
                                prepped.setBoolean(8, true);
//                                prepped.executeUpdate();
                                PreparedStatement preppedTall = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "1");
//                                preppedTall.executeUpdate();
                                PreparedStatement preppedGrande = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "2");
//                                preppedGrande.executeUpdate();
                                PreparedStatement preppedVenti = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "3");
                                preppedVenti.executeUpdate();
                                stmts.add(prepped);
                                stmts.add(preppedGrande);
                                stmts.add(preppedTall);
                                stmts.add(preppedVenti);
                            }
                            else{
                                PreparedStatement preppedDisableNoSize = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "0");
                                ArrayList<Double> tallAmounts = new ArrayList<>(amounts);
//                                tallAmounts.forEach(amount -> {amount*=.75;});
                                tallAmounts.replaceAll(amount -> amount * .75);
                                ArrayList<Double> ventiAmounts = new ArrayList<>(amounts);
                                ventiAmounts.replaceAll(amount -> amount*=1.5);
                                Array sqlIngredients = conn.createArrayOf("text", ingredients.toArray());
                                ///TODO: Modify ingredient amount to scale
                                PreparedStatement preppedTall = conn.prepareStatement(sql);
                                preppedTall.setString(1, currBaseName.getText() + "-tall");
                                preppedTall.setString(2, currDispName.getText());
                                preppedTall.setString(3, currCategory.getSelectionModel().getSelectedItem());
                                preppedTall.setArray(4, sqlIngredients);
                                Array sqlAmountsTall = conn.createArrayOf("double", tallAmounts.toArray());
                                preppedTall.setArray(5, sqlAmountsTall);
                                preppedTall.setDouble(6, Math.max(Double.parseDouble(currPrice.getText())-.4, 0));
                                preppedTall.setString(7, "tall");
                                preppedTall.setInt(9, Integer.parseInt("999" + String.format("%02d",i+1) + "1"));
                                preppedTall.setBoolean(8, true);

                                PreparedStatement preppedGrande = conn.prepareStatement(sql);
                                preppedGrande.setString(1, currBaseName.getText() + "-grande");
                                preppedGrande.setString(2, currDispName.getText());
                                preppedGrande.setString(3, currCategory.getSelectionModel().getSelectedItem());
                                preppedGrande.setArray(4, sqlIngredients);
                                Array sqlAmounts = conn.createArrayOf("double", amounts.toArray());
                                preppedGrande.setArray(5, sqlAmounts);
                                preppedGrande.setDouble(6, Double.parseDouble(currPrice.getText()));
                                preppedGrande.setString(7, "grande");
                                preppedGrande.setInt(9, Integer.parseInt("999" + String.format("%02d",i+1) + "2"));
                                preppedGrande.setBoolean(8, true);
                                ///TODO: Modify ingredient amount to scale
                                PreparedStatement preppedVenti = conn.prepareStatement(sql);
                                preppedVenti.setString(1, currBaseName.getText() + "-venti");
                                preppedVenti.setString(2, currDispName.getText());
                                preppedVenti.setString(3, currCategory.getSelectionModel().getSelectedItem());
                                preppedVenti.setArray(4, sqlIngredients);
                                Array sqlAmountsVenti = conn.createArrayOf("double", ventiAmounts.toArray());
                                preppedVenti.setArray(5, sqlAmountsVenti);
                                preppedVenti.setDouble(6, Double.parseDouble(currPrice.getText())+.8);
                                preppedVenti.setString(7, "NA");
                                preppedVenti.setInt(9, Integer.parseInt("999" + String.format("%02d",i+1) + "3"));
                                preppedVenti.setBoolean(8, true);
                                stmts.add(preppedDisableNoSize);
                                stmts.add(preppedGrande);
                                stmts.add(preppedTall);
                                stmts.add(preppedVenti);
                            }
                        } else {
//                            stmts.add("UPDATE special_menu_items SET enabled=false WHERE item_id LIKE 99" + String.format("%02d", i) + "%");
                            PreparedStatement prepped0 = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "0");
                            PreparedStatement prepped1 = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "1");
                            PreparedStatement prepped2 = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "2");
                            PreparedStatement prepped3 = conn.prepareStatement("UPDATE special_menu_items SET enabled=false WHERE item_id = 999" + String.format("%02d", i+1) + "3");

                            stmts.add(prepped0);
                            stmts.add(prepped1);
                            stmts.add(prepped2);
                            stmts.add(prepped3);
                        }
                    }
                    stmts.forEach(preppedStatement -> {
                        try {
                            preppedStatement.executeUpdate();
                            System.out.println("Executed successfully: " + preppedStatement.toString());
                        } catch (SQLException e) {
                            System.out.println("failed statement: " + preppedStatement.toString());
                            System.out.println(e.getMessage());
                        }
                    });
                } catch(SQLException e){
                    return null;
                }
            }
            return null;
        });
        Optional<ArrayList<Pair<String, Double>>> result = dialog.showAndWait();


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
                        String amounts = response.getString("amounts");
                        double price = response.getDouble("price");
                        MenuItemsItem item = new MenuItemsItem(item_id, item_name, display_name, category, size, ingredients, amounts, price);
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
            String query = "SELECT * FROM menu_items ORDER BY item_name";
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
            columns.get(6).setCellValueFactory(new PropertyValueFactory<>("amounts"));
            columns.get(7).setCellValueFactory(new PropertyValueFactory<>("price"));

            while (response.next()) {
                int item_id = response.getInt("item_id");
                String item_name = response.getString("item_name");
                String display_name = response.getString("display_name");
                String category = response.getString("category");
                String size = response.getString("size");
                String ingredients = response.getString("ingredients");
                String amounts = response.getString("amounts");
                double price = response.getDouble("price");
                MenuItemsItem item = new MenuItemsItem(item_id, item_name, display_name, category, size, ingredients, amounts, price);
                items.add(item);
            }
            response.close();
            tableQuery.close();
            query = "SELECT * FROM special_menu_items ORDER BY inventory_name";
            tableQuery = conn.prepareStatement(query);
            response = tableQuery.executeQuery();
            while (response.next()) {
                int item_id = response.getInt("item_id");
                String item_name = response.getString("inventory_name");
                String display_name = response.getString("display_name");
                String category = response.getString("category");
                String size = response.getString("size");
                String ingredients = response.getString("ingredients");
                String amounts = response.getString("amounts");
                double price = response.getDouble("price");
                MenuItemsItem item = new MenuItemsItem(item_id, item_name, display_name, category, size, ingredients, amounts, price);
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
