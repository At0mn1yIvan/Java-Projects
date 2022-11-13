module com.example.demolab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.demolab4 to javafx.fxml;
    exports com.example.demolab4;
}