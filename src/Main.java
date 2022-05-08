import classes.Person;
import data.Database;

public class Main {
    public static void main(String[] args){
        Database db = new Database();

        Person p = new Person("Pepík", "Vomáčka", "25012001", db);
        db.addPerson(p);
        Person p1 = new Person("Petr", "Vomel", "12031999",db);
        db.addPerson(p1);

        System.out.println(p.getId());
        System.out.println(p1.getId());
    }
}
