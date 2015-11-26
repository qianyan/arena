package oo;

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

    public String attack(Person victim) {
        return startAttackTo(victim.name) +
        victim.isAttacked(getDamage()) +
        endAttack();
    }

    protected String attackIdentify() {
        return getROLE() + name;
    }

    private String startAttackTo(String victimName) {
        return attackIdentify() + "攻击了" + victimName + ",";
    }

    private String isAttacked(int damage) {
        int shouldReduceBlood = shouldReduceBlood(damage);
        blood -= shouldReduceBlood;
        return name + "受到了" + shouldReduceBlood + "点伤害," +
                name + "剩余生命：" + blood;
    }

    public int shouldReduceBlood(int damage) {
        return damage;
    }

    private String endAttack() {
        return "\n";
    }

    public boolean isAlive() {
        return blood >= 0;
    }
}
