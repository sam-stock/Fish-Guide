package edu.psu.ist.model;


import java.io.Serializable;

public class Fish implements Serializable {
    private String name;
    private String color;
    private Type type;

    public Fish(String name, String color, Type type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public Fish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void makeFish(Fish fish) {
    }

    public String getFishDetails(){
        return "Fish Details{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
