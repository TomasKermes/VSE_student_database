public class Teacher extends Person{

    private String title;
    private boolean isPartTime;

    public Teacher(String name, String lastName, String dateofBirth, Database db,String title, boolean isPartTime) {
        super(name, lastName, dateofBirth, db);
        this.title = title;
        this.isPartTime = isPartTime;
    }
}
