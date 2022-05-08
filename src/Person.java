import java.util.HashMap;

public class Person {
    private String id;
    private String name;
    private String lastName;
    private String dateofBirth; //Format should be DDMMYYYY


    public Person(String name, String lastName, String dateofBirth) {
        if (!dateofBirth.matches("(\\d){8}")){
            throw new IllegalArgumentException("bad dateofBirth format");
        };
        this.name = name;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;


    }

    public String getId() {
        return id;
    }

}