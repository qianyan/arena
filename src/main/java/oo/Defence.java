package oo;

public class Defence {
    private String name;
    private int weakenDamage;

    public Defence(String name, int weakenDamage) {
        this.name = name;
        this.weakenDamage = weakenDamage;
    }

    public int weakenDamage() {
        return weakenDamage;
    }
}
