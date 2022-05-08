package classes;

import data.Database;

import java.util.Locale;

/**
 * Abstraktí třída person
 *
 * parent třídou pro Student, Teacher a Externist
 * */
public abstract class Person {
    private String id;
    private String name;
    private String lastName;
    private String dateofBirth; //Format should be DDMMYYYY

    /**
     * Konstruktor třídy
     *
     * slouží pro načítání a vytváření objektů z csv souboru
     * */
    public Person(String id, String name, String lastName, String dateofBirth){
        this.id = id;
        if (!dateofBirth.matches("(\\d){8}")){
            throw new IllegalArgumentException("bad dateofBirth format");
        }
        this.name = name;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
    }

    /**
     * Konstruktor třídy
     *
     * slouží pro vytvoření nového záznamu v db
     * */
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

    /**
     * getter unikátního klíče
     * */
    public String getId() {
        return id;
    }

    /**
     * setter unikátního klíče
     *
     * @param id
     * */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter jména
     * */
    public String getName() {
        return name;
    }

    /**
     * setter jména
     *
     * @param name
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter příjmení
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter příjmení
     *
     * @param lastName
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter datumu narození
     * */
    public String getDateOfBirth() {
        return dateofBirth;
    }

    /**
     * setter datumu narození
     *
     * @param dateOfBirth
     * */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateofBirth = dateOfBirth;
    }

    public String[] getAllProperties(){
        return new String[] {id,name,lastName,dateofBirth};
    }

}