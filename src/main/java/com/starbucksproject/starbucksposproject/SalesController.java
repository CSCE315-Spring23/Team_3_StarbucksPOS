package com.starbucksproject.starbucksposproject;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
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
    private String startDatePrivate;
    @FXML
    private TextField toDate;
    private String endDatePrivate;

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
//    @FXML
//    protected void clickExcessReport(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("excess-report-gui.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
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
                startDatePrivate = fromDate.getText();
                endDatePrivate = toDate.getText();

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

    @FXML
    protected void clickPairSalesButton() {
        // Creates the connection to the database
        conn = DBConnection.getInstance().getConnection();

        // Initialize the dialog for the sales report
        Dialog<Object> dialog = new Dialog<Object>();
        dialog.setTitle("Sales Report");
        dialog.setHeaderText("Select start date and end date:");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        TextField fromDate = new TextField();
        TextField toDate = new TextField();
        fromDate.setText("YYMMDD");
        toDate.setText("YYMMDD");
        Button updateView = new Button("Update View");

        // Creates the pop-up box
        GridPane grid = new GridPane();
        GridPane innerGrid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));
        innerGrid.setHgap(10);
        innerGrid.setVgap(10);
        innerGrid.setAlignment(Pos.CENTER);
        innerGrid.setPadding(new Insets(20, 20, 10, 10));
        innerGrid.add(new Label("Start date: (YYMMDD)"), 0, 0);
        innerGrid.add(fromDate, 1, 0);
        innerGrid.add(new Label("End date: (YYMMDD)"), 0, 1);
        innerGrid.add(toDate, 1, 1);
        grid.add(innerGrid,0,0);
        grid.add(updateView, 0, 1);
        TableView<PairSaleItem> tableView = new TableView<>();
        tableView.prefWidthProperty().bind(tableView.widthProperty().multiply(2));


        TableColumn<PairSaleItem, String> item1Col = new TableColumn<>("Item 1");
        item1Col.setCellValueFactory(new PropertyValueFactory<>("item1"));
        item1Col.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));

        TableColumn<PairSaleItem, String> item2Col = new TableColumn<>("Item 2");
        item2Col.setCellValueFactory(new PropertyValueFactory<>("item2"));
        item2Col.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));


        TableColumn<PairSaleItem, Integer> amountCol = new TableColumn<>("Amount");
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amountCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));


        tableView.getColumns().add(item1Col);
        tableView.getColumns().add(item2Col);
        tableView.getColumns().add(amountCol);

        grid.add(tableView, 0, 2);
        updateView.setOnAction((ActionEvent event) -> {
            try{
                HashMap<Integer, String> idToName = CurrentOrderList.getInstance().getIdToNameMap();
                HashMap<ItemPair<String, String>, PairSaleItem> soldTogetherTracker = new HashMap<>();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM transactions WHERE transaction_date >= " + fromDate.getText() + " and transaction_date <= " + toDate.getText());
                while (rs.next()){
                    Object[] array = (Object[]) rs.getArray("order_list").getArray();
                    int[] intArray = new int[array.length];

                    for (int i = 0; i < array.length; i++) {
                        intArray[i] = (Integer) array[i];
                    }

                    for (int i = 0; i < intArray.length; i++) {
                        for (int j = i+1; j < intArray.length; j++) {
                            ItemPair<String, String> pair1 = new ItemPair<>(idToName.get(intArray[i]), idToName.get(intArray[j]));
                            ItemPair<String, String> pair2 = new ItemPair<>(idToName.get(intArray[j]), idToName.get(intArray[i]));
                            //If both null create for the first item
                            if (soldTogetherTracker.get(pair1) == null && soldTogetherTracker.get(pair2) == null){
                                soldTogetherTracker.put(pair1, new PairSaleItem(idToName.get(intArray[i]), idToName.get(intArray[j]), 1));
                            }
                            //Otherwise add to the one that is not null
                            else if(soldTogetherTracker.get(pair1) != null){
                                soldTogetherTracker.get(pair1).amount++;
                            }
                            else{
                                soldTogetherTracker.get(pair2).amount++;
                            }
                        }
                    }
                }
                rs.close();
                stmt.close();
                ObservableList<PairSaleItem> items = FXCollections.observableList(new ArrayList<PairSaleItem>(soldTogetherTracker.values()));
                tableView.setItems(items);
                tableView.getSortOrder().add(amountCol);
                amountCol.setSortType(TableColumn.SortType.DESCENDING);
                tableView.sort();
            }
            catch (Exception e){
                System.out.println("Update Failed");
            }
        });

        dialog.getDialogPane().setContent(grid);

        // Gets start date and end date from entered text strings
        Platform.runLater(() -> fromDate.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            return null;
        });

        dialog.showAndWait();

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
        strArr[0] = strArr[0].replace("{", "");
        strArr[strArr.length-1] = strArr[strArr.length-1].replace("}", "");
        ArrayList<Integer> intList = new ArrayList<>(); // create a new ArrayList to store the integers

        for (String s : strArr) {
            intList.add(Integer.parseInt(s)); // convert each string to an integer and add to the list
        }

        return intList;
    }

    private static ArrayList<Float> splitAmtString(String str) {
        String[] strArr = str.split(","); // split the string on commas
        strArr[0] = strArr[0].replace("{", "");
        strArr[strArr.length-1] = strArr[strArr.length-1].replace("}", "");
        ArrayList<Float> intList = new ArrayList<>(); // create a new ArrayList to store the integers

        for (String s : strArr) {
            intList.add(Float.parseFloat(s)); // convert each string to an integer and add to the list
        }

        return intList;
    }

    private static ArrayList<String> getOrderList(String beginDate, String endDate) {
        String query = "SELECT order_list FROM transactions WHERE transaction_date BETWEEN "+ beginDate +" AND " + endDate;
        // Set 1 as beginDate and 2 as endDate
        ArrayList<String> orderLists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

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
    public class SalesReportItem{
        public String item;
        public Integer num;

        public SalesReportItem(String item, Integer num) {
            this.item = item;
            this.num = num;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

    public class excessReportItem{
        public String item;
        public Float num;

        public excessReportItem(String item, Float num) {
            this.item = item;
            this.num = num;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Float getNum() {
            return num;
        }

        public void setNum(Float num) {
            this.num = num;
        }
    }
    public void clickSalesItemReport(ActionEvent event) throws IOException {
        clickSalesBounded();
        HashMap<String, Integer> salesItemReport = getSalesItemReport(startDatePrivate, endDatePrivate);
        ArrayList<String> items = new ArrayList<>(salesItemReport.keySet());
        ArrayList<SalesReportItem> salesReportItems = new ArrayList<>(items.size());
        for (String item : items) {
            salesReportItems.add(new SalesReportItem(item, salesItemReport.get(item)));
        }
        ObservableList<SalesReportItem> observable = FXCollections.observableList(salesReportItems);

        Dialog<Object> dialog = new Dialog<Object>();
        dialog.setTitle("Sales Report");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        GridPane grid = new GridPane();
        TableView<SalesReportItem> tableView = new TableView<>();
        TableColumn<SalesReportItem, String> itemNameCol = new TableColumn<>("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        itemNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.7));
        TableColumn<SalesReportItem, String> soldCol = new TableColumn<>("Amount Sold");
        soldCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        soldCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        tableView.getColumns().add(itemNameCol);
        tableView.getColumns().add(soldCol);
        tableView.setItems(observable);
        grid.add(tableView, 0, 0);

        dialog.getDialogPane().setContent(grid);

        // Gets start date and end date from entered text strings
        dialog.setResultConverter(dialogButton -> {
            return null;
        });

        dialog.showAndWait();

    }

    public void clickExcessReport(ActionEvent event) throws IOException {
        clickSalesBounded();
        HashMap<String, Float> excessReport = getExcessReport();
        ArrayList<String> items = new ArrayList<>(excessReport.keySet());
        ArrayList<excessReportItem> excessReportItems = new ArrayList<>(items.size());
        for (String item : items) {
            excessReportItems.add(new excessReportItem(item, excessReport.get(item)));
        }
        ObservableList<excessReportItem> observable = FXCollections.observableList(excessReportItems);

        Dialog<Object> dialog = new Dialog<Object>();
        dialog.setTitle("Excess Report");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        GridPane grid = new GridPane();
        TableView<excessReportItem> tableView = new TableView<>();
        TableColumn<excessReportItem, String> itemNameCol = new TableColumn<>("Inventory Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("inventory"));
        itemNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.7));
        TableColumn<excessReportItem, String> soldCol = new TableColumn<>("Amount Usec");
        soldCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        soldCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        tableView.getColumns().add(itemNameCol);
        tableView.getColumns().add(soldCol);
        tableView.setItems(observable);
        grid.add(tableView, 0, 0);

        dialog.getDialogPane().setContent(grid);

        // Gets start date and end date from entered text strings
        dialog.setResultConverter(dialogButton -> {
            return null;
        });

        dialog.showAndWait();

    }

    public HashMap<String, Float> getExcessReport() {
        ArrayList<String> ingredientsList = getIngredientsList();
        HashMap<String, Float> hashMap = new HashMap<>();
        String key;
        ArrayList<Float> amtInventory = getAmtInventory();
        for (String str : ingredientsList) { hashMap.put(str, 0f); }

        conn = DBConnection.getInstance().getConnection();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT ingredient_amounts FROM inventory_history WHERE date BETWEEN "+startDatePrivate+" AND " + endDatePrivate;
            ResultSet itr = statement.executeQuery(query);
            while (itr.next()) {
                ArrayList<Float> amounts = splitAmtString(itr.getString("ingredient_amounts"));
                for (int i=0; i < amounts.size(); i++) {
                    key = hashMap.keySet().toArray()[i].toString();
                    float currAmt = hashMap.get(key);
                    hashMap.put(key, currAmt + amounts.get(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        Iterator<Map.Entry<String, Float>> iterator = hashMap.entrySet().iterator();
        int i=0;
        while (iterator.hasNext()) {
            Map.Entry<String, Float> entry = iterator.next();
            float ratio = entry.getValue() / amtInventory.get(i);
            ratio = Math.round(ratio * 10)/10;
            if (ratio > 0.1 || amtInventory.get(i) == 0) {
                iterator.remove();
            }
            i++;
        }

        return hashMap;
    }

    private ArrayList<Float> getAmtInventory() {
        ArrayList<Float> inventoryNames = new ArrayList<>();;
        try {
            Statement stmt = conn.createStatement();

            String sql = "SELECT quantity FROM inventory";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                float inventoryAmt = rs.getFloat("quantity");
                inventoryNames.add(inventoryAmt);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return inventoryNames;

    }

    private ArrayList<String> getIngredientsList() {
        ArrayList<String> inventoryNames = new ArrayList<>();;
        try {
            Statement stmt = conn.createStatement();

            String sql = "SELECT inventory_name FROM inventory";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String inventoryName = rs.getString("inventory_name");
                inventoryNames.add(inventoryName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return inventoryNames;
    }
}
