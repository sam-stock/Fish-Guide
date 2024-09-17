package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.Type;
import edu.psu.ist.view.FishView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FishController implements ActionListener{
    private FishView fishView;
    private List<Fish> fishs = new ArrayList<>();
    private ListController listController;
    int currentIndex;

    public FishController(){
        this.fishView = new FishView(this);
        addActionListeners();
        //createInitialElements();
        fishView.setDisplayResultMessage("Enter Fish Specifications");
    }

    public FishController(ListController listController){
        this.fishView = new FishView(this);
        addActionListeners();
    }

    public FishController(ListController listController, int selectedRow){
        this.listController = listController;
        this.fishs = listController.getFishs();
        Fish selectedFish = fishs.get(selectedRow);
        this.fishView = new FishView(this, selectedFish);
        this.currentIndex = selectedRow;
        addActionListeners();
    }

    public void addActionListeners(){
        fishView.getAddButton().addActionListener(this);
        fishView.getClearButton().addActionListener(this);
        fishView.getDeleteButton().addActionListener(this);
        fishView.getNextButton().addActionListener(this);
        fishView.getQuitButton().addActionListener(this);
        fishView.getPreviousButton().addActionListener(this);
        fishView.getUpdateButton().addActionListener(this);
        fishView.getBackButton().addActionListener(this);
        fishView.getNewButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
            if (source == fishView.getAddButton()) {
                Fish newFish = fishView.createFish();
                fishs.add(newFish);
                fishView.setDisplayResultMessage(newFish.getName() + " has been added");
                currentIndex = fishs.indexOf(newFish);
                listController.fishPersistenceListController.writeFishFile();
            }
            try {
                if (source == fishView.getNextButton()) {
                    fishView.clearText();
                    currentIndex = currentIndex + 1;
                    Fish nextFish = fishs.get(currentIndex);
                    fishView.displayFish(nextFish);
                    displayFish(currentIndex);
                }
            }catch (IndexOutOfBoundsException exception){
                fishView.setDisplayResultMessage("End of the list");
            }

            try{
                if (source == fishView.getPreviousButton()) {
                    fishView.clearText();
                    currentIndex = currentIndex - 1;
                    Fish previousFish = fishs.get(currentIndex);
                    fishView.displayFish(previousFish);
                    displayFish(currentIndex);
                }
            }catch (IndexOutOfBoundsException exception){
                fishView.setDisplayResultMessage("Beginning of the list");
            }

            if (source == fishView.getUpdateButton()) {
                Fish updatedFish = fishView.createFish();
                fishs.set(currentIndex, updatedFish);
                fishView.setDisplayResultMessage("Fish Updated");
                listController.fishPersistenceListController.writeFishFile();
            }
            if (source == fishView.getDeleteButton()) {
                fishs.remove(currentIndex);
                fishView.clearText();
                fishView.setDisplayResultMessage("Fish Deleted");
                listController.fishPersistenceListController.writeFishFile();
            }
            if (source == fishView.getClearButton()) {
                fishView.clearText();
            }
            if (source == fishView.getBackButton()){
                this.fishView.dispose();
                listController.showListView();
            }
            if (source == fishView.getQuitButton()) {
                System.exit(0);
            }
            if(source == fishView.getNewButton()){
                fishView.clearText();
            }
    }

    public void displayFish(int index){
        Fish previousFish = fishs.get(index);
        fishView.displayFish(previousFish);
    }

//    public void createInitialElements(){
//        Fish fish1 = new Fish("Tuna", "Blue", Type.OPEN_WATER);
//        Fish fish2 = new Fish("Salmon", "Silver", Type.DEEP_WATER);
//        Fish fish3 = new Fish("Halibut", "Brown", Type.BOTTOM_FEEDER);
//        fishs.add(fish1);
//        fishs.add(fish2);
//        fishs.add(fish3);
//        currentIndex = 0;
//        displayFish(0);
//    }

}
