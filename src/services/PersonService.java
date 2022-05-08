package services;

import com.opencsv.CSVWriter;
import data.Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonService {
    public File file;

    public PersonService(String filepath) throws IOException {
        File newFile = new File(filepath);
        if(newFile.exists()){
            this.file = newFile;
        }
        else {
            throw new IOException("File doesn't exist");
        }

    }

    public void writeData(Database db) throws IOException{
        try{
            FileWriter outputFile = new FileWriter(this.file,false);

            CSVWriter writer = new CSVWriter(outputFile);





        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
