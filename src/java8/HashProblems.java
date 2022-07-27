package java8;

import java.util.HashSet;
import java.util.Set;

public class HashProblems {
	
	static boolean isSubset(int[] arr1, int[] arr2) {
		Set<Integer> hset = new HashSet<Integer>();
		for(int i: arr1) {
			if(!hset.contains(i)) {
				hset.add(i);
			}
		}
		for(int j: arr2) {
			if(!hset.contains(j)) return false;
		}
		return true;
	}
	
	static boolean isDisjoint(int[] arr1, int[] arr2) {
		Set<Integer> hset = new HashSet<Integer>();
		for(int i: arr1) {
			if(!hset.contains(i)) hset.add(i);
		}
		for(int j: arr2) {
			if(hset.contains(j)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
	    int[] arr2 = {7, 1, -2};
	    int[] arr3 = {10, 12};
	    System.out.println(isSubset(arr1, arr2));
	    System.out.println(isSubset(arr1, arr3));
	    System.out.println(isDisjoint(arr1, arr2));
	    System.out.println(isDisjoint(arr1, arr3));
	}

}
