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

    public void addToMyProjectsList(Project project) {
        myProjectList.add(project);
    }
    public void addPoint() {
        lookingPoints++;
    }

    public void showProjectList() {
        for (Project item : myProjectList) {
            System.out.println(item);
        }
    }

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

    public Double getCash() {
        return cash;
    }

    public Integer getNumberOfDealers() {
        return myDealerList.size();
    }

    public void showMyWorkerList() {
        for (Worker item : myWorkerList) {
            System.out.println(item);
        }
    }
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
    public void dissmisMenu() {
        System.out.println("\nKogo chcesz zwolnić?");
        System.out.println("0. Programista");
        System.out.println("1. Sprzedawca");
        System.out.println("2. Tester");
        System.out.println("3. Wyjdź");
    }
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

    public Project getLastFinishedProject() {
        return finishedProjects.get(finishedProjects.size() - 1);
    }

    public void addToMyWorkerList(Worker object) {
        myWorkerList.add(object);
    }
    public Worker getLastWorkerObj() {
        return myWorkerList.get(myWorkerList.size() - 1);
    }

    public boolean checkIfUCouldPay(Double cash) {
        if (this.cash >= cash) {
            return true;
        }
        return false;
    }
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
    public boolean payForWorker() {
        Worker tempObj = getLastWorkerObj();
        if (pay(tempObj.cost) == true) {
            return true;
        }
        return false;
    }

    public void removeLastObjFromWorkerList() {
        myWorkerList.remove(myProjectList.size() - 1);
    }

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

    public void RemoveLastObjFromWorkerList() {
        myWorkerList.remove(myProjectList.size() - 1);
    }

    public int sizeWorkerList() {
        return myWorkerList.size();
    }

    public void updateDataProjectList(Project project, int Index) {
        myProjectList.set(Index, project);
    }
    public Integer finishedProjects() {
        return finishedProjects.size();
    }

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

    public Project getProject(Integer number) {
        return myProjectList.get(number);
    }
    public Integer getNumberOfTesters() {
        return myTesterList.size();
    }
//    public Double payForEmployee() {
////        Double worker = payForeEmployer();
//        double dealer = payForeEmployer(myDealerList);
//        double tester = payForeEmployer(myTesterList);
////        Double sum = worker + dealer + tester;
////        return sum;
////    }
//    public void payForMonth() {
//        Double Cash = this.cash;
//        this.cash = Cash - payForEmployee();
//    }

    public void removeProject(Project project) {
        myProjectList.remove(project);
    }
    public void addFinishedProject(Project project) {
        finishedProjects.add(project);
    }

    public void showFinishedProject() {
        for (Project item : finishedProjects) {
            System.out.println(item);
        }
    }

    public void addFriendToMyList(List<Friend> list) {
        for (int i = 0; i < 3; i++) {
            myFriendList.add(list.get(i));
        }
    }

    public void setCash(Double cash) {
        Double Cash = this.cash;
        this.cash = Cash + cash;
    }

    public List<Project> getMyProjectList() {
        return myProjectList;
    }
    public Double payForeEmployer(List<Human> list) {
        Double sum = 0.0;
        for (Human item : list) {
            sum = sum + item.cost + 1000;
        }
        return sum;
    }
    public Integer activeProjects() {
        return myProjectList.size();
    }

    public Integer getPoints() {
        return lookingPoints;
    }

}
