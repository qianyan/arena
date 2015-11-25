package oo;

public class NoDefence extends Defence {
    private final static NoDefence INSTANCE = new NoDefence("", 0);

    private NoDefence(String name, int weakenDamage) {
        super(name, weakenDamage);
    }

    public static NoDefence getInstance() {
        return INSTANCE;
    }
}
