package oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PersonTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldCreatePlayerSuccessfully() {
        Person person = new Person("王二麻子", 100, 10);

        assertThat(person.getName(), is("王二麻子"));
        assertThat(person.getBlood(), is(100));
        assertThat(person.getDamage(), is(10));
    }

    @Test
    public void shouldCanAttackOtherPlayer() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 80, 20);

        attacker.attack(victim);

        assertThat(victim.getBlood(), is(80 - attacker.getDamage()));
    }

    @Test
    public void shouldAliveWhenBloodIs0() {
        Person survivor = new Person("王二麻子", 0, 0);

        assert(survivor.isAlive());
    }

    @Test
    public void shouldAliveWhenBloodGreatThan0() {
        Person survivor = new Person("王二麻子", 1, 0);

        assert(survivor.isAlive());
    }

    @Test
    public void shouldDeathWhenBloodLessThan0() {
        Person die = new Person("王二麻子", -1, 0);

        assertFalse(die.isAlive());
    }

    @Test
    public void shouldPrintAttackerAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 100, 10);

        attacker.attack(victim);

        assertThat(outContent.toString(), is("普通人张三攻击了李四，李四受到了10点伤害，李四剩余血量：90\n"));
    }
}