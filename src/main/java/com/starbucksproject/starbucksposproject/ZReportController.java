package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.util.Pair;
import java.util.Calendar;
import java.io.IOException;
import java.sql.*;

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
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class ZReportController implements Initializable {
	Connection conn = null;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TableView zReportTable;

	@FXML
	private TextField zDate;

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

	protected void searchZDate(ActionEvent event){
		String inputDate = zDate.getText();
		conn = DBConnection.getInstance().getConnection();

		try {
			String query = "SELECT * FROM z_reports WHERE last_transaction_date="+ inputDate;
			PreparedStatement tableQuery = conn.prepareStatement(query);
			ResultSet response = tableQuery.executeQuery();
			ObservableList<ZReportItem> items = FXCollections.observableArrayList();

			ObservableList<TableColumn> columns = zReportTable.getColumns();
			columns.get(0).setCellValueFactory(new PropertyValueFactory<>("last_transaction_id"));
			columns.get(1).setCellValueFactory(new PropertyValueFactory<>("last_transaction_date"));
			columns.get(2).setCellValueFactory(new PropertyValueFactory<>("total"));


			while (response.next()) {
				int last_transaction_id = response.getInt("last_transaction_id");
				int last_transaction_date = response.getInt("last_transaction_date");
				double total = response.getDouble("total");

				ZReportItem item = new ZReportItem(last_transaction_id, last_transaction_date, total);
				items.add(item);
			}

			zReportTable.setItems(items);


		}
		catch(SQLException e){
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
		}
	}

	@FXML
	protected void clickZEnter(ActionEvent event) throws  IOException{
			try {
				searchZDate(event);
			} catch (Exception e){
				System.out.println("Could not search for date.");
			}

	}
	@FXML
	protected void clickXEnter(ActionEvent event) throws  IOException{
		try {
			searchXReport(event);
		} catch (Exception e){
			System.out.println("Could not search for date.");
		}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conn = DBConnection.getInstance().getConnection();
		try {
			String query = "SELECT * FROM z_reports ORDER BY last_transaction_date DESC";
			PreparedStatement tableQuery = conn.prepareStatement(query);
			ResultSet response = tableQuery.executeQuery();
			ObservableList<ZReportItem> items = FXCollections.observableArrayList();

			ObservableList<TableColumn> columns = zReportTable.getColumns();
			columns.get(0).setCellValueFactory(new PropertyValueFactory<>("last_transaction_id"));
			columns.get(1).setCellValueFactory(new PropertyValueFactory<>("last_transaction_date"));
			columns.get(2).setCellValueFactory(new PropertyValueFactory<>("total"));


			while (response.next()) {
				int last_transaction_id = response.getInt("last_transaction_id");
				int last_transaction_date = response.getInt("last_transaction_date");
				double total = response.getDouble("total");

				ZReportItem item = new ZReportItem(last_transaction_id, last_transaction_date, total);
				items.add(item);
			}

			zReportTable.setItems(items);


		}
		catch(SQLException e){
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
		}
	}

	@FXML
	protected void clickReset(ActionEvent event) throws IOException {
		conn = DBConnection.getInstance().getConnection();
		try {
			String query = "SELECT * FROM z_reports ORDER BY last_transaction_date DESC";
			PreparedStatement tableQuery = conn.prepareStatement(query);
			ResultSet response = tableQuery.executeQuery();
			ObservableList<ZReportItem> items = FXCollections.observableArrayList();

			ObservableList<TableColumn> columns = zReportTable.getColumns();
			columns.get(0).setCellValueFactory(new PropertyValueFactory<>("last_transaction_id"));
			columns.get(1).setCellValueFactory(new PropertyValueFactory<>("last_transaction_date"));
			columns.get(2).setCellValueFactory(new PropertyValueFactory<>("total"));


			while (response.next()) {
				int last_transaction_id = response.getInt("last_transaction_id");
				int last_transaction_date = response.getInt("last_transaction_date");
				double total = response.getDouble("total");

				ZReportItem item = new ZReportItem(last_transaction_id, last_transaction_date, total);
				items.add(item);
			}

			zReportTable.setItems(items);


		}
		catch(SQLException e){
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
		}

	}

	private String createNewDate() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String formattedDate = dateFormat.format(today);
		return formattedDate;
	}

	/**
	 * Creates the most recent X report, adding all transactions
	 *
	 * @param event An ActionEvent that represents the button being clicked.
	 * @throws IOException An exception caused if the input value is not expected.
	 */
	protected void searchXReport(ActionEvent event) throws IOException{

		String inputDate = zDate.getText();
		conn = DBConnection.getInstance().getConnection();
		try {
			// Get maximum Z report transaction ID
			String query1 = "SELECT MAX(last_transaction_id) AS max_id FROM z_reports";
			PreparedStatement tableQuery1 = conn.prepareStatement(query1);
			ResultSet response1 = tableQuery1.executeQuery();

			int latest_z_id = 0;
			while (response1.next()) {
				latest_z_id = response1.getInt("max_id");
			}

			// Use ID to get sum of recent transaction amounts
			String query2 = "SELECT SUM(total) AS total_sum FROM transactions WHERE transaction_id > " + latest_z_id + " AND transaction_id < " + 1000000000;
			PreparedStatement tableQuery2 = conn.prepareStatement(query2);
			ResultSet response2 = tableQuery2.executeQuery();

			double transaction_sum = 0.0;
			while (response2.next()) {
				transaction_sum = response2.getDouble("total_sum");
			}

			// Get most recent transaction value
			String query3 = "SELECT MAX(transaction_id) AS max_id FROM transactions WHERE transaction_id < " + 1000000000;
			PreparedStatement tableQuery3 = conn.prepareStatement(query3);
			ResultSet response3 = tableQuery3.executeQuery();

			int latest_x_id = 0;
			while (response3.next()) {
				latest_x_id = response3.getInt("max_id");
			}

			// Get most recent day value
			String query4 = "SELECT MAX(transaction_date) AS max_date FROM transactions WHERE transaction_id < " + 1000000000;
			PreparedStatement tableQuery4 = conn.prepareStatement(query4);
			ResultSet response4 = tableQuery4.executeQuery();

			int latest_x_date = 0;
			while (response4.next()) {
				latest_x_date = response4.getInt("max_date");
			}

			ObservableList<ZReportItem> items = FXCollections.observableArrayList();

			ObservableList<TableColumn> columns = zReportTable.getColumns();
			columns.get(0).setCellValueFactory(new PropertyValueFactory<>("last_transaction_id"));
			columns.get(1).setCellValueFactory(new PropertyValueFactory<>("last_transaction_date"));
			columns.get(2).setCellValueFactory(new PropertyValueFactory<>("total"));

			ZReportItem item = new ZReportItem(latest_x_id, latest_x_date, transaction_sum);
			items.add(item);

			zReportTable.setItems(items);


		}
		catch(SQLException e){
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
		}
	}
}

