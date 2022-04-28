package java8;

import java.util.Arrays;
import java.util.List;

public class StringTest {

	public static List<String> splitWords(String str){
		List<String> countriesList = Arrays.asList(str.split(" ",-1));
		return countriesList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String str:splitWords("Madhu sudhana Rao Valeti")) {
			System.out.println(str);
		}
	}

}
