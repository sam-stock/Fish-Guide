package edu.psu.ist.view;

import edu.psu.ist.controller.FishController;
import edu.psu.ist.model.Fish;


import javax.swing.*;

public class FishView extends JFrame{
    private JPanel fishPanel;
    private JTextField nameTxt;
    private JTextField colorTxt;
    private JTextField typeTxt;
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel colorLabel;
    private JButton addButton;
    private JButton clearButton;
    private JLabel resultMessage;
    private JButton previousButton;
    private JButton nextButton;
    private JButton quitButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JLabel fishGuideLabel;
    private JComboBox comboBoxType;
    private JButton backButton;
    private JButton newButton;

    private FishController fishController;
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 800;

    public FishView(FishController fishController){
        this.fishController = fishController;
        createComponent();
    }

    public FishView(FishController fishController, Fish selectedFish){
        this.fishController = fishController;
        createComponent();
        displayFish(selectedFish);
    }


    public void createComponent(){
        this.add(fishPanel);
        this.comboBoxType.setModel(new DefaultComboBoxModel(edu.psu.ist.model.Type.values()));
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Fish Guide GUI Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Fish createFish(){
        String name = nameTxt.getText();
        edu.psu.ist.model.Type type = (edu.psu.ist.model.Type) comboBoxType.getSelectedItem();
        String color = colorTxt.getText();
        Fish fish = new Fish(name, color, type);
        return fish;
    }

    public void displayFish(Fish fish){
        this.nameTxt.setText(fish.getName());
        this.comboBoxType.setSelectedItem(fish.getType());
        this.colorTxt.setText(fish.getColor());
    }

    public void clearText(){
        this.nameTxt.setText("");
        this.comboBoxType.setSelectedItem(null);
        this.colorTxt.setText("");
    }

    public void setDisplayResultMessage(String message){
        this.resultMessage.setText(message);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getQuitButton() {
        return quitButton;
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

    public JButton getNewButton() {
        return newButton;
    }
}
