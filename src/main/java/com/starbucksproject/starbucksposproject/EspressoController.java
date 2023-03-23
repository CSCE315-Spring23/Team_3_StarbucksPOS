package com.starbucksproject.starbucksposproject;

import javafx.fxml.FXML;

public class EspressoController extends CommonPOSController {

    int drinkSize = 0;

    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button sets the drink size to grande
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button sets the drink size to venti
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }
    @FXML
    protected void clickAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103002");
        } else {
            CurrentOrderList.getInstance().addItem("103003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced americano to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedAmericano() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103041");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103042");
        } else {
            CurrentOrderList.getInstance().addItem("103043");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cappuccino to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCappuccino() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103005");
        } else {
            CurrentOrderList.getInstance().addItem("103006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103008");
        } else {
            CurrentOrderList.getInstance().addItem("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103008");
        } else {
            CurrentOrderList.getInstance().addItem("103009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds cinnamon dolce latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103020");
        } else {
            CurrentOrderList.getInstance().addItem("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced cinnamon dolce latte to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCinnamonDolceLatte() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103020");
        } else {
            CurrentOrderList.getInstance().addItem("103021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds caramel macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103011");
        } else {
            CurrentOrderList.getInstance().addItem("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced caramel macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCaramelMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103011");
        } else {
            CurrentOrderList.getInstance().addItem("103012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds coconut macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103026");
        } else {
            CurrentOrderList.getInstance().addItem("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced cocounut macchiato to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoconutMacchiato() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103026");
        } else {
            CurrentOrderList.getInstance().addItem("103027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103014");
        } else {
            CurrentOrderList.getInstance().addItem("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103014");
        } else {
            CurrentOrderList.getInstance().addItem("103015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds white mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103017");
        } else {
            CurrentOrderList.getInstance().addItem("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced white mocha drink to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103017");
        } else {
            CurrentOrderList.getInstance().addItem("103018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds coconut mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103036");
        } else {
            CurrentOrderList.getInstance().addItem("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced coconut mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedCoconutMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103035");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103036");
        } else {
            CurrentOrderList.getInstance().addItem("103037");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds black white mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103039");
        } else {
            CurrentOrderList.getInstance().addItem("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds iced black white mocha to the order list in either size tall, grande, or venti
     */
    @FXML
    protected void clickIcedBlackWhiteMocha() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("103038");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("103039");
        } else {
            CurrentOrderList.getInstance().addItem("103040");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds solo espresso to the order list
     */
    @FXML
    protected void clickSolo() {
        CurrentOrderList.getInstance().addItem("103031");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds double espresso to the order list
     */
    @FXML
    protected void clickDouble() {
        CurrentOrderList.getInstance().addItem("103032");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds triple espresso to the order list
     */
    @FXML
    protected void clickTriple() {
        CurrentOrderList.getInstance().addItem("103033");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button adds quad espresso to the order list
     */
    @FXML
    protected void clickQuad() {
        CurrentOrderList.getInstance().addItem("103034");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
