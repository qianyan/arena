package oo;

import static oo.Printer.print;

public class Game {
    public void fight(Person firstPerson, Person secondPerson) {
        Person loser = firstPerson;

        while (firstPerson.isAlive()) {
            firstPerson.attack(secondPerson);

            if (!secondPerson.isAlive()) {
                loser = secondPerson;
                break;
            }
            secondPerson.attack(firstPerson);
        }

        print(loser.getName() + "被打败了");
    }
}
