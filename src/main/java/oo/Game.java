package oo;

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

        System.out.print(loser.getName() + "被打败了");
    }
}
