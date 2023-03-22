package com.starbucksproject.starbucksposproject;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;

public class IngredientDialog extends Dialog<ObservableList<Pair<String, Double>>> {

	private TableView<Pair<Boolean, Pair<String, Double>>> table;
	private ButtonType okButton;

	public IngredientDialog(ArrayList<String> ingredientList) {
		setTitle("Ingredient Dialog");
		setHeaderText("Please select the ingredients and quantities used:");

		// Create the table
		TableColumn<Pair<Boolean, Pair<String, Double>>, Boolean> selectedCol = new TableColumn<>("Selected");
		selectedCol.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getKey()));
		selectedCol.setCellFactory(col -> new CheckBoxTableCell<>() {});

		TableColumn<Pair<Boolean, Pair<String, Double>>, String> nameCol = new TableColumn<>("Inventory Name");
		nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().getKey()));

		TableColumn<Pair<Boolean, Pair<String, Double>>, Double> quantityCol = new TableColumn<>("Quantity Used");
		quantityCol.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getValue().getValue()).asObject());
		quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		quantityCol.setOnEditCommit(event -> {
			Pair<Boolean, Pair<String, Double>> rowData = event.getRowValue();
			Double newValue = event.getNewValue();
			boolean goodValue = newValue > 0;
			Pair<Boolean, Pair<String, Double>> updatedRowData = new Pair<>(goodValue, new Pair<>(rowData.getValue().getKey(), newValue));
			int rowIndex = event.getTablePosition().getRow();
			table.getItems().set(rowIndex, updatedRowData);
			// updateOkButton();
		});

		quantityCol.setEditable(true);


		table = new TableView<>();
		ObservableList<Pair<Boolean, Pair<String, Double>>> data = FXCollections.observableArrayList();

		for (String ingredient : ingredientList) {
			Pair<Boolean, Pair<String, Double>> row = new Pair<>(false, new Pair<>(ingredient, 0.0));
			data.add(row);
		}

		table.setItems(data);

		table.setEditable(true);
		table.getColumns().addAll(selectedCol, nameCol, quantityCol);

		// Create the layout
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 10, 10, 10));
		grid.add(table, 0, 0);

		// Add a listener to update the OK button
//		table.getItems().forEach(item -> item.getKeyProperty().addListener((obs, oldVal, newVal) -> {
//			updateOkButton();
//		}));

		// Create the OK button
		okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
		getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
//		updateOkButton();

		// Set the content
		getDialogPane().setContent(grid);

		// Set the result converter
		setResultConverter(buttonType -> {
			if (buttonType == okButton) {
				ObservableList<Pair<String, Double>> result = FXCollections.observableArrayList();
				for (Pair<Boolean, Pair<String, Double>> item : table.getItems()) {
					if (item.getKey()) {
						result.add(new Pair<>(item.getValue().getKey(), item.getValue().getValue()));
					}
				}
				return result;
			}
			return null;
		});
	}

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
}