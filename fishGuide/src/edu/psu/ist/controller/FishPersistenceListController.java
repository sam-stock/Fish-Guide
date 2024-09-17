package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FishPersistenceListController {
    private List<Fish> fishs = new ArrayList<>();
    private String fileName = "FishFile.txt";

    public FishPersistenceListController(){
        readFishFile();
        if (fishs.isEmpty()){
            createInitialElements();
            writeFishFile();
        }
    }

    public List<Fish> getFishs() {
        return fishs;
    }
    public void writeFishFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(fishs);
            out.close();
            System.out.println("successful writing to file");
        } catch (IOException e) {
            System.out.println("Caught exception while writing file" + e.getMessage());
        }
    }

    public void readFishFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            fishs = (ArrayList) in.readObject();
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Caught exception while reading file" + e.getMessage());
        }
        System.out.println("successful reading file");
    }

    public void createInitialElements(){
        Fish fish1 = new Fish("Tuna", "Blue", Type.OPEN_WATER);
        Fish fish2 = new Fish("Salmon", "Silver", Type.DEEP_WATER);
        Fish fish3 = new Fish("Halibut", "Brown", Type.BOTTOM_FEEDER);
        fishs.add(fish1);
        fishs.add(fish2);
        fishs.add(fish3);
    }
}
