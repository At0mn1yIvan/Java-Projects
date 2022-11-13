package com.example.demolab4;

import ClockClasses.Clock;
import ClockClasses.Main;
import ClockClasses.ShopClock;
import ClockClasses.TimeInterface;
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
        TimeInterface myClock = MainApplication.shop.MostExpWatch();
        MostExpensiveClockLabel.setText(myClock.toString());
    }
}

