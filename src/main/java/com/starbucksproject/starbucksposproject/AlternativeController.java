package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class AlternativeController extends CommonPOSController {

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
    protected void clickSteamedMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106013");
        }
        else if(drinkSize == 1){

                CurrentOrderList.getInstance().addItem("106014");
        } else{
                CurrentOrderList.getInstance().addItem("106015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickColdMilk() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106002");
        } else {
            CurrentOrderList.getInstance().addItem("106003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHotChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106005");
        } else {
            CurrentOrderList.getInstance().addItem("106006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHotWhiteChocolate() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106008");
        } else {
            CurrentOrderList.getInstance().addItem("106009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSoda() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("106010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("106011");
        } else {
            CurrentOrderList.getInstance().addItem("106012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
