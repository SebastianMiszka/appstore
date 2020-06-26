package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Game {
    int tour = 2;
    LocalDate time = LocalDate.of(2020, 1, 1);

    DayOfWeek DayOfWeek = time.getDayOfWeek();

    public void Today() {
        System.out.println("Zaczynasz grę, jest: " + time + " " + time.getDayOfWeek());
    }

    public void TimeAdd(){
        time = time.plusDays(2);
        System.out.println("Dzisiaj jest: " + time + " " + time.getDayOfWeek());
    }

    public void StartGame(){
        System.out.println("Zaczynamy grę");

    }

    public void CodeTime() {
        if (tour == 1) {
            StartGame();
        }

        else if(tour == 3){
                System.out.println("Elo");
            System.exit(0);
            }
        else{
            System.out.println("Today is: " + time.getDayOfWeek() + " Day " + tour);
            time = time.plusDays(1);
            tour = tour+1;
        }
        }
    }




