package com.company;

public class Player extends Worker {
    Double cash = 20000.0;

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.ability= new String[5];
        this.ability[0]="front-end";
        this.ability[1]="backend";
        this.ability[2]="baza danych";
        this.ability[3]="wordpress";
        this.ability[4]="prestashop";
    }

}
