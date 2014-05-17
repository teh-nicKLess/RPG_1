package Items.Equipment.Armour;

import Utilities.Randomizer;

public enum Bodypart {
    
    HANDS((byte)1), FEET((byte)1), HEAD((byte)2), LEGS((byte)3), TORSO((byte)5);
    
    private final byte multiplier;

    private Bodypart(final byte multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * returns the Bodypart's multiplier value for armour calculation
     * @return the Bodypart's multiplier value for armour calculation
     */
    protected final byte getMultiplier() { 
        return multiplier; 
    }
    
    /**
     * returns a random Bodypart
     * @return a random Bodypart
     */
    public static Bodypart getRandomBodypart() {
        return Bodypart.values()[Randomizer.getRandomNumber(Bodypart.values().length)]; 
    }
        
}
