package edu.psu.ist.view;

import edu.psu.ist.controller.ListController;
import edu.psu.ist.controller.TackleListController;

import javax.swing.*;

public class TackleListView extends JFrame{
    private JPanel rootPanel;
    private JPanel tablePanel;
    private JTable tackleTable;
    private JPanel buttonTable;
    private JButton showTackleDetailsButton;
    private JButton showFishListButton;
    private JButton doneButton;
    private JScrollPane scrollPane;
    private TackleListController tackleListController;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 600;

    public TackleListView(TackleListController tackleListController) {
        this.tackleListController = tackleListController;
        createListComponents();
    }
    public void createListComponents(){
        this.add(rootPanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Tackle List GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        tackleTable.setModel(tackleListController.getTackleTableModel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public JTable getTackleTable() {
        return tackleTable;
    }

    public JButton getShowTackleDetailsButton() {
        return showTackleDetailsButton;
    }

    public JButton getShowFishListButton() {
        return showFishListButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }
}
