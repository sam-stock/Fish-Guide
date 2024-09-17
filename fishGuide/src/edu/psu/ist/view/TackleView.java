package edu.psu.ist.view;

import edu.psu.ist.controller.TackleController;
import edu.psu.ist.model.Tackle;

import javax.swing.*;

public class TackleView extends JFrame{
    private JPanel tacklePanel;
    private JLabel nameLabel;
    private JTextField nameTxt;
    private JTextField typeTxt;
    private JLabel typeOfTackleLabel;
    private JLabel useLabel;
    private JTextField useTxt;
    private JButton addButton;
    private JButton previousButton;
    private JButton nextButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton quitButton;
    private JButton clearButton;
    private JLabel message;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 600;
    TackleController tackleController;

    public TackleView(TackleController tackleController){
        this.tackleController = tackleController;
        createComponents();
    }
    public TackleView(TackleController tackleController, Tackle tackle){
        this.tackleController = tackleController;
        createComponents();
        displayTackle(tackle);
    }
    public void createComponents() {
        this.add(tacklePanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Tackle GUI Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public Tackle createTackle(){
        String name = nameTxt.getText().trim();
        String typeOfTackle = typeTxt.getText().trim();
        String use = useTxt.getText().trim();
        Tackle tackle = new Tackle(name, typeOfTackle, use);
        return tackle;
    }

    public void displayTackle(Tackle tackle){
        this.nameTxt.setText(tackle.getName());
        this.typeTxt.setText(tackle.getTypeOfTackle());
        this.useTxt.setText(tackle.getUse());
    }
    public void clearFields(){
        this.nameTxt.setText("");
        this.typeTxt.setText("");
        this.useTxt.setText("");
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }



    public TackleController getTackleController() {
        return tackleController;
    }

    public void setDisplayResultMessage(String s) {
        this.message.setText(s);
    }
}
