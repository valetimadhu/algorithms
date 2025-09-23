package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringTest {

	public static List<String> splitWords(String str){
		List<String> countriesList = Arrays.asList(str.split(" ",-1));
		return countriesList;
	}
	
	public static int methodA(int i) {
		return i +10;
	}
	public static String methodA(String s) {
		return s;
	}
	
	public  String doReverse(String input) {
		String output;
		int strLength = input.length();
		StackR stackR=new StackR(strLength);
		for(int i=0; i< strLength; i++)
			stackR.push(input.charAt(i));
		output =" ";
		while(!stackR.isEmpty())
			output += stackR.pop();
		return output.trim();
	}
	
	public static List<String> maxCharLengthList(List<String> list){
		
		//find out maximum length 
		int maxLength = list.stream().mapToInt(String::length).max().orElse(0);
		
		return list.stream().filter(str -> str.length() == maxLength).collect(Collectors.toList());
		
	}
	
	public static String largestGoodIntegerUsingRegEx(String num) {
		String result = null;
		String regex = "(\\d)\\1{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(num);
		
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		while(matcher.find()) {
			set.add(Integer.valueOf(matcher.group()));
		}
		if(!set.isEmpty()) {
			for(Integer number: set) {
				result = String.valueOf(number);
				break;
				
			}
		}
		
		return result;
		
	}
	
	public static String largestGoodIntegerUsingStreams(String num) {

		Pattern pattern = Pattern.compile("(\\d)\\1{2}");
		Matcher matcher = pattern.matcher(num);
		
		return matcher.results().map(MatchResult::group)
				.map(Integer::valueOf)
				.max(Integer::compareTo)
				.map(String::valueOf)
				.orElse(null);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for(int i=0; i< nums.length-1; i++) {
			for(int j=1; j<= nums.length-1; j++) {
				if(nums[i]+ nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
        
    }
	
	public static int[] twoSumUsingMap(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			int complement = target- nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement),i};
			}
			
			map.put(nums[i],i);
			
		}
		
		return new int[0];
		
	}
	
	public static void main(String[] args) {
		StringTest test = new StringTest();
		String in = "abcdefgheggehgfedcba";

		if(in.equalsIgnoreCase(test.doReverse(in))) {
			System.out.println(" Palindrome"); 
		}else {
			System.out.println("not palindrome"); 
		}
		
		List<String> list = new ArrayList<>(List.of("ab", "bc", "ca", "abcd", "defg", "lmnt", "cdef", "abe", "a", "b"));
		
		List<String> maxList = maxCharLengthList(list);
		
		for(String str: maxList) {
			//System.out.println(str);
		}
		
		//System.out.println(largestGoodIntegerUsingStreams("6777133339"));
		int[] nums = {2,3,5,6,7,8,1,9};
		int[] result = twoSum(nums , 15);
		for(int i: result) {
			System.out.println(i);
		}
		int[] result2 = twoSumUsingMap(nums , 15);
		for(int i: result2) {
			System.out.println(i);
		}
		
		
		
	}

}

class StackR{
	private int maxLength;
	private char[] stackArray;
	private int top;
	
	public StackR(int max) {
		maxLength = max;
		stackArray = new char[maxLength];
		top = -1;
	}
	
	public void push(char c) {
		stackArray[++top] = c;
	}

	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
}
