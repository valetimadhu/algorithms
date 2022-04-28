package algorithm.dynamic;

import java.util.HashMap;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		
		
		int windowStart =0;
		int maxLength =0;
		HashMap<Character, Integer> charMap = new HashMap<>();
		for(int windowend =0; windowend < str.length() ; windowend++) {
			char rightchar = str.charAt(windowend);
			charMap.put(rightchar, charMap.getOrDefault(rightchar, 0)+1);
			while(charMap.size() > k) {
				char leftchar = str.charAt(windowStart);
				charMap.put(leftchar, charMap.get(leftchar) -1);
				if(charMap.get(leftchar) ==0) {
					charMap.remove(leftchar);
				}
				windowStart++;
			}
			
			maxLength = Math.max(maxLength, windowend-windowStart+1);
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
	}

}
