package oo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SoldierTest {
    private Soldier soldier;
    private Person person;
    private Weapon weapon;
    private Armor armor;

    @Before
    public void setUp() {
        soldier = new Soldier("张三", 100, 10);
        person = new Person("李四", 100, 10);
        weapon = new Weapon("优质木棒", 10);
        armor = new Armor("木遁", 5);
    }

    @Test
    public void shouldPrintSoliderAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        String result = soldier.attack(person);

        assertThat(result, is("战士张三攻击了李四,李四受到了10点伤害,李四剩余生命：90\n"));
    }

    @Test
    public void shouldPrintPersonAttackedVictimAndVictimGetHowMuchDamageAndHowMuchBloodLeft() {
        String result = person.attack(soldier);

        assertThat(result, is("普通人李四攻击了张三,张三受到了10点伤害,张三剩余生命：90\n"));
    }

    @Test
    public void shouldAttackDamageIsSoldierDamagePlusWeaponDamage() {
        soldier.wearWeapon(weapon);

        String result = soldier.attack(person);

        assertThat(result, is("战士张三用优质木棒攻击了李四,李四受到了20点伤害,李四剩余生命：80\n"));
    }

    @Test
    public void shouldWeakenTheDamageFromAttackerWhenSoldierIsAttacked() {
        soldier.wearDefence(armor);

        String result = person.attack(soldier);

        assertThat(result, is("普通人李四攻击了张三,张三受到了5点伤害,张三剩余生命：95\n"));
    }

    @Test
    public void shouldNotAffectSoldierDamageAfterWearDefence() {
        soldier.wearDefence(armor);

        String result = soldier.attack(person);

        assertThat(result, is("战士张三攻击了李四,李四受到了10点伤害,李四剩余生命：90\n"));
    }
}