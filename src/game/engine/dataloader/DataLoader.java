package game.engine.dataloader;

import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataLoader {
    private static final String TITANS_FILE_NAME = "titans.csv";
    private static final String WEAPONS_FILE_NAME = "weapons.csv";

    public static HashMap<Integer, TitanRegistry> readTitanRegistry() throws IOException {
        HashMap<Integer,TitanRegistry> TitansMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(TITANS_FILE_NAME));
        String line = br.readLine();
        while(line != null){
            String[] TitansStr = line.split(",");
            int[] TitansInt = new int[TitansStr.length];
            for(int i = 0; i<TitansStr.length;i++){
                TitansInt[i] = Integer.parseInt(TitansStr[i]);
            }
            TitanRegistry titanRegistry = new TitanRegistry(TitansInt[0],TitansInt[1],TitansInt[2],TitansInt[3],TitansInt[4],TitansInt[5],TitansInt[6]);
            TitansMap.put(TitansInt[0],titanRegistry);
            line = br.readLine();
        }
        br.close();
        return TitansMap;
    }

    public static HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
        HashMap<Integer,WeaponRegistry> WeaponsMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME));
        String line = br.readLine();
        while(line != null){
            String[] WeaponsStr = line.split(",");
            int[] WeaponsInt = new int[WeaponsStr.length];
            for(int i = 0; i<WeaponsStr.length;i++){
                if(i != 3)
                    WeaponsInt[i] = Integer.parseInt(WeaponsStr[i]);
            }
            WeaponRegistry weaponRegistry;
            if(WeaponsStr.length > 4){
                weaponRegistry = new WeaponRegistry(WeaponsInt[0], WeaponsInt[1], WeaponsInt[2], WeaponsStr[3], WeaponsInt[4], WeaponsInt[5]);
            } else if (WeaponsStr.length > 2) {
                weaponRegistry = new WeaponRegistry(WeaponsInt[0], WeaponsInt[1], WeaponsInt[2], WeaponsStr[3]);
            } else {
                weaponRegistry = new WeaponRegistry(WeaponsInt[0], WeaponsInt[1]);
            }

            WeaponsMap.put(WeaponsInt[0],weaponRegistry);
            line = br.readLine();
        }
        br.close();
        return WeaponsMap;
    }

    public static String getTitansFileName() {
        return DataLoader.TITANS_FILE_NAME;
    }

    public static String getWeaponsFileName() {
        return DataLoader.WEAPONS_FILE_NAME;
    }
}
