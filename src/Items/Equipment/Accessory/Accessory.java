package Items.Equipment.Accessory;

import Items.Equipment.Equipment;
import Items.Equipment.Weight;


public abstract class Accessory extends Equipment {
    
    private Slot slot;
    
    
    public Slot getSlot() {
        return slot;
    }
    
    @Override
    public Weight getWeight() {
        return Slot.getWeight();
    }
    
}
