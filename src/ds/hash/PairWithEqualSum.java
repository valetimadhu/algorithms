package ds.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairWithEqualSum {

	public static String findPair(int[] arr) {
		String result = "";
		Map<Integer, int[]> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (!map.containsKey(sum)) {
					map.put(sum, new int[] { arr[i], arr[j] });
				} else {
					int[] prevPair = map.get(sum);
					result += prevPair[0] + "  " + prevPair[1] + "  " + arr[i] + "  " + arr[j];
					return result;
				}
			}
		}
		return result;

	}

	private static String arrayPair(int[] arr) {
		// map--> (sum, List<int[]>
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		StringBuilder pair = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (!map.containsKey(sum)) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);
					map.put(sum, list);
				} else {
					map.get(sum).add(arr[i]);
					map.get(sum).add(arr[j]);
					for (Integer s : map.get(sum)) {
						pair.append(s);
						pair.append(" ");
					}
					return pair.toString();
				}
			}
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 4, 7, 1, 12, 9 };
		System.out.println(findPair(arr));
		System.out.println(arrayPair(arr));
	}

}

;