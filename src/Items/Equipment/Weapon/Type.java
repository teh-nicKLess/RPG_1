package Items.Equipment.Weapon;

import Utilities.Randomizer;

public enum Type {
    
    BOW(true), CROSSBOW(true), AXE(false), MACE(false), HAMMER(true), SWORD(false), 
    LONGSWORD(true), SHIELD(false), SPEAR(false), DAGGER(false), STAFF(true);
    
    private final boolean twoHands;
    
    private Type(boolean hands) {
        this.twoHands = hands;
    }
    
    public boolean isTwoHanded() {
        return twoHands;
    }
    
    public static Type getRandomType() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    }
    
}
