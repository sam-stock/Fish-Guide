package edu.psu.ist.controller;

import edu.psu.ist.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TipBox {
    LinkedList<Tip> tipsToGive = new LinkedList<>();
    public TipBox(){
        this.buildTipBox();
        this.printTips();

    }
    public void buildTipBox(){
        Fish fish1 = new Fish("Tuna", "Blue", Type.OPEN_WATER);
        Location local1 = new Location("CA", "San Diego");
        Technique tec1 = new Technique("Fly Lining", "Attraction",
                "Use only hook and live bait to swim by itself");
        Tip tip1 = new Tip(fish1, local1, tec1, 1);

        Fish fish2 = new Fish("Salmon", "Silver", Type.DEEP_WATER);
        Location local2 = new Location("AK", "Juneau");
        Technique tec2 = new Technique("Trolling", "Attraction",
                "Use flashers to attract fish and down-riggers to hold the bait at the depth you want");
        Tip tip2 = new Tip(fish2, local2, tec2, 2);

        Fish fish3 = new Fish("Halibut", "Brown", Type.BOTTOM_FEEDER);
        Location local3 = new Location("AK", "Juneau");
        Technique tec3 = new Technique("Jigging", "Attraction",
                "Bobbing the bait up and down to act like an injured fish ");
        Tip tip3 = new Tip(fish3, local3, tec3, 3);

        addTips(tip1);
        addTips(tip2);
        addTips(tip3);
    }
    public void printTips(){
        ListIterator<Tip> tipIterator = tipsToGive.listIterator();
        while(tipIterator.hasNext()){
            System.out.println(tipIterator.next().toString());
        }
    }
    public void addTips(Tip newTip){
        ListIterator<Tip> tipListIterator = tipsToGive.listIterator();
        boolean tipAdded = false;
        boolean insertDecision = false;
        while(tipListIterator.hasNext()) {
            insertDecision = tipListIterator.next().whereToInsert(newTip);
            if (insertDecision) {
                tipsToGive.add(tipListIterator.previousIndex(), newTip);
                tipAdded = true;
                break;
            }
        }
        if (tipAdded == false) {
            tipsToGive.add(newTip);
        }
    }
    public void removeTip(Tip tip){
        tipsToGive.remove(tip);
    }
    public List<Tip> getTip(String fishName){
        List<Tip> results = new ArrayList<>();
        ListIterator<Tip> tipListIterator = tipsToGive.listIterator();
        while(tipListIterator.hasNext()) {
            Tip currentTip = tipListIterator.next();
            if (currentTip.getFish().getName().equals(fishName)){
                results.add(currentTip);
            }
        }
        System.out.println("Search Results: " + results);
        return results;
    }
    public List<Tip> searchItem(int tipNumber){
        List<Tip> results = new ArrayList<>();
        ListIterator<Tip> tipListIterator = tipsToGive.listIterator();
        while(tipListIterator.hasNext()) {
            Tip currentTip = tipListIterator.next();
            if (currentTip.getTipNumber() == tipNumber){
                results.add(currentTip);
            }
        }
        System.out.println("Search Results: " + results);
        return results;
    }
    public void updateTip(int oldTipNumber, Tip updatedTip){
        ListIterator<Tip> tipListIterator = tipsToGive.listIterator();
        while(tipListIterator.hasNext()) {
            Tip currentTip = tipListIterator.next();
            int currentIndex = tipsToGive.indexOf(currentTip);
            if (currentTip.getTipNumber() == oldTipNumber){
                tipsToGive.set(currentIndex, updatedTip);
            }
        }
    }

}
