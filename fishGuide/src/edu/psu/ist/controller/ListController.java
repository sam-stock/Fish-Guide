package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.FishTableModel;
import edu.psu.ist.model.Tackle;
import edu.psu.ist.model.Type;
import edu.psu.ist.view.FishView;
import edu.psu.ist.view.ListView;
import edu.psu.ist.view.TackleListView;
import edu.psu.ist.view.TackleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListController implements ActionListener {
    private ListView listView;
    private FishView fishView;

    List<Fish> fishs = new ArrayList<>();

    FishTableModel fishTableModel;
    FishController fishController;
    FishPersistenceListController fishPersistenceListController;
    TackleListView tackleListView;
    TackleController tackleController;

    public ListController(){
        this.fishPersistenceListController = new FishPersistenceListController();
        fishs = fishPersistenceListController.getFishs();
        this.fishTableModel = new FishTableModel(fishs);
        this.listView = new ListView(this);
        addActionListeners();
    }
    public FishTableModel getFishTableModel() {
        return fishTableModel;
    }
    public List<Fish> getFishs() {
        return fishs;
    }

    public FishPersistenceListController getFishPersistenceListController() {
        return fishPersistenceListController;
    }

//    public void createInitialElements(){
//        Fish fish1 = new Fish("Tuna", "Blue", Type.OPEN_WATER);
//        Fish fish2 = new Fish("Salmon", "Silver", Type.DEEP_WATER);
//        Fish fish3 = new Fish("Halibut", "Brown", Type.BOTTOM_FEEDER);
//        fishs.add(fish1);
//        fishs.add(fish2);
//        fishs.add(fish3);
//    }
    public void addActionListeners(){
        listView.getDoneButton().addActionListener(this);
        listView.getNewButton().addActionListener(this);
        listView.getShowDetailsButton().addActionListener(this);
        listView.getTackleUsedButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listView.getDoneButton()){
            System.exit(0);
        }
        if (e.getSource() == listView.getNewButton()){
            listView.dispose();
            int selectedRow = 0;
            this.fishController = new FishController(this, selectedRow);
            //fishView.clearText();
        }
        if (e.getSource() == listView.getShowDetailsButton()){
            listView.dispose();

            int selectedRow = listView.getFishTable().getSelectedRow();
            System.out.println("selectedRow = " +selectedRow);

            if (listView.getFishTable().getSelectedRow() == -1){
                selectedRow = 0;
            }
            this.fishController = new FishController(this, selectedRow);
        }
        if (e.getSource() == listView.getTackleUsedButton()) {
            listView.dispose();
            int selectedRow = listView.getFishTable().getSelectedRow();
            if (listView.getFishTable().getSelectedRow() == -1){
                selectedRow = 0;
            }
            Fish selectedFish = fishs.get(selectedRow);
            this.tackleController = new TackleController(selectedFish);
        }
    }
    public void showListView() {
        this.listView.setVisible(true);
    }
}
