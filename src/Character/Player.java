package Character;


public class Player extends Character {

    
    public Player(BaseStats bs, int accessorySlots) {
        this.setStats(bs);
        this.setLoadout(new Loadout(this, accessorySlots));
        this.addInventory(new Inventory());
    }
    
}
