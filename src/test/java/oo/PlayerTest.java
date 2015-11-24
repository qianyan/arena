package oo;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

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
    public void shouldDeathWhenBloodLessThan0() {
        Player die = new Player("王二麻子", -1, 0);

        assertFalse(die.isAlive());
    }

    @Test
    public void shouldPrintAttackerAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        Player attacker = new Player("张三", 100, 10);
        Player victim = new Player("李四", 100, 10);

        attacker.attack(victim);

        assertThat(outContent.toString(), is("张三攻击了李四，李四受到了10点伤害，李四剩余血量：90\n"));
    }
}