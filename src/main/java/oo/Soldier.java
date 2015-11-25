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
        return super.getDamage() + weapon.getDamage();
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
        return getROLE() + getName() + weapon.used();
    }

    @Override
    public int shouldReduceBlood(int damage) {
        return (damage > defence.getWeakenDamage()) ? damage - defence.getWeakenDamage() : 0;
    }
}
