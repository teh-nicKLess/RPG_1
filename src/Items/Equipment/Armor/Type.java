package Items.Equipment.Armor;

import Utilities.Randomizer;

public enum Type {
    
    CLOTH, LEATHER, CHAINMAIL, PLATE;
    
    public static Type getRandomType() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    } 
    
}
