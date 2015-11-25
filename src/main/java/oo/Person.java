package oo;

import static oo.Printer.print;

public class Person {
    private String ROLE = "普通人";
    private String name;
    private int blood;
    private int damage;

    public Person(String name, int blood, int damage) {
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

    public String getROLE() {
        return ROLE;
    }

    public void attack(Person victim) {
        startAttackTo(victim.name);
        victim.isAttacked(getDamage());
        endAttack();
    }

    protected String attackIdentify() {
        return getROLE() + name;
    }

    private void startAttackTo(String victimName) {
        print(attackIdentify() + "攻击了" + victimName + "，");
    }

    private void isAttacked(int damage) {
        int shouldReduceBlood = shouldReduceBlood(damage);
        blood -= shouldReduceBlood;
        print(name + "受到了" + shouldReduceBlood + "点伤害，" +
                name + "剩余血量：" + blood);
    }

    public int shouldReduceBlood(int damage) {
        return damage;
    }

    private void endAttack() {
        print("\n");
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
