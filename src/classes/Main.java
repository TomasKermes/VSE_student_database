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
        db.setPeople(PersonService.readData(db));

        Faculty f1 = new Faculty();
        f1.addPerson(db.getPerson("kovj00"));
        Faculty f2 = new Faculty();
        Faculty f3 = new Faculty();


        Teacher t = new Teacher("Lukáš", "Buňát", "30061990",db, "ing", false);
        db.addPerson(t);

        Student s = new Student("Tomáš","Janek", "03052001",db,'b');
        db.addPerson(s);

        PersonService.writeData(db);


        System.out.println(db.getPerson("kovj00").getId());

    }
}
