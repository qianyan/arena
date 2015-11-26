package oo;

public class Game {
    private Printable printer;

    public Game(Printable printer) {
        this.printer = printer;
    }

    public void fight(Person firstPerson, Person secondPerson) {
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

        printer.print(result + loser.getName() + "被打败了");
    }
}
