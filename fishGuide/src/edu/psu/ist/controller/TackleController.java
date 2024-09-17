package edu.psu.ist.controller;

import edu.psu.ist.model.Fish;
import edu.psu.ist.model.Tackle;
import edu.psu.ist.view.FishView;
import edu.psu.ist.view.TackleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TackleController implements ActionListener {
    private TackleView tackleView;
    private List<Tackle> tackles = new ArrayList<>();
    private TackleListController tackleListController;
    private ListController listController;

    int currentIndex;

    public TackleController(){
        this.tackleView = new TackleView(this);
        addActionListeners();
        //createInitialElements();
    }

    public TackleController(ListController listController){
        this.tackleView = new TackleView(this);
        addActionListeners();
    }
    public TackleController(Fish selectedFish) {
        tackleView = new TackleView(this);
        addActionListeners();
        Tackle newTackle = new Tackle();
        tackleView.displayTackle(newTackle);
    }

    public TackleController(TackleListController tackleListController, int selectedRow){
        this.tackleListController = tackleListController;
        this.tackles = tackleListController.getTackleList();
        Tackle selectedTackle = tackles.get(selectedRow);
        this.tackleView = new TackleView(this, selectedTackle);
        this.currentIndex = selectedRow;
        addActionListeners();
    }

    public void addActionListeners(){
        tackleView.getAddButton().addActionListener(this);
        tackleView.getClearButton().addActionListener(this);
        tackleView.getDeleteButton().addActionListener(this);
        tackleView.getNextButton().addActionListener(this);
        tackleView.getQuitButton().addActionListener(this);
        tackleView.getPreviousButton().addActionListener(this);
        tackleView.getUpdateButton().addActionListener(this);
        tackleView.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == tackleView.getAddButton()) {
            Tackle newTackle = tackleView.createTackle();
            tackleView.setDisplayResultMessage(newTackle.getName() + " has been added");
            TacklePersistenceListController tacklePersistenceListController = new TacklePersistenceListController();
            tacklePersistenceListController.getTackles().add(newTackle);
            tacklePersistenceListController.writeTackleFile();
            showTackleListView();
        }
        try {
            if (source == tackleView.getNextButton()) {
                tackleView.clearFields();
                currentIndex = currentIndex + 1;
                Tackle nextTackle = tackles.get(currentIndex);
                tackleView.displayTackle(nextTackle);
                displayTackle(currentIndex);
            }
        }catch (IndexOutOfBoundsException exception){
            tackleView.setDisplayResultMessage("End of the list");
        }

        try{
            if (source == tackleView.getPreviousButton()) {
                tackleView.clearFields();
                currentIndex = currentIndex - 1;
                Tackle previousTackle = tackles.get(currentIndex);
                tackleView.displayTackle(previousTackle);
                displayTackle(currentIndex);
            }
        }catch (IndexOutOfBoundsException exception){
            tackleView.setDisplayResultMessage("Beginning of the list");
        }

        if (source == tackleView.getUpdateButton()) {
            Tackle updatedTackle = tackleView.createTackle();
            tackles.set(currentIndex, updatedTackle);
            tackleView.setDisplayResultMessage("Tackle Updated");
            TacklePersistenceListController tacklePersistenceListController = new TacklePersistenceListController();
            tacklePersistenceListController.writeTackleFile();
        }
        if (source == tackleView.getDeleteButton()) {
            tackles.remove(currentIndex);
            tackleView.clearFields();
            tackleView.setDisplayResultMessage("Tackle Deleted");
            TacklePersistenceListController tacklePersistenceListController = new TacklePersistenceListController();
            tacklePersistenceListController.writeTackleFile();
        }
        if (source == tackleView.getClearButton()) {
            tackleView.clearFields();
        }
        if (source == tackleView.getBackButton()){
          showTackleListView();
        }
        if (source == tackleView.getQuitButton()) {
            System.exit(0);
        }

    }
    public void displayTackle(int index){
        Tackle previousTackle = tackles.get(index);
        tackleView.displayTackle(previousTackle);
    }
    private void showTackleListView() {
        tackleView.dispose();
        new TackleListController();
    }
}
