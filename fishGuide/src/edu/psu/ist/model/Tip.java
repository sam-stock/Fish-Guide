package edu.psu.ist.model;

public class Tip {
    private Fish fish;
    private Location location;
    private Technique technique;
    private long tipNumber;
    private String tip;

    public Tip(Fish fish, Location location, Technique technique, long tipNumber) {
        this.fish = fish;
        this.location = location;
        this.technique = technique;
        this.tipNumber = tipNumber;
    }
    public Tip(String tip, long tipNumber){
        this.tip = tip;
        this.tipNumber = tipNumber;
    }

    public Fish getFish() {
        return fish;
    }

    public Location getLocation() {
        return location;
    }

    public Technique getTechnique() {
        return technique;
    }

    public long getTipNumber() {
        return tipNumber;
    }
    public boolean whereToInsert(Tip tip){
        boolean decision = false;
        if (this.tipNumber > tip.tipNumber){
            decision = true;
        } else {

        }
        return decision;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "fish=" + fish +
                ", location=" + location +
                ", technique=" + technique +
                ", tipNumber=" + tipNumber +
                '}';
    }
}
