package classes;

import data.Database;

public class Teacher extends Person{

    private String title;
    private boolean isPartTime;

    public Teacher(String name, String lastName, String dateofBirth, Database db, String title, boolean isPartTime) {
        super(name, lastName, dateofBirth, db);
        this.title = title;
        this.isPartTime = isPartTime;
    }

    //////////////////////////////////////////////////// Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }

    @Override
    public String[] getAllProperties(){
        return new String[] {super.getId(),super.getName(),super.getLastName(),super.getDateofBirth(),title, String.valueOf(isPartTime)};
    }

}
