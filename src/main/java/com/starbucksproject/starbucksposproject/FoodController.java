package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class FoodController extends CommonPOSController {
    @FXML
    protected void clickBagel() {
        CurrentOrderList.getInstance().addItem("201003");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMultigrainBagel() {
        CurrentOrderList.getInstance().addItem("201002");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickEverythingBagel() {
        CurrentOrderList.getInstance().addItem("201001");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCreamCheese() {
        CurrentOrderList.getInstance().addItem("201004");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheeseDanish() {
        CurrentOrderList.getInstance().addItem("201006");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickAppleFritter() {
        CurrentOrderList.getInstance().addItem("201007");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSaltedCaramelCookie() {
        CurrentOrderList.getInstance().addItem("201008");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCinnamonRoll() {
        CurrentOrderList.getInstance().addItem("201009");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBlueberryMuffin() {
        CurrentOrderList.getInstance().addItem("201010");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTuxedoMuffin() {
        CurrentOrderList.getInstance().addItem("201011");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBananaMuffin() {
        CurrentOrderList.getInstance().addItem("201012");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetCroissant() {
        CurrentOrderList.getInstance().addItem("201014");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickToffeeBar() {
        CurrentOrderList.getInstance().addItem("201017");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrownie() {
        CurrentOrderList.getInstance().addItem("201019");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201018");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickSweetChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201015");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBakedChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201016");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    @FXML
    protected void clickZoesCookie() {
        CurrentOrderList.getInstance().addItem("201020");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickCheesecake() {
        CurrentOrderList.getInstance().addItem("201021");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickReesesBar() {
        CurrentOrderList.getInstance().addItem("201022");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
