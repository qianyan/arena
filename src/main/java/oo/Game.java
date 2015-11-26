package oo;

public class Game {
    public String fight(Person firstPerson, Person secondPerson) {
        Person loser = firstPerson;
        String result = "";
        while (firstPerson.isAlive()) {
            result += firstPerson.attack(secondPerson);

            if (!secondPerson.isAlive()) {
                loser = secondPerson;
                break;
            }
            result += secondPerson.attack(firstPerson);
        }

        return result + loser.getName() + "被打败了";
    }
}
