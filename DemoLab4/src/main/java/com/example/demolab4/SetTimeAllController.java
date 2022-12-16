package com.example.demolab4;

import ClockClasses.Hand;
import ClockClasses.ThrowOutputException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static java.lang.Integer.parseInt;

public class SetTimeAllController {

    @FXML
    private CheckBox SetHoursCheckBox;

    @FXML
    private CheckBox SetMinutesCheckBox;

    @FXML
    private CheckBox SetSecondsCheckBox;

    @FXML
    private Button SetTimeAllSubButton;

    @FXML
    private TextField TimeValueTextField;




    void setCheckBox(CheckBox SelChB, CheckBox OthChB1, CheckBox OthChB2){
        if (SelChB.isSelected()) {
            OthChB1.setDisable(true);
            OthChB2.setDisable(true);
        }
        else {
            OthChB1.setDisable(false);
            OthChB2.setDisable(false);
        }
    }
    @FXML
    void onSetHoursCheckBoxClicked(MouseEvent event) {
        setCheckBox(SetHoursCheckBox, SetMinutesCheckBox, SetSecondsCheckBox);
    }
    @FXML
    void onSetMinutesCheckBoxClicked(MouseEvent event) {
        setCheckBox(SetMinutesCheckBox, SetHoursCheckBox, SetSecondsCheckBox);
    }

    @FXML
    void onSetSecondsCheckBoxClicked(MouseEvent event) {
        setCheckBox(SetSecondsCheckBox, SetHoursCheckBox, SetMinutesCheckBox);
    }

    @FXML
    void onTimeValueTextFieldClicked(MouseEvent event) {
        if (TimeValueTextField.getText().equals("VALUE"))
            TimeValueTextField.clear();
    }

    @FXML
    void onSetTimeAllSubButtonClicked(MouseEvent event) throws ThrowOutputException {
        if (SetHoursCheckBox.isSelected()){
            MainApplication.shop.SetTimeAll(Hand.HOUR, parseInt(TimeValueTextField.getText()));
        }
        if (SetMinutesCheckBox.isSelected()){
            MainApplication.shop.SetTimeAll(Hand.MINUTE, parseInt(TimeValueTextField.getText()));
        }
        if (SetSecondsCheckBox.isSelected()){
            MainApplication.shop.SetTimeAll(Hand.SECOND, parseInt(TimeValueTextField.getText()));
        }

    }
}
