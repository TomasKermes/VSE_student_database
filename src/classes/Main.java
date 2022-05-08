package classes;

import data.Database;
import services.PersonService;

import java.io.IOException;

public class Main {
    private static PersonService PersonService;

    static {
        try {
            PersonService = new PersonService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Database db = new Database();

        Person p = new Person("Pepík", "Vomáčka", "25012001", db);
        db.addPerson(p);
        Person p1 = new Person("Petr", "Vomel", "12031999",db);
        db.addPerson(p1);
        Teacher t = new Teacher("Karel", "Vašut", "30061970",db, "ing", false);
        db.addPerson(t);


        PersonService.writeData(db);



        System.out.println(db.convertWithIteration());
        System.out.println(db.getPerson("vašk00"));



    }
}
