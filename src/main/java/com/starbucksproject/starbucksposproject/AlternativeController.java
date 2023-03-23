package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;
/**
 * The AlternativeController.java function implements javafx buttons for the alternative menu items in our database
 */
public class AlternativeController extends CommonPOSController {

    int drinkSize = 0;


    /**
     * Assign drink size variable to 0 to indicate tall
     */
    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }

    /**
     * Assign drink size variable to 1 to indicate grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }

    /**
     * Assign drink size variable to 2 to indicate venti
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    @FXML
    protected void clickSteamedMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106013");
        }
        else if(drinkSize == 1){

            CurrentOrderList.getInstance().addItem("106014");
        } else{
            CurrentOrderList.getInstance().addItem("106015");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cold milk to the orderlist
     */
    @FXML
    protected void clickColdMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106002");
        } else {
            CurrentOrderList.getInstance().addItem("106003");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds hot chocolate to the orderlist
     */
    @FXML
    protected void clickHotChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106005");
        } else {
            CurrentOrderList.getInstance().addItem("106006");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds hot white chocolate to the orderlist
     */
    @FXML
    protected void clickHotWhiteChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106008");
        } else {
            CurrentOrderList.getInstance().addItem("106009");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds soda to the orderlist
     */
    @FXML
    protected void clickSoda() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106011");
        } else {
            CurrentOrderList.getInstance().addItem("106012");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
