package edu.psu.ist.view;

import edu.psu.ist.controller.ListController;

import javax.swing.*;

public class ListView extends JFrame{
    private JPanel rootpanel;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable fishTable;
    private JButton newButton;
    private JButton showDetailsButton;
    private JButton doneButton;
    private JScrollPane scrollPane;
    private JButton tackleUsedButton;
    private ListController listController;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 600;

    public ListView(ListController listController) {
        this.listController = listController;
        createListComponents();
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JTable getFishTable() {
        return fishTable;
    }

    public JButton getTackleUsedButton() {
        return tackleUsedButton;
    }

    public void createListComponents(){
        this.add(rootpanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Fish List GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        fishTable.setModel(listController.getFishTableModel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
