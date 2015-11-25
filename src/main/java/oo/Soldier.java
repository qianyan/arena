package oo;

public class Soldier extends Person {
    private String ROLE = "战士";
    private Weapon weapon;

    public Soldier(String name, int blood, int damage) {
        super(name, blood, damage);
        weapon = NoWeapon.getInstance();
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

    @Override
    protected String attackIdentify() {
        return getROLE() + getName() + weapon.used();
    }
}
