package classes;

import data.Database;

public abstract class Student extends Person{

    enum DegreeType{
        BACHELOR ,
        MASTER,
        PHD
    }

    private DegreeType degreeType;

    public Student(String id, String name, String lastName, String dateOfBirth, char deg) {
        super(id, name, lastName, dateOfBirth);
        setDegreeType(deg);
    }

    public Student(String name, String lastName, String dateOfBirth, Database db, char deg) {
        super(name, lastName, dateOfBirth, db);
        setDegreeType(deg);
    }

    //////////////////////////////////////////////////// Getters & Setters

    public void setDegreeType(char c){
        switch(c){
            case 'b':
                degreeType = DegreeType.BACHELOR;
                break;
            case 'm':
                degreeType = DegreeType.MASTER;
                break;
            case 'p':
                degreeType = DegreeType.PHD;
                break;
        }
    }

    public DegreeType getDegreeType(){
        return this.degreeType;
    }

    @Override
    public String[] getAllProperties(){
        return new String[] {super.getId(),super.getName(),super.getLastName(),super.getDateOfBirth(),getDegreeType().toString()};
    }
}
