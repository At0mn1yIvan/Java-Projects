package com.example.demolab4;

import ClockClasses.Time;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MostExpensiveClockController {

    @FXML
    private AnchorPane MostExpensiveClockScene;

    @FXML
    private Label MostExpensiveClockLabel;

    @FXML
    private void initialize(){
        Time myClock = MainApplication.shop.MostExpWatch();
        MostExpensiveClockLabel.setText(myClock.toString());
    }
}

