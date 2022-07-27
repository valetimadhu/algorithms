package ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParentChildPairs {

	public static Map<Integer,Set<Integer>> findNodeswithOneOrTwoParents(List<Pair> pairsList) {
		Map<Integer,Set<Integer>> parentchildmap = new HashMap<>();
		int parentCount =0;
		for(int i=0; i< pairsList.size(); i++) {
			parentCount =0;
			for(int j=0; j< pairsList.size() ; j++) {
				if(pairsList.get(i).c == pairsList.get(j).c  ) {
					parentCount ++;
						
				}
				if(parentCount >=2) break;
			}
			if(parentCount ==1 ) {
				updateParentChildMap(parentchildmap, 1, pairsList.get(i).c);
			}else if(parentCount ==2) {
				updateParentChildMap(parentchildmap, 2, pairsList.get(i).c);
			}
		}
		
		return parentchildmap;
	}
	
	static void updateParentChildMap(Map<Integer,Set<Integer>> map, int key, int value) {
		if(!map.containsKey(key)) {
			Set<Integer> childList = new HashSet<>();
			childList.add(value);
			map.put(key,childList );
		}else {
			map.get(key).add(value);
			
		}
		
	}
	
	public static Set<Integer> findZeroParents(List<Pair> pairs) {
		Set<Integer> list = new HashSet<Integer>();
		boolean match = false;
		for(Pair first: pairs) {
			match = false;
			for(Pair second: pairs) {
				if(first.p == second.c) {
					match = true;
					break;
				}
			}
			
		if(!match) list.add(first.p);
		}
		return list;
	}
	private static List<Pair> constructPairs(int[][] pcpairs){
		List<Pair> pairs = new ArrayList<>();
		for(int i=0; i< pcpairs.length; i++) {
			Pair pair = new Pair(pcpairs[i][0], pcpairs[i][1]);
			pairs.add(pair);
		}
		return pairs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] parentchildpairs = {{1,3},{2,3}, {3,6}, {5,6}, {15,9}, {5,7}, {4,5} , {4,8}, {4,9}, {9,11}};
		List<Pair> pairList = constructPairs(parentchildpairs);
		for(Integer i: findZeroParents(pairList)) {
			System.out.println(i);
		}
		Iterator it = findNodeswithOneOrTwoParents(pairList).entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
class Pair {
	int p;
	int c;
	
	public Pair(int p, int c) {
		this.p = p;
		this.c = c;
	}
}
