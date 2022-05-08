import java.util.HashMap;
import java.util.Locale;

public abstract class Person {
    private String id;
    private String name;
    private String lastName;
    private String dateofBirth; //Format should be DDMMYYYY

    public Person(String name, String lastName, String dateofBirth, Database database) {
        if (!dateofBirth.matches("(\\d){8}")){
            throw new IllegalArgumentException("bad dateofBirth format");
        }
        this.name = name;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;

        String[] lastNameChars = this.lastName.split("");
        String[] nameChars = this.name.split("");

        StringBuilder xname = new StringBuilder();

        //First 3 letters of lastname
        for(int i = 0; i < 3;i++){
            xname.append(lastNameChars[i].toLowerCase(Locale.ROOT));
        }
        //First letter of fistName
        xname.append(nameChars[0].toLowerCase(Locale.ROOT));

        int suffix = database.getCountOfIndentsWithSamePrefix(xname.toString());

        xname.append(suffix/10>0? suffix : "0" + suffix);

        this.id = xname.toString();

    }

    //////////////////////////////////////////////////// Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
}