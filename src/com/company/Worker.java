package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Worker extends Human {
    String  ability[];

    public Worker(String nName, String nSurname, String[] nAbility, Double nCost) {
        this.name = nName;
        this.surname = nSurname;
        this.ability = nAbility;
        this.cost = nCost;
    }

    List<Worker> workerList = new LinkedList<>();

    public Worker() {
    }

    //Tworzenie nowego randomowego programisty
    public void generateWorker() {
        String[] tab = uniqueAbility();
        Double nCost = 10000.0 + (1500 * (tab.length - 1));
        workerList.add(new Worker(createRandomName(9), createRandomSurname(9), tab, nCost));

    }
//Wyświetlanie listy programistów
    public void showWorkerList() {
        Integer i = 0;
        for (Worker item : workerList) {
            System.out.println(i + ". " + item);
            i++;
        }
    }
//Pobieranie numeru indexu programisty
    public Worker getWorker(Integer index) {
        return workerList.get(index);
    }

    @Override
    public String toString() {
        return
                "Imię =" + name +
                        ", Nazwisko =" + surname +
                        ", Umiejętności =" + Arrays.toString(ability) +
                        ", kasa: " + cost;
    }

//usuwanie programisty z listy
    public void removeFromWorkerList(Integer index) {
        workerList.remove(workerList.get(index));
    }

    public void generateWorker(Integer number) {
        for (; workerList.size() != number; ) {
            generateWorker();
        }
    }
}
