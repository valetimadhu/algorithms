package java8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRCache {
	
	private int capacity;
	List<Integer> list = new LinkedList<>();
	Map<Integer, String> map = new HashMap<>();
	
	public LRCache(int capacity) {
		this.capacity = capacity;
		
	}
	
	public void put(int key, String str) {
		
		if(list.size() >= capacity) {
			list.removeLast();
			map.remove(key);
		}
		map.put(key, str);
		list.addFirst(key);
		
	}

	public String get(int key) {
		if(map.containsKey(key)) {
			list.remove((Object)key);
			list.addFirst(key);
			return map.get(key);
		} else {
			return null;
		}
		 
	}
	// display method
		public void display() {

			for (int i = 0; i < list.size(); i++) {
				int key = list.get(i);
				System.out.println(key + " => " + map.get(key));
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRCache cache = new LRCache(3);
		cache.put(1, "one");
		cache.put(2, "two");
		cache.put(3, "three");
		cache.put(4, "four"); // putting new cache when full. 1 will be removed
		cache.get(3); // accessing 3, it will be moved to top
		cache.get(2);// accessing 2, it will be moved to top
		cache.put(1, "one"); // putting new cache when full. 4 will be removed
		cache.get(3);// accessing 3, it will be moved to top
		cache.get(1);// accessing 1, it will be moved to top
		cache.display(); // 1 should be on top
		/*
		 * output 
		 * 1 => one 
		 * 3 => three 
		 * 2 => two
		 * 
		 **/

	}

}
