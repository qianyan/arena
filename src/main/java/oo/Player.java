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

    public void attack(Player victim) {
        startAttackTo(victim);
        victim.isAttacked(damage);
        endAttack();
    }

    private void startAttackTo(Player victim) {
        print(name + "攻击了" + victim.name + "，");
    }

    private void isAttacked(int damage) {
        blood -= damage;
        print(name + "受到了" + damage + "点伤害，" +
                name + "剩余血量：" + blood);
    }

    private void endAttack() {
        print("\n");
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
