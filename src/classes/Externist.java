package classes;

import data.Database;

public class Externist extends Person{

    private String title;
    private double payment;

    public Externist(String id, String name, String lastName, String dateOfBirth, String title, double payment){
        super(id, name, lastName, dateOfBirth);
        this.title = title;
        this.payment = payment;
    }

    public Externist(String name, String lastName, String dateOfBirth, Database db, String title, double payment){
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

    public double getPayment() {
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
