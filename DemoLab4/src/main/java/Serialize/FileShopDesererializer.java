package Serialize;

import ClockClasses.ShopClock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileShopDesererializer {
    private final File file;

    public FileShopDesererializer(File file) {
        
        this.file = file;
    }
    
    public ShopClock Load() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            return (ShopClock) objectInputStream.readObject();
        }
    }
}
