package com.company;

        import java.util.LinkedList;
        import java.util.List;

public class AbilityDays extends RandomGenerator {
    String ability;
    Integer time;

    public AbilityDays(String nAbility, Integer nDays) {
        this.ability = nAbility;
        this.time = nDays;
    }

    public AbilityDays() {

    }

    List<AbilityDays> abilityDaysList = new LinkedList<>();

    public void createabilityDaysList(Integer number, Integer time) {
        if (abilityDaysList.size() != 0){
            abilityDaysList.clear();
        }
        for (int i = 0; i < number; i++) {
            if (abilityDaysList.size() == 0) {
                abilityDaysList.add(new AbilityDays(createWorkerAbility(), randomInt(100)));
            } else {
                String value;
                do {
                    value = createWorkerAbility();
                } while (generateUniqueSkills(value) == true);
                abilityDaysList.add(new AbilityDays(value, randomInt(100)));
            }
        }
    }
    public List<AbilityDays> copyList() {
        return abilityDaysList;
    }

    @Override
    public String toString() {
        return "Umiejętność=" + ability + '\'' +
                ", dni=" + time;

    }

    public Double setPriceOnList() {
        Double value = 0.0;

        for (AbilityDays item : abilityDaysList) {

            value += item.time * 500;

        }
        return value;
    }

    public String[] stringTab(List<AbilityDays> tempList) {
        String[] TempTab = new String[tempList.size()];
        int i = 0;
        for (AbilityDays Item : tempList) {
            TempTab[i] = Item.ability;
            i++;
        }
        return TempTab;
    }

    public List<AbilityDays> fromAbilityDaysTabToString(AbilityDays[] tab) {
        List<AbilityDays> TempList = new LinkedList<>();
        for (int i = 0; i < tab.length; i++) {

            TempList.add(tab[i]);
        }
        return TempList;
    }
    public boolean parseSkills(AbilityDays[] tab, String[] Tab) {
        List<AbilityDays> tempList = fromAbilityDaysTabToString(tab);
        String[] first = stringTab(tempList);
        String[] second = Tab;
        Integer value = 0;
        boolean check = false;


        for (int j = 0; j < second.length; j++) {
            for (int i = 0; i < first.length; i++) {
                if (first[i].equals(second[j]) == true) {
                    value++;
                }

            }
        }
        if (value == first.length) {
            check = true;
        }

        return check;
    }


    public Integer getDaysFromList() {
        Integer value = 0;

        for (AbilityDays item : abilityDaysList) {

            value += item.time;

        }
        return value;
    }

    public boolean generateUniqueSkills(String skill) {
        boolean value = false;
        for (AbilityDays items : abilityDaysList) {
            if (items.ability == skill) {
                value = true;
            }
        }
        return value;
    }

    public AbilityDays[] returSkillAndDays() {
        AbilityDays[] TempTab = new AbilityDays[6];
        for (int i = 0; i < abilityDaysList.size(); i++) {
            TempTab[i] = abilityDaysList.get(i);

        }
        return TempTab;
    }

    public List<AbilityDays> getDayFromTab (AbilityDays[] tab){

        List<AbilityDays> TempList = new LinkedList<>();

        return TempList;

    }



    public void clearList() {
        abilityDaysList.clear();
    }

    public void showList(List<AbilityDays> list){
        for(AbilityDays items: list) {
            System.out.println(items.time+items.ability);
        }
    }

    public AbilityDays[] ListToTab(List<AbilityDays> list)    {
        AbilityDays[]tempTab = new AbilityDays[6];
        for (int i=0;i<abilityDaysList.size();i++)
        {

            tempTab[i] = abilityDaysList.get(i);

        }

        return tempTab;
    }

    public void showList(AbilityDays[] tempTab) {
        for(int i=0;i<tempTab.length;i++)
        {
            System.out.println(tempTab[i]);
        }
    }

    public AbilityDays[] returAbilityDays()    {
        AbilityDays[] TempTab= new AbilityDays[6];
        for(int i=0;i<abilityDaysList.size();i++)
        {
            TempTab[i]=abilityDaysList.get(i);

        }
        return TempTab;
    }
}