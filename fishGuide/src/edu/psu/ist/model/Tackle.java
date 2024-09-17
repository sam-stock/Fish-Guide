package edu.psu.ist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tackle implements Trackable, Serializable {
    private String name;
    private String typeOfTackle;
    private String use;

    public Tackle() {
    }

    public Tackle(String name, String typeOfTackle, String use) {
        this.name = name;
        this.typeOfTackle = typeOfTackle;
        this.use = use;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfTackle() {
        return typeOfTackle;
    }

    public void setTypeOfTackle(String typeOfTackle) {
        this.typeOfTackle = typeOfTackle;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "Tackle{" +
                "name='" + name + '\'' +
                ", typeOfTackle='" + typeOfTackle + '\'' +
                ", use='" + use + '\'' +
                '}';
    }

    @Override
    public void trackSetup() {
        System.out.println("This " + this.getClass().getSimpleName() + "will be added");
    }

    @Override
    public void track() {
        List<String> tackle = new ArrayList<>();
        tackle.add(this.name);
        System.out.println("The tackle ha been added");
    }
}
