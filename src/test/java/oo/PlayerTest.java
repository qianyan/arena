package oo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void shouldCreatePlayerSuccessfully() {
        Player player = new Player("王二麻子", 100, 10);

        assertThat(player.getName(), is("王二麻子"));
        assertThat(player.getBlood(), is(100));
        assertThat(player.getDamage(), is(10));
    }

    @Test
    public void shouldCanAttackOtherPlayer() {
        Player attacker = new Player("张三", 100, 10);
        Player victim = new Player("李四", 80, 20);

        attacker.attack(victim);

        assertThat(victim.getBlood(), is(80 - attacker.getDamage()));
    }

    @Test
    public void shouldAliveWhenBloodIs0() {
        Player survivor = new Player("王二麻子", 0, 0);

        assert(survivor.isAlive());
    }

    @Test
    public void shouldAliveWhenBloodGreatThan0() {
        Player survivor = new Player("王二麻子", 1, 0);

        assert(survivor.isAlive());
    }

    @Test
    public void shouldDeathWhenBloodLessThan0() {
        Player die = new Player("王二麻子", -1, 0);

        assertFalse(die.isAlive());
    }
}