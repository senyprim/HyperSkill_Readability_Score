package readability.index;

import java.util.HashMap;
import java.util.Map;

public class AgeIndex {
    private static final Map<Integer,AgeIndexData> readabilityAge;
    static {
        readabilityAge=new HashMap<>();
        readabilityAge.put(1,new AgeIndexData(5,6,	"Kindergarten"));
        readabilityAge.put(2,new AgeIndexData(6,7,	"First/Second Grade"));
        readabilityAge.put(3,new AgeIndexData(7,9,	"Third Grade"));
        readabilityAge.put(4,new AgeIndexData(9,10,	"Fourth Grade"));
        readabilityAge.put(5,new AgeIndexData(10,11,	"Fifth Grade"));
        readabilityAge.put(6,new AgeIndexData(11,12,	"Sixth Grade"));
        readabilityAge.put(7,new AgeIndexData(12,13,	"Seventh Grade"));
        readabilityAge.put(8,new AgeIndexData(13,14,	"Eighth Grade"));
        readabilityAge.put(9,new AgeIndexData(14,15,	"Ninth Grade"));
        readabilityAge.put(10,new AgeIndexData(15,16,	"Tenth Grade"));
        readabilityAge.put(11,new AgeIndexData(16,17,	"Eleventh Grade"));
        readabilityAge.put(12,new AgeIndexData(17,18,	"Twelfth grade"));
        readabilityAge.put(13,new AgeIndexData(18,24,	"College student"));
        readabilityAge.put(14,new AgeIndexData(24,Integer.MAX_VALUE,	"Professor"));
    }
    public static AgeIndexData getAgeIndex(int index){
        return readabilityAge.get(index);
    }
    public static AgeIndexData getAgeIndex(double index){
        return getAgeIndex((int)Math.round(index));
    }
}
