package Character;


public enum BaseStats {
    
    HUMAN   (10, 10, 10, 10, 10, 10, 10, 10), 
    ORK     (15, 5, 5, 15, 5, 15, 15, 5), 
    SKELETON(5, 15, 10, 10, 10, 10, 5, 15);
    
    
    private final int strength;
    private final int intelligence;
    private final int dexterity;
    private final int hitpoints;
    private final int agility;
    private final int condition;
    
    private final int physicalArmour;
    private final int magicalArmour;
        
    
    private BaseStats(int str, int intel, int dex, int hp, int ag, int con, int pa, int ma) {
        this.strength = str;
        this.intelligence = intel;
        this.dexterity = dex;
        this.hitpoints = hp;
        this.agility = ag;
        this.condition = con;
        this.physicalArmour = pa;
        this.magicalArmour = ma;
    }
    
    
    protected int getStrength() {
        return strength;
    }
    
    protected int getIntelligence() {
        return intelligence;
    }
    
    protected int getDexterity() {
        return dexterity;
    }
    
    protected int getHitpoints() {
        return hitpoints;
    }
    
    protected int getAgility() {
        return agility;
    }
    
    protected int getCondition() {
        return condition;
    }
    
    protected int getPhysicalArmour() {
        return physicalArmour;
    }
    
    protected int getMagicalArmour() {
        return magicalArmour;
    }
    
    
}
