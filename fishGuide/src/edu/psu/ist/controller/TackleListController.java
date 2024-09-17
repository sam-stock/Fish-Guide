package edu.psu.ist.controller;

import edu.psu.ist.model.Tackle;
import edu.psu.ist.model.TackleTableModel;
import edu.psu.ist.view.TackleListView;
import edu.psu.ist.view.TackleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TackleListController implements ActionListener {
    private List<Tackle> tackleList = new ArrayList<>();
    private TackleTableModel tackleTableModel;
    private TackleListView tackleListView;
    private TacklePersistenceListController tacklePersistenceListController;
    TackleController tackleController;

    public TackleListController(){
        tacklePersistenceListController = new TacklePersistenceListController();
        tackleList = tacklePersistenceListController.getTackles();
        tackleTableModel = new TackleTableModel(tackleList);
        this.tackleListView = new TackleListView(this);
        addActionListeners();
    }


    public List<Tackle> getTackleList() {
        return tackleList;
    }

    public TackleListView getTackleListView() {
        return tackleListView;
    }

    public TackleTableModel getTackleTableModel() {
        return tackleTableModel;
    }
    private void addActionListeners(){
        tackleListView.getDoneButton().addActionListener(this);
        tackleListView.getShowFishListButton().addActionListener(this);
        tackleListView.getShowTackleDetailsButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == tackleListView.getDoneButton()) {
            System.exit(0);
        }
        if (obj == tackleListView.getShowFishListButton()) {
            tackleListView.dispose();
            new ListController();
        }
        if(obj == tackleListView.getShowTackleDetailsButton()){
            tackleListView.dispose();
            int selectedRow = tackleListView.getTackleTable().getSelectedRow();

            if (tackleListView.getTackleTable().getSelectedRow() == -1){
                selectedRow = 0;
            }
            this.tackleController = new TackleController(this, selectedRow);
        }
    }
    public void showListView() {
        this.tackleListView.setVisible(true);
    }

}
