package oo;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {
    private Game game;
    private Printable printer;

    @Before
    public void setUp() {
        printer = mock(Printable.class);
        game = new Game(printer);
    }

    @Test
    public void shouldSecondPlayerLoseWhenFirstPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 10, 10);
        Person secondPerson = new Person("李四", 9, 10);

        game.fight(firstPerson, secondPerson);

        verify(printer).print(String.format("%s\n%s",
                "普通人张三攻击了李四,李四受到了10点伤害,李四剩余生命：-1",
                "李四被打败了"));
    }

    @Test
    public void shouldFirstPlayerLoseWhenSecondPlayerIsPowerful() {
        Person firstPerson = new Person("张三", 10, 8);
        Person secondPerson = new Person("李四", 20, 9);

        game.fight(firstPerson, secondPerson);

        verify(printer).print(String.format("%s\n%s\n%s\n%s\n%s",
                "普通人张三攻击了李四,李四受到了8点伤害,李四剩余生命：12",
                "普通人李四攻击了张三,张三受到了9点伤害,张三剩余生命：1",
                "普通人张三攻击了李四,李四受到了8点伤害,李四剩余生命：4",
                "普通人李四攻击了张三,张三受到了9点伤害,张三剩余生命：-8",
                "张三被打败了"));
    }
}