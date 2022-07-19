package algorithm.dynamic;

import java.util.HashMap;

public class Banner {

	public static int countBanners(String str) {
		
		
		HashMap<Character,Integer> charMap = new HashMap<>();
		int bannerCount =0;
		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			
			if(charMap.get(c) ==null || charMap.get(c) ==0 ) {
				String faceBook = new String("facebook");
				
				for(int j=0; j<faceBook.length(); j++) {
					char ch = faceBook.charAt(j);
					charMap.put(ch,charMap.getOrDefault(ch, 0)+1);
				}
				bannerCount++;
				
			}else {
				charMap.put(c,charMap.get(c)-1);
			
			}
			
		}
		
		return bannerCount;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(countBanners("facebookbookfacee"));

	}

}
