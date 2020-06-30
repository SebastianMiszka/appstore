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
    
}
