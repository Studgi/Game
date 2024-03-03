package game.engine.weapons;

public class SniperCannon extends Weapon {

    public static final int WEAPON_CODE = 2;

    private int minRange;
    private int maxRange;

    public SniperCannon(int baseDamage, int minRange, int maxRange) {
        super(baseDamage);
        this.minRange = minRange;
        this.maxRange = maxRange;
    }
}
