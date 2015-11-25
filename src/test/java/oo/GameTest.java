package oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        game = new Game();
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldSecondPlayerLoseWhenFirstPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 10, 10);
        Person secondPerson = new Person("李四", 9, 10);

        game.fight(firstPerson, secondPerson);

        assertThat(outContent.toString(), is("普通人张三攻击了李四，李四受到了10点伤害，李四剩余血量：-1\n李四被打败了"));
    }

    @Test
    public void shouldFirstPlayerLoseWhenSecondPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 9, 10);
        Person secondPerson = new Person("李四", 20, 10);

        game.fight(firstPerson, secondPerson);

        assertThat(outContent.toString(), is("普通人张三攻击了李四，李四受到了10点伤害，李四剩余血量：10\n" +
                "普通人李四攻击了张三，张三受到了10点伤害，张三剩余血量：-1\n" +
                "张三被打败了"));
    }
}