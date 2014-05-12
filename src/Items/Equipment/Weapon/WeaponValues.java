package Items.Equipment.Weapon;


public class WeaponValues {
    
    private final static int[] weaponHP         = {5, 10, 15, 20, 25};
    
    private final static int[] bow              = {5, 10, 15, 20, 25};
    private final static int[] crossbow         = {100, 110, 125, 150, 200};
    private final static int[] axe              = {30, 35, 40, 55, 70};
    private final static int[] mace             = {150, 160, 175, 200, 250};
    private final static int[] hammer           = {10, 20, 30, 35, 45};
    private final static int[] sword            = {200, 210, 225, 250, 300};
    private final static int[] longsword        = {55, 60, 70, 85, 100};
    private final static int[] shield           = {250, 260, 270, 300, 350};
    private final static int[] spear            = {250, 260, 270, 300, 350};
    private final static int[] dagger           = {250, 260, 270, 300, 350};
    private final static int[] staff            = {250, 260, 270, 300, 350};
    
    
    protected static int[] getDamage(Type type) {
        final int[] dmg;
        switch (type) {
            case BOW:       dmg = bow;          break;
            case CROSSBOW:  dmg = crossbow;     break;  
            case AXE:       dmg = axe;          break;
            case MACE:      dmg = mace;         break;
            case HAMMER:    dmg = hammer;       break;
            case SWORD:     dmg = sword;        break;
            case LONGSWORD: dmg = longsword;    break;
            case SHIELD:    dmg = shield;       break;
            case SPEAR:     dmg = spear;        break;
            case DAGGER:    dmg = dagger;       break;
            case STAFF:     dmg = staff;        break;
            default:        assert false; dmg = null;
        }
        return dmg;
    }
    
    protected static int[] getHP() {
        return weaponHP;
    }
    
}
