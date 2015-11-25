package oo;

public class NoWeapon extends Weapon {
    private final static NoWeapon INSTANCE = new NoWeapon("", 0);

    private NoWeapon(String name, int damage) {
        super(name, damage);
    }

    public String isUsed() {
        return "";
    }

    public static NoWeapon getInstance() {
        return INSTANCE;
    }
}
