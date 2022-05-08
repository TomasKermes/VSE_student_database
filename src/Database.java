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
}
