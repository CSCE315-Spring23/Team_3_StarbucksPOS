package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class CoffeeController extends CommonPOSController {

    int drinkSize = 0;

    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }

    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }

    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    @FXML
    protected void clickCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101002");
        } else {
            CurrentOrderList.getInstance().addItem("101003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCoffeeTraveller() {
        CurrentOrderList.getInstance().addItem("101014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickIcedCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101005");
        } else {
            CurrentOrderList.getInstance().addItem("101006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCafeLait() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101008");
        } else {
            CurrentOrderList.getInstance().addItem("101009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickColdBrew() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101011");
        } else {
            CurrentOrderList.getInstance().addItem("101012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickCoffeeRefill() {
        CurrentOrderList.getInstance().addItem("101013");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());

    }
}
