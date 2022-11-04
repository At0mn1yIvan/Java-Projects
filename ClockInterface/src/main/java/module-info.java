module com.example.clockinterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.clockinterface to javafx.fxml;
    exports com.example.clockinterface;
}