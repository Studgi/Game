package game.engine.lanes;
import game.engine.base.Wall;
import game.engine.titans.Titan;
import game.engine.weapons.Weapon;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Lane implements Comparable<Lane> {

    private final Wall laneWall;
    private int dangerLevel;
    private final PriorityQueue<Titan> titans;
    private final ArrayList<Weapon> weapons;

    public Lane(Wall laneWall){
        this.laneWall = laneWall;
        this.dangerLevel = 0;
        this.titans = new PriorityQueue<>();
        this.weapons = new ArrayList<>();
    }

    public Wall getLaneWall(){
        return this.laneWall;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel){
        this.dangerLevel = Math.max(dangerLevel, 0);
    }

    public PriorityQueue<Titan> getTitans(){
        return this.titans;
    }

    public ArrayList<Weapon> getWeapons(){
        return this.weapons;
    }

    @Override
    public int compareTo(Lane o) {
        return this.dangerLevel - o.dangerLevel;
    }
}
