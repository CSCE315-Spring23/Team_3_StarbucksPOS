package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public abstract class CommonPOSController implements Initializable {
	Connection conn = null;
	protected Stage stage;
	protected Scene scene;
	protected Parent root;

	@FXML
	protected Button menuItemSpecial1;
	@FXML
	protected Button menuItemSpecial2;
	@FXML
	protected Button menuItemSpecial3;
	@FXML
	protected Button menuItemSpecial4;
	@FXML
	protected Button menuItemSpecial5;
	@FXML
	protected Button menuItemSpecial6;
	@FXML
	protected Button menuItemSpecial7;
	@FXML
	protected Button menuItemSpecial8;
	@FXML
	protected Button menuItemSpecial9;
	@FXML
	protected Button menuItemSpecial10;
	@FXML
	protected TextArea orderListField;

	/**
	 * Overload to the initialize function from the Initializable interface, runs when controller is called. Updated order list and special menu item buttons.
	 * @author Devon Kelly
	 * @param location
	 * The location used to resolve relative paths for the root object, or
	 * {@code null} if the location is not known.
	 *
	 * @param resources
	 * The resources used to localize the root object, or {@code null} if
	 * the root object was not localized.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Order list setup
		conn = DBConnection.getInstance().getConnection();

		ArrayList<String> curr = CurrentOrderList.getInstance().getCurrentOrder();
		if (curr != null){
			try{
				HashMap<Integer, String> idToName = CurrentOrderList.getInstance().getIdToNameMap();
				StringBuilder stringBuilder = new StringBuilder();
				curr.forEach(item -> {
					stringBuilder.append(idToName.get(Integer.parseInt(item))).append("\n");
				});
				orderListField.setText(stringBuilder.toString());
			} catch (SQLException e){
				e.printStackTrace();
			}
		}



		//Special menu setup
		menuItemSpecial1.setDisable(true);
		menuItemSpecial2.setDisable(true);
		menuItemSpecial3.setDisable(true);
		menuItemSpecial4.setDisable(true);
		menuItemSpecial5.setDisable(true);
		menuItemSpecial6.setDisable(true);
		menuItemSpecial7.setDisable(true);
		menuItemSpecial8.setDisable(true);
		menuItemSpecial9.setDisable(true);
		menuItemSpecial10.setDisable(true);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true");
			while(rs.next()){
				switch((rs.getInt("item_id")/10)%100){
					case 1:
						menuItemSpecial1.setDisable(false);
						menuItemSpecial1.setText(rs.getString("display_name"));
						break;
					case 2:
						menuItemSpecial2.setDisable(false);
						menuItemSpecial2.setText(rs.getString("display_name"));
						break;
					case 3:
						menuItemSpecial3.setDisable(false);
						menuItemSpecial3.setText(rs.getString("display_name"));
						break;
					case 4:
						menuItemSpecial4.setDisable(false);
						menuItemSpecial4.setText(rs.getString("display_name"));
						break;
					case 5:
						menuItemSpecial5.setDisable(false);
						menuItemSpecial5.setText(rs.getString("display_name"));
						break;
					case 6:
						menuItemSpecial6.setDisable(false);
						menuItemSpecial6.setText(rs.getString("display_name"));
						break;
					case 7:
						menuItemSpecial7.setDisable(false);
						menuItemSpecial7.setText(rs.getString("display_name"));
						break;
					case 8:
						menuItemSpecial8.setDisable(false);
						menuItemSpecial8.setText(rs.getString("display_name"));
						break;
					case 9:
						menuItemSpecial9.setDisable(false);
						menuItemSpecial9.setText(rs.getString("display_name"));
						break;
					case 10:
						menuItemSpecial10.setDisable(false);
						menuItemSpecial10.setText(rs.getString("display_name"));
						break;

				}
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {

		}

	}

	public void UpdateOrderList(){
		try {
			ArrayList<String> curr = CurrentOrderList.getInstance().getCurrentOrder();
			HashMap<Integer, String> idToName = CurrentOrderList.getInstance().getIdToNameMap();
			StringBuilder stringBuilder = new StringBuilder();
			curr.forEach(item -> {
				stringBuilder.append(idToName.get(Integer.parseInt(item))).append("\n");
			});
			orderListField.setText(stringBuilder.toString());
		}
		catch (SQLException e){
			//do nothing since won't throw guaranteed by initialize guaranteed to have completed successfully
		}
	}
	/**This function moves the POS to the addons scene.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clickAddons(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	protected void clickNextDrink() {}

	/**This function moves the POS to the manager-menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clickManagerMenu(ActionEvent event) throws IOException {
		if(CurrentOrderList.getInstance().isManager()) {
			root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else{
			root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	/**This function moves the POS to the coffee menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clickCoffeeMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**This function moves the POS to the espresso menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clickEspressoMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**This function moves the POS to the blended beverage menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void clickBlendedMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**This function moves the POS to the tea menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void clickTeasMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	/**This function moves the POS to the Coffee Alternatives Menu Scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	/**This function moves the POS to the food menu scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void clickFoodMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**This function will take the user back to the log-in scene.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void clickLogout(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	protected void clickEditCustomerName() {}

	/**
	 * This function will remove the most recently added item from the order list
	 */
	@FXML
	protected void clickVoidLastItem() {
		if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
			CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
	}

	/**
	 * This function completes the transaction by clearing the order list and changing the database.
	 */
	@FXML
	protected void clickPay() {
		CurrentOrderList.getInstance().completeTransaction();

	}

	/**
	 * This button is the menu item button for special item 1
	 */
	@FXML
	protected void clickSpecial1() {
		CurrentOrderList.getInstance().addItem("999010");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 2
	 */
	@FXML
	protected void clickSpecial2() {
		CurrentOrderList.getInstance().addItem("999020");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 3
	 */
	@FXML
	protected void clickSpecial3() {
		CurrentOrderList.getInstance().addItem("999030");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 4
	 */
	@FXML
	protected void clickSpecial4() {
		CurrentOrderList.getInstance().addItem("999040");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 5
	 */
	@FXML
	protected void clickSpecial5() {
		CurrentOrderList.getInstance().addItem("999050");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 6
	 */
	@FXML
	protected void clickSpecial6() {
		CurrentOrderList.getInstance().addItem("999060");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 7
	 */
	@FXML
	protected void clickSpecial7() {
		CurrentOrderList.getInstance().addItem("999070");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 8
	 */
	@FXML
	protected void clickSpecial8() {
		CurrentOrderList.getInstance().addItem("999080");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 9
	 */
	@FXML
	protected void clickSpecial9() {
		CurrentOrderList.getInstance().addItem("999090");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}
	/**
	 * This button is the menu item button for special item 10
	 */
	@FXML
	protected void clickSpecial10() {
		CurrentOrderList.getInstance().addItem("999100");
		UpdateOrderList();
		System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
	}

}
