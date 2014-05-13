package Items.Equipment.Armor;

import Items.Equipment.Equipment;
import Items.Quality;
import Utilities.Randomizer;


public final class Armor extends Equipment {
    
    private final int value;
    private final Slot slot;
    private final Material mat;
    
    
    public Armor() {
        this(Slot.getRandomSlot(), Material.getRandomType(), Quality.getRandomQuality());
    }
    
    public Armor(Material type) {
        this(Slot.getRandomSlot(), type, Quality.getRandomQuality());
    }
    
    public Armor(Slot slot) {
        this(slot, Material.getRandomType(), Quality.getRandomQuality());
    }
    
    public Armor(Quality qual) {
        this(Slot.getRandomSlot(), Material.getRandomType(), qual);
    }
    
    public Armor(Slot slot, Material type) {
        this(slot, type, Quality.getRandomQuality());
    }
    
    public Armor(Slot slot, Quality qual) {
        this(slot, Material.getRandomType(), qual);
    }
    
    public Armor(Material type, Quality qual) {
        this(Slot.getRandomSlot(), type, qual);
    }
    
    public Armor(Slot slot, Material mat, Quality qual) {
        this.slot = slot;
        this.mat = mat;
        super.setQuality(qual);
        this.value = this.calculateArmor(slot, qual, mat.getBaseValue());
        super.setDurability(qual, mat.getDurability());
        //TODO super.setName();
    }
    
    public final int getValue() {
        return value;
    }
    
    public final Slot getSlot() {
        return slot;
    }
    
    public final Material getMaterial() {
        return mat;
    }
    
    private int calculateArmor(Slot slot, Quality qual, int armorValue) {
        final int max;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: max = armorValue * 5; break;
            case EPIC:      max = armorValue * 4; break;
            case RARE:      max = armorValue * 3; break; 
            case UNCOMMON:  max = armorValue * 2; break;
            case COMMON:    max = armorValue; break;
            default:        assert false; max = 0;
        }
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1)) * slot.getMultiplier();
    }
    
    @Override
    public String toString() {
        String str = "Slot: " + slot + "; Type: " + mat + "; Quality: " + super.getQuality() + "; Armour: " + value;
        return str;
    }
    
}
