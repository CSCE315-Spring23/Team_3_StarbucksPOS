package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class FoodController extends CommonPOSController {
    @FXML
    protected void clickBagel() {
        CurrentOrderList.getInstance().addItem("201003");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMultigrainBagel() {
        CurrentOrderList.getInstance().addItem("201002");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickEverythingBagel() {
        CurrentOrderList.getInstance().addItem("201001");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCreamCheese() {
        CurrentOrderList.getInstance().addItem("201004");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheeseDanish() {
        CurrentOrderList.getInstance().addItem("201006");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickAppleFritter() {
        CurrentOrderList.getInstance().addItem("201007");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSaltedCaramelCookie() {
        CurrentOrderList.getInstance().addItem("201008");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCinnamonRoll() {
        CurrentOrderList.getInstance().addItem("201009");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBlueberryMuffin() {
        CurrentOrderList.getInstance().addItem("201010");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTuxedoMuffin() {
        CurrentOrderList.getInstance().addItem("201011");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBananaMuffin() {
        CurrentOrderList.getInstance().addItem("201012");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetCroissant() {
        CurrentOrderList.getInstance().addItem("201014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickToffeeBar() {
        CurrentOrderList.getInstance().addItem("201017");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrownie() {
        CurrentOrderList.getInstance().addItem("201019");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201018");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201015");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBakedChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201016");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickZoesCookie() {
        CurrentOrderList.getInstance().addItem("201020");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheesecake() {
        CurrentOrderList.getInstance().addItem("201021");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickReesesBar() {
        CurrentOrderList.getInstance().addItem("201022");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
