package com.example.demolab4;

import ClockClasses.Clock;
import ClockClasses.SubClock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static java.lang.Integer.parseInt;

public class AddNewWatchesController {

    @FXML
    private TextField AddBrandTextField;

    @FXML
    private TextField AddPriceTextField;

    @FXML
    private TextField AddHoursTextField;

    @FXML
    private TextField AddMinutesTextField;

    @FXML
    private TextField AddSecondsTextField;
    @FXML
    private Button AddNewWatchesButton;
    @FXML
    private CheckBox SecondsAddCheckBox;

    @FXML
    void onAddBrandTextFieldClicked(MouseEvent event) {
        if (AddBrandTextField.getText().equals("VALUE"))
            AddBrandTextField.clear();
    }

    @FXML
    void onAddPriceTextFieldClicked(MouseEvent event) {
        if (AddPriceTextField.getText().equals("0"))
            AddPriceTextField.clear();
    }
    @FXML
    void onAddHoursTextFieldClicked(MouseEvent event) {
        if (AddHoursTextField.getText().equals("0"))
            AddHoursTextField.clear();
    }

    @FXML
    void onAddMinutesTextFieldClicked(MouseEvent event) {
        if (AddMinutesTextField.getText().equals("0"))
            AddMinutesTextField.clear();
    }

    @FXML
    void onAddSecondsTextFieldClicked(MouseEvent event) {
        if (AddSecondsTextField.getText().equals("0"))
            AddSecondsTextField.clear();
    }

    @FXML
    void onSecondsAddCheckBoxClicked(MouseEvent event) {
        if (!SecondsAddCheckBox.isSelected())
            AddSecondsTextField.setDisable(true);
        else
            AddSecondsTextField.setDisable(false);
    }

    @FXML
    void onAddNewWatchesButtonClicked(MouseEvent event) {
        String brand = AddBrandTextField.getText();
        int price = parseInt(AddPriceTextField.getText());
        int hours = parseInt(AddHoursTextField.getText());
        int minutes = parseInt(AddMinutesTextField.getText());
        int seconds = parseInt(AddSecondsTextField.getText());
        if (SecondsAddCheckBox.isSelected())
            MainApplication.shop.Watches.add(new SubClock(brand, price,  hours, minutes, seconds));
        else
            MainApplication.shop.Watches.add(new Clock(brand, price, hours, minutes));
    }





}


