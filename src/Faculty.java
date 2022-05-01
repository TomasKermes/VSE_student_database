import java.util.ArrayList;

public class Faculty {

    private String name;
    private ArrayList<Person> people;

    public void addPerson(Person p) {
        this.people.add(p);
    }

    //looks through arraylist for people with matching id, removes them
    public void removePerson(int id){
        for(Person p: people){
            if(p.getId() == id){
                people.remove(p);
                break;
            }
        }
    }

    public void transferPerson(int id, Faculty transferF){
        for(Person p: people){
            if(p.getId() == id){
                transferF.addPerson(p);
                people.remove(p);
                break;
            }
        }
    }
}
