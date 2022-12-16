package com.example.demolab4;

import ClockClasses.ShopClock;
import Serialize.FileShopDesererializer;
import Serialize.FileShopSererializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    public static ShopClock shop;

    public MainApplication() throws IOException, ClassNotFoundException {
        //shop = new DBShopDeserializer().Load(); // выгрузка из базы данных
        shop = new FileShopDesererializer(new File("Shop.bin")).Load(); // выгрузка из файла
        //Инициализация БД:
        //shop = new ShopClock();
        //shop.add()...
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Clock shop");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws IOException {
        //new DBShopSerializer(shop).Save(); //запись данных в БД
        new FileShopSererializer(shop, new File("Shop.bin")).Save(); //запись в файл
    }

    public static void main(String[] args) {
        launch();
    }
}
