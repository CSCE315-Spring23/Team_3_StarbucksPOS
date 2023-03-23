package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class BlendedController extends CommonPOSController {

    int drinkSize = 0;

    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button makes a drink grande size
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button makes a venti tall size
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }
    @FXML
    protected void clickCoffeeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105002");
        } else {
            CurrentOrderList.getInstance().addItem("105003");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a espresso frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void  clickEspressoFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105005");
        } else {
            CurrentOrderList.getInstance().addItem("105006");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a mocha frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickMochaFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105008");
        } else {
            CurrentOrderList.getInstance().addItem("105009");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a white mocha frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickWhiteMochaFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105026");
        } else {
            CurrentOrderList.getInstance().addItem("105027");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a caramel frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickCaramelFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105011");
        } else {
            CurrentOrderList.getInstance().addItem("105012");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a java chip frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickJavaChipFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105020");
        } else {
            CurrentOrderList.getInstance().addItem("105021");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a vanilla bean creme frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickVanillaBeanCremeCrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105017");
        } else {
            CurrentOrderList.getInstance().addItem("105018");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a strawberry creme frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickStrawberryCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105014");
        } else {
            CurrentOrderList.getInstance().addItem("105015");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a double chocolate creme frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickDoubleChocolateCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105023");
        } else {
            CurrentOrderList.getInstance().addItem("105024");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a matcha creme frap to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickMatchaCremeFrappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("105031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("105032");
        } else {
            CurrentOrderList.getInstance().addItem("105033");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a blueberry smoothies to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickBlueberrySmoothie() {
        CurrentOrderList.getInstance().addItem("105028");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a pomegranate smoothies to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickPomegranateSmoothie() {
        CurrentOrderList.getInstance().addItem("105029");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a mango smoothies to order list of either size tall, grande, venti
     */
    @FXML
    protected void clickMangoSmoothie() {
        CurrentOrderList.getInstance().addItem("105030");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
