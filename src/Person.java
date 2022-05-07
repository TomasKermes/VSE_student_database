import java.util.HashMap;

public abstract class Person {
    private String name;
    private String lastName;
    private int age;

    private final int id;
    private static int counter;
    static HashMap peopleMap;

    public Person(String name, String lastName, int age, Faculty f) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = counter;
        counter++;
        f.addPerson(this);
        peopleMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }
}