package com.example.demolab4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



import java.io.IOException;

import static com.example.demolab4.MainApplication.*;

public class MainController {

    @FXML
    private AnchorPane MainScene;

    @FXML
    public Label WatchLabel;
    @FXML
    private Button MostExpensiveClockButton;

    @FXML
    private Button PopularBrandButton;

    @FXML
    private Button SetTimeAllButton;

    @FXML
    private Button PreviousWatchButton;
    @FXML
    private Button NextWatchButton;

    @FXML
    private Button AddNewWatchesButton;

    private int ind;
    @FXML
    void onMostExpensiveClockButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("most-expensive-clock-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Most expensive clock");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    @FXML
    void onPopularBrandButtonClicked(MouseEvent event){
        String brand =  shop.PopularBrand();
        if (PopularBrandButton.getText().equals("Popular Brand"))
            PopularBrandButton.setText(brand);
        else
            PopularBrandButton.setText("Popular Brand");
    }

    @FXML
    void onSetTimeAllButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("set-time-all-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Set time on all clocks");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    @FXML
    void onPreviousWatchButtonClicked(MouseEvent event) {
        if (ind - 1 < 0) {
            ind = shop.Watches.size();
            WatchLabel.setText(shop.Watches.get(ind - 1).toString());

        }
        else {
            WatchLabel.setText(shop.Watches.get(--ind).toString());
        }
    }


    @FXML
    void onNextWatchButtonClicked(MouseEvent event) {
        if (ind + 1 > shop.Watches.size() - 1) {
            ind = 0;
            WatchLabel.setText(shop.Watches.get(ind).toString());

        }
        else {
            WatchLabel.setText(shop.Watches.get(++ind).toString());
        }
    }

    @FXML
    void onAddNewWatchesButtonClicked(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-new-watches-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add new watches");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    @FXML
    public void initialize(){
        ind = 0;
        WatchLabel.setText(shop.Watches.get(ind).toString());

    }
}


