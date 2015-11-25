package oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SoldierTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Soldier soldier;
    private Person person;
    private Weapon weapon;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        soldier = new Soldier("张三", 100, 10);
        person = new Person("李四", 100, 10);
        weapon = new Weapon("优质木棒", 10);
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldPrintSoliderAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        soldier.attack(person);

        assertThat(outContent.toString(), is("战士张三攻击了李四，李四受到了10点伤害，李四剩余血量：90\n"));
    }

    @Test
    public void shouldPrintPersonAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        person.attack(soldier);

        assertThat(outContent.toString(), is("普通人李四攻击了张三，张三受到了10点伤害，张三剩余血量：90\n"));
    }

    @Test
    public void shouldAttackDamageIsSoldierDamagePlusWeaponDamage() {
        soldier.wearWeapon(weapon);

        soldier.attack(person);

        assertThat(outContent.toString(), is("战士张三用优质木棒攻击了李四，李四受到了20点伤害，李四剩余血量：80\n"));
    }
}