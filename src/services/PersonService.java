package services;

import classes.Person;
import com.opencsv.CSVWriter;
import data.Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

}
