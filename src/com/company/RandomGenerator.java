package com.company;

import java.util.Random;
import java.util.Scanner;

public class RandomGenerator {

    Random generator = new Random();

    Scanner scan = new Scanner(System.in);

    public Integer randomInt(Integer number) {

        return generator.nextInt(number);
    }
//Tworzenie imienia
    public String createRandomName(Integer number) {
        String createdRandomName = "";
        switch (randomInt(9)) {
            case 1:
                createdRandomName = "Andrzej";
                break;
            case 2:
                createdRandomName = "Marcin";
                break;
            case 3:
                createdRandomName = "Kacper";
                break;
            case 4:
                createdRandomName = "Anita";
                break;
            case 5:
                createdRandomName = "Marzena";
                break;
            case 6:
                createdRandomName = "Bogdan";
                break;
            case 7:
                createdRandomName = "Alan";
                break;
            case 8:
                createdRandomName = "Urszula";
                break;
            default:
                createdRandomName = "Szymon";

        }
        return createdRandomName;
    }

//Tworzenie nazwiska
    public String createRandomSurname(Integer number) {
        String createdRandomSurname = "";
        switch (randomInt(9)) {
            case 1:
                createdRandomSurname = "Butelka";
                break;
            case 2:
                createdRandomSurname = "Kania";
                break;
            case 3:
                createdRandomSurname = "Bończa";
                break;
            case 4:
                createdRandomSurname = "Ortega";
                break;
            case 5:
                createdRandomSurname = "Jubilat";
                break;
            case 6:
                createdRandomSurname = "Matejko";
                break;
            case 7:
                createdRandomSurname = "Andrzejczak";
                break;
            case 8:
                createdRandomSurname = "Gombrowicz";
                break;

            default:
                createdRandomSurname = "Edwards";

        }
        return createdRandomSurname;
    }

//Tworzenie umiejętności pracownika
    public String createWorkerAbility() {

        String createdAbility = "";
        switch (randomInt(7)) {
            case 1:
                createdAbility = "front-end";
                break;
            case 2:
                createdAbility = "backend";
                break;
            case 3:
                createdAbility = "baza danych";
                break;
            case 4:
                createdAbility = "mobile";
                break;
            case 5:
                createdAbility = "wordpress";
                break;
            case 6:
                createdAbility = "prestashop";
                break;
            default:
                createdAbility = "baza danych";
                break;
        }

        return createdAbility;
    }
//Tworzenie nazw projektów
    public String createProjectName() {
        String createdProjectName = "";
        switch (randomInt(11)) {
            case 1:
                createdProjectName = "Sklep internetowy";
                break;
            case 2:
                createdProjectName = "Gra 3D";
                break;
            case 3:
                createdProjectName = "Kalkulator";
                break;
            case 4:
                createdProjectName = "Obsługa maszyn";
                break;
            case 5:
                createdProjectName = "Photoshop";
                break;
            case 6:
                createdProjectName = "OBS";
                break;
            case 7:
                createdProjectName = "Winamp";
                break;
            case 8:
                createdProjectName = "Windows 2.0";
                break;
            case 9:
                createdProjectName = "Aplikacja Bankowa";
                break;
            case 10:
                createdProjectName = "Tinder";
                break;
            default:
                createdProjectName = "Facebook";

        }
        return createdProjectName;
    }

    public Integer generateType() {

        Integer createdType  = 0;

//Tworzenie typu wyluzowany, wymagający, skrwl
        Integer randomNumber = randomInt(99);
        if (randomNumber <= 33 && randomNumber >= 1) {
            createdType  = 1;
        }
        if (randomNumber <= 66 && randomNumber >= 34) {
            createdType  = 2;
        }
        if (randomNumber <= 99 && randomNumber >= 67) {
            createdType = 3;
        }
        return createdType;
    }
//unikalne umiejętności poszczególnych pracowników
    public String[] uniqueAbility() {

        Integer no = randomInt(3) + 3;
        String ability;
        String[] tab = new String[no];


        for (int i = 0; i < no; i++) {
            if (i == 0) {
                tab[i] = createWorkerAbility();
            } else {
                do {
                    ability = createWorkerAbility();
                } while (ability(tab, ability) == true);
                tab[i] = ability;

            }

        }

        return tab;

    }

    public boolean ability(String[] tab, String ability) {
        boolean value = false;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == ability) {
                value = true;

            }
        }
        return value;
    }
//Ogranicznik wprowadzania liczby nie większej niż podana
    public Integer maxInput(int max) {
        Integer number;
        do {
            System.out.println("Wybierz co chcesz zrobić, z przedziału od 0 do " + max);
            number = scan.nextInt();
        } while (number < 0 || number > max);
        return number;
    }


}