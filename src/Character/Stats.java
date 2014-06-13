package Character;


public class Stats {
    
    private final BaseStats base;
    private Religion religion;
    
    private int equipmentMovementSpeed = 0;
    private int equipmentWeaponDamage = 0;
    private int equipmentPhysicalArmour = 0;
    private int equipmentMagicalArmour = 0;
    private int equipmentAttackSpeed = 0;
    private int equipmentMagicEfficiency = 1;
    
    private int strength = 0;
    private int intelligence = 0;
    private int dexterity = 0;
    private int hitpoints = 0;
    private int agility = 0;
    private int condition = 0;
    private int magicEfficiency = 1;

    
    public Stats(BaseStats base) {
        this.base = base;
    }
    
    
    public Religion getReligion() {
        return religion;
    }
    
    public int getStrength() {
        return base.getStrength() + religion.getStrength() + strength;
    }
    
    public int getIntelligence() {
        return base.getIntelligence() + religion.getIntelligence() + intelligence;
    }
    
    public int getDexterity() {
        return base.getDexterity() + religion.getDexterity() + dexterity;
    }
    
    public int getHitpoints() {
        return base.getHitpoints() + religion.getHitpoints() + hitpoints;
    }
    
    public int getAgility() {
        return base.getAgility() + religion.getAgility() + agility;
    }
    
    public int getCondition() {
        return base.getCondition() + religion.getCondition() + condition;
    }
    
    public int getMovementSpeed() {
        return this.getAgility() + equipmentMovementSpeed;
    }

    public int getWeaponDamageBonus() {
        return this.getStrength() + equipmentWeaponDamage;
    }
    
    public int getMagicEfficiency() {
        return this.getIntelligence() * equipmentMagicEfficiency * magicEfficiency;
    }

    public int getPhysicalArmour() {
        return base.getPhysicalResistance() + equipmentPhysicalArmour;
    }

    public int getMagicalArmour() {
        return base.getMagicalResistance() + equipmentMagicalArmour;
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
    
    protected void setEquipmentMagicEfficiency(int value) {
        equipmentMagicEfficiency = value;
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
    
    protected void setStrength(int value) {
        this.strength = value;
    }
    
    protected void setIntelligence(int value) {
        this.intelligence = value;
    }
    
    protected void setDexterity(int value) {
        this.dexterity = value;
    }
    
    protected void setHitpoints(int value) {
        this.hitpoints = value;
    }
    
    protected void setAgility(int value) {
        this.agility = value;
    }
    
    protected void setCondition(int value) {
        this.condition = value;
    }
    
    protected void setMagicEfficiency(int value) {
        this.magicEfficiency = value;
    }
    
    protected void setReligion(Religion religion) {
        this.religion = religion;
    }
    
}
