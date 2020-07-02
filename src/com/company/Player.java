package com.company;

import java.util.LinkedList;
import java.util.List;

public class Player extends Worker {
    Double cash = 20000.0;
    Integer lookingPoints = 15;
    Integer classifieds = 3;

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
    List<Project> finishedProjects = new LinkedList<>();
    List<Project> projectsGivedToFriends = new LinkedList<>();
    List<Project> myProjectList = new LinkedList<>();
    List<Human> myDealerList = new LinkedList<>();
    List<Worker> myWorkerList = new LinkedList<>();
    List<Human> myTesterList = new LinkedList<>();
    List<Friend> myFriendList = new LinkedList<>();

    //Dodanie nowego projektu do listy projektów
    public void addToMyProjectsList(Project project) {
        myProjectList.add(project);
    }

    //Dodawanie punktów postępu w grze
    public void addPoint() {
        lookingPoints++;
    }

    //Wyświetlanie listy projektów
    public void showProjectList() {
        for (Project item : myProjectList) {
            System.out.println(item);
        }
    }

    //Menu wyboru zatrudniania pracowników
    public void hireEmployee() {
        System.out.println("Masz: " + getClassifieds() + " Żeby mieć więcej musisz zapłacić 5000$");
        System.out.println("Masz teraz: " + getCash() + " $");
        System.out.println("Testerzy: " + getNumberOfTesters());
        System.out.println("Programiści: " + getNumberOfProgrammers());
        System.out.println("Sprzedawcy: " + getNumberOfDealers());
        System.out.println("Kogo chcesz zatrudnić? Albo może chcesz zobaczyć więcej opcji?");
        System.out.println("0. Programista");
        System.out.println("1. Tester 3000.0");
        System.out.println("2. Sprzedawca 3500.0");
        System.out.println("3. Więcej opcji 5000$");
        System.out.println("4. Wyjście");
    }
    public Integer getClassifieds() {
        return classifieds;
    }
//pobieranie ilości kasy
    public Double getCash() {
        return cash;
    }
//Pobieranie ilości sprzedawców z listy
    public Integer getNumberOfDealers() {
        return myDealerList.size();
    }
//Wyświetlanie listy pracowników
    public void showMyWorkerList() {
        for (Worker item : myWorkerList) {
            System.out.println(item);
        }
    }

    //zatrudnianie Testera
    public boolean hireTester() {
        myTesterList.add(generateTester());
        Human tempObj = myTesterList.get(myTesterList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("Masz teraz " + myTesterList.size() + " Testerów");
            return true;
        } else {
            myTesterList.remove(tempObj);
        }
        return false;
    }
    //zatrudnianie sprzedawcy
    public boolean hireDealer() {
        myDealerList.add(generateDealer());
        Human tempObj = myDealerList.get(myDealerList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("Masz teraz " + myDealerList.size() + " Sprzedawców");
            return true;
        } else {
            myDealerList.remove(tempObj);
        }
        return false;
    }

    public void setClassifieds() {
        this.classifieds++;
    }

    //Sprawdzanie ilości pracowników
    public void numberOfEmployee() {
        System.out.println("Masz teraz " + getNumberOfDealers() + " Sprzedawców");
        System.out.println("Masz teraz " + getNumberOfProgrammers() + " Programistów");
        if (getNumberOfDealers() == 0 && (getNumberOfProgrammers() == 0) && (getNumberOfTesters() == 0)) {
            System.out.println("Nie masz żadnego pracownika");
        } else {
            if (getNumberOfProgrammers() == 0) {
                System.out.println("Nie masz żadnego programisty ");
            }
            if (getNumberOfTesters() == 0) {
                System.out.println("Nie masz żadnego testera");
            }
            if (getNumberOfDealers() == 0) {
                System.out.println("Nie masz żadnego sprzedawcy");
            }
        }
    }
    //zwalnianie testera
    public boolean dissmisTester() {
        if (getNumberOfTesters() != 0) {
            if (pay(1500.0) == true) {
                myTesterList.remove(0);
                System.out.println("Tester zwolniony!");
                return true;
            } else {
                System.out.println("Nie możesz zwolnić testera");
            }
        } else {
            System.out.println("Nie możesz zwonić kogoś kogo nie zatrudniłeś");
        }
        return false;
    }
    //zwalnianie sprzedawcy
    public boolean dissmisDealer() {
        if (getNumberOfDealers() != 0) {
            if (pay(2000.0) == true) {
                myDealerList.remove(0);
                System.out.println("Sprzedawca zwolniony !");
                return true;
            } else {
                System.out.println("Nie możesz zwonić sprzedawcy ");
            }
        } else {
            System.out.println("Nie możesz zwonić kogoś kogo nie zatrudniłeś");
        }
        return false;
    }
    //zwalnianie programisty
    public boolean dissmisWorker() {
        if (getNumberOfProgrammers() != 0) {
            System.out.println("Lista zwolnionych ");
            showWorkerList();
            System.out.println(getNumberOfProgrammers() + ". Wyjście\nKogo chcesz zwolnić?");
            Integer tempOption = maxInput(getNumberOfProgrammers());
            if (tempOption != getNumberOfProgrammers()) {
                if (pay(myWorkerList.get(tempOption).cost / 2) == true) {
                    myWorkerList.remove(tempOption);
                    System.out.println("Programista zwolniony !");
                    return true;
                } else {
                    System.out.println("Nie możesz zwolnić programisty");
                }
            }
        } else {
            System.out.println("Nie możesz zwonić kogoś kogo nie zatrudniłeś");
        }
        return false;
    }
    //Menu zwalniania pracowników
    public void dissmisMenu() {
        System.out.println("\nKogo chcesz zwolnić?");
        System.out.println("0. Programista");
        System.out.println("1. Sprzedawca");
        System.out.println("2. Tester");
        System.out.println("3. Wyjdź");
    }

    //Po wybraniu kogo chce się zwonić, sprawdza czy zwolnienie doszło do skutku
    public boolean dissmisEmploye() {
        numberOfEmployee();
        dissmisMenu();
        switch (maxInput(4)) {
            case 0:
                if (dissmisWorker() == true) return true;
                break;
            case 1:
                if (dissmisDealer() == true) return true;
                break;
            case 2:
                if (dissmisTester() == true) return true;
                break;
            case 3:
                return false;
        }
        return false;
    }
//Pobieranie ostatniego zakończonego projektu
    public Project getLastFinishedProject() {
        return finishedProjects.get(finishedProjects.size() - 1);
    }
//Dodawanie do listy programistów
    public void addToMyWorkerList(Worker object) {
        myWorkerList.add(object);
    }
    //pobieranie ostatniego programisty
    public Worker getLastWorkerObj() {
        return myWorkerList.get(myWorkerList.size() - 1);
    }
//Sprawdzanie czy ma się wystarczająco dużo pieniędzy na opłatę
    public boolean checkIfUCouldPay(Double cash) {
        if (this.cash >= cash) {
            return true;
        }
        return false;
    }

    //Funkcja płacenia
    public boolean pay(Double cash) {
        if (checkIfUCouldPay(cash) == true) {
            Double money = this.cash;
            this.cash = money - cash;
            System.out.println("Udana transakcja, masz:  " + this.cash);
            return true;
        } else {
            System.out.println("Masz tylko: " + this.cash + " Żeby to zapłacić musisz mieć: " + cash);
        }
        return false;
    }

    //Płacenie pracownikowi
    public boolean payForWorker() {
        Worker tempObj = getLastWorkerObj();
        if (pay(tempObj.cost) == true) {
            return true;
        }
        return false;
    }

    //Usuwanie ostatniego pracownika z listy pracowników
    public void removeLastObjFromWorkerList() {
        myWorkerList.remove(myProjectList.size() - 1);
    }
//Zatrudnianie programisty
    public boolean hireWorker() {
        generateWorker(getClassifieds());
        showWorkerList();
        System.out.println(getClassifieds() + ". Wyjdź\nTutaj jest lista Twoich programistów: " + "\nAktualnie zatrudnieni programiści: " + sizeWorkerList());
        showMyWorkerList();
        System.out.println("Wybierz od 0");
        int answer = maxInput(getClassifieds());
        if (answer != getClassifieds()) {
            addToMyWorkerList(getWorker(answer));
            if (payForWorker() == true) {
                System.out.println("Programista zatrudniony");
                removeFromWorkerList(answer);
                return true;
            } else {
                System.out.println("Nie masz wystarczająco dużo kaski");
                removeLastObjFromWorkerList();
            }
        }
        return false;
    }
//Pobieranie wielkości listy pracowników
    public int sizeWorkerList() {
        return myWorkerList.size();
    }

    public void updateDataProjectList(Project project, int Index) {
        myProjectList.set(Index, project);
    }
    //Pobieranie wielkości listy projektów
    public Integer finishedProjects() {
        return finishedProjects.size();
    }
//Pobieranie indexu skończonego projektu
    public Project getFinishedProject(Integer index) {
        return finishedProjects.get(index);
    }

    public void updateFinishedProject(Project project, Integer index) {
        finishedProjects.set(index, project);
    }

    public String[] abilityToProject() {
        return ability;
    }

    public List<Project> getProjectsGivedToFriendst() {
        return projectsGivedToFriends;
    }

    public Integer getNumberOfProgrammers() {
        return myWorkerList.size();
    }
    public Project getLastObjectFromProject() {
        return myProjectList.get(myProjectList.size() - 1);
    }
    public String[] getProgrammerSkills(Integer index) {
        return myWorkerList.get(index).ability;
    }
    public Project getProject(Integer number) { return myProjectList.get(number);
    }
    public Integer getNumberOfTesters() {
        return myTesterList.size();
    }
    //zapłata wszystkim pracownikom
    public Double payForEmployee() {
        Double worker = payForeEmployer();
        double dealer = payForeEmployer(myDealerList);
        double tester = payForeEmployer(myTesterList);
        Double sum = worker + dealer + tester;
        return sum;
    }
    //Płatność pracownikowi
    public Double payForeEmployer() {
        Double sum = 0.0;
        for (Worker item : myWorkerList) {
            sum = sum + item.cost + 2000;
        }
        return sum;
    }
    public void payForMonth() {
        Double Cash = this.cash;
        this.cash = Cash - payForEmployee();
    }
//usuwanie projektu z listy
    public void removeProject(Project project) {
        myProjectList.remove(project);
    }
    //dodanie projektu do listy jako skończony
    public void addFinishedProject(Project project) {
        finishedProjects.add(project);
    }
//Wyświetlanie skończonych projektów
    public void showFinishedProject() {
        for (Project item : finishedProjects) {
            System.out.println(item);
        }
    }
//Dodanie przyjaciela do listy przyjaciół
    public void addFriendToMyList(List<Friend> list) {
        for (int i = 0; i < 3; i++) {
            myFriendList.add(list.get(i));
        }
    }
//Dodawanie pieniędzy
    public void setCash(Double cash) {
        Double Cash = this.cash;
        this.cash = Cash + cash;
    }

    public List<Project> getMyProjectList() {
        return myProjectList;
    }
    //Płatność pracownikowi
    public Double payForeEmployer(List<Human> list) {
        Double sum = 0.0;
        for (Human item : list) {
            sum = sum + item.cost + 1000;
        }
        return sum;
    }
    //Wyświetlanie iości aktywnych projektów
    public Integer activeProjects() {
        return myProjectList.size();
    }
//dodanie punktów postępu
    public Integer getPoints() {
        return lookingPoints;
    }

}
