public abstract class Student extends Person{

    private DegreeType degreeType;

    public Student(String name, String lastName, int age, int id, char deg) {
        super(name, lastName, age);
        setDegreeType(deg);
    }

    enum DegreeType{
        BACHELOR,
        MASTER,
        PHD
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
