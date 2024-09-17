package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.Tip;
import edu.psu.ist.model.Type;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapController {
    Map<Integer, Fish> fishInventory = new HashMap<>();

    AtomicInteger sequenceNumber = new AtomicInteger();

    public HashMapController() {
        createInitialCollection();
        printCollection();
    }

        public void createInitialCollection(){
        Fish fish1 = new Fish("Tuna", "Blue", Type.OPEN_WATER);
        Fish fish2 = new Fish("Salmon", "Silver", Type.DEEP_WATER);
        Fish fish3 = new Fish("Halibut", "Brown", Type.BOTTOM_FEEDER);
            fishInventory.put(sequenceNumber.incrementAndGet(), fish1);
            fishInventory.put(sequenceNumber.incrementAndGet(), fish2);
            fishInventory.put(sequenceNumber.incrementAndGet(), fish3);
    }

    public void printCollection() {
        //for-loop, iterator, streams(>java 8)
//        System.out.println("accessing collection through for loop");
        for (Map.Entry entry:fishInventory.entrySet()) {
            System.out.println("entry: " + entry);
        }
//        System.out.println("accessing collection through iterator");
//        Iterator iterator = instrumentInventory.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry)iterator.next();
//            System.out.println("entry: " + entry);
//        }
//        System.out.println("accessing collection through streams");
//        instrumentInventory.entrySet().stream().forEach(entry->System.out.println("entry: " + entry));
    }

    public void addFish(Fish fish) {
        fishInventory.put(sequenceNumber.incrementAndGet(), fish);
    }


    public List<Fish> searchCollection(String searchTerm) {
        List<Fish> searchResults = new ArrayList<>();
        for (Map.Entry entry:fishInventory.entrySet()) {
            Fish fish = (Fish)entry.getValue();
            if (fish.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(fish);
            }
        }
        return searchResults;
    }

    public void removeFish(Fish fish) {
        Iterator iterator = fishInventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Fish existingFish = (Fish)entry.getValue();
            Integer key = (Integer) entry.getKey();
            if (existingFish.equals(fish)) {
                iterator.remove();
//                instrumentInventory.remove(key); //--- ConcurrentModificationException
            }
        }
    }

    public void updateFish(Fish oldFish, Fish updatedFish){
        Iterator iterator = fishInventory.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Fish existingFish = (Fish)entry.getValue();
            Integer key = (Integer) entry.getKey();
            if (existingFish.equals(oldFish)) {
                fishInventory.put(key, updatedFish);
            }
        }

    }
}
