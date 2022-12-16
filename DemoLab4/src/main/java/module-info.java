module com.example.demolab4 {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens com.example.demolab4 to javafx.fxml;
    exports com.example.demolab4;
    exports ClockClasses;
    opens ClockClasses to javafx.fxml, org.hibernate.orm.core;
}