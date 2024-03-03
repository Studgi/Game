package game.engine.weapons.factory;

import game.engine.weapons.Weapon;

public class FactoryResponse {
    private final Weapon weapon;
    private int remainingResources;

    public FactoryResponse(Weapon weapon, int remainingResources) {
        this.weapon = weapon;
        this.remainingResources = remainingResources;
    }
}
