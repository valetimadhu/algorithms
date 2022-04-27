package ds.hash;

import java.util.HashSet;

public class DisjointArray {

	public static boolean isDisjoint(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i: arr1) {
			if(!set.contains(i)) {
				set.add(i);
			}
		}
		
		for(int j: arr2) {
			if(set.contains(j)) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
	    int[] arr2 = {7, 10, 8};
	    int[] arr3 = {1, 12};
	    System.out.println(isDisjoint(arr1, arr2));
	    System.out.println(isDisjoint(arr1, arr3));
	}

}
