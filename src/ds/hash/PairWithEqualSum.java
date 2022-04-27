package ds.hash;

import java.util.HashMap;
import java.util.Map;

public class PairWithEqualSum {

	
	public static String findPair(int[] arr) {
		String result = "";
		Map<Integer, int[]> map = new HashMap<>();
	
		for(int i=0; i< arr.length; i++) {
			for(int j=i+1; j< arr.length; j++) {
				int sum = arr[i] + arr[j];
				if(!map.containsKey(sum)) {
					map.put(sum, new int[] {arr[i],arr[j]});
				}
				else{
					int[] prevPair = map.get(sum);
					result += prevPair[0]+"  "+prevPair[1]+"  "+arr[i]+"  "+arr[j];
					return result;
				}
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 4, 7, 1, 12, 9};
	     System.out.println(findPair(arr));
	}

}

;