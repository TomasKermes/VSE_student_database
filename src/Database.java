import java.util.HashMap;
import java.util.Map;

public class Database {

    static Map<String, Person> peopleMap;

    public Database(){
        peopleMap = new HashMap<>();
    }

    public void addPerson(Person p){
        peopleMap.put(p.getId(),p);
    }

    public void removePerson(Person p){
        peopleMap.remove(p.getId());
    }
}
