package game.engine.base;

import game.engine.interfaces.Attackee;

public class Wall implements Attackee {
    private final int baseHealth;
    private int currentHealth;

    public Wall(int baseHealth){
        this.baseHealth = baseHealth;
        this.currentHealth = baseHealth;
    }

    public int getBaseHealth(){
        return this.baseHealth;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public void setCurrentHealth(int currentHealth){
        this.currentHealth = Math.max(currentHealth, 0);
    }

    public int getResourcesValue(){
        return -1;
    }
}
