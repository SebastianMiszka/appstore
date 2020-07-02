package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Friend extends  Worker {
    Integer type;

    public Friend(String nName, String nSurname, String[] nAbility, Integer nType) {
        this.name = nName;
        this.surname = nSurname;
        this.ability = nAbility;
        this.type = nType;
    }

    List<Friend> friendList = new LinkedList<>();

    public Friend() {

    }
//Tworzenie nowego przyjaciela
    public void generateFriend() {
        for (int i = 0; i < 3; i++) {

            friendList.add(new Friend(createRandomName(9), createRandomSurname(9), uniqueAbility(), i));
        }
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    @Override
    public String toString() {
        return "\nImię='" + name + '\'' +
                "\nNazwisko='" + surname + '\'' +
                "\n Umiejętności=" + Arrays.toString(ability) +
                "\nTyp=" + type + "\nWybierz według typu, typ 0 jest najdroższy, 1 najgorszy, ale nie tak drogi jak 0, 2 najgorszy, ale także najtańszy";
    }


}