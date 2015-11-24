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
        Player firstPlayer = new Player("张三", 100, 10);
        Player secondPlayer = new Player("李四", 100, 9);

        game.fight(firstPlayer, secondPlayer);

        assertThat(outContent.toString(), is(secondPlayer.getName() + "被打败了"));
    }

    @Test
    public void shouldFirstPlayerLoseWhenSecondPlayerIsPowerful() {
        Player firstPlayer = new Player("张三", 100, 9);
        Player secondPlayer = new Player("李四", 100, 10);

        game.fight(firstPlayer, secondPlayer);

        assertThat(outContent.toString(), is(firstPlayer.getName() + "被打败了"));
    }
}