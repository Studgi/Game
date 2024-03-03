package game.engine.weapons;

import game.engine.interfaces.Attacker;

abstract public class Weapon implements Attacker {

    private final int baseDamage;

    public Weapon(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public int getDamage() {
        return this.baseDamage;
    }
}
