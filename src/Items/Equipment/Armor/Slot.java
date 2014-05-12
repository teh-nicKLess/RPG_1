package Items.Equipment.Armor;

import Utilities.Randomizer;

public enum Slot {
    
    ARMS, FEET, HEAD, LEGS, TORSO;
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)]; 
    }
    
}
