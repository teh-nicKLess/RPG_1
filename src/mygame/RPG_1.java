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
        String language = "en";
        currentLocale = new Locale(language);
        
        
        for (int i = 0; i < iterations; i++) {
            Armour a = new Armour();
            System.out.println(a);
            System.out.println(a.getName());
            
            Weapon w = new Weapon();
            System.out.println(w);
            
        }
        
    }

}
