//package com.starbucksproject.starbucksposproject;
//
//import javafx.beans.property.SimpleBooleanProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.util.Pair;
//
//public class IngredientDialog extends Dialog<ObservableList<Pair<String, Double>>> {
//
//	private TableView<Pair<Boolean, Pair<String, Double>>> table;
//	private ButtonType okButton;
//
//	public IngredientDialog() {
//		setTitle("Ingredient Dialog");
//		setHeaderText("Please select the ingredients and quantities used:");
//
//		// Create the table
//		TableColumn<Pair<Boolean, Pair<String, Double>>, Boolean> selectedCol = new TableColumn<>("Selected");
//		selectedCol.setCellValueFactory(cellData -> cellData.getValue().getKeyProperty());
//		selectedCol.setCellFactory(col -> new CheckBoxTableCell<>());
//
//		TableColumn<Pair<Boolean, Pair<String, Double>>, String> nameCol = new TableColumn<>("Inventory Name");
//		nameCol.setCellValueFactory(cellData -> cellData.getValue().getValue().getKeyProperty());
//
//		TableColumn<Pair<Boolean, Pair<String, Double>>, Double> quantityCol = new TableColumn<>("Quantity Used");
//		quantityCol.setCellValueFactory(cellData -> cellData.getValue().getValue().getValueProperty().asObject());
//		quantityCol.setCellFactory(col -> new EditingDoubleTableCell<>());
//		quantityCol.setEditable(true);
//		quantityCol.setOnEditCommit(event -> {
//			event.getRowValue().getValue().setValue(event.getNewValue());
//			updateOkButton();
//		});
//		quantityCol.setDisable(true);
//
//		table = new TableView<>(FXCollections.observableArrayList(
//				new Pair<>(false, new Pair<>("Ingredient 1", 0.0)),
//				new Pair<>(false, new Pair<>("Ingredient 2", 0.0)),
//				new Pair<>(false, new Pair<>("Ingredient 3", 0.0)),
//				new Pair<>(false, new Pair<>("Ingredient 4", 0.0))
//		                                                         ));
//		table.setEditable(true);
//		table.getColumns().addAll(selectedCol, nameCol, quantityCol);
//
//		// Create the layout
//		GridPane grid = new GridPane();
//		grid.setHgap(10);
//		grid.setVgap(10);
//		grid.setPadding(new Insets(20, 150, 10, 10));
//		grid.add(table, 0, 0);
//
//		// Add a listener to update the OK button
//		table.getItems().forEach(item -> item.getKeyProperty().addListener((obs, oldVal, newVal) -> {
//			quantityCol.setDisable(!newVal);
//			updateOkButton();
//		}));
//
//		// Create the OK button
//		okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//		getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
//		updateOkButton();
//
//		// Set the content
//		getDialogPane().setContent(grid);
//
//		// Set the result converter
//		setResultConverter(buttonType -> {
//			if (buttonType == okButton) {
//				ObservableList<Pair<String, Double>> result = FXCollections.observableArrayList();
//				for (Pair<Boolean, Pair<String, Double>> item : table.getItems()) {
//					if (item.getKey()) {
//						result.add(new Pair<>(item.getValue().getKey(), item.getValue().getValue()));
//					}
//				}
//				return result;
//			}
//			return null;
//		});
//	}
//
//	private void updateOkButton() {
//		boolean anySelected = false;
//		for (Pair<Boolean, Pair<String, Double>> item : table.getItems()) {
//			if (item.getKey() && item.getValue().getValue() > 0.0) {
//				anySelected = true;
//				break;
//			}
//		}
//		Button okButton = (Button) getDialogPane().lookupButton(this.okButton);
//		okButton.setDisable(!anySelected);
//	}
//}