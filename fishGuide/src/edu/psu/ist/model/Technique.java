package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.List;

public class Technique implements Trackable{

    private String use;
    private String typeOfTechnique;
    private String name;

    public Technique() {
    }

    public Technique(String name, String typeOfTechnique, String use) {
        this.use = use;
        this.typeOfTechnique = typeOfTechnique;
        this.name = name;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getTypeOfTechnique() {
        return typeOfTechnique;
    }

    public void setTypeOfTechnique(String typeOfTechnique) {
        this.typeOfTechnique = typeOfTechnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Technique{" +
                ", name='" + name + '\'' +
                ", typeOfTechnique='" + typeOfTechnique + '\'' +
                "use='" + use + '\'' +
                '}';
    }

    @Override
    public void trackSetup() {
        System.out.println("This " + this.getClass().getSimpleName() + " will be added");
    }

    @Override
    public void track() {
        List<String> techs = new ArrayList<>();
        techs.add(this.name);
        System.out.println("The technique has been added");
    }
}
