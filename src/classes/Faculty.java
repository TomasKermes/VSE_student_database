package classes;

import java.util.ArrayList;

public class Faculty {

    private String name;
    private ArrayList<Person> people;

    public void addPerson(Person p) {
        this.people.add(p);
    }

    //looks through arraylist for people with matching id, removes them
    public void removePerson(String id){
        for(Person p: people){
            if(p.getId().equals(id)){
                people.remove(p);
                break;
            }
        }
    }

    public void transferPerson(String id, Faculty transferF){
        for(Person p: people){
            if(p.getId().equals(id)){
                transferF.addPerson(p);
                people.remove(p);
                break;
            }
        }
    }
}
