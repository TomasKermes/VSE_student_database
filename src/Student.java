public abstract class Student extends Person{

    enum DegreeType{
        BACHELOR,
        MASTER,
        PHD
    }

    private DegreeType degreeType;

    public Student(String name, String lastName, String dateofBirth, int id, char deg) {
        super(name, lastName, dateofBirth);
        setDegreeType(deg);
    }

    public void setDegreeType(char c){
        switch (c) {
            case 'b' -> degreeType = DegreeType.BACHELOR;
            case 'm' -> degreeType = DegreeType.MASTER;
            case 'p' -> degreeType = DegreeType.PHD;
        }
    }


}
