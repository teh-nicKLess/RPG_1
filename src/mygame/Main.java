package mygame;

import Items.Equipment.Armor.Armor;
import com.jme3.app.SimpleApplication;


public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        final int iterations = 100;
        
        for (int i = 0; i < iterations; i++) {
            Armor a = new Armor();
            System.out.println(a);
        }
        
    }

}
