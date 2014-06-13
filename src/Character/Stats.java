package Character;


public class Stats {
    
    private final BaseStats base;
    private int equipmentMovementSpeed = 0;
    private int equipmentWeaponDamage = 0;
    private int equipmentSpellDamage = 0;
    private int equipmentPhysicalArmour = 0;
    private int equipmentMagicalArmour = 0;
    private int equipmentAttackSpeed = 0;
    
    private int strength = 0;
    private int intelligence = 0;
    private int dexterity = 0;
    private int hitpoints = 0;
    private int agility = 0;
    private int condition = 0;

    
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

    public int getWeaponDamageBonus() {
        return this.getStrength() + equipmentWeaponDamage;
    }
    
    public int getSpellDamageBonus() {
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
