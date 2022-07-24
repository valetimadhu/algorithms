package ds.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNonRepeat {

	public static int findFirstUnique(int[] arr) {
		int result=0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i< arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		for(int j=0; j< arr.length; j++) {
			if(map.get(arr[j]) == 0) return arr[j];
		}
		return result;
	}
	
	public static char findFirstUnique(String str){
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0; i< str.length(); i++) {
			char ch = str.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(ch,1);
			}else{
				map.put(ch,map.get(ch)+1);
			}
		}
		for(HashMap.Entry<Character,Integer>  entry : map.entrySet()){
		if(entry.getValue() ==1 ) return entry.getKey();
		}
		return ' ';
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);
        System.out.print("First Unique in an String: " + findFirstUnique("madhu"));

	}

}
