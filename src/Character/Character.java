package Character;

import Items.Equipment.Accessory.Accessory;
import Items.Equipment.Armour.Bodypart;
import Items.Equipment.Equipment;
import Items.Equipment.MagicAttribute;
import Items.Equipment.Weapon.Weapon;
import java.util.ArrayList;
import java.util.EnumMap;


public abstract class Character {
    
    private final static ArrayList<MagicAttribute> movementSpeedAttr = new ArrayList<MagicAttribute>(2);
    private final static ArrayList<MagicAttribute> weaponDamageAttr = new ArrayList<MagicAttribute>(2);
    private final static ArrayList<MagicAttribute> spellDamageAttr = new ArrayList<MagicAttribute>(2);
    private final static ArrayList<MagicAttribute> physicalArmourAttr = new ArrayList<MagicAttribute>(2);
    private final static ArrayList<MagicAttribute> magicalArmourAttr = new ArrayList<MagicAttribute>(2);
    private final static ArrayList<MagicAttribute> attackSpeedAttr = new ArrayList<MagicAttribute>(2);
    
    static {
        movementSpeedAttr.add(MagicAttribute.SPEED);
        movementSpeedAttr.add(MagicAttribute.MOVEMENTSPEED);
        
        attackSpeedAttr.add(MagicAttribute.SPEED);
        attackSpeedAttr.add(MagicAttribute.ATTACKSPEED);
        
        weaponDamageAttr.add(MagicAttribute.WEAPONDAMAGE);
        weaponDamageAttr.add(MagicAttribute.DAMAGE);
        
        spellDamageAttr.add(MagicAttribute.SPELLDAMAGE);
        spellDamageAttr.add(MagicAttribute.DAMAGE);
        
        physicalArmourAttr.add(MagicAttribute.ARMOUR);
        physicalArmourAttr.add(MagicAttribute.DAMAGEREDUCTION);
        
        magicalArmourAttr.add(MagicAttribute.DAMAGEREDUCTION);
        magicalArmourAttr.add(MagicAttribute.SPELLRESISTANCE);
    }
    
    private Loadout loadout;
    private ArrayList<Inventory> inv = new ArrayList<Inventory>();
    private Stats stats;
     
    
    public Stats getStats() {
        return stats;
    }
    
    public Loadout getLoadout() {
        return loadout;
    }
    
    public void addInventory(Inventory inv) {
        this.inv.add(inv);
    }
    
    protected ArrayList<Inventory> getInventory() {
        return inv;
    }
    
    protected void setStats(BaseStats bs) {
        if (stats == null) {
            stats = new Stats(bs);
        }
    }
    
    protected void setLoadout(Loadout lo) {
        if (loadout == null) {
            this.loadout = lo;
        }
    }
    
    protected void onEquipmentChange() {
        this.updateMovementSpeed();
        this.updateAttackSpeed();
        this.updateWeaponDamage();
        this.updateSpellDamage();
        this.updatePhysicalArmour();
        this.updateMagicalArmour();
    }
    
    private void updateMovementSpeed() {
        stats.setEquipmentMovementSpeed(this.calculateValueFor(movementSpeedAttr));
    }
    
    private void updateAttackSpeed() {
        stats.setEquipmentAttackSpeed(this.calculateValueFor(attackSpeedAttr));
    }
    
    private void updateWeaponDamage() {
        stats.setEquipmentWeaponDamage(this.calculateValueFor(weaponDamageAttr));
    }
    
    private void updateSpellDamage() {
        stats.setEquipmentSpellDamage(this.calculateValueFor(spellDamageAttr));
    }
    
    private void updatePhysicalArmour() {
        stats.setEquipmentPhysicalArmour(this.calculateValueFor(physicalArmourAttr));
    }
    
    private void updateMagicalArmour() {
        stats.setEquipmentMagicalArmour(this.calculateValueFor(magicalArmourAttr));
    }
    
    private int calculateValueFor(final ArrayList<MagicAttribute> magiType) {
        int value = 0;
        for (Accessory ac : loadout.getAccessories()) {
            value += this.extractValue(ac, magiType);
        } 
        for (Bodypart bp : Bodypart.values()) {
            if (loadout.getArmour(bp) != null) {
                value += this.extractValue(loadout.getArmour(bp), magiType);
            }
        }
        for (Weapon w : loadout.getWeapons()) {
            if (w != null) {
                value += this.extractValue(w, magiType);
            }
        }
        return value;
    }
    
    private int extractValue(final Equipment equip, final ArrayList<MagicAttribute> magiType) {
        int value = 0;
        EnumMap<MagicAttribute, Integer> attributes = equip.getMagicAttributes();
        for (MagicAttribute magi : magiType) {
            if (attributes.containsKey(magi)) {
                value += attributes.get(magi);
            }
        }
        return value;
    }
    
    
}
