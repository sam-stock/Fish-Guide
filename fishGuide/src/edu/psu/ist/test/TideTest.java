package edu.psu.ist.test;

import edu.psu.ist.model.Tide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TideTest {

    Tide tide = new Tide("8 feet", "58 Degrees");

    @Test
    void getHeight() {
        assertEquals("8 feet", tide.getHeight());
    }

    @Test
    void setHeight() {
        tide.setHeight("6 feet");
        assertEquals("6 feet", tide.getHeight());
    }

    @Test
    void getTempOfTide() {
        assertEquals("58 Degrees", tide.getTempOfTide());
    }

    @Test
    void setTempOfTide() {
        tide.setTempOfTide("56 Degrees");
        assertEquals("56 Degrees", tide.getTempOfTide());
    }

    @Test
    void testToString() {
        String expected = "Tide{" +
                "height='" + tide.getHeight() + '\'' +
                ", tempOfTide='" + tide.getTempOfTide() + '\'' +
                '}';
    }
}