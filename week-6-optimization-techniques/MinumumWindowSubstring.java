package week6optimizationTechniques;

import java.util.HashMap;

public class MinumumWindowSubstring {
	
	public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        
        int sLen = s.length(), tLen = t.length();
        
        // create hashtable to second string
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        
        int minLength = Integer.MAX_VALUE, count = 0;
        int[] window = new int[2];
        window[0] = -1; window[1] = -1;
        for (int l = 0, r = 0; r < sLen; r++) {
            char c = s.charAt(r);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            
                if (map.get(c) >= 0)
                count++;
            
            }
            
            while (count == tLen) {
                // record minWindowLength
                int windowLen = r-l+1;
                if (windowLen < minLength) {
                    minLength = windowLen;
                    window[0] = l; window[1] = r;            
                }
                
                // advance l
                char c2 = s.charAt(l);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2)+1);
                
                    // check count
                    if (map.get(c2) >= 1) // ineligible window
                        count--;
                }
                
                l++;
            } //while
        }
        
        return window[0] == -1 ? "" : s.substring(window[0], window[1]+1);
    } // func

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	} // main
}