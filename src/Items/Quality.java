package Items;

import Utilities.Randomizer;


public enum Quality {
   
    COMMON((byte)50), UNCOMMON((byte)75), RARE((byte)90), 
    EPIC((byte)97), LEGENDARY((byte)100), UNIQUE(Byte.MAX_VALUE);
    
    
    private final byte rank;
    
    private Quality(final byte rank) {
        this.rank = rank;
    }
    
    private byte getRank() {
        return rank;
    }
     
    /**
     * returns a random Quality [COMMON, maxQ] - unique NOT included
     * @param maxQ the best outcome of the random draft (upper bound)
     * @return a random Quality (not Unique)
     */
    public static Quality getRandomQuality(final Quality maxQ) {
        if (maxQ.equals(UNIQUE)) {
            throw new IllegalArgumentException("No random uniques!");
        }
        final byte rating = (byte)Randomizer.getRandomNumberNIncluded(maxQ.getRank());
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
    
    /**
     * returns a random Quality [COMMON, LEGENDARY] - unique NOT included
     * @return a random Quality
     */
    public static Quality getRandomQuality() {
        return getRandomQuality(Quality.LEGENDARY);
    }
       
}
