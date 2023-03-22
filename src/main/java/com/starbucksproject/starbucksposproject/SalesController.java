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
import java.util.HexFormat;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class SalesController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView salesTable;

    @FXML
    private TextField fromDate;
    @FXML
    private TextField toDate;

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
    protected void clickBack(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Allows the sales table to be updated to show only sales between two dates.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickSalesBounded(ActionEvent event) throws IOException {
        // Enter SalesReport actions here:
        conn = DBConnection.getInstance().getConnection();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Sales Report");
        dialog.setHeaderText("Select start date and end date:");
        ButtonType selectButtonType = new ButtonType("Enter", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
        TextField fromDate = new TextField();
        TextField toDate = new TextField();
        fromDate.setText("000000");
        toDate.setText("000000");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Start date: (YYMMDD)"), 0, 0);
        grid.add(fromDate, 1, 0);
        grid.add(new Label("End date: (YYMMDD)"), 0, 1);
        grid.add(toDate, 1, 1);
        Node selectButton = dialog.getDialogPane().lookupButton(selectButtonType);
        selectButton.setDisable(false);
        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> fromDate.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == selectButtonType) {
                int startDate = Integer.parseInt(fromDate.getText());
                int endDate = Integer.parseInt(toDate.getText());

                return new Pair<>(String.format("%d", startDate), String.format("%d", endDate));
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(pair -> {


            int startDate = 0;
            int endDate = 0;

            startDate = Integer.parseInt(fromDate.getText());
            endDate = Integer.parseInt(toDate.getText());

            try {
                final String query = "SELECT * FROM sales ORDER BY date DESC";
                PreparedStatement tableQuery = conn.prepareStatement(query);
                ResultSet response = tableQuery.executeQuery();
                ObservableList<SalesItem> items = FXCollections.observableArrayList();

                ObservableList<TableColumn> columns = salesTable.getColumns();
                columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
                columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
                columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
                columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
                columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
                columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

                while (response.next()) {
                    int day = response.getInt("day");
                    int date = response.getInt("date");
                    int week = response.getInt("week");
                    int year = response.getInt("year");
                    boolean game_day = response.getBoolean("game_day");
                    double sales = response.getDouble("sales");

                    if (date >= startDate && date <= endDate) {
                        SalesItem item = new SalesItem(day, date, week, year, game_day, sales);
                        items.add(item);
                    }
                }

                salesTable.setItems(items);


            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
            }

        });
    }

    /**
     * Resets the table to the full database value.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickReset(ActionEvent event) throws IOException {
        conn = DBConnection.getInstance().getConnection();
        try {
            final String query = "SELECT * FROM sales ORDER BY date DESC";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<SalesItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = salesTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

            while (response.next()) {
                int day = response.getInt("day");
                int date = response.getInt("date");
                int week = response.getInt("week");
                int year = response.getInt("year");
                boolean game_day = response.getBoolean("game_day");
                double sales = response.getDouble("sales");

                SalesItem item = new SalesItem(day, date, week, year, game_day, sales);
                items.add(item);
            }

            salesTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }
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
            final String query = "SELECT * FROM sales ORDER BY date DESC";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<SalesItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = salesTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

            while (response.next()) {
                int day = response.getInt("day");
                int date = response.getInt("date");
                int week = response.getInt("week");
                int year = response.getInt("year");
                boolean game_day = response.getBoolean("game_day");
                double sales = response.getDouble("sales");

                SalesItem item = new SalesItem(day, date, week, year, game_day, sales);
                items.add(item);
            }

            salesTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }

    }


}
