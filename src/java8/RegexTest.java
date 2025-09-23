package java8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Hello world";
		String regex = "Hello";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		if (matcher.find()) {
            System.out.println("Pattern found!"); // Output: Pattern found!
        }
		
		Pattern abcPattern = Pattern.compile("[abc]");
		
		Pattern nonabcPattern = Pattern.compile("[^abc]");
		
		Pattern rangePattern = Pattern.compile("[a-c]");
		
		Pattern unionPattern = Pattern.compile("a-c[f-h]");
		
		Pattern anyCharPattern = Pattern.compile(".");
		
		Pattern anyDigitPattern = Pattern.compile("\\d");
		
		String ipv4Regex = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		
		String ipregex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
	               "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

		
		Pattern ipPattern = Pattern.compile(ipv4Regex);
		
		
		
		
		System.out.println(ipPattern.matcher("192.168.0.1").matches() ? "Valid IP" : "Not a valid IP");
		
		System.out.println(ipPattern.matcher("235.789.123.123").matches() ? " Valid IP ": "Not a valid IP");
		
		
		
	
		
		
		
	}

}
