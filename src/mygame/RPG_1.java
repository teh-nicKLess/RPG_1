package mygame;

import java.util.Locale;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class RPG_1 extends SimpleApplication {
    
    public static Locale currentLocale;
    
    public static void main(String[] args) {
        RPG_1 app = new RPG_1();
        app.start();
    }
    
    @Override
    public void simpleInitApp() {

//        final MagicBolt bolt1 = new MagicBolt(new Element("fire"));
//        System.out.println(bolt1.getName());
//        System.out.println(bolt1.getDescription());

        Spatial test = assetManager.loadModel("Textures/testworld2.j3o");
        test.scale(0.05f, 0.05f, 0.05f);
        test.setLocalTranslation(new Vector3f(0, -1, 9));
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //mat.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        mat.setColor("Color", ColorRGBA.Blue);
        test.setMaterial(mat);
        test.setCullHint(Spatial.CullHint.Never);
        rootNode.attachChild(test);

//        for (float i = 0; i < 3f; i = i + 0.01f) {
//            test.setLocalTranslation(test.getLocalTranslation().x, test.getLocalTranslation().y + i, test.getLocalTranslation().z);
//        }

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1f));
        rootNode.addLight(sun);
        
        rootNode.setCullHint(Spatial.CullHint.Never);

    }
}
