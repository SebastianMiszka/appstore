package com.company;

import java.util.LinkedList;
import java.util.List;

public class Player extends Worker {
    Double cash = 20000.0;
    Integer lookingPoints = 15;

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

    List<Project> myProjectList = new LinkedList<>();
    List<Friend> myFriendList = new LinkedList<>();

    public void addToMyProjectsList(Project project) {
        myProjectList.add(project);
    }

    public void showProjectList() {
        for (Project item : myProjectList) {
            System.out.println(item);
        }
    }

    public Integer activeProjects() {
        return myProjectList.size();
    }

    public Integer getPoints() {
        return lookingPoints;
    }

}
