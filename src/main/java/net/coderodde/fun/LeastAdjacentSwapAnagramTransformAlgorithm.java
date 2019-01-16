package net.coderodde.fun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This interface defines the API and basic infrastructure for algorithms 
 * returning a shortest list of inversion required to transform one anagram into
 * another.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Jan 5, 2019)
 */
public interface LeastAdjacentSwapAnagramTransformAlgorithm {
    
    /**
     * Encodes an adjacent pair of elements in an array.
     */
    public static final class AdjacentSwapDescriptor {
        
        public final int startingIndex;
        
        public AdjacentSwapDescriptor(int startingIndex) {
            this.startingIndex = startingIndex;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            
            if (!o.getClass().equals(this.getClass())) {
                return false;
            }
            
            AdjacentSwapDescriptor other = (AdjacentSwapDescriptor) o;
            return startingIndex == other.startingIndex;
        }
        
        @Override
        public String toString() {
            return "(" + startingIndex + ", " + (startingIndex + 1) + ")";
        }
    }
    
    /**
     * Finds a shortest sequence of inversion transforming {@code string1} into
     * {@code string2}.
     * 
     * @param string1 the source string.
     * @param string2 the target string.
     * @return the list of inversions transforming the source array into the 
     *         target array.
     */
    public List<AdjacentSwapDescriptor> compute(String string1, String string2);
        
    /**
     * Checks that the two input strings are anagrams.
     * 
     * @param string1 the first string.
     * @param string2 the second string.
     * @return {@code true} if the two input strings are anagrams. {@code false}
     *         otherwise.
     */
    static  boolean areAnagrams(String string1, String string2) {
        Map<Character, Integer> characterCountMap1 = new HashMap<>();
        Map<Character, Integer> characterCountMap2 = new HashMap<>();
        
        for (char c : string1.toCharArray()) {
            characterCountMap1.
                    put(c, characterCountMap1.getOrDefault(c, 0) + 1);
        }
        
        for (char c : string2.toCharArray()) {
            characterCountMap2.
                    put(c, characterCountMap2.getOrDefault(c, 0) + 1);
        }
        
        return characterCountMap1.equals(characterCountMap2);
    }
}