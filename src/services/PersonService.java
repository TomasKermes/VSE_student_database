package services;

import java.io.File;
import java.io.IOException;

public class PersonService {
    public File file;

    public PersonService(String filepath) throws IOException {

        File newFile = new File(filepath);
        if(newFile.exists()){
            filepath = filepath;
        }
        else {
            throw new IOException("");
        }

    }

    public static void writeDataLineByLine(){

    }

    public void getAllSudents(){

    }

    public void getAllTeachers(){

    }

    public void getAllMasters(){

    }

    public void getAll
}
