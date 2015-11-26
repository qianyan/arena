package oo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void shouldSecondPlayerLoseWhenFirstPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 10, 10);
        Person secondPerson = new Person("李四", 9, 10);

        String result = game.fight(firstPerson, secondPerson);

        assertThat(result, is(String.format("%s\n%s",
                "普通人张三攻击了李四,李四受到了10点伤害,李四剩余生命：-1",
                "李四被打败了")));
    }

    @Test
    public void shouldFirstPlayerLoseWhenSecondPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 10, 8);
        Person secondPerson = new Person("李四", 20, 9);

        String result = game.fight(firstPerson, secondPerson);

        assertThat(result, is(String.format("%s\n%s\n%s\n%s\n%s",
                        "普通人张三攻击了李四,李四受到了8点伤害,李四剩余生命：12",
                        "普通人李四攻击了张三,张三受到了9点伤害,张三剩余生命：1",
                        "普通人张三攻击了李四,李四受到了8点伤害,李四剩余生命：4",
                        "普通人李四攻击了张三,张三受到了9点伤害,张三剩余生命：-8",
                "张三被打败了")));
    }
}