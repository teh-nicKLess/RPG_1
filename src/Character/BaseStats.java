package Character;


public class BaseStats {
    
    private int movementSpeed;
    private int weaponDamage;
    private int physicalArmour;
    private int magicalArmour;
    private int attackSpeed;
    
    
    protected int getMovementSpeed() {
        return movementSpeed;
    }
    
    protected int getWeaponDamage() {
        return weaponDamage;
    }
    
    protected int getPhysicalArmour() {
        return physicalArmour;
    }
    
    protected int getMagicalArmour() {
        return magicalArmour;
    }
    
    protected int getAttackSpeed() {
        return attackSpeed;
    }
    
}
