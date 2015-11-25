package oo;

public class NoArmor extends Armor {
    private final static NoArmor INSTANCE = new NoArmor("", 0);

    private NoArmor(String name, int weakenDamage) {
        super(name, weakenDamage);
    }

    public static NoArmor getInstance() {
        return INSTANCE;
    }
}
