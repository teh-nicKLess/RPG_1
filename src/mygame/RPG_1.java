package mygame;

import com.jme3.app.SimpleApplication;
import java.util.Locale;


public class RPG_1 extends SimpleApplication {

    public static Locale currentLocale = new Locale(System.getProperty("user.language"));;
    
    
    public static void main(String[] args) {
        RPG_1 app = new RPG_1();
        app.start();
    }

    @Override
    public void simpleInitApp() {
                
    }

}
