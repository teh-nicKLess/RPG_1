package Items.Equipment.Armor;


abstract class ArmorValues {
    
    private final static int[] clothArmor     = {5, 10, 15, 20, 25};
    private final static int[] clothHP        = {100, 110, 125, 150, 200};
    
    private final static int[] leatherArmor   = {30, 35, 40, 55, 70};
    private final static int[] leatherHP      = {150, 160, 175, 200, 250};
    
    private final static int[] chainmailArmor = {10, 20, 30, 35, 45};
    private final static int[] chainmailHP    = {200, 210, 225, 250, 300};
    
    private final static int[] plateArmor     = {55, 60, 70, 85, 100};
    private final static int[] plateHP        = {250, 260, 270, 300, 350};
    
    
    protected static int[] getArmor(Type type) {
        final int[] armor;
        switch (type) {
            case CLOTH:     armor = clothArmor;       break;
            case LEATHER:   armor = leatherArmor;     break;
            case CHAINMAIL: armor = chainmailArmor;   break;
            case PLATE:     armor = plateArmor;       break;
            default:        assert false; armor = null;
        }
        return armor;
    }
    
    protected static int[] getHP(Type type) {
        final int[] hp;
        switch (type) {
            case CLOTH:     hp = clothHP;       break;
            case LEATHER:   hp = leatherHP;     break;
            case CHAINMAIL: hp = chainmailHP;   break;
            case PLATE:     hp = plateHP;       break;
            default:        assert false; hp = null;    
        }
        return hp;
    }
    
}
