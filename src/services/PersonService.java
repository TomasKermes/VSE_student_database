package services;

import classes.Person;
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
                if(nextRecord.length == 6 && (nextRecord[5].equals("true") || nextRecord[5].equals("false"))){
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
                }
                else if(nextRecord.length == 6 && ){

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return people;
    }

}
