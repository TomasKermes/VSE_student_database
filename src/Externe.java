public class Externe extends Person{

    private String title;
    private int payment;

    public Externe(String name, String lastName, String dateofBirth, String title){
        super(name, lastName, dateofBirth);
        this.title = title;
    }
}
