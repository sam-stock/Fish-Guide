package edu.psu.ist.test;

import edu.psu.ist.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestHarness {
    public void TestHarness() {
        //testFish();
        //testClassHierarchy();'
        testInterface();
    }

    public void testFish(){
        //Constructors
        Fish newFish = new Fish();
        System.out.println(newFish);

        Fish tuna = new Fish("Tuna", "Blue", Type.OPEN_WATER);
        System.out.println(tuna);
        //Setters
        tuna.setName("tuna");
        tuna.setColor("Yellow");
        tuna.setType(Type.SCHOOL_FISH);
        System.out.println(tuna);
        //Getters
        tuna.getName();
        tuna.getColor();
        tuna.getType();
    }

    public void testLocation(){
        //Constructors
        Location newLocation = new Location();
        System.out.println(newLocation);

        Location sanDiego = new Location("CA", "San Diego");
        System.out.println(sanDiego);
        //Setters
        sanDiego.setState("California");
        sanDiego.setCity("San Diego");
        System.out.println(sanDiego);
        //Getters
        sanDiego.getState();
        sanDiego.getCity();
    }

    public void testClassHierarchy(){
        Fish newFish = new Fish("Sea Bass", "green", Type.REEF_RESIDER);
        Fish catchableFish = new Uncatchable("Garibaldi", "orange", Type.REEF_RESIDER, false);
        Fish edibleFish = new Edible("Sea Bass", "green", Type.REEF_RESIDER, true);

        ArrayList<Fish> fishList = new ArrayList<>();
        fishList.add(newFish);
        fishList.add(catchableFish);
        fishList.add(edibleFish);

        for (Fish fish: fishList){
            fish.makeFish(fish);
            System.out.println(fish.getFishDetails());
        }
    }

    public void testInterface(){
        System.out.println("In the test method");
        List<Trackable> trackables = new ArrayList<>();

        Technique jigging = new Technique("Jigging", "Line manipulation",
                "Used to attract bottom feeders that look up for their food");
        trackables.add(jigging);

        Tackle flasher = new Tackle("Flasher", "Line attatchment",
                "Used to catch salmon eyes with bright colors");
        trackables.add(flasher);

        for(Trackable trackable: trackables){
            System.out.println(trackable);
            trackable.trackSetup();
            trackable.track();
            System.out.println("-----------------------------");
        }
    }
}



