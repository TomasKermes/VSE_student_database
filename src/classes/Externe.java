package classes;

import data.Database;

public class Externe extends Person{

    private String title;
    private int payment;

    public Externe(String id, String name, String lastName, String dateOfBirth, String title,int payment){
        super(id, name, lastName, dateOfBirth);
        this.title = title;
        this.payment = payment;
    }

    public Externe(String name, String lastName, String dateOfBirth, Database db, String title, int payment){
        super(name, lastName, dateOfBirth, db);
        this.title = title;
        this.payment = payment;
    }

    //////////////////////////////////////////////////// Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String[] getAllProperties(){
        return new String[] {super.getId(),super.getName(),super.getLastName(),super.getDateOfBirth(),title, String.valueOf(payment)};
    }

}
