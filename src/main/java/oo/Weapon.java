package oo;

public class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String used() {
        return "用" + name;
    }

    public int getDamage() {
        return damage;
    }
}
