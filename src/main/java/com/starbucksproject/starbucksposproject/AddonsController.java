package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;
/**
 * The AddonsController.java class is responsible for implementing javafx buttons for the addon items in our database.
 */
public class AddonsController extends CommonPOSController {

    @FXML
    protected void clickEspressoShot() {
        CurrentOrderList.getInstance().addItem("102001");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for frappuccino roast
     */
    @FXML
    protected void clickFrappuccinoRoast() {
        CurrentOrderList.getInstance().addItem("102020");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for classic syrup
     */
    @FXML
    protected void clickClassicSyrup() {
        CurrentOrderList.getInstance().addItem("102002");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for vanilla syrup
     */
    @FXML
    protected void clickVanillaSyrup() {
        CurrentOrderList.getInstance().addItem("102003");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for caramel syrup
     */
    @FXML
    protected void clickCaramelSyrup() {
        CurrentOrderList.getInstance().addItem("102021");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for cinnamon dolce syrup
     */
    @FXML
    protected void clickCinnamonDolceSyrup() {
        CurrentOrderList.getInstance().addItem("102022");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for toffee nut syrup
     */
    @FXML
    protected void clickToffeeNutSyrup() {
        CurrentOrderList.getInstance().addItem("102023");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for mocha sauce
     */
    @FXML
    protected void clickMochaSauce() {
        CurrentOrderList.getInstance().addItem("102024");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for white chocolate sauce
     */
    @FXML
    protected void clickWhiteChocolateSauce() {
        CurrentOrderList.getInstance().addItem("102025");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for cinnamon dolce topping
     */
    @FXML
    protected void clickCinnamonDolceTopping() {
        CurrentOrderList.getInstance().addItem("102029");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for 2 percent milk
     */
    @FXML
    protected void click2pMilk() {
        CurrentOrderList.getInstance().addItem("102027");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for whole milk
     */
    @FXML
    protected void clickWholeMilk() {
        CurrentOrderList.getInstance().addItem("102028");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for breve
     */
    @FXML
    protected void clickBreve() {
        CurrentOrderList.getInstance().addItem("102004");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for heavy cream
     */
    @FXML
    protected void clickHeavyCream() {
        CurrentOrderList.getInstance().addItem("102005");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for sweet cream
     */
    @FXML
    protected void clickSweetCream() {
        CurrentOrderList.getInstance().addItem("102006");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for whipped cream
     */
    @FXML
    protected void clickWhippedCream() {
        CurrentOrderList.getInstance().addItem("102007");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for almond milk
     */
    @FXML
    protected void clickAlmondMilk() {
        CurrentOrderList.getInstance().addItem("102008");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for oat milk
     */
    @FXML
    protected void clickOatMilk() {
        CurrentOrderList.getInstance().addItem("102009");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for soy milk
     */
    @FXML
    protected void clickSoyMilk() {
        CurrentOrderList.getInstance().addItem("102010");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for coconut milk
     */
    @FXML
    protected void clickCoconutMilk() {
        CurrentOrderList.getInstance().addItem("102011");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for lemonade
     */
    @FXML
    protected void clickLemonade() {
        CurrentOrderList.getInstance().addItem("102012");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for matcha
     */
    @FXML
    protected void clickMatcha() {
        CurrentOrderList.getInstance().addItem("102013");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for strawberry inclusions
     */
    @FXML
    protected void clickStrawberryInclusions() {
        CurrentOrderList.getInstance().addItem("102014");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for dragonfruit inclusions
     */
    @FXML
    protected void clickDragonfruitInclusions() {
        CurrentOrderList.getInstance().addItem("102015");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for strawberry acai base
     */
    @FXML
    protected void clickStrawberryAcaiBase() {
        CurrentOrderList.getInstance().addItem("102016");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for dragonfruit base
     */
    @FXML
    protected void clickMangoDragonfruitBase() {
        CurrentOrderList.getInstance().addItem("102017");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for honey
     */
    @FXML
    protected void clickHoney() {
        CurrentOrderList.getInstance().addItem("102019");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for ice
     */
    @FXML
    protected void clickIce() {
        CurrentOrderList.getInstance().addItem("102018");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
