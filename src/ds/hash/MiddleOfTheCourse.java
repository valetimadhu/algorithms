package ds.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiddleOfTheCourse {

	public static String findMiddle(String[][] courses) {
		Map<String,String> map = constructMap(courses);
		String from = findStartingPoint(map);
		
		List<String> orderedCourses = new ArrayList<String>();
		
		orderedCourses.add(from);
		int cntr=0;
		String key= from;
		while(cntr < courses.length) {
			orderedCourses.add(map.get(key));
			key = map.get(key);
			cntr ++;
		}
		orderedCourses.forEach(s -> System.out.println(s));
		return orderedCourses.get(orderedCourses.size() /2);
	}
	
	public static Map<String,String > constructMap(String[][] courses){
		Map<String,String> map = new HashMap<>();
		for(int i=0; i< courses.length; i++) {
			for(int j=0; j< courses[i].length; j++) {
				map.put(courses[i][0], courses[i][1]);
			}
		}
		return map;
	}
	
	public static String findStartingPoint(Map<String,String> map) {
		Map<String,String> reverseMap = new HashMap<>();
		for(Map.Entry<String,String> entry: map.entrySet()) {
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		String starting = null;
		int cnt =0;
		for(Map.Entry<String,String> entry: map.entrySet()) {
			if(!reverseMap.containsKey(entry.getKey())) {
				cnt++;
				starting = entry.getKey();
				
			}
		}
		if(cnt > 1) return null;
		
		return starting;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] courses = {{"NewYork","Chicago"}, {"Boston","Texas"}, {"Missouri","NewYork"},{"Texas","Missouri"}};
		System.out.println(findMiddle(courses));
	}

}
