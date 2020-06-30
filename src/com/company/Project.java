package com.company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Project extends RandomGenerator{

    String projectName;
    String nameClient;
    AbilityDays[] listAbilityDaystab;
    Double price;
    Double amount_Of_Penalty;
    String complexity;
    LocalDate payDay;
    Integer clientId;
    Integer clientType;
    LocalDate realPayDay;
    boolean isPently;
    Double realPrice;
    Integer requiredTestDays;
    LocalDate dateOfCommissioning;
    LocalDate realDateOfCommissioning;
    boolean isFinished;
    boolean iGotMoney;
    boolean payed;
    Client client = new Client();
    AbilityDays AbilityDays = new AbilityDays();
    boolean playerWorking;
    boolean bigProject;

    public Project(String nProjectName,
                   String nNameClient,
                   Double price,
                   String nComplexity,
                   Integer nClientId,
                   Double nAmount_Of_Penalty,
                   LocalDate nPayDay,
                   AbilityDays[] tab,
                   Integer nClientType,
                   LocalDate nClientPayDay,
                   boolean nIsPently,
                   Double nRealPrice,
                   Integer nRequiredTestDays,
                   LocalDate nDateOfCommissioning,
                   boolean nIsFinished,
                   boolean nIGotMoney,
                   boolean nPayed,
                   LocalDate nRealDateOfCommissioning,
                   boolean nPlayerWorking,
                   boolean nBigProject


    ) {

        this.projectName = nProjectName;
        this.nameClient = nNameClient;
        this.price = price;
        this.amount_Of_Penalty = nAmount_Of_Penalty;
        this.complexity = nComplexity;
        this.payDay = nPayDay;
        this.clientId = nClientId;
        this.listAbilityDaystab = new AbilityDays[6];
        this.listAbilityDaystab = tab;
        this.clientType = nClientType;
        this.realPayDay = nClientPayDay;
        this.isPently = nIsPently;
        this.realPrice = nRealPrice;
        this.requiredTestDays = nRequiredTestDays;
        this.dateOfCommissioning = nDateOfCommissioning;
        this.isFinished = nIsFinished;
        this.iGotMoney = nIGotMoney;
        this.payed = nPayed;
        this.realDateOfCommissioning = nRealDateOfCommissioning;
        this.playerWorking=nPlayerWorking;
        this.bigProject=nBigProject;
    }


    List<Project> listOfProject = new LinkedList<>();
    public Project() {

    }

    public void generateProject(Integer ability, Integer time, LocalDate acctualDay) {
        client.checkClientList();
        AbilityDays.createabilityDaysList(ability, time);
        Integer number = randomInt(33);
        Integer workingDays = AbilityDays.getDaysFromList() - AbilityDays.getDaysFromList() * randomInt(25) / 100;
        LocalDate PayDay = acctualDay.plusDays(workingDays);
        LocalDate RealPayDay = acctualDay.plusDays(getClientPayDay(workingDays, client.getTypeFromList(number)));
        boolean Pently = chance(client.getTypeFromList(number));
        Integer TypeClient = client.getTypeFromList(number);
        String ClientName = client.getNameClientFromList(number);
        String Complexity = setComplexityInList(AbilityDays.copyList());
        Integer RequiredTestDays = workingDays / 3;
        Double Price = AbilityDays.setPriceOnList() + (RequiredTestDays * 450);//+
        Double RealPrice = getRealPrice(Price, TypeClient);
        Double ValueOfPently = RealPrice * randomInt(5) / 100;
        LocalDate DateOfCommissioning = acctualDay.plusDays((workingDays / 5) * 7);
        AbilityDays[] skillsTab = AbilityDays.returSkillAndDays();
        boolean iGotMoneyFromClient = iGotMoney(TypeClient);
        LocalDate RealDateOfCommissioning = getRealDateOfCommissioning(DateOfCommissioning);
        boolean isBig=false;
        if(workingDays>100)isBig=true;

        listOfProject.add(new Project(createProjectName(),
                ClientName,
                Price,
                Complexity,
                number,
                ValueOfPently,
                PayDay,
                skillsTab,
                TypeClient,
                RealPayDay,
                Pently,
                RealPrice,
                RequiredTestDays,
                DateOfCommissioning,
                false,
                iGotMoneyFromClient,
                false,
                RealDateOfCommissioning,
                false,
                isBig));


    }


    public String setComplexityInList(List<AbilityDays> list) {
        String value = "";
        switch (list.size()) {
            case 1:
                value = "łatwe";
                break;
            case 2:
                value = "średnie";
                break;
            case 3:
                value = "trudne";
                break;
            default:
                value = "trudne";
        }
        return value;
    }

    public void numberOfProjects(Integer ability, Integer time, LocalDate acctualDay) {
        generateProject(ability, time, acctualDay);
    }


    public void createProjectList(Integer point, LocalDate acctualDay) {
        Integer number;
        Integer time;
        if (point < 30) {
            time = 20;
            do {
                if (point % 5 == 0) {
                    if (
                            randomInt(2) >= 1) {
                        numberOfProjects(1, time, acctualDay);
                    } else {
                        numberOfProjects(2, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 30 && point < 60) {
            time = 40;
            do {
                if (point % 5 == 0) {
                    number = randomInt(100);
                    if (number < 20) {
                        numberOfProjects(3, time, acctualDay);
                    } else if (number >= 20 && number < 60) {
                        numberOfProjects(2, time, acctualDay);
                    } else {
                        numberOfProjects(1, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 60 && point < 90) {
            time = 50;
            do {
                if (point % 5 == 0) {
                    number = randomInt(100);
                    if (number < 10) {
                        numberOfProjects(4, time, acctualDay);
                    } else if (number >= 10 && number < 30) {
                        numberOfProjects(3, time, acctualDay);
                    } else if (number >= 30 && number < 65) {
                        numberOfProjects(2, time, acctualDay);
                    } else {
                        numberOfProjects(1, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 90 && point < 180) {
            time = 75;
            do {
                if (point % 5 == 0) {
                    number = randomInt(100);
                    if (number < 5) {
                        numberOfProjects(5, time, acctualDay);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(4, time, acctualDay);
                    } else if (number >= 15 && number < 50) {
                        numberOfProjects(3, time, acctualDay);
                    } else if (number >= 50 && number < 80) {
                        numberOfProjects(2, time, acctualDay);
                    } else {
                        numberOfProjects(1, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 180 && point < 360) {
            time = 100;
            do {
                if (point % 5 == 0) {
                    number = randomInt(100);
                    if (number < 20) {
                        numberOfProjects(6, time, acctualDay);
                    } else if (number >= 20 && number < 40) {
                        numberOfProjects(5, time, acctualDay);
                    } else if (number >= 40 && number < 60) {
                        numberOfProjects(4, time, acctualDay);
                    } else if (number >= 60 && number < 80) {
                        numberOfProjects(3, time, acctualDay);
                    } else if (number >= 80 && number < 90) {
                        numberOfProjects(2, time, acctualDay);
                    } else {
                        numberOfProjects(1, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 360 && point < 500) {
            time = 150;
            do {
                if (point % 5 == 0) {
                    number = randomInt(100);
                    if (number < 5) {
                        numberOfProjects(6, time, acctualDay);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(5, time, acctualDay);
                    } else if (number >= 15 && number < 40) {
                        numberOfProjects(4, time, acctualDay);
                    } else if (number >= 40 && number < 65) {
                        numberOfProjects(3, time, acctualDay);
                    } else if (number >= 65 && number < 90) {
                        numberOfProjects(2, time, acctualDay);
                    } else {
                        numberOfProjects(1, time, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);

        } else if (point >= 500) {
            time = 150;
            do {
                if (point % 5 == 0) {
                    numberOfProjects(6, time, acctualDay);
                }
                point = point - 1;
            } while (point > 0);
        }
    }

    public void removeFromList() {
        listOfProject.clear();
    }

    public void showListOfProject() {
        for (Project project : listOfProject) {
            System.out.println(project);

        }
    }

    public Project getAProject(Integer Option) {
        return listOfProject.get(Option);
    }

    public boolean iGotMoney(Integer clienttype) {
        if (clienttype == 3) {
            return false;
        }
        if (randomInt(100) > 50 && clienttype == 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean chance(Integer Type) {

        boolean value = false;

        if (randomInt(100) <= 20 && Type == 1) {
            value = true;
        }
        return value;


    }

    public Integer getClientPayDay(Integer time, Integer Type) {
        Integer value = time;
        if (randomInt(100) <= 30 && (Type == 1 || Type == 3)) {
            value = value + 5;
        }
        return value;
    }


    public Double getRealPrice(Double price, Integer Type) {
        Double temp = price;
        if (randomInt(100) == 1 && Type == 3) {
            temp = 0.0;
        }

        return temp;

    } //checking type 3 client witch payments

    public LocalDate getDateOfCommissioning(Project project) {
        return project.realDateOfCommissioning;
    }

    public boolean status(Project project) {
        return project.isFinished;
    }
    public Project changeStatus(Project project) {
        project.isFinished = true;
        return project;
    }

    public Double getAmount_Of_Penalty(Project project) {
        return project.amount_Of_Penalty;
    }

    public boolean getPayed(Project project) {
        return project.payed;
    }
    public AbilityDays[] fromProjectToAbilityDaystab(Project project) {
        return project.listAbilityDaystab;
    }

    public Project setNewHours(Project project) {
        AbilityDays[] tab = fromProjectToAbilityDaystab(project);
        project.playerWorking=true;
        project.listAbilityDaystab = AbilityDays.workDay(tab);
        return project;
    }

    public Integer getRequiredTestDays(Project project) {
        return project.requiredTestDays;
    }



    public Integer checkProjectStatusSkills(Project project) {
        AbilityDays[] tab = fromProjectToAbilityDaystab(project);
        return AbilityDays.checkStatus(tab);
    }

    public Project setNewTestingHours(Project project) {
        project.playerWorking=true;
        project.requiredTestDays--;
        return project;
    }


    public boolean parseSkills(Project project, String[] Tab) {
        AbilityDays[] tab = fromProjectToAbilityDaystab(project);
        return AbilityDays.parseSkills(tab, Tab);
    }
    public boolean getControlPoint(Project project){
        if((project.playerWorking==false)&&(project.bigProject==true)){
            return true ;
        }
        return false;
    }
    public Project dontMoneyForU(Project project) {
        if (project.iGotMoney == false) {
            project.realDateOfCommissioning.plusYears(1000000000);
            project.payDay.plusYears(1000000000);
            project.realPayDay.plusYears(1000000000);
            project.dateOfCommissioning.plusYears(1000000000);

        }
        return project;
    }


    public Double getPrice(Project project) {
        return project.realPrice;
    }

    public Project payed(Project project) {
        project.payed = true;
        return project;
    }


    public LocalDate getRealDateOfCommissioning(LocalDate time) {
        return time.plusDays(5);
    }

    public Integer getSizeOfList() {
        return listOfProject.size();
    }

    @Override
    public String toString() {
        return "Projekt{" +
                "nazwa='" + projectName + '\'' +
                ", Imię Klienta'" + nameClient + '\'' +
                ", Potrzebne umiejętności i dni do wykonania: " + Arrays.toString(listAbilityDaystab) +
                ", cena=" + price +
                ", Kara za przekroczenie czasu=" + amount_Of_Penalty +
                ", Trudność='" + complexity + '\'' +
                ", Dzień zapłaty=" + payDay +
                ", Wymagane dni do testowania=" + requiredTestDays +
                ", Data uruchomienia=" + dateOfCommissioning+
                ", Duży projekt? " + bigProject+
                ", Czy gracz pracuje ?" + playerWorking;

    }
    }


