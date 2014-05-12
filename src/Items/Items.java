package Items;

public abstract class Items {
    
    private String name;
    private Quality quality;
    
    
    public final String getName() {
        return name;
    }
    
    protected final void setName(String name) {
        if (this.name == null) {
            this.name = name.trim();
        }
    }
    
    public final Quality getQuality() {
        return quality;
    } 
    
    protected final void setQuality(Quality qual) {
        if (quality == null) {
            this.quality = qual;
        }
    }
    
}
