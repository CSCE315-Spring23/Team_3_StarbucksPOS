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
import java.net.Inet4Address;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Sales Controller implements the buttons and other functions for the Sales page, including the
 * ability to look at all sales between two dates.
 */
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

    /**
     * Changes the current page to the main server page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
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
     * Changes the current page to the excess report page.
     *
     * @param event An ActionEvent that represents the button being clicked.
     * @throws IOException An exception caused if the input value is not expected.
     *
     */
    @FXML
    protected void clickExcessReport(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("excess-report-gui.fxml"));
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
    protected void clickBack(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Allows the sales table to be updated to show only sales between two dates.
     */
    @FXML
    protected void clickSalesBounded() {
        // Creates the connection to the database
        conn = DBConnection.getInstance().getConnection();

        // Initialize the dialog for the sales report
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Sales Report");
        dialog.setHeaderText("Select start date and end date:");
        ButtonType selectButtonType = new ButtonType("Enter", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);
        ChoiceBox<String> inventoryChoiceBox = new ChoiceBox<>();
        TextField fromDate = new TextField();
        TextField toDate = new TextField();
        fromDate.setText("YYMMDD");
        toDate.setText("YYMMDD");

        // Creates the pop-up box
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

        // Gets start date and end date from entered text strings
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
                // Creates and executes query
                final String query = "SELECT * FROM sales ORDER BY date DESC";
                PreparedStatement tableQuery = conn.prepareStatement(query);
                ResultSet response = tableQuery.executeQuery();
                ObservableList<SalesItem> items = FXCollections.observableArrayList();

                // Populates table with columns
                ObservableList<TableColumn> columns = salesTable.getColumns();
                columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
                columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
                columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
                columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
                columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
                columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

                // Populates columns with cells
                while (response.next()) {
                    int day = response.getInt("day");
                    int date = response.getInt("date");
                    int week = response.getInt("week");
                    int year = response.getInt("year");
                    boolean game_day = response.getBoolean("game_day");
                    double sales = response.getDouble("sales");

                    // check date before adding to the table
                    if (date >= startDate && date <= endDate) {
                        SalesItem item = new SalesItem(day, date, week, year, game_day, sales);
                        items.add(item);
                    }
                }

                salesTable.setItems(items);
            }
            // catch exception if connection does not work
            catch(SQLException e){
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
        // Creates the connection to the database
        conn = DBConnection.getInstance().getConnection();
        try {
            // Creates and executes query
            final String query = "SELECT * FROM sales ORDER BY date DESC";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<SalesItem> items = FXCollections.observableArrayList();
            // Populates table with columns
            ObservableList<TableColumn> columns = salesTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

            // Populates columns with cells
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
        // catch exception if connection does not work
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
        // Creates the connection to the database
        conn = DBConnection.getInstance().getConnection();
        try {
            // Creates and executes query
            final String query = "SELECT * FROM sales ORDER BY date DESC";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<SalesItem> items = FXCollections.observableArrayList();

            // Populates table with columns
            ObservableList<TableColumn> columns = salesTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("day"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("week"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("game_day"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("sales"));

            // Populates columns with cells
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
        // catch exception if connection does not work
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }
    }

    public static HashMap<String, Integer> getSalesItemReport(String beginDate, String endDate) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> orderList = getOrderList(beginDate, endDate);
        String itemName;

        for (String order : orderList) {
            ArrayList<Integer> orderInID = splitOrderString(order);
            for (int itemID : orderInID) {
                try {
                    itemName = CurrentOrderList.getInstance().getIdToNameMap().get(itemID);
                    if (!hashMap.containsKey(itemName)) { hashMap.put(itemName, 0); }
                    int appleCount = hashMap.get(itemName) + 1;
                    hashMap.put(itemName, appleCount);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    private static ArrayList<Integer> splitOrderString(String str) {
        String[] strArr = str.split(","); // split the string on commas
        ArrayList<Integer> intList = new ArrayList<>(); // create a new ArrayList to store the integers

        for (String s : strArr) {
            intList.add(Integer.parseInt(s)); // convert each string to an integer and add to the list
        }

        return intList;
    }

    private static ArrayList<String> getOrderList(String beginDate, String endDate) {
        String query = "SELECT order_list FROM transactions WHERE transaction_date BETWEEN ? AND ?";
        // Set 1 as beginDate and 2 as endDate
        ArrayList<String> orderLists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, beginDate);
            pstmt.setString(2, endDate);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                orderLists.add(rs.getString("order_list"));
            }
        } catch (SQLException e) {
            // Handle any errors that might occur
            e.printStackTrace();
        }
        return orderLists;
    }

    private static int[] getAllDates(String beginDate, String endDate) {
        // Convert the input dates to LocalDate objects
        LocalDate startDate = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern("yyMMdd"));
        LocalDate endDateObj = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyMMdd"));

        // Calculate the number of days between the start and end dates
        int days = (int) ChronoUnit.DAYS.between(startDate, endDateObj);

        // Create an array to store the dates
        int[] allDates = new int[days + 1];

        // Iterate through the dates and add them to the array
        for (int i = 0; i <= days; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            allDates[i] = Integer.parseInt(currentDate.format(DateTimeFormatter.ofPattern("yyMMdd")));
        }

        return allDates;
    }

    public static float[] getZReport() {
        float[] returnArray = {230322f, 13462.98f};
        TransactionsController newTrans = new TransactionsController();
        newTrans.updateSalesForDay();

        returnArray[0] = getCurrentDate();
        returnArray[1] = getSalesForDay(returnArray[0]);

        return returnArray;
    }

    private static float getCurrentDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String dateStr = now.format(formatter);
        float dateInt = Float.parseFloat(dateStr);
        return dateInt;
    }

    private static float getSalesForDay(float date) {
        String query = "SELECT sales FROM sales WHERE date=" + (int) date;


        Connection conn=DBConnection.getInstance().getConnection();
        float returnFloat = 0f;
        try {
            Statement stmt = conn.createStatement();
            ResultSet resSet = stmt.executeQuery(query);
            if (resSet.next()) {
                returnFloat = resSet.getFloat("sales");
            } else {
                System.out.println("No results returned in requestQuery.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return returnFloat;

    }
}
