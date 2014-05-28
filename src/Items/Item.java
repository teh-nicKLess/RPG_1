package Items;

public abstract class Item {
    
    private String name;
    private Quality quality;
    
    
    /**
     * returns the item's name
     * @return the item's name 
     */
    public final String getName() {
        return name;
    }
    
    /**
     * returns the item's Quality
     * @return the item's Quality
     */
    public final Quality getQuality() {
        return quality;
    } 
    
    /**
     * sets the item's name
     * @param name - name to set
     */
    protected final void setName(final String name) {
        if (this.name == null && name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } 
    }
    
    /**
     * sets the item's Quality
     * @param qual - Quality to set
     */
    protected final void setQuality(final Quality qual) {
        if (quality == null && qual != null) {
            this.quality = qual;
        }
    }
    
}
