package Items;

import Utilities.Randomizer;


public enum Quality {
   
    COMMON((byte)50), UNCOMMON((byte)75), RARE((byte)90), 
    EPIC((byte)97), LEGENDARY((byte)100), UNIQUE(Byte.MAX_VALUE);
    
    
    private final byte rank;
    
    private Quality(byte rank) {
        this.rank = rank;
    }
    
    private byte getRank() {
        return rank;
    }
       
    public static Quality getRandomQuality(Quality maxQ) {
        byte rating = (byte)Randomizer.getRandomNumber(maxQ.getRank() + 1);
        assert (rating <= maxQ.getRank());
        
        if (rating <= Quality.COMMON.getRank()) {
            return Quality.COMMON;
        } else if (rating <= Quality.UNCOMMON.getRank()) {
            return Quality.UNCOMMON;
        } else if (rating <= Quality.RARE.getRank()) {
            return Quality.RARE;
        } else if (rating <= Quality.EPIC.getRank()) {
            return Quality.EPIC;
        } else if (rating <= Quality.LEGENDARY.getRank()) {
            return Quality.LEGENDARY;
        } else {
            assert false;
            return null;
        }
    }
    
    public static Quality getRandomQuality() {
        return getRandomQuality(Quality.LEGENDARY);
    }
       
}
