package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.Tackle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TacklePersistenceListController {
    private List<Tackle> tackles = new ArrayList<>();
    private String fileName = "TackleFile.txt";

    public TacklePersistenceListController(){
        readTackleFile();
        if (tackles.isEmpty()){
            writeTackleFile();
        }
    }

    public List<Tackle> getTackles() {
        return tackles;
    }
    public void writeTackleFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(tackles);
            out.close();
            System.out.println("successful writing to file");
        } catch (IOException e) {
            System.out.println("Caught exception while writing file" + e.getMessage());
        }
    }

    public void readTackleFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            tackles = (ArrayList) in.readObject();
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Caught exception while reading file" + e.getMessage());
        }
        System.out.println("successful reading file");
    }
}
