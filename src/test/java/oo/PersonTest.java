package oo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PersonTest {

    @Test
    public void shouldBeAbleToAttackOtherPlayer() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 80, 20);

        attacker.attack(victim);

        assertThat(victim.getBlood(), is(70));
    }

    @Test
    public void shouldAliveWhenBloodIs0() {
        Person survivor = new Person("王二麻子", 0, 0);

        assertTrue(survivor.isAlive());
    }

    @Test
    public void shouldAliveWhenBloodGreatThan0() {
        Person survivor = new Person("王二麻子", 1, 0);

        assertTrue(survivor.isAlive());
    }

    @Test
    public void shouldDeathWhenBloodLessThan0() {
        Person die = new Person("王二麻子", -1, 0);

        assertFalse(die.isAlive());
    }

    @Test
    public void shouldVictimGetDamageAndBloodLeftWhenAttackerAttackedVictimAnd() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 100, 10);

        String result = attacker.attack(victim);

        assertThat(result, is("普通人张三攻击了李四,李四受到了10点伤害,李四剩余生命：90\n"));
    }
}