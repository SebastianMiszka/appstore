package com.company;

public class Human extends RandomGenerator {
    String name;
    String surname;
    Double cost;

    public Human(String nname, String nsurname, Double nCost) {
        this.name = nname;
        this.surname = nsurname;
        this.cost = nCost;
    }

    public Human() {

    }
    public Human generateTester() {
        return new Human(createRandomName(9), createRandomSurname(9), 3000.0);
    }

    public Human generateDealer() {
        return new Human(createRandomName(9), createRandomSurname(9),3500.0);
    }
}
