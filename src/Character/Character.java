package Character;

import Items.Equipment.Accessory.Accessory;
import Items.Equipment.Armour.Bodypart;
import Items.Equipment.MagicAttribute;
import java.util.ArrayList;
import java.util.EnumMap;


public abstract class Character {
    
    private final static ArrayList<MagicAttribute> movementSpeedAttr = new ArrayList<MagicAttribute>();
    private final static ArrayList<MagicAttribute> weaponDamageAttr = new ArrayList<MagicAttribute>();
    private final static ArrayList<MagicAttribute> physicalArmourAttr = new ArrayList<MagicAttribute>();
    private final static ArrayList<MagicAttribute> magicalArmourAttr = new ArrayList<MagicAttribute>();
    private final static ArrayList<MagicAttribute> attackSpeedAttr = new ArrayList<MagicAttribute>();
    
    static {
        movementSpeedAttr.add(MagicAttribute.SPEED);
        movementSpeedAttr.add(MagicAttribute.MOVEMENTSPEED);
        
        attackSpeedAttr.add(MagicAttribute.SPEED);
        attackSpeedAttr.add(MagicAttribute.ATTACKSPEED);
        
        weaponDamageAttr.add(MagicAttribute.WEAPONDAMAGE);
        weaponDamageAttr.add(MagicAttribute.DAMAGE);
        
        physicalArmourAttr.add(MagicAttribute.ARMOUR);
        physicalArmourAttr.add(MagicAttribute.DAMAGEREDUCTION);
        
        magicalArmourAttr.add(MagicAttribute.DAMAGEREDUCTION);
        magicalArmourAttr.add(MagicAttribute.SPELLRESISTANCE);
    }
    
    private Loadout loadout;
    private ArrayList<Inventory> inv;
    private BaseStats baseStats;
    private int movementSpeed;
    private int weaponDamage;
    private int physicalArmour;
    private int magicalArmour;
    private int attackSpeed;

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getPhysicalArmour() {
        return physicalArmour;
    }

    public int getMagicalArmour() {
        return magicalArmour;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    protected Loadout getLoadout(){
        return loadout;
    }
    
    protected ArrayList<Inventory> getInventory() {
        return inv;
    }
    
    protected void onEquipmentChange() {
        this.updateMovementSpeed();
        this.updateAttackSpeed();
        this.updateWeaponDamage();
        this.updatePhysicalArmour();
        this.updateMagicalArmour();
    }
    
    private void updateMovementSpeed() {
        movementSpeed = baseStats.getMovementSpeed();
        movementSpeed += this.calculateValueFor(movementSpeedAttr);
    }
    
    private void updateAttackSpeed() {
        attackSpeed = baseStats.getAttackSpeed();
        attackSpeed += this.calculateValueFor(attackSpeedAttr);
    }
    
    private void updateWeaponDamage() {
        weaponDamage = baseStats.getWeaponDamage();
        weaponDamage += this.calculateValueFor(weaponDamageAttr);
    }
    
    private void updatePhysicalArmour() {
        physicalArmour = baseStats.getPhysicalArmour();
        physicalArmour += this.calculateValueFor(physicalArmourAttr);
    }
    
    private void updateMagicalArmour() {
        magicalArmour = baseStats.getMagicalArmour();
        magicalArmour += this.calculateValueFor(magicalArmourAttr);
    }
    
    private int calculateValueFor(ArrayList<MagicAttribute> magiType) {
        int temp = 0;
        for (Accessory ac : loadout.getAccessories()) {
            EnumMap<MagicAttribute, Integer> attributes = ac.getMagicAttributes();
            for (MagicAttribute magi : magiType) {
                if (attributes.containsKey(magi)) {
                    temp += attributes.get(magi);
                }
            }
        } 
        for (Bodypart bp : Bodypart.values()) {
            EnumMap<MagicAttribute, Integer> attributes = loadout.getArmour(bp).getMagicAttributes();
            for (MagicAttribute magi : magiType) {
                if (attributes.containsKey(magi)) {
                    temp += attributes.get(magi);
                }
            }
        }
        EnumMap<MagicAttribute, Integer> primAttributes = loadout.getWeapon(true).getMagicAttributes();
        for (MagicAttribute magi : magiType) {
            if (primAttributes.containsKey(magi)) {
                temp += primAttributes.get(magi);
            }
        }
        EnumMap<MagicAttribute, Integer> secAttributes = loadout.getWeapon(false).getMagicAttributes();
        for (MagicAttribute magi : magiType) {
            if (secAttributes.containsKey(magi)) {
                temp += secAttributes.get(magi);
            }
        }
        
        return temp;
    }
    
    
}
