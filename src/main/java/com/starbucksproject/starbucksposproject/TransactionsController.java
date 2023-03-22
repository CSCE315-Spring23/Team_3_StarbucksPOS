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

import java.text.ParseException;
import java.util.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionsController implements Initializable {
    Connection conn = DBConnection.getInstance().getConnection();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView transactionsTable;
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
            final String query = "SELECT * FROM transactions ORDER BY transaction_id DESC";
            PreparedStatement tableQuery = conn.prepareStatement(query);
            ResultSet response = tableQuery.executeQuery();
            ObservableList<TransactionsItem> items = FXCollections.observableArrayList();

            ObservableList<TableColumn> columns = transactionsTable.getColumns();
            columns.get(0).setCellValueFactory(new PropertyValueFactory<>("transaction_id"));
            columns.get(1).setCellValueFactory(new PropertyValueFactory<>("transaction_date"));
            columns.get(2).setCellValueFactory(new PropertyValueFactory<>("num_of_items"));
            columns.get(3).setCellValueFactory(new PropertyValueFactory<>("order_list"));
            columns.get(4).setCellValueFactory(new PropertyValueFactory<>("employee"));
            columns.get(5).setCellValueFactory(new PropertyValueFactory<>("total"));

            while (response.next()) {
                int transaction_id = response.getInt("transaction_id");
                int transaction_date = response.getInt("transaction_date");
                int num_of_items = response.getInt("num_of_items");
                String order_list = response.getString("order_list");
                String employee = response.getString("employee");
                double total = response.getDouble("total");

                TransactionsItem item = new TransactionsItem(transaction_id, transaction_date, num_of_items, order_list, employee, total);
                items.add(item);
            }

            transactionsTable.setItems(items);


        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
        }

    }

    private void processQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private String requestQuery(String query, String columnName) {
        String returnString = "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet resSet = stmt.executeQuery(query);
            if (resSet.next()) {
                returnString = resSet.getString(columnName);
            } else {
                System.out.println("No results returned in requestQuery.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return returnString;
    }

    public void updateSalesForDay() {
        // update the total to the DB (SAM)
        String currDate = createNewDate();
//        updateDay(currDate);
//        updateWeek(currDate);
        updateYear(currDate);
        updateGameDay(currDate);
        updateSales(currDate);
    }

    private String createNewDate() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String formattedDate = dateFormat.format(today);
        processQuery("INSERT INTO sales (date) VALUES (" + formattedDate + ")");
        return formattedDate;
    }

//    private void updateDay(String currDate) {
//        processQuery("INSERT INTO sales (day) VALUES (");
//    }

//    private void updateWeek(String currDate) {
//        processQuery("INSERT INTO sales (week) VALUES ("+);
//    }

    private void updateYear(String currDate) {
        processQuery("UPDATE sales SET year = 20"+currDate.substring(0,2)+" WHERE date=" + currDate);
    }

    private void updateGameDay(String currDate) {
        // Just make it false
        processQuery("INSERT INTO sales (game_day) VALUES (false) WHERE date=" + currDate);
    }

    private void updateSales(String currDate) {
        // Create the query
        String query = updateSalesQuery();
        // request the query
        String total = requestQuery(query, "total");
        // Update it to the table ROW ALREADY EXIST
        processQuery("UPDATE transactions SET total=" + total + " WHERE transaction_date=" + currDate);
    }

    private String updateSalesQuery() {
        String latestDateQuery = "SELECT MAX(transaction_date) from transactions";// write query to get the latest date
        // request the query
        String latestDate = requestQuery(latestDateQuery, "transaction_date");
        // total for that latestDate (SAM)
        return "SELECT SUM(total) from transactions WHERE transaction_Date =" + latestDate;
    }

    private static float[] addArrays(float[] arr1, float[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Input arrays must have the same length");
        }

        float[] result = new float[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }

        return result;
    }

    public HashMap<String, Float> getExcessReport(String beginDate, String endDate) throws ParseException {
        String[] ingredientsList = getIngredientsList();
        float[] amountsList = getFloatArray(beginDate, endDate);

        HashMap<String, Float> hashMap = new HashMap<String, Float>();

        for (int i = 0; i < ingredientsList.length; i++) {
            String key = ingredientsList[i];
            Float value = amountsList[i];
            hashMap.put(key, value);
        }

        return hashMap;
    }

    private float[] getFloatArray(String beginDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        Date startDate = dateFormat.parse(beginDate);
        Date endDateObj = dateFormat.parse(endDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        float[] returnAmount = new float[84];
        Arrays.fill(returnAmount, 0.0f);

        while (calendar.getTime().before(endDateObj)) {
            Date currentDate = calendar.getTime();
            String dateString = dateFormat.format(currentDate);
            float[] currAmount = getInventoryForDay(dateString);
            returnAmount = addArrays(currAmount, returnAmount);

            calendar.add(Calendar.DATE, 1);
        }

        System.out.println(dateFormat.format(endDateObj));

        return returnAmount;
    }

    private String[] getIngredientsList() {
        String[] inventoryArray = new String[84];
        try {
            Statement stmt = conn.createStatement();

            String sql = "SELECT inventory_name FROM inventory";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<String> inventoryNames = new ArrayList<String>();
            while (rs.next()) {
                String inventoryName = rs.getString("inventory_name");
                inventoryNames.add(inventoryName);
            }

            inventoryArray = inventoryNames.toArray(new String[inventoryNames.size()]);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return inventoryArray;
    }

    public float[] getInventoryForDay(String day) {
        float[] floatArray = new float[85];
        Arrays.fill(floatArray, 0f);
        try {
            String sql = "SELECT ingredient_amounts FROM inventory_history WHERE date = ?"; // Replace with your SQL query
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, day); // Replace with the date you want to retrieve the ingredient amounts for

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Array ingredientArray = result.getArray("ingredient_amounts");
                floatArray = (float[]) ingredientArray.getArray();

                // Do something with the float array here...

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return floatArray;
    }
}
