package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Game extends RandomGenerator {
    int tour = 2;
    Project project = new Project();
    Player first = new Player("Sebastian", "Miszka");
    LocalDate time = LocalDate.of(2020, 1, 1);

    DayOfWeek DayOfWeek = time.getDayOfWeek();

    public void Today() {
        System.out.println("Zaczynasz grę, jest: " + time + " " + time.getDayOfWeek());
    }

    public void TimeAdd(){
        time = time.plusDays(1);
        System.out.println("Dzisiaj jest: " + time + " " + time.getDayOfWeek());
    }

    public void StartGame(){
        System.out.println("Zaczynamy grę");

    }

    public void CodeTime() {
        if (tour == 1) {
            System.out.println("Dzień 1");
            StartGame();

        }else {
            System.out.println(tour);
            System.out.println("Co chcesz dzisiaj zrobić?");
            System.out.println("1. Podpisz umowę na realizację projektu");
            System.out.println("2. Przeznacz dzień na szukanie klientów");
            System.out.println("3. Przeznacz dzień na programowanie");
            System.out.println("4. Przeznacz dzień na testowanie");
            System.out.println("5. Oddaj gotowy projekt klientowi");
            System.out.println("6. Zatrudnij nowego pracownika");
            System.out.println("7. Zwolnij pracownika");
            System.out.println("8. Przezacz dzień na rozliczenia z urzędami ");
            Choice(maxInput(8));
        }
    }
        public void Choice(Integer option) {
            switch (option) {
                case 1:
                    if (signAContract() == true) EndTour();
                    break;
            }
            switch (option) {
                case 2:
                    System.out.println("Wybór 2");
                    break;
            }
            switch (option) {
                case 3:
                    System.out.println("Wybór 3");
                    break;
            }
            switch (option) {
                case 4:
                    System.out.println("Wybór 4");
                    break;
            }
            switch (option) {
                case 5:
                    System.out.println("Wybór 5");
                    break;
            }
            switch (option) {
                case 6:
                    System.out.println("Wybór 6");
                    break;
            }
            switch (option) {
                case 7:
                    System.out.println("Wybór 7");
                    break;
            }
            switch (option) {
                case 8: {
                    System.out.println("Zus opłacony");
                    EndTour();
                }
                    break;
            }
        }

    public boolean signAContract() {
        if (project.getSizeOfList() == 0) {
            project.createProjectList(first.getPoints(), time);
        }
        project.showListOfProject();
        Integer sizeList = project.getSizeOfList();
        System.out.println(sizeList + ". Wróć");
        System.out.println("Masz " + first.getPoints() + " punktów, jak zbierzesz więcej punktów możesz odkryć większe projekty");
        System.out.println("\nMasz " + sizeList + " dostępnych projektów.\nWybierz któryś");
        Integer tempOption = maxInput(sizeList);
        if (tempOption != sizeList) {
            first.addToMyProjectsList(project.getAProject(tempOption));
            project.removeFromList();
            System.out.println("Wybrany przez Ciebie projekt1 to:\n");
            first.showProjectList();
            System.out.println("Projekt dodany to Twojej listy projektów\nAktywne projekty: " + first.activeProjects());
            return true;
        }
        return false;
    }

    public void EndTour() {
        TimeAdd();
        System.out.println("Jest to tura gry nr: " + tour++);
    }

}





