package edu.psu.ist.model;

public class Edible extends Fish{
    private boolean edible;

    public Edible(boolean edible) {
        this.edible = edible;
    }

    public Edible(String name, String color, Type type, boolean edible) {
        super(name, color, type);
        this.edible = edible;
    }

    public boolean isEdible(){
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "Edible{" +
                "edible=" + edible +
                '}';
    }

    @Override
    public void makeFish(Fish fish) {
        super.makeFish(fish);
        edible(fish);
    }

    public String getFishDetails(){
        return super.getFishDetails() + " " + "Edible: " + edible;
    }

    public boolean edible(Fish fish){
        boolean edible = true;
        if (fish.getName().equals("Red Lionfish") | fish.getName().equals("Puffer fish")
                | fish.getName().equals("Spotted trunkfish")){
            edible = false;
        }
        return edible;
    }
}
