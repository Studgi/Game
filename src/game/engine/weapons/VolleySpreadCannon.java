package game.engine.weapons;

public class VolleySpreadCannon extends Weapon {

    public static final int WEAPON_CODE = 3;

    public VolleySpreadCannon(int baseDamage) {
        super(baseDamage);
    }

    @Override
    int getWeaponCode() {
        return WEAPON_CODE;
    }
}
