module com.starbucksproject.starbucksposproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.starbucksproject.starbucksposproject to javafx.fxml;
    exports com.starbucksproject.starbucksposproject;
}