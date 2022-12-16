package Serialize;

import ClockClasses.ShopClock;

import java.io.*;

public class FileShopSererializer {
    private final ShopClock shop;
    private final File file;

    public FileShopSererializer(ShopClock shop, File file) {

        this.shop = shop;
        this.file = file;
    }

    public void Save() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(shop);
        }
    }
}
