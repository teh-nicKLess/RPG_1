package Character;


public enum BaseStats {
    
    HUMAN   (10, 10, 10, 10, 10, 10, 100, 10, 10), 
    ORK     (15, 5,  5,  20, 5,  15, 80,  15, 5), 
    SKELETON(5,  15, 10, 5,  10, 10, 120, 5,  15);
    
    
    private final int strength;
    private final int intelligence;
    private final int dexterity;
    private final int hitpoints;
    private final int agility;
    private final int condition;
    private final int magicEfficiency;
    
    private final int physicalResistance;
    private final int magicalResistance;
        
    
    private BaseStats(int str, int intel, int dex, int hp, int ag, int con, int me, int pa, int ma) {
        this.strength = str;
        this.intelligence = intel;
        this.dexterity = dex;
        this.hitpoints = hp;
        this.agility = ag;
        this.condition = con;
        this.magicEfficiency = me;
        this.physicalResistance = pa;
        this.magicalResistance = ma;
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
    
    protected int getMagicEfficiency() {
        return magicEfficiency;
    }
    
    protected int getPhysicalResistance() {
        return physicalResistance;
    }
    
    protected int getMagicalResistance() {
        return magicalResistance;
    }
    
    
}
