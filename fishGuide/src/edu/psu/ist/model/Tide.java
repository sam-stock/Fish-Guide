package edu.psu.ist.model;

public class Tide {

    private String height;
    private String tempOfTide;

    public Tide() {
    }

    public Tide(String height, String tempOfTide) {
        this.height = height;
        this.tempOfTide = tempOfTide;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTempOfTide() {
        return tempOfTide;
    }

    public void setTempOfTide(String tempOfTide) {
        this.tempOfTide = tempOfTide;
    }

    @Override
    public String toString() {
        return "Tide{" +
            "height='" + height + '\'' +
                    ", tempOfTide='" + tempOfTide + '\'' +
                    '}';
    }
}
