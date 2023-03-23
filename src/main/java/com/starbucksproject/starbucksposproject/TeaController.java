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

public class TeaController extends CommonPOSController {

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
    protected void clickHotTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104001");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104002");
        } else {
            CurrentOrderList.getInstance().addItem("104003");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickBrewedTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104004");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104005");
        } else {
            CurrentOrderList.getInstance().addItem("104006");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104007");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104008");
        } else {
            CurrentOrderList.getInstance().addItem("104009");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHoChiMinhTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104010");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104011");
        } else {
            CurrentOrderList.getInstance().addItem("104012");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTazoChaiTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104016");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104017");
        } else {
            CurrentOrderList.getInstance().addItem("104018");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickIcedTeaLemonade() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104013");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104014");
        } else {
            CurrentOrderList.getInstance().addItem("104015");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonBlackTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104040");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104041");
        } else {
            CurrentOrderList.getInstance().addItem("104042");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickTavalonGreenTea() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104043");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104044");
        } else {
            CurrentOrderList.getInstance().addItem("104045");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104025");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104026");
        } else {
            CurrentOrderList.getInstance().addItem("104027");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickStrawberryLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104022");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104023");
        } else {
            CurrentOrderList.getInstance().addItem("104024");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickPinkDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104019");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104020");
        } else {
            CurrentOrderList.getInstance().addItem("104021");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104034");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104035");
        } else {
            CurrentOrderList.getInstance().addItem("104036");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickMangoLemonadeRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104031");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104032");
        } else {
            CurrentOrderList.getInstance().addItem("104033");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickDragonDrink() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104028");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104029");
        } else {
            CurrentOrderList.getInstance().addItem("104030");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    @FXML
    protected void clickHibiscusRefresher() {
        if (drinkSize == 0) {
            CurrentOrderList.getInstance().addItem("104037");
        } else if (drinkSize == 1) {
            CurrentOrderList.getInstance().addItem("104038");
        } else {
            CurrentOrderList.getInstance().addItem("104039");
        }
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }

}
