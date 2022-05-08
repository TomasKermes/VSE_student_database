import java.util.HashMap;

public class Person {
    private String name;
    private String lastName;
    private String dateofBirth; //Format should be DDMMYYYY

    private final int id;
    private static int counter;
    static HashMap peopleMap;


    public Person(String name, String lastName, String dateofBirth) {
        if (dateofBirth.matches("(\\d){8}") == false){
            throw new IllegalArgumentException("bad dateofBirth format");
        };
        this.name = name;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.id = counter;
        counter++;
        peopleMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }

}