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

public class ZReportController implements Initializable {
	Connection conn = null;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TableView zReportTable;

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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conn = DBConnection.getInstance().getConnection();
		try {
			String query = "SELECT * FROM sales ORDER BY date DESC";
			PreparedStatement tableQuery = conn.prepareStatement(query);
			ResultSet response = tableQuery.executeQuery();
			ObservableList<ZReportItem> items = FXCollections.observableArrayList();

			ObservableList<TableColumn> columns = zReportTable.getColumns();
			columns.get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
			columns.get(1).setCellValueFactory(new PropertyValueFactory<>("sales"));


			while (response.next()) {
				int date = response.getInt("date");
				double sales = response.getDouble("sales");
				ZReportItem item = new ZReportItem(date, sales);
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
}

