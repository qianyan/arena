package oo;

import static oo.Printer.print;

public class Game {
    public void fight(Player firstPlayer, Player secondPlayer) {
        Player loser = firstPlayer;

        while (firstPlayer.isAlive()) {
            firstPlayer.attack(secondPlayer);

            if (!secondPlayer.isAlive()) {
                loser = secondPlayer;
                break;
            }
            secondPlayer.attack(firstPlayer);
        }

        print(loser.getName() + "被打败了");
    }
}
