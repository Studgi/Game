package game.engine.titans;

import game.engine.interfaces.Attackee;
import game.engine.interfaces.Attacker;
import game.engine.interfaces.Mobil;

public abstract class Titan implements Attackee, Attacker, Mobil, Comparable<Titan> {
    private final int baseHealth;
    private int currentHealth;
    private final int baseDamage;
    private final int heightInMeters;
    private int distanceFromBase;
    private int speed;
    private final int resourcesValue;
    private final int dangerLevel;
    public Titan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed, int resourcesValue, int dangerLevel){
        this.baseHealth=baseHealth;
        this.baseDamage=baseDamage;
        this.heightInMeters=heightInMeters;
        this.distanceFromBase=distanceFromBase;
        this.speed=speed;
        this.resourcesValue=resourcesValue;
        this.dangerLevel=dangerLevel;
        this.currentHealth = baseHealth;
    }

    public int getBaseHealth() {
        return this.baseHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = Math.max(currentHealth, 0);
    }

    public int getDamage() {
        return this.baseDamage;
    }
    public int getHeightInMeters() {
        return this.heightInMeters;
    }
    public int getDistance() {
        return this.distanceFromBase;
    }

    public void setDistance(int distanceFromBase) {
        this.distanceFromBase =  Math.max(distanceFromBase, 0);
    }
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = Math.max(speed, 0);
    }

    public int getResourcesValue() {
        return this.resourcesValue;
    }
    public int getDangerLevel(){
        return this.dangerLevel;
    }

    @Override
    public int compareTo(Titan o){
        return this.distanceFromBase - o.distanceFromBase;
    }
}