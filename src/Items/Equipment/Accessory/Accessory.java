package Items.Equipment.Accessory;

import Items.Equipment.Equipment;
import Items.Equipment.Weight;
import Items.Quality;
import java.util.EnumMap;
import java.util.ResourceBundle;


public abstract class Accessory extends Equipment {
    
    private Slot slot;
    private static final EnumMap<Slot, String> nameMap = new EnumMap<Slot, String>(Slot.class);
    
    static {
        final ResourceBundle names = ResourceBundle.getBundle("Internationalization.Accessory", mygame.RPG_1.currentLocale);
        nameMap.put(Slot.RING,      names.getString("RING"));
        nameMap.put(Slot.NECKLACE,  names.getString("NECKLACE"));
        nameMap.put(Slot.BRACELET,  names.getString("BRACELET"));
    }
    
    public Accessory() {
        this(Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    public Accessory(final Slot slot) {
        this(slot, Quality.getRandomQuality());
    }
    
    public Accessory(final Quality qual) {
        this(Slot.getRandomSlot(), qual);
    }
    
    public Accessory(final Slot slot, final Quality qual) {
        this.slot = slot;
        super.setQuality(qual);
        super.setName(nameMap.get(slot));
        super.setDurability(qual, slot.getDurability());
        super.setMagicAttributes(slot.getMaxMagicSlots(), qual);
    }
    
    public Slot getSlot() {
        return slot;
    }
    
    @Override
    public final Weight getWeight() {
        return slot.getWeight();
    }
    
}
