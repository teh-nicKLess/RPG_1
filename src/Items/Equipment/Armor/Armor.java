package Items.Equipment.Armor;

import Items.Equipment.Equipment;
import Items.Quality;
import Utilities.Randomizer;


public final class Armor extends Equipment {
    
    private final int value;
    private final Slot slot;
    private final Type type;
    
    
    public Armor() {
        this(Slot.getRandomSlot(), Type.getRandomType(), Quality.getRandomQuality());
    }
    
    public Armor(Type type) {
        this(Slot.getRandomSlot(), type, Quality.getRandomQuality());
    }
    
    public Armor(Slot slot) {
        this(slot, Type.getRandomType(), Quality.getRandomQuality());
    }
    
    public Armor(Quality qual) {
        this(Slot.getRandomSlot(), Type.getRandomType(), qual);
    }
    
    public Armor(Slot slot, Type type) {
        this(slot, type, Quality.getRandomQuality());
    }
    
    public Armor(Slot slot, Quality qual) {
        this(slot, Type.getRandomType(), qual);
    }
    
    public Armor(Type type, Quality qual) {
        this(Slot.getRandomSlot(), type, qual);
    }
    
    public Armor(Slot slot, Type type, Quality qual) {
        this.slot = slot;
        this.type = type;
        super.setQuality(qual);
        this.value = this.calculateArmor(slot, qual, ArmorValues.getArmor(type));
        super.setDurability(this.calculateHealth(qual, ArmorValues.getHP(type)));
        //TODO super.setName();
    }
    
    public final int getValue() {
        return value;
    }
    
    public final Slot getSlot() {
        return slot;
    }
    
    public final Type getType() {
        return type;
    }
    
    private int calculateArmor(Slot slot, Quality qual, int[] armorValues) {
        final int max;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: max = armorValues[4]; break;
            case EPIC:      max = armorValues[3]; break;
            case RARE:      max = armorValues[2]; break; 
            case UNCOMMON:  max = armorValues[1]; break;
            case COMMON:    max = armorValues[0]; break;
            default:        assert false; max = 0;
        }
        final int min = max / 2;
        return (int)(min + Randomizer.getRandomNumber(((max - min) + 1))) * slot.getMultiplier();
    }

    protected final int calculateHealth(Quality qual, int[] healthValues) {
        int hp = Randomizer.getRandomNumber(51);
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: hp += healthValues[4]; break;
            case EPIC:      hp += healthValues[3]; break;
            case RARE:      hp += healthValues[2]; break; 
            case UNCOMMON:  hp += healthValues[1]; break;
            case COMMON:    hp += healthValues[0]; break;
            default:        assert false; hp = 0;
        }
        return hp;
    }
    
    @Override
    public String toString() {
        String str = "Slot: " + slot + "; Type: " + type + "; Quality: " + super.getQuality() + "; Armour: " + value;
        return str;
    }
    
}
