package com.starbucksproject.starbucksposproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * This class implements button functionality of tea menu items.
 */
public class TeaController extends CommonPOSController {

    int drinkSize = 0;

    /**
     * This button lets the user specify the drink is size tall.
     */
    @FXML
    protected void clickTall() {
        drinkSize = 0;
    }
    /**
     * This button lets the user specify the drink is size grande.
     */
    @FXML
    protected void clickGrande() {
        drinkSize = 1;
    }
    /**
     * This button lets the user specify the drink is size venti.
     */
    @FXML
    protected void clickVenti() {
        drinkSize = 2;
    }

    /**
     * This button lets the user add hot tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickHotTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104002");
        } else {
            CurrentOrderList.getInstance().addItem("104003");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

    /**
     * This button lets the user add brewed tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickBrewedTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104005");
        } else {
            CurrentOrderList.getInstance().addItem("104006");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add green tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104008");
        } else {
            CurrentOrderList.getInstance().addItem("104009");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add ho chi minh tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickHoChiMinhTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104011");
        } else {
            CurrentOrderList.getInstance().addItem("104012");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add tazo chai tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickTazoChaiTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104017");
        } else {
            CurrentOrderList.getInstance().addItem("104018");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add iced tea lemonade to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickIcedTeaLemonade() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104014");
        } else {
            CurrentOrderList.getInstance().addItem("104015");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add tavalon black tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickTavalonBlackTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104040");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104041");
        } else {
            CurrentOrderList.getInstance().addItem("104042");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add tavalon green tea to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickTavalonGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104043");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104044");
        } else {
            CurrentOrderList.getInstance().addItem("104045");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add strawberry refresher to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickStrawberryRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104026");
        } else {
            CurrentOrderList.getInstance().addItem("104027");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add strawberry lemonade refresher to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickStrawberryLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104023");
        } else {
            CurrentOrderList.getInstance().addItem("104024");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add pink drink to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickPinkDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104020");
        } else {
            CurrentOrderList.getInstance().addItem("104021");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add mango refresher to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickMangoRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104034");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104035");
        } else {
            CurrentOrderList.getInstance().addItem("104036");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add lemonade refresher to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickMangoLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104032");
        } else {
            CurrentOrderList.getInstance().addItem("104033");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add dragon drink to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickDragonDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104028");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104029");
        } else {
            CurrentOrderList.getInstance().addItem("104030");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button lets the user add hibiscus refresher to the order in size tall, grande, or venti.
     */
    @FXML
    protected void clickHibiscusRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104037");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104038");
        } else {
            CurrentOrderList.getInstance().addItem("104039");
        }
        UpdateOrderList();
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
