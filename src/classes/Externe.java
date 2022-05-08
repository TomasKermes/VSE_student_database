package classes;

import data.Database;

public class Externe extends Person{

    private String title;
    private int payment;

    public Externe(String name, String lastName, String dateofBirth, Database db, String title){
        super(name, lastName, dateofBirth, db);
        this.title = title;
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
