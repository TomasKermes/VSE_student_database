public class Externe extends Person{

    private String title;
    private int payment;

    public Externe(String name, String lastName, int age, String title){
        super(name, lastName, age);
        this.title = title;
    }
}
