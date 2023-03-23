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
 * The AddonsController.java class is responsible for implementing javafx buttons for the addon items in our database.
 */
public class AddonsController implements Initializable {
    Connection conn = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button menuItemSpecial1;
    @FXML
    private Button menuItemSpecial2;
    @FXML
    private Button menuItemSpecial3;
    @FXML
    private Button menuItemSpecial4;
    @FXML
    private Button menuItemSpecial5;
    @FXML
    private Button menuItemSpecial6;
    @FXML
    private Button menuItemSpecial7;
    @FXML
    private Button menuItemSpecial8;
    @FXML
    private Button menuItemSpecial9;
    @FXML
    private Button menuItemSpecial10;

    /**This function moves the POS to the addons scene.
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickAddons(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addons-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickNextDrink() {}

    /**This function moves the POS to the manager-menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickManagerMenu(ActionEvent event) throws IOException {
        if(CurrentOrderList.getInstance().isManager()) {
            root = FXMLLoader.load(getClass().getResource("manager-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**This function moves the POS to the coffee menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickCoffeeMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function moves the POS to the espresso menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void clickEspressoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("espresso-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function moves the POS to the blended beverage menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickBlendedMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("blended-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function moves the POS to the tea menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickTeasMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tea-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**This function moves the POS to the Coffee Alternatives Menu Scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickCoffeeAlternativesMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("coffee-alternative-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**This function moves the POS to the food menu scene
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickFoodMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("food-gui.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**This function will take the user back to the log-in scene.
     * @param event
     * @throws IOException
     */
    @FXML
    protected void clickLogout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void clickEditCustomerName() {}

    /**
     * This function will remove the most recently added item from the order list
     */
    @FXML
    protected void clickVoidLastItem() {
        if (CurrentOrderList.getInstance().getCurrentOrder().size() > 0)
            CurrentOrderList.getInstance().getCurrentOrder().remove(CurrentOrderList.getInstance().getCurrentOrder().size()-1);
    }

    /**
     * This function completes the transaction by clearing the order list and changing the database.
     */
    @FXML
    protected void clickPay() {
        CurrentOrderList.getInstance().completeTransaction();

    }

    /**
     * This button is the menu item button for special item 1
     */
    @FXML
    protected void clickSpecial1() {
        CurrentOrderList.getInstance().addItem("999010");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 2
     */
    @FXML
    protected void clickSpecial2() {
        CurrentOrderList.getInstance().addItem("999020");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 3
     */
    @FXML
    protected void clickSpecial3() {
        CurrentOrderList.getInstance().addItem("999030");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 4
     */
    @FXML
    protected void clickSpecial4() {
        CurrentOrderList.getInstance().addItem("999040");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 5
     */
    @FXML
    protected void clickSpecial5() {
        CurrentOrderList.getInstance().addItem("999050");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 6
     */
    @FXML
    protected void clickSpecial6() {
        CurrentOrderList.getInstance().addItem("999060");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 7
     */
    @FXML
    protected void clickSpecial7() {
        CurrentOrderList.getInstance().addItem("999070");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 8
     */
    @FXML
    protected void clickSpecial8() {
        CurrentOrderList.getInstance().addItem("999080");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 9
     */
    @FXML
    protected void clickSpecial9() {
        CurrentOrderList.getInstance().addItem("999090");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for special item 10
     */
    @FXML
    protected void clickSpecial10() {
        CurrentOrderList.getInstance().addItem("999100");
        System.out.println(CurrentOrderList.getInstance().getCurrentOrder());
    }
    /**
     * This button is the menu item button for a shot of espresso
     */
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

    /**This function disables all special menu item buttons, connects to database, then re-enable any buttons that are relevant
     * based on the result of the query
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuItemSpecial1.setDisable(true);
        menuItemSpecial2.setDisable(true);
        menuItemSpecial3.setDisable(true);
        menuItemSpecial4.setDisable(true);
        menuItemSpecial5.setDisable(true);
        menuItemSpecial6.setDisable(true);
        menuItemSpecial7.setDisable(true);
        menuItemSpecial8.setDisable(true);
        menuItemSpecial9.setDisable(true);
        menuItemSpecial10.setDisable(true);
        conn = DBConnection.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM special_menu_items WHERE enabled=true and category='add-on'");
            while(rs.next()){
                switch((rs.getInt("item_id")/10)%100){
                    case 1:
                        menuItemSpecial1.setDisable(false);
                        menuItemSpecial1.setText(rs.getString("display_name"));
                        break;
                    case 2:
                        menuItemSpecial2.setDisable(false);
                        menuItemSpecial2.setText(rs.getString("display_name"));
                        break;
                    case 3:
                        menuItemSpecial3.setDisable(false);
                        menuItemSpecial3.setText(rs.getString("display_name"));
                        break;
                    case 4:
                        menuItemSpecial4.setDisable(false);
                        menuItemSpecial4.setText(rs.getString("display_name"));
                        break;
                    case 5:
                        menuItemSpecial5.setDisable(false);
                        menuItemSpecial5.setText(rs.getString("display_name"));
                        break;
                    case 6:
                        menuItemSpecial6.setDisable(false);
                        menuItemSpecial6.setText(rs.getString("display_name"));
                        break;
                    case 7:
                        menuItemSpecial7.setDisable(false);
                        menuItemSpecial7.setText(rs.getString("display_name"));
                        break;
                    case 8:
                        menuItemSpecial8.setDisable(false);
                        menuItemSpecial8.setText(rs.getString("display_name"));
                        break;
                    case 9:
                        menuItemSpecial9.setDisable(false);
                        menuItemSpecial9.setText(rs.getString("display_name"));
                        break;
                    case 10:
                        menuItemSpecial10.setDisable(false);
                        menuItemSpecial10.setText(rs.getString("display_name"));
                        break;

                }
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {

        }

    }
}
