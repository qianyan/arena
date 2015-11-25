package oo;

public class Soldier extends Person {
    private String ROLE = "战士";

    public Soldier(String name, int blood, int damage) {
        super(name, blood, damage);
    }

    @Override
    public String getROLE() {
        return ROLE;
    }
}
