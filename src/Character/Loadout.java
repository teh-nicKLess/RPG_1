package Character;

import Items.Equipment.Accessory.Accessory;
import Items.Equipment.Armour.Armour;
import Items.Equipment.Armour.Bodypart;
import Items.Equipment.Weapon.Weapon;
import java.util.ArrayList;
import java.util.EnumMap;


public class Loadout {
    
    private static final int primarySlot    = 0;
    private static final int secondarySlot  = 1;
    
    private Character character;
    private EnumMap<Bodypart, Armour> armour = new EnumMap<Bodypart, Armour>(Bodypart.class);
    private ArrayList<Accessory> accessory;
    private final int accessorySlots;
    private Weapon[] weapon = new Weapon[2];
    
    
    public Loadout(final Character ch, final int accessorySlots) {
        this.character = ch;
        this.accessorySlots = accessorySlots;
        this.accessory = new ArrayList<Accessory>(accessorySlots);
    }
    
    public Accessory equip(final Accessory ac, final int slotIndex) {
        if (slotIndex > accessorySlots) {
            assert false;
            return null;
        }
        Accessory temp = accessory.get(slotIndex);
        accessory.add(slotIndex, ac);
        this.notifyChange();
        return temp;
    }
    
    public Armour equip(final Armour arm) {
        Armour temp = armour.get(arm.getBodypart());
        armour.put(arm.getBodypart(), arm);
        this.notifyChange();
        return temp;
    }
    
    public Weapon[] equip(final Weapon weap, final boolean primary) {
        final Weapon[] temp;
        if(weap.isTwoHanded()) {
            temp = weapon.clone();
            weapon[primarySlot]     = weap;
            weapon[secondarySlot]   = null;
        } else {
            if (primary) {
                temp = new Weapon[] {weapon[primarySlot]};
                weapon[primarySlot]     = weap;
                weapon[secondarySlot]   = null;
            } else {
                temp = new Weapon[] {weapon[secondarySlot]};
                weapon[primarySlot]     = null;
                weapon[secondarySlot]   = weap;
            }
        }
        this.notifyChange();
        return temp;
    }
    
    public Weapon getWeapon(final boolean primary) {
        return primary ? weapon[primarySlot] : weapon[secondarySlot];
    }
    
    public Weapon[] getWeapons() {
        return weapon.clone();
    }
    
    public Accessory getAccessory(final int slotIndex) {
        return accessory.get(slotIndex);
    }
    
    public Armour getArmour(final Bodypart bp) {
        return armour.get(bp);
    }
    
    protected ArrayList<Accessory> getAccessories() {
        return accessory;
    }
    
    
    private void notifyChange() {
        character.onEquipmentChange();
    }
    
}
