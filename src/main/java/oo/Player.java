package oo;

import static oo.Printer.print;

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
        print(name + "攻击了" + otherPlayer.name + "，" +
                otherPlayer.name + "受到了" + damage + "点伤害，" +
                otherPlayer.name + "剩余血量：" + otherPlayer.blood + "\n");
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
