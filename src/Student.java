public abstract class Student extends Person{

    enum DegreeType{
        BACHELOR,
        MASTER,
        PHD
    }

    private DegreeType degreeType;

    public Student(String name, String lastName, String dateofBirth, Database db, int id, char deg) {
        super(name, lastName, dateofBirth, db);
        setDegreeType(deg);
    }

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


}
