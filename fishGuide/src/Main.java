import edu.psu.ist.controller.FishController;
import edu.psu.ist.controller.HashMapController;
import edu.psu.ist.controller.ListController;
import edu.psu.ist.controller.TipBox;
import edu.psu.ist.model.*;
import edu.psu.ist.test.LinkedListTest;
import edu.psu.ist.test.TestHarness;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TestHarness test = new TestHarness();
        //test.testFish();
        //test.testLocation();
        //test.testClassHierarchy();
        //test.testInterface();
        //FishController fishController = new FishController();
        //ListController listController =
        //ListController listController = new ListController();
        //new LinkedListTest();
//        TipBox tipBox = new TipBox();
//        Tip newTip = new Tip("It is good to use a bait bad to draw in fish", 4);
       Fish fish1 = new Fish("Bass", "Green", Type.SHORE);
       Fish fish2 = new Fish("Skulpin", "Brown", Type.BOTTOM_FEEDER);
//        Location local1 = new Location("CA", "Redondo Beach");
//        Technique tec1 = new Technique("Setting the hook", "Catch", "Making sure the fish is on");
//
//        Tip newTip2 = new Tip(fish1, local1, tec1, 2);
//        tipBox.addTips(newTip);
//        tipBox.removeTip(newTip);
//        tipBox.getTip("Tuna");
//        tipBox.updateTip(2,newTip2);
        HashMapController hashMapController = new HashMapController();
        hashMapController.searchCollection("Tuna");
        hashMapController.addFish(fish1);
        hashMapController.updateFish(fish1,fish2);
        hashMapController.removeFish(fish2);
        





    }
}