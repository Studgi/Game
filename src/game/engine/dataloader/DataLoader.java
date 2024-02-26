package game.engine.dataloader;

import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataLoader {
    File titans = new File("." + File.pathSeparator + "titans.csv");
    File weapons = new File("." + File.pathSeparator + "weapons.csv");
    private String TITANS_FILE_NAME;
    private String WEAPONS_FILE_NAME;

//    public static HashMap<Integer, TitanRegistry> readTitanRegistry() throws IOException {
//
//    }
//
//    public static HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
//
//    }
}
