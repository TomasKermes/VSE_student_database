package services;

import classes.Externist;
import classes.Person;
import classes.Student;
import classes.Teacher;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import data.Database;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PersonService {
    public File file;

    public PersonService() throws IOException {
        File newFile = new File("src/data/users.csv");
        if(newFile.exists()){
            this.file = newFile;
        }
        else {
            throw new IOException("File doesn't exist");
        }

    }

    public void writeData(Database db) throws IOException{
        if(db == null){
            throw new NullPointerException("e");
        }
        try{
            FileWriter outputFile = new FileWriter(this.file,false);

            CSVWriter writer = new CSVWriter(outputFile);

            List<String[]> data = new ArrayList<String[]>();

            HashSet<Person> people = db.getAllPeople();

            for (Person p : people){
                String[] s = p.getAllProperties();
                data.add(s);
            }

            writer.writeAll(data);

            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String,Person> readData(Database db) throws IOException {
        HashMap<String,Person> people = new HashMap<>();
        try {
            FileReader fileReader = new FileReader("src/data/users.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext())!=null)
            {
                if(nextRecord.length == 5 && (nextRecord[4].equals("BACHELOR")||nextRecord[4].equals("MASTER") || nextRecord[4].equals("PHD"))){
                    Student s = new Student("0","0","0","00000000",'b');
                    for (int i = 0; i<nextRecord.length;i++){
                        switch (i){
                            case 0:
                                s.setId(nextRecord[i]);
                                break;
                            case 1:
                                s.setName(nextRecord[i]);
                                break;
                            case 2:
                                s.setLastName(nextRecord[i]);
                                break;
                            case 3:
                                s.setDateOfBirth(nextRecord[i]);
                                break;
                            case 4:
                                char myChar = 'a';
                                switch (nextRecord[i]) {
                                    case "BACHELOR":
                                        myChar = 'b';
                                        break;
                                    case "MASTER":
                                        myChar = 'm';
                                        break;
                                    case "PHD":
                                        myChar = 'p';
                                        break;
                                }
                                s.setDegreeType(myChar);
                                break;
                        }
                    }
                    people.put(s.getId(),s);
                }
                else if(nextRecord.length == 6 && (nextRecord[5].equals("true") || nextRecord[5].equals("false"))){
                    Teacher t =  new Teacher("0","0","0","00000000",null, false);
                    for (int i = 0; i<nextRecord.length;i++){
                        switch (i){
                            case 0:
                                t.setId(nextRecord[i]);
                                break;
                            case 1:
                                t.setName(nextRecord[i]);
                                break;
                            case 2:
                                t.setLastName(nextRecord[i]);
                                break;
                            case 3:
                                t.setDateOfBirth(nextRecord[i]);
                                break;
                            case 4:
                                t.setTitle(nextRecord[i]);
                                break;
                            case 5:
                                t.setPartTime(Boolean.parseBoolean(nextRecord[i]));
                                break;
                        }
                    }
                    people.put(t.getId(),t);
                }
                else if (nextRecord.length == 6 && isInteger(nextRecord[5])){
                    Externist externist = new Externist("0","0","0","00000000","title",10000000);
                    for (int i = 0; i<nextRecord.length;i++){
                        switch (i){
                            case 0:
                                externist.setId(nextRecord[i]);
                                break;
                            case 1:
                                externist.setName(nextRecord[i]);
                                break;
                            case 2:
                                externist.setLastName(nextRecord[i]);
                                break;
                            case 3:
                                externist.setDateOfBirth(nextRecord[i]);
                                break;
                            case 4:
                                externist.setTitle(nextRecord[i]);
                                break;
                            case 5:
                                externist.setPayment(Integer.parseInt(nextRecord[i]));
                                break;
                        }
                    }
                    people.put(externist.getId(),externist);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return people;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
