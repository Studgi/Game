package game.engine.dataloader;

import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataLoader {
    static File titans = new File("." + File.pathSeparator + "titans.csv");
    static File weapons = new File("." + File.pathSeparator + "weapons.csv");
    private static final String TITANS_FILE_NAME = titans.toString();
    private static final String WEAPONS_FILE_NAME = weapons.toString();


    public static HashMap<Integer, TitanRegistry> readTitanRegistry() throws IOException {
        HashMap<Integer,TitanRegistry> TitansMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(TITANS_FILE_NAME));
        while(br.readLine() != null){
            String[] TitansStr = (br.readLine()).split(",");
            int[] TitansInt = new int[TitansStr.length];
            for(int i = 0; i<TitansStr.length;i++){
                TitansInt[i] = Integer.parseInt(TitansStr[i]);
            }
            TitanRegistry titanRegistry = new TitanRegistry(TitansInt[0],TitansInt[1],TitansInt[2],TitansInt[3],TitansInt[4],TitansInt[5],TitansInt[6]);
            TitansMap.put(TitansInt[0],titanRegistry);
        }
        return TitansMap;
    }

    public static HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
        HashMap<Integer,WeaponRegistry> WeaponsMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME));
        while(br.readLine() != null){
            String[] WeaponsStr = (br.readLine()).split(",");
            int[] WeaponsInt = new int[WeaponsStr.length];
            for(int i = 0; i<WeaponsStr.length;i++){
                if(i != 3)
                    WeaponsInt[i] = Integer.parseInt(WeaponsStr[i]);
            }
            WeaponRegistry weaponRegistry;
            if(WeaponsStr.length > 4){
                weaponRegistry = new WeaponRegistry(WeaponsInt[0], WeaponsInt[1], WeaponsInt[2], WeaponsStr[3], WeaponsInt[4], WeaponsInt[5]);
            } else {
                weaponRegistry = new WeaponRegistry(WeaponsInt[0], WeaponsInt[1], WeaponsInt[2], WeaponsStr[3]);
            }

            WeaponsMap.put(WeaponsInt[0],weaponRegistry);
        }
        return WeaponsMap;
    }
}
