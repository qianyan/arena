package oo;

public class Player {
    private String name;
    private int blood;
    private int damage;

    public Player(String name, int blood, int damage) {
        this.name = name;
        this.blood = blood;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Player otherPlayer) {
        otherPlayer.blood -= damage;
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
