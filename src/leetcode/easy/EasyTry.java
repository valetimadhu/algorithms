package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EasyTry {

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
	

	public static String longestCommonPrefix(String[] strs) {
		
		int shortLengthStr = Integer.MAX_VALUE;
		String shortLengthString = null;
		
		for(String str: strs) {
			
			if(str.length() < shortLengthStr) {
				shortLengthStr = str.length();
				shortLengthString = str;
			}
		}
		
		String commonPrefix = "null";

		for(int i= shortLengthStr; i> 0; i--) {
			int matches =0;
			for(String str: strs) {
				if((str.substring(0, i)).equals(shortLengthString.substring(0, i))) {
					matches++;
					if(matches == strs.length) return str.substring(0, i);
				}
			}
		}
		
		return commonPrefix;
        
    }
	
	public static String longestCommonPrefixBest(String[] strs) {
		
		if(null == strs || strs.length ==0) return "null";
		
		String prefix = strs[0];
		
		for(int i=1; i< strs.length; i++) {
			
			while(!strs[i].startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length()-1);
				if( prefix.isEmpty()) return "null";
			}
			
		}
		return prefix;
		
	}

	/*
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true
	 */
	public static boolean isValidparenthesis(String s) {
			if(s.isEmpty() || s.length() %2 != 0) return false;
			Stack<Character> stack = new Stack<>();
			for(char c: s.toCharArray()) {
				switch(c) 
				{
				case '(' : 
	           
				case '{' :            
	             
				case '[' :            
	                stack.push(c);
	                break;
				case ')' : 
					if (stack.isEmpty() || stack.pop() != '(') {
	                        return false; // Mismatch or no opening bracket
	                    }
	                    break;
				case '}' :
				   if(stack.isEmpty() || stack.pop() != '{'){
	                return false;
	               }
	               break;
				case ']' : 
	                if(stack.isEmpty() || stack.pop() != '[') return false;
	                break;

					default: break;
				}
			}
			return stack.isEmpty();
    }
	/*
	 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
	 */
	public int removeDuplicates(int[] nums) {
		
	    if(nums.length ==0) return 0;
	    int k=1;
	    
	    for(int i=1; i< nums.length; i++) {
	    	if(nums[i] != nums[i-1]) {
	    		nums[k] = nums[i];
	    		k++;
	    	}
	    }
	    return k;
	    }
	
public static int strStr(String haystack, String needle) {
	
	if(needle.length() ==0) return 0;
//	
//	Pattern pattern = Pattern.compile(needle);
//	Matcher matcher = pattern.matcher(haystack);
//	
//	return matcher.find() ? matcher.start(): -1;
	
	return haystack.indexOf(needle);
	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs= new String[]{"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
		System.out.println(longestCommonPrefixBest(strs));
		List<String> list = new ArrayList<>(List.of("ab", "bc", "ca", "abcd", "defg", "lmnt", "cdef", "abe", "a", "b"));
		
		List<String> maxList = maxCharLengthList(list);
		
		for(String str: maxList) {
			//System.out.println(str);
		}
		
		//System.out.println(largestGoodIntegerUsingStreams("6777133339"));
		int[] nums = {2,3,5,6,7,8,1,9};
		int[] result = twoSum(nums , 15);
		for(int i: result) {
			//System.out.println(i);
		}
		int[] result2 = twoSumUsingMap(nums , 15);
		for(int i: result2) {
			//System.out.println(i);
		}
		System.out.println(strStr("hello", "ll"));

	}

}
