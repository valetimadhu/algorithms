package algorithm.dynamic;

import java.util.HashMap;

public class MaxFruitCountOfTwoTypes {
	
	public static int findLength(char[] arr) {
		int windowStart =0;
		int maxLength =0;
		HashMap<Character, Integer> fruitMap = new HashMap<>();
		for(int windowEnd =0; windowEnd < arr.length; windowEnd++) {
			fruitMap.put(arr[windowEnd], fruitMap.getOrDefault(arr[windowEnd],0) +1);
			while(fruitMap.size() > 2) {
				fruitMap.put(arr[windowStart], fruitMap.get(arr[windowStart] -1));
				if(fruitMap.get(arr[windowStart]) == null || fruitMap.get(arr[windowStart]) ==0 ) {
					fruitMap.remove(arr[windowStart]);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Maximum number of fruits: " + 
                MaxFruitCountOfTwoTypes.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
System.out.println("Maximum number of fruits: " + 
                MaxFruitCountOfTwoTypes.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

	}

}
