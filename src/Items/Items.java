package Items;

public abstract class Items {
    
    private String name;
    private Quality quality;
    
    
    public final String getName() {
        return name;
    }
    
    public final Quality getQuality() {
        return quality;
    } 
        
    protected final void setName(final String name) {
        if (this.name == null && name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } 
    }
    
    protected final void setQuality(final Quality qual) {
        if (quality == null && qual != null) {
            this.quality = qual;
        }
    }
    
}
