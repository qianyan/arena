package oo;

import static java.lang.String.format;

public class Person {
    private String name;
    private int blood;
    protected int damage;

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

    public String getRole() {
        return "普通人";
    }

    public String attack(Person victim) {
        return format("%s攻击了%s,%s\n", attackIdentify(), victim.name, victim.isAttacked(damage));
    }

    protected String attackIdentify() {
        return getRole() + name;
    }

    private String isAttacked(int damage) {
        int reducedBlood = bleed(damage);
        blood -= reducedBlood;
        return format("%s受到了%d点伤害,%s剩余生命：%d", name, reducedBlood, name, blood);
    }

    protected int bleed(int damage) {
        return damage;
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
