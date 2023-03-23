package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class implements buttons and the menu for the food menu.
 */
public class FoodController extends CommonPOSController {
    /**
     * Ensures drinkSize is set to -1 such that special menu items call the right size
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
        setDrinkSize(-1);
        super.initialize(location, resources);
    }

    /**
     * This button adds a bagel to the order list
     */
    @FXML
    protected void clickBagel() {
        CurrentOrderList.getInstance().addItem("201003");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a multigrain bagel to the order list
     */
    @FXML
    protected void clickMultigrainBagel() {
        CurrentOrderList.getInstance().addItem("201002");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds an everything bagel to the order list
     */
    @FXML
    protected void clickEverythingBagel() {
        CurrentOrderList.getInstance().addItem("201001");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cream cheese to the order list
     */
    @FXML
    protected void clickCreamCheese() {
        CurrentOrderList.getInstance().addItem("201004");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a cheese danish to the order list
     */
    @FXML
    protected void clickCheeseDanish() {
        CurrentOrderList.getInstance().addItem("201006");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds an apple fritter to the order list
     */
    @FXML
    protected void clickAppleFritter() {
        CurrentOrderList.getInstance().addItem("201007");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a salted caramel cookie to the order list
     */
    @FXML
    protected void clickSaltedCaramelCookie() {
        CurrentOrderList.getInstance().addItem("201008");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a cinnamon roll to the order list
     */
    @FXML
    protected void clickCinnamonRoll() {
        CurrentOrderList.getInstance().addItem("201009");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    /**
     * This button adds a blueberry muffin to the order list
     */
    protected void clickBlueberryMuffin() {
        CurrentOrderList.getInstance().addItem("201010");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a tuxedo muffin to the order list
     */
    @FXML
    protected void clickTuxedoMuffin() {
        CurrentOrderList.getInstance().addItem("201011");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a banana muffin to the order list
     */
    @FXML
    protected void clickBananaMuffin() {
        CurrentOrderList.getInstance().addItem("201012");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds a sweet croissant to the order list
     */
    @FXML
    protected void clickSweetCroissant() {
        CurrentOrderList.getInstance().addItem("201014");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a toffee bar to the order list
     */
    @FXML
    protected void clickToffeeBar() {
        CurrentOrderList.getInstance().addItem("201017");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a brownie to the order list
     */
    @FXML
    protected void clickBrownie() {
        CurrentOrderList.getInstance().addItem("201019");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a chocolate chip cookie to the order list
     */
    @FXML
    protected void clickChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201018");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a sweet chocolate chip cookie to the order list
     */
    @FXML
    protected void clickSweetChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201015");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a baked chocolate chip cookie to the order list
     */
    @FXML
    protected void clickBakedChocolateChipCookie() {
        CurrentOrderList.getInstance().addItem("201016");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button adds a Zoes Cookie to the order list
     */
    @FXML
    protected void clickZoesCookie() {
        CurrentOrderList.getInstance().addItem("201020");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a cheesecake to the order list
     */
    @FXML
    protected void clickCheesecake() {
        CurrentOrderList.getInstance().addItem("201021");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds a reese's bar to the order list
     */
    @FXML
    protected void clickReesesBar() {
        CurrentOrderList.getInstance().addItem("201022");
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
