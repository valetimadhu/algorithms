package ds.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckPath {
	
	public static String tracePath(Map<String,String> map) {
		String path= new String();
		//Find the starting point
		String from = startingPoint(map);
		if(null != from) {
			String to = map.get(from);
			while(to != null) {
				path += from + "-->"+ to + "--> ";
				from =to;
				to = map.get(to);
			}
		}
		return path;
	}
	
	/*
	 * 
	 */
	static String startingPoint(Map<String,String> map) {
		HashMap<String,String> reverseMap = new HashMap<String,String>();
		String from = null;
		for(Map.Entry<String,String> entry: map.entrySet()) {
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		int count =0;
		for(Map.Entry<String,String> entry: map.entrySet()) {
			if(!reverseMap.containsKey(entry.getKey())) {
				count++;
				from = entry.getKey();
			}
		}
		if(count >1 ) return null;
		return from;
	}

	static String startingPointBF(String[][] cities) {
		List<City> citiesList = new ArrayList<>();
		String starting ="";
		for(int i=0; i< cities.length; i++) {
			for(int j=0; j<2; j++) {
				citiesList.add(new City(cities[i][0], cities[i][1]));
			}
		}
		boolean match = false;
		for(City first: citiesList) {
			match = false;
			for(City second : citiesList) {
				if( first.starting == second.end ) {
					match = true;
					break;
				}
				
			}
			if(!match) return first.starting;
		}
		return starting;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("NewYork","Chicago");
		map.put("Boston","Texas");
		map.put("Missouri","NewYork");
		map.put("Texas","Missouri");
		System.out.println(tracePath(map));
		
		String[][] cities = {{"NewYork","Chicago"}, {"Boston","Texas"}, {"Missouri","NewYork"},{"Texas","Missouri"}};
		System.out.println(" Starting point using strings array :"+startingPointBF(cities));
		
	}

}
class City {
	String starting;
	String end;
	public City(String s, String e) {
		this.starting =s;
		this.end = e;
	}
	
}
