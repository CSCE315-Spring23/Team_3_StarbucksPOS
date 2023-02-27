module com.starbucksproject.starbucksposproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.starbucksproject.starbucksposproject to javafx.fxml;
    exports com.starbucksproject.starbucksposproject;
}