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

       /* Teacher t = new Teacher("Karel", "Vašut", "30061970",db, "ing", false);
        db.addPerson(t);

        Student s = new Student("Jan","Kovář", "02042000",db,'b');
        db.addPerson(s);

        PersonService.writeData(db);*/

        System.out.println(db.getPerson("kovj00").getId());

    }
}
