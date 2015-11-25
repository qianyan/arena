package oo;

public class Armor {
    private String name;
    private int weakenDamage;

    public Armor(String name, int weakenDamage) {
        this.name = name;
        this.weakenDamage = weakenDamage;
    }

    public int weakenDamage() {
        return weakenDamage;
    }
}
