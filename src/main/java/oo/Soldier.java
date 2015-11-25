package oo;

public class Soldier extends Person {
    private String ROLE = "战士";
    private Weapon weapon;
    private Defence defence;

    public Soldier(String name, int blood, int damage) {
        super(name, blood, damage);
        weapon = NoWeapon.getInstance();
        defence = NoDefence.getInstance();
    }

    @Override
    public int getDamage() {
        return super.getDamage() + weapon.attackDamage();
    }

    @Override
    public String getROLE() {
        return ROLE;
    }

    public void wearWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void wearDefence(Defence defence) {
        this.defence = defence;
    }

    @Override
    protected String attackIdentify() {
        return getROLE() + getName() + weapon.isUsed();
    }

    @Override
    public int shouldReduceBlood(int damage) {
        return (damage > defence.weakenDamage()) ? damage - defence.weakenDamage() : 0;
    }
}
