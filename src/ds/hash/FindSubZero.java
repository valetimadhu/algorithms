package ds.hash;

import java.util.HashMap;

public class FindSubZero {

	public static boolean findSubZero(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0 || arr[i] == 0 || map.get(sum) != null)
				return true;
			map.put(sum, i);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 4, -7, 3, 12, 9 };
		int[] arr2 = { 6, 4, -7, 5, 12, 9 };
		System.out.println(findSubZero(arr));
		System.out.println(findSubZero(arr2));
	}

}
