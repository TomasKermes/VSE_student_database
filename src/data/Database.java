package data;

import classes.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Database {

    static Map<String, Person> peopleMap;

    public Database(){
        peopleMap = new HashMap<>();
    }

    //////////////////////////////////////////////////// Utils

    public void setPeople(HashMap<String,Person> people){
        peopleMap = people;
    }

    public void addPerson(Person p){
        peopleMap.put(p.getId(),p);
    }

    public void removePerson(Person p){
        peopleMap.remove(p.getId());
    }

    public int getCountOfIndentsWithSamePrefix(String prefix){
        int counter = 0;

        String[] keys = peopleMap.keySet().toArray(new String[0]);

        for (String key : keys) {
            key = key.split("(?<=\\D)(?=\\d)")[0];

            if (key.equals(prefix)) {
                counter++;
            }
        }

        return counter;
    }

    public Person getPerson(String id){
        if(peopleMap.containsKey(id)){
            return peopleMap.get(id);
        }
        return null;
    }

    public int getPeopleCount(){
        return peopleMap.size();
    }

    public HashSet<Person> getAllPeople(){
        return new HashSet<>(peopleMap.values());
    }
}
