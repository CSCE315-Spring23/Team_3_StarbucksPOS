package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class ExcessReportController {
	Connection conn = null;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TableView inventoryTable;

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
}

