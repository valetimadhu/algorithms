package ds.hash;

import java.util.HashMap;

public class SymmetricPair {

	public static String findSymmetric(int[][] arr) {
		String result =" ";
		HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
		for(int i=0; i< arr.length; i++) {
			int first = arr[i][0];
			int second = arr[i][1];
			Integer value = map.get(second);
			
			if(value != null && value == first) {
				result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
			}else {
			map.put(first, second);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2},{3,4},{5,9},{4,3},{9,5}};
		System.out.println(findSymmetric(arr));
	}

}
