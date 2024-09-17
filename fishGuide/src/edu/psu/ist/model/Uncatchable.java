package edu.psu.ist.model;

public class Uncatchable extends Fish{
    private boolean catchable;

    public Uncatchable(boolean catchable) {
        this.catchable = catchable;
    }

    public Uncatchable(String name, String color, Type type, boolean catchable) {
        super(name, color, type);
        this.catchable = catchable;
    }

    public boolean isCatchable() {
        return catchable;
    }

    public void setCatchable(boolean catchable) {
        this.catchable = catchable;
    }

    @Override
    public String toString() {
        return "Uncatchable{" +
                "catchable=" + catchable +
                '}';
    }

    @Override
    public void makeFish(Fish fish) {
        super.makeFish(fish);
        catchable(fish);
    }

    public String getFishDetails(){
        return super.getFishDetails() + " " + "Catchable = " + catchable;
    }

    public boolean catchable(Fish fish){
        boolean catchable = true;
        if (fish.getName().equals("Garibaldi") | fish.getName().equals("Black Grouper")){
            catchable = false;
        }
        return catchable;
    }
}
