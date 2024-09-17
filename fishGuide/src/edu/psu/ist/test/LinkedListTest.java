package edu.psu.ist.test;

import edu.psu.ist.controller.TipBox;

public class LinkedListTest {
    public LinkedListTest(){
        testTipBox();
    }
    public void testTipBox(){
        TipBox tipBox = new TipBox();
        tipBox.searchItem(2);
    }
}
