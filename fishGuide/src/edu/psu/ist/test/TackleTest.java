package edu.psu.ist.test;

import edu.psu.ist.model.Tackle;

import static org.junit.jupiter.api.Assertions.*;

class TackleTest {

    Tackle tackle = new Tackle("Circle Hook", "Hook", "To have a better hold on the fish");

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Circle Hook", tackle.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        tackle.setName("J Hook");
        assertEquals("J Hook", tackle.getName());
    }

    @org.junit.jupiter.api.Test
    void getTypeOfTackle() {
        assertEquals("Hook", tackle.getTypeOfTackle());
    }

    @org.junit.jupiter.api.Test
    void setTypeOfTackle() {
        tackle.setTypeOfTackle("Hook");
        assertEquals("Hook", tackle.getTypeOfTackle());
    }

    @org.junit.jupiter.api.Test
    void getUse() {
        assertEquals("To have a better hold on the fish", tackle.getUse());
    }

    @org.junit.jupiter.api.Test
    void setUse() {
        tackle.setUse("Used to set the hook better");
        assertEquals("Used to set the hook better", tackle.getUse());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
       String expected = "Tackle{" +
                "name='" + tackle.getName() + '\'' +
                ", typeOfTackle='" + tackle.getTypeOfTackle() + '\'' +
                ", use='" + tackle.getUse() + '\'' +
                '}';
       assertEquals(expected, tackle.toString());
    }
}