public class Externe extends Person{

    private String title;
    private int payment;

    public Externe(String name, String lastName, String dateofBirth, Database db, String title){
        super(name, lastName, dateofBirth, db);
        this.title = title;
    }
}
