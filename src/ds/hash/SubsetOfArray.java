package ds.hash;

import java.util.HashSet;

public class SubsetOfArray {

	public static boolean isSubset(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i: arr1) {
			if(!set.contains(i)) {
				set.add(i);
			}
		}
		for(int j: arr2) {
			if(!set.contains(j)) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
	    int[] arr2 = {7, 1, -2};
	    int[] arr3 = {10, 12};

	    System.out.println(isSubset(arr1, arr2));
	    System.out.println(isSubset(arr1, arr3));

	}

}
