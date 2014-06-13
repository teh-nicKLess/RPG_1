package Character;


public enum Religion {
    
    REL_1   (10, 10, 10, 10, 10, 10, 100), 
    REL_2   (10, 10, 10, 10, 10, 10, 100), 
    REL_3   (10, 10, 10, 10, 10, 10, 100);
    
    
    private final int strength;
    private final int intelligence;
    private final int dexterity;
    private final int hitpoints;
    private final int agility;
    private final int condition;
    private final int magicEfficiency;
    
    
    private Religion(int str, int intel, int dex, int hp, int ag, int con, int me) {
        this.strength = str;
        this.intelligence = intel;
        this.dexterity = dex;
        this.hitpoints = hp;
        this.agility = ag;
        this.condition = con;
        this.magicEfficiency = me;
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
    
}
