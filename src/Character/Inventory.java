package Character;

import Items.Item;


public class Inventory {
    
    private static final int defaultRows = 10;
    private static final int defaultColumns = 10;
    
    private final Item[][] inv;
    
    
    public Inventory() {
        this(defaultRows, defaultColumns);
    }
    
    public Inventory(int rows, int columns) {
        inv = new Item[rows][columns];
    }
    
    public Item[][] getInventory() {
        return inv.clone();
    }
    
    public Item getItem(int row, int column) {
        return inv[row][column];
    }
    
    public Item setItem(Item item, int row, int column) {
        Item temp = inv[row][column];
        inv[row][column] = item;
        return temp;
    }
    
    
}
