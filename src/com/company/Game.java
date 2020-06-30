package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Game extends RandomGenerator {
    int tour = 2;
    Project project = new Project();
    Player first = new Player("Sebastian", "Miszka");
    LocalDate time = LocalDate.of(2020, 1, 1);
    Friend friend = new Friend();
    Integer controlPoint=2;
    Integer zus = 2;

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

    public void firstDay() {
        friend.generateFriend();
        first.addFriendToMyList(friend.getFriendList());

    }

    public void CodeTime() {
        if (tour == 1) {
            firstDay();

        }else {
            System.out.println("Jest to tura gry nr: " + tour);
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
                    if (signAContract() == true) endDay();
                    break;
            }
            switch (option) {
                case 2:
                    addPoint();
                    break;
            }
            switch (option) {
                case 3:
                    if (programmingDay() == true) endDay();
                    break;
            }
            switch (option) {
                case 4:
                    if (testUrApp() == true) endDay();
                    break;
            }
            switch (option) {
                case 5:
                    if (handOverTheProject() == true) endDay();
                    break;
            }
            switch (option) {
                case 6:
                    hireAnEmployee();
                    break;
            }
            switch (option) {
                case 7:
                    dissmisEmploye();
                    break;
            }
            switch (option) {
                case 8: {
                    paperTimeDay();
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

    public boolean programmingDay() {
        if (first.activeProjects() == 0) {
            System.out.println("Nie masz projektów, podpisz jakiś");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), first.abilityToProject());
            if (checkingProject == true) {
                System.out.println("Masz wystaczająco dużo umiejętności do zrobienia tego projektu");
                System.out.println("Masz tylko jeden projekt i to właśnie na nim będziesz pracować:");
                first.showProjectList();
                Project tempObj = first.getLastObjectFromProject();
                Integer tempInt = checkProjectStatusSkills(tempObj);
                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                if (tempInt != 0) {
                    first.updateDataProjectList(project.setNewHours(tempObj), first.activeProjects() - 1);
                    return true;
                } else {
                    System.out.println("\nTen projekt jest skończony");
                }
            } else {
                System.out.println("Nie masz umiejętności aplikacji mobilnych");
            }
        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ".Wyjdź\nTo są Twoje projekty, na którym chcesz pracować?");
            Integer TempInt = maxInput(first.activeProjects());
            boolean checkingProject = project.parseSkills(first.getProject(TempInt), first.abilityToProject());
            if ((TempInt != first.activeProjects()) && (checkingProject == true)) {
                Project tempObj = first.getProject(TempInt);
                Integer tempInt = checkProjectStatusSkills(tempObj);
                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                if (tempInt != 0) {
                    first.updateDataProjectList(project.setNewHours(first.getProject(TempInt)), TempInt);
                    return true;
                } else {
                    System.out.println("\nNie możesz pracować na tym projekcie, ponieważ jest skończony");
                }
            }
        }
        return false;
    }

    public boolean handOverTheProject() {
        if ((first.activeProjects() == 0) && (first.finishedProjects() == 0)) {
            System.out.println("Nie masz ani jednego projektu");
        } else if (first.finishedProjects() != 0) {
            if (first.finishedProjects() == 1) {
                System.out.println("Masz tylko jeden projekt do oddania");
                first.updateFinishedProject(project.changeStatus(first.getLastFinishedProject()), first.finishedProjects() - 1);
                return true;
            } else {
                System.out.println("To jest Twój skończony projekt:");
                first.showFinishedProject();
                Integer tempInt = maxInput(first.finishedProjects() - 1);
                first.updateFinishedProject(project.changeStatus(first.getFinishedProject(tempInt)), tempInt);
                return true;
            }
        } else if (first.activeProjects() != 0) {
            System.out.println("Na pewno chcesz oddać projekt klientowi?");
            System.out.println("0. Tak");
            System.out.println("1. Nie");
            if (maxInput(1) == 0) {
                if (first.activeProjects() == 1) {
                    System.out.println("Masz tylko jeden projekt do oddania");
                    first.updateDataProjectList(project.changeStatus(first.getLastObjectFromProject()), first.activeProjects() - 1);
                    first.updateDataProjectList(project.dontMoneyForU(first.getLastObjectFromProject()), first.activeProjects() - 1);
                    return true;
                } else {
                    System.out.println("To jest Twój projekt:");
                    first.showProjectList();
                    Integer tempInt = maxInput(first.activeProjects() - 1);
                    first.updateDataProjectList(project.changeStatus(first.getProject(tempInt)), tempInt);
                    first.updateDataProjectList(project.dontMoneyForU(first.getProject(tempInt)), tempInt);
                    return true;
                }
            }
        }
        return false;
    }

    public void hireAnEmployee() {
        first.hireEmployee();
        switch (maxInput(5)) {
            case 0:
                if (first.hireWorker() == true) endDay();
                break;
            case 1:
                if (first.hireTester() == true) endDay();
                break;
            case 2:
                if (first.hireDealer() == true) endDay();
                break;
            case 3:
                getClassifiedsPont();
                break;
            case 4:
                break;
        }
    }

    public void getClassifiedsPont() {
        if (first.pay(5000.0) == true) {
            first.setClassifieds();
        }
    }


    public void dissmisEmploye() {
        if (first.dissmisEmploye() == true) endDay();
    }

    public void addPoint() {
        first.addPoint();
        EndTour();
    }

    public void EndTour() {
        TimeAdd();
        System.out.println("Jest to tura gry nr: " + tour++);
    }

    public Integer checkProjectStatusSkills(Project object) {
        Integer tempInt = project.checkProjectStatusSkills(object);
        return tempInt;
    }
    public Integer checkProjectStatusTest(Project object) {
        Integer tempInt = project.getRequiredTestDays(object);
        return tempInt;
    }
    public void checkProjectStatus(Integer time, Integer test, Project object) {
        if ((time == 0) && (test == 0)) {
            first.addFinishedProject(object);
            first.showFinishedProject();
            first.removeProject(object);
        }
        Integer tempInt = time + test;
        System.out.println("Ten projekt ma " + tempInt + " dni pracy");
    }

    public void paperTimeDay() {
        this.zus--;
    }

    public boolean testUrApp() {
        if (first.activeProjects() == 0) {
            System.out.println("Nie masz żadnego projektu, podpisz jakiś");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            System.out.println("Masz tylko jeden projekt i właśnie na nim będziesz pracować");
            first.showProjectList();
            Project tempObj = first.getLastObjectFromProject();
            Integer tempInt = checkProjectStatusTest(tempObj);
            checkProjectStatus(checkProjectStatusSkills(tempObj), tempInt, tempObj);
            if (tempInt != 0) {
                first.updateDataProjectList(project.setNewTestingHours(tempObj), first.activeProjects() - 1);
                return true;
            }
        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ". Wyjdź\nTo są Twoje projekt, na którym chcesz pracować?");
            Integer TempInt = maxInput(first.activeProjects());
            if (TempInt != first.activeProjects()) {
                Project tempObj = first.getProject(TempInt);
                Integer tempInt = checkProjectStatusTest(tempObj);
                checkProjectStatus(checkProjectStatusSkills(tempObj), tempInt, tempObj);
                if (tempInt != 0) {
                    first.updateDataProjectList(project.setNewTestingHours(first.getProject(TempInt)), TempInt);
                    return true;
                }
            }
        }
        return false;
    }

    public void endDay() {
        for (int i = 0; i < first.getMyProjectList().size(); i++) {
            if ((project.getDateOfCommissioning(first.getMyProjectList().get(i)).isBefore(time) == true)
                    && (project.status(first.getMyProjectList().get(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getMyProjectList().get(i)));
            }
            if ((project.status(first.getMyProjectList().get(i)) == true) &&
//                    (project.getClientPayDay(first.getMyProjectList().get(i)).isBefore(time) == true) &&
                    (project.getPayed(first.getMyProjectList().get(i)))) {
                if(project.getControlPoint(first.getMyProjectList().get(i))==true){
                    controlPoint++;

                }
                first.setCash(project.getPrice(first.getMyProjectList().get(i)));
                first.updateDataProjectList(project.payed(first.getMyProjectList().get(i)), i);

            }
        }// this loop verify every day my project
        for (int i = 0; i < first.finishedProjects(); i++) {
            if ((project.getDateOfCommissioning(first.getFinishedProject(i)).isBefore(time) == true)
                    && (project.status(first.getFinishedProject(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getFinishedProject(i)));
            }
            if ((project.status(first.getFinishedProject(i)) == true)
//                    && (project.getClientPayDay(first.getFinishedProject(i)).isBefore(time) == true)
                    && (project.getPayed(first.getFinishedProject(i)) == false)) {
                if(project.getControlPoint(first.getFinishedProject(i))==true){
                    controlPoint++;
                }
                first.setCash(project.getPrice(first.getFinishedProject(i)));
                first.updateFinishedProject(project.payed(first.getFinishedProject(i)), i);
            }
        }
        for (int i = 0; i < first.getProjectsGivedToFriendst().size(); i++) {
            if ((project.getDateOfCommissioning(first.getProjectsGivedToFriendst().get(i)).isBefore(time) == true)
                    && (project.status(first.getProjectsGivedToFriendst().get(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getMyProjectList().get(i)));
            }
            if ((project.status(first.getProjectsGivedToFriendst().get(i)) == true) &&
//                    (project.getClientPayDay(first.getProjectsGivedToFriendst().get(i)).isBefore(time) == true) &&
                    (project.getPayed(first.getProjectsGivedToFriendst().get(i)))) {
                if(project.getControlPoint(first.getProjectsGivedToFriendst().get(i))==true){
                    controlPoint++;
                }
                first.setCash(project.getPrice(first.getProjectsGivedToFriendst().get(i)) / 10);
                first.updateDataProjectList(project.payed(first.getProjectsGivedToFriendst().get(i)), i);
            }
        }
        if ((time.getDayOfWeek().equals(DayOfWeek.SATURDAY) == false) && (time.getDayOfWeek().equals(DayOfWeek.SUNDAY) == false)) {
            for (int i = 0; i < first.getNumberOfProgrammers(); i++) {
                if (randomInt(100) < 10) {
                    System.out.println("Któryś programista jest dzisiaj chory");
                } else {
                    {
                        if (first.activeProjects() == 0) {
                            System.out.println("Pracownik nie ma żadnego projektu, podpisz jakiś");

                        } else if (first.activeProjects() == 1) {
                            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), first.getProgrammerSkills(i));

                            if (checkingProject == true) {
                                System.out.println("Teraz Twój programista pracuje ");
                                System.out.println("Masz wystarczająco umiejętności do tego projektu");
                                System.out.println("Masz tylko jeden projekt i na nim będziesz pracował");
                                first.showProjectList();
                                Project tempObj = first.getLastObjectFromProject();
                                Integer tempInt = checkProjectStatusSkills(tempObj);
                                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                                if (tempInt != 0) {
                                    first.updateDataProjectList(project.setNewHours(tempObj), first.activeProjects() - 1);

                                } else {
                                    System.out.println("\nTen projekt jest już skończony");
                                }
                            } else {
                                System.out.println("Pracownik nie ma wystarczających umiejętności, żeby to zrobić");
                            }

                        } else {
                            first.showProjectList();
                            System.out.println(first.activeProjects() + ". Wyjdź\nTo są Twoje projekty, który chcesz robić?");

                            Integer TempInt = maxInput(first.activeProjects());
                            boolean checkingProject = project.parseSkills(first.getProject(TempInt), first.getProgrammerSkills(i));
                            if ((TempInt != first.activeProjects()) && (checkingProject == true)) {
                                Project tempObj = first.getProject(TempInt);
                                Integer tempInt = checkProjectStatusSkills(tempObj);
                                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                                if (tempInt != 0) {
                                    first.updateDataProjectList(project.setNewHours(first.getProject(TempInt)), TempInt);

                                } else {
                                    System.out.println("\nTen projekt jest już skończony");
                                }

                            }


                        }

                    }

                }//programmers working
            }//programmers working day monday-fiday
            for (int i = 0; i < first.getNumberOfTesters(); i++) {
                testUrApp();
            }
        }
        if (time.getDayOfMonth() == 25) {
            if (zus != 0) {
                for (; ; ) {
                    System.out.println("ZUS cię dojechał");
                }
            }
            zus = 2;
//            first.payForMonth();
        }

        time = time.plusDays(1);
        tour++;
        if(controlPoint>=3)//
        {
            for(;;){
                System.out.println("Wygrałeś grę");
            }
        }
    }
}






