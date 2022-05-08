package classes;

import data.Database;

public class Teacher extends Person{

    private String title;
    private boolean isPartTime;

    public Teacher(String id, String name, String lastName, String dateOfBirth,  String title, boolean isPartTime) {
        super(id, name, lastName, dateOfBirth);
        this.title = title;
        this.isPartTime = isPartTime;
    }

    public Teacher(String name, String lastName, String dateOfBirth, Database db, String title, boolean isPartTime) {
        super(name, lastName, dateOfBirth, db);
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
        return new String[] {super.getId(),super.getName(),super.getLastName(),super.getDateOfBirth(),title, String.valueOf(isPartTime)};
    }

}
