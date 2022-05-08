import java.util.HashMap;

public class Person {
    private String name;
    private String lastName;
    private int age;

    private final int id;
    private static int counter;
    static HashMap peopleMap;


    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = counter;
        counter++;
        peopleMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }
}