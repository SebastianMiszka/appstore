package com.company;

import java.util.Random;

public class RandomGenerator {

    Random generator = new Random();

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
                createdRandomSurname = "Edwards ";

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
                createdProjectName = "1";
                break;
            case 2:
                createdProjectName = "2";
                break;
            case 3:
                createdProjectName = "3";
                break;
            case 4:
                createdProjectName = "4";
                break;
            case 5:
                createdProjectName = "5";
                break;
            case 6:
                createdProjectName = "6";
                break;
            case 7:
                createdProjectName = "7";
                break;
            case 8:
                createdProjectName = "8";
                break;
            case 9:
                createdProjectName = "9";
                break;
            case 10:
                createdProjectName = "10";
                break;
            default:
                createdProjectName = "11";

        }
        return createdProjectName;
    }

}