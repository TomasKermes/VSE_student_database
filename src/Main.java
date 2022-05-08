import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args){
        Database db = new Database();

        Student p = new Student("Pepík", "Vomáčka", "25012001", db, 'm') {
        };
        db.addPerson(p);
        Student p1 = new Student("Petr", "Vomel", "12031999", db, 'b') {
        };
        db.addPerson(p1);

        System.out.println(p.getId());
        System.out.println(p1.getId());
    }
}
