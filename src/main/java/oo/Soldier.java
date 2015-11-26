package oo;

public class Soldier extends Person {
    private Weapon weapon;
    private Armor armor;

    public Soldier(String name, int blood, int damage) {
        super(name, blood, damage);
        weapon = NoWeapon.getInstance();
        armor = NoArmor.getInstance();
    }

    @Override
    public String getRole() {
        return "战士";
    }

    public void wearWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.damage += weapon.attackDamage();
    }

    public void wearDefence(Armor armor) {
        this.armor = armor;
    }

    @Override
    protected String attackIdentify() {
        return getRole() + getName() + weapon.isUsed();
    }

    @Override
    public int bleed(int damage) {
        return (damage > armor.weakenDamage()) ? damage - armor.weakenDamage() : 0;
    }
}
