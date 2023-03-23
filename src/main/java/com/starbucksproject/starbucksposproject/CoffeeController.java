package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class CoffeeController extends CommonPOSController {


    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button makes the drink size grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button makes the drink size venti
     */
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
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds coffee traveller to the order list
     */
    @FXML
    protected void clickCoffeeTraveller() {
        CurrentOrderList.getInstance().addItem("101014");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced coffee to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoffee() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101005");
        } else {
            CurrentOrderList.getInstance().addItem("101006");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds cafe lait to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickCafeLait() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101008");
        } else {
            CurrentOrderList.getInstance().addItem("101009");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cold brew to the order list in either tall, grande, or venti
     */
    @FXML
    protected void clickColdBrew() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("101010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("101011");
        } else {
            CurrentOrderList.getInstance().addItem("101012");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds coffee refill to the order list
     */
    @FXML
    protected void clickCoffeeRefill() {
        CurrentOrderList.getInstance().addItem("101013");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());

    }
}
