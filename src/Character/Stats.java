package Character;


public class Stats {
    
    private final BaseStats base;
    private int equipmentMovementSpeed;
    private int equipmentWeaponDamage;
    private int equipmentSpellDamage;
    private int equipmentPhysicalArmour;
    private int equipmentMagicalArmour;
    private int equipmentAttackSpeed;
    
    private int strength;
    private int intelligence;
    private int dexterity;
    private int hitpoints;
    private int agility;
    private int condition;

    
    public Stats(BaseStats base) {
        this.base = base;
    }
    
    
    public int getStrength() {
        return base.getStrength() + strength;
    }
    
    public int getIntelligence() {
        return base.getIntelligence() + intelligence;
    }
    
    public int getDexterity() {
        return base.getDexterity() + dexterity;
    }
    
    public int getHitpoints() {
        return base.getHitpoints() + hitpoints;
    }
    
    public int getAgility() {
        return base.getAgility() + agility;
    }
    
    public int getCondition() {
        return base.getCondition() + condition;
    }
    
    public int getMovementSpeed() {
        return base.getAgility() + equipmentMovementSpeed;
    }

    public int getWeaponDamage() {
        return this.getStrength() + equipmentWeaponDamage;
    }
    
    public int getSpellDamage() {
        return this.getIntelligence() + equipmentSpellDamage;
    }

    public int getPhysicalArmour() {
        return base.getPhysicalArmour() + equipmentPhysicalArmour;
    }

    public int getMagicalArmour() {
        return base.getMagicalArmour() + equipmentMagicalArmour;
    }

    public int getAttackSpeed() {
        return this.getDexterity() + equipmentAttackSpeed;
    }
    
    protected void setEquipmentMovementSpeed(int value) {
        equipmentMovementSpeed = value;
    }
    
    protected void setEquipmentWeaponDamage(int value) {
        equipmentWeaponDamage = value;
    }
    
    protected void setEquipmentSpellDamage(int value) {
        equipmentSpellDamage = value;
    }
    
    protected void setEquipmentPhysicalArmour(int value) {
        equipmentPhysicalArmour = value;
    }
    
    protected void setEquipmentMagicalArmour(int value) {
        equipmentMagicalArmour = value;
    }
    
    protected void setEquipmentAttackSpeed(int value) {
        equipmentAttackSpeed = value;
    }
    
    
}
