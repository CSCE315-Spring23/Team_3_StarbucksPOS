module com.starbucksproject.starbucksposproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires java.naming;
    requires java.management;
    requires java.security.jgss;
    requires java.instrument;
    opens com.starbucksproject.starbucksposproject to javafx.fxml;
    exports com.starbucksproject.starbucksposproject;
}
