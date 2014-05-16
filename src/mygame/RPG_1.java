package mygame;

import Items.Equipment.Armour.Armour;
import Items.Equipment.Weapon.Weapon;
import com.jme3.app.SimpleApplication;
import java.util.Locale;


public class RPG_1 extends SimpleApplication {

    public static Locale currentLocale;
    
    
    public static void main(String[] args) {
        RPG_1 app = new RPG_1();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        final int iterations = 5;
        currentLocale = new Locale(System.getProperty("user.language"));
                
        
        for (int i = 0; i < iterations; i++) {
            final Armour a = new Armour();
            System.out.println(a);
            //System.out.println(a.getName());
            
            //final Weapon w = new Weapon();
            //System.out.println(w);
            //System.out.println(w.getName());
            
        }
                
    }

}
