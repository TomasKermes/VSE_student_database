public class Teacher extends Person{

    private String title;
    private boolean isPartTime;

    public Teacher(String name, String lastName, String dateofBirth, String title, boolean isPartTime) {
        super(name, lastName, dateofBirth);
        this.title = title;
        this.isPartTime = isPartTime;
    }
}
