package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Game {

    LocalDate time = LocalDate.of(2020, 1, 1);

    DayOfWeek DayOfWeek = time.getDayOfWeek();

    public void Today() {
        System.out.println("Zaczynasz grę, jest: " + time + " " + time.getDayOfWeek());
    }

    public void TimeAdd(){
        time = time.plusDays(2);
        System.out.println("Dzisiaj jest: " + time + " " + time.getDayOfWeek());
    }




}
